#include<stdio.h>
#include<stdlib.h>
#define CAPACITY 10

/*堆有两个性质：
 * 1.结构性：堆必须是一颗完全二叉树
 * 2.堆序性：堆的父节点要么都大于子节点，要么小于子节点，前者叫大顶堆，后者叫小顶堆；
 * 由此，堆可以用一个数组来表示，并有如下性质：
 * 1.对于任意i位置的元素，他的左子节点在2i位置，右子节点在2i+1位置；
 * 2.他的父节点（假如有）在i/2位置*/

/*创建一个小顶堆,size代表的是实际元素的个数*/
typedef struct MinHeap {
	int size;
	int data[CAPACITY];
} heap;

void init( heap *h );
void insert(heap *h,int x);
void travel(heap *h);

/*数组0位置要空着*/
void init( heap *h ) {
	h->size=0;
	int i;
	for(i=1; i< 6; i++) {
		h->data[i]=2*i+1;
		h->size++;
	}
}

void insert(heap *h,int x) {
	if(h->size == CAPACITY) {
		printf("heap is full!");
		return;
	}
	int i;
	h->size++;
	for(i=h->size; i>=1; i/=2) {
		if(x < h->data[i/2]) {
			h->data[i]=h->data[i/2];
		} else {
			break;
		}
	}
	h->data[i]=x;
}
/*删除最小元素，在小顶堆即意味着删除根节点
 * 1.首先将最后一个元素赋值给根元素，这样保证了堆的结构性；
 * 2.重建堆，使堆保持堆序*/
void deleteMin(heap *h) {
	h->data[1]=h->data[h->size];
	h->size--;
	int i;
	int temp=h->data[1];
	for(i=1; i<=h->size; i*=2) {
		if(h->data[i] > h->data[2*i]) {
			h->data[i]=h->data[2*i];
		} else {
			break;
		}
	}
	h->data[i]=temp;
}
/*遍历时越过空白位置0，从1开始*/
void travel(heap *h) {
	int i;
	for(i=1; i<=h->size; i++) {
		printf("%d ",h->data[i]);
	}
	printf("\n");
}


main() {
	heap *h=(heap*)malloc(sizeof(heap));
	init(h);
	travel(h);
	insert(h,6);
	travel(h);
	deleteMin(h);
	travel(h);
}