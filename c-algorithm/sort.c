#include<stdio.h>
#include<stdlib.h>
void travel(int a[],int n);
void swap(int *pa, int *pb);
void bubble_sort(int a[],int n);
void insert_sort(int a[], int n);
void shell_sort(int a[], int n);
void quick_sort(int a[], int left,int right);
void select_sort(int a[], int n);
void merge_sort(int *a, int n);
void merge(int *a,int *a1,int n1,int *a2,int n2);



main() {
	int a[]= {67,8,4,34,86,87,6,45,7,864,56,1,3,78,9,13};
	int n=sizeof(a)/sizeof(int);
	travel(a,n);
	merge_sort(a,n);
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
		for(j=i; j>0; j--) {
			if(temp<a[j-1]) {
				a[j]=a[j-1];
			} else {
				break;
			}
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


/*快速排序
快速排序是采用分支思想的递归冒泡排序改进算法，原理是先找到一个基准key，一般是数组的第一个元素；
缓存起来，然后设置一前一后两个游标，i=0;j=n-1;当i<j的时候，只有不遇到a[j]<key，则j一直向前移动；
如果遇到a[j]<key,则将a[j]赋值给a[i](i目前为0，况且a[i]已被缓存),之后i向后移动，知道遇到一个元素a[i]>key;
此时把a[i]赋值给a[j](刚刚的a[j]已被赋值到其它位置，所以不担心被覆盖)，最后i==j，将缓存区的元素赋给a[i];
一趟遍历结束，此时a[i]之前的元素都小于它，之后的元素都大于它，用同样的方法对之前之后两个子序列进行排序*/
void quick_sort(int a[], int left,int right) {
	if(left>=right) {
		return;
	}
	int i=left;
	int j=right;
	int key=a[i];
	while(i<j) {
		while(i<j && key<=a[j]) {
			j--;
		}
		a[i]=a[j];
		while(i<j && key>=a[i]) {
			i++;
		}
		a[j]=a[i];
	}
	a[i]=key;
	quick_sort(a,left,i-1);
	quick_sort(a,i+1,right);
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
/*归并排序基于这样一种思想：
1.如果两个子序列是有序的，那么将他们合并成一个有序的序列所需的时间复杂度是O(N);
2.将一个序列一直二分，直到只剩下一个元素，那么最后的子序列一定是有序的*/
void merge_sort(int *a, int n) {
	int n1, n2;
	int *a1, *a2;
	int *container;
	if (n <= 1) {
		return;
	}
	n1 = n/2;
	n2 = n - n1;
	a1 = a + 0;
	a2 = a + n1;

	merge_sort(a1, n1);
	merge_sort(a2, n2);
	merge(a,a1,n1,a2,n2);

}

void merge(int *a,int *a1,int n1,int *a2,int n2){
	int i = 0,j = 0,k = 0;
	int *container;
	container = (int *) malloc(sizeof(int)*(n1+n2));
	while(i<n1 && j<n2) {
		if (a1[i] <= a2[j]) {
			container[k++] = a1[i++];
		} else {
			container[k++] = a2[j++];
		}
	}
	while (i < n1) {
		container[k++] = a1[i++];
	}
	while (j < n2) {
		container[k++] = a2[j++];
	}
	for(i=0; i<(n1+n2); i++) {
		a[i] = container[i];
	}
	free(container);
}






