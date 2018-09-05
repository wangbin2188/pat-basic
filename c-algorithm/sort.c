#include<stdio.h>
#include<stdlib.h>
void travel(int a[],int n);
void swap(int *pa, int *pb);
void bubble_sort(int a[],int n);
void insert_sort(int a[], int n);
void shell_sort(int a[], int n);
void quick_sort(int a[], int n);
void select_sort(int a[], int n);
void merge_sort(int *a, int n);




main() {
	int a[]= {67,8,4,34,86,87,6,45,7,864,56,1,3,78,9,13};
	int n=sizeof(a)/sizeof(int);
	travel(a,n);
	shell_sort(a,n);
	travel(a,n);
}

void travel(int a[],int n) {
	int i;
	for(i=0; i<n; i++) {
		printf("%d ",a[i]);
	}
	printf("\n");
}

void swap(int *pa,int *pb) {
	int temp;
	temp=*pa;
	*pa=*pb;
	*pb=temp;
}
/*冒泡排序：
原理：比较临近的两个元素，只要不符合顺序就进行交换；
要点：1.不要越界；2.遍历一遍以后最大的元素就会到最后，所以下次遍历就不用遍历整个数组*/
void bubble_sort(int a[],int n) {
	int i,j;
	for(i=0; i<n-1; i++) {
		for(j=0; j<n-i-1; j++) {
			if(a[j]>a[j+1]) {
				swap(a+j,a+j+1);
			}
		}
	}
}
/*插入排序：
原理：首先1个元素肯定是有序的，所以插入排序从第二个元素开始遍历；
内循环首先请求一个空间保存待插入元素，从当前元素向数组起始位置反向遍历；
当发现有大于待插入元素的元素，则将此元素向后挪一位，最终将缓冲区的元素放入空白位置*/
void insert_sort(int a[],int n) {
	int i,j,temp;
	for(i=1; i<n; i++) {
		temp=a[i];
		for(j=i; j>0&&a[j-1]>temp; j--) {
			a[j]=a[j-1];
		}
		a[j]=temp;
	}
}
/*希尔排序的内核是多趟插入排序*/
void shell_sort(int a[], int n) {
	int i,j,step;
	int temp;
	for(step=n/2; step>0; step/=2) {
		for(i=step; i<n; i++) {
			temp=a[i];
			for(j=i; j>=step; j-=step) {
				if(temp<a[j-step]) {
					a[j]=a[j-step];
				} else {
					break;
				}
			}
			a[j]=temp;
		}
	}
}
/*快速排序*/
void quick_sort(int a[], int n) {
	int pivot;
	int sample;
	swap(a+0, a+n/2);
	pivot = 1;
	for (sample=1; sample<n; sample++) {
		if (a[sample] < a[0]) {
			swap(a+pivot, a+sample);
			pivot++;
		}
	}
	swap(a+0,a+pivot-1);
	if (n<=2) {
		return;
	} else {
		quick_sort(a, pivot);
		quick_sort(a+pivot, n-pivot);
	}
}
/*选择排序的原理是先找到起始数组中最小的元素，将它交换到i=0；
然后寻找剩下元素中最小的元素，将它交换到i=1的位置…… 直到找到第二大的元素，将它交换到n-2的位置。
这时，整个数组的排序完成*/
void select_sort(int a[], int n) {
	int i,j;
	int min_idx;
	for (j = 0; j < n-1; j++) {
		min_idx = j;
		for (i = j+1; i < n; i++) {
			if (a[i] < a[min_idx]) {
				min_idx = i;
			}
		}
		swap(a+j, a+min_idx);
	}
}
/*归并排序*/
void merge_sort(int *a, int n) {
	int i, j, k;
	int ac1, ac2;
	int *ah1, *ah2;
	int *container;
	if (n <= 1) {
		return;
	}
	ac1 = n/2;
	ac2 = n - ac1;
	ah1 = a + 0;
	ah2 = a + ac1;

	merge_sort(ah1, ac1);
	merge_sort(ah2, ac2);

	i = 0;
	j = 0;
	k = 0;
	container = (int *) malloc(sizeof(int)*n);
	while(i<ac1 && j<ac2) {
		if (ah1[i] <= ah2[j]) {
			container[k++] = ah1[i++];
		} else {
			container[k++] = ah2[j++];
		}
	}
	while (i < ac1) {
		container[k++] = ah1[i++];
	}
	while (j < ac2) {
		container[k++] = ah2[j++];
	}
	for(i=0; i<n; i++) {
		a[i] = container[i];
	}
	free(container);
}




