#include<stdio.h>
void insert_sort(int a[],int n);
int binary_search(int a[],int x,int n);
void print_array(int a[],int n);

main() {
	int a[]= {4,-3,2,-5,7,-32,90,1,-8,43,-9,2};
	int n=sizeof(a)/sizeof(0);
	int x=43;
	print_array(a,n);
	insert_sort(a,n);
	print_array(a,n);
	int m=binary_search(a,x,n);
	printf("%d",m);
}
/*插入排序*/
void insert_sort(int a[],int n) {
	int i,j;
	for(i=1; i<n; i++) {
		int temp=a[i];
		for(j=i; j>0&&a[j-1]>temp; j--) {
			a[j]=a[j-1];
		}
		a[j]=temp;
	}
}
/*二分查找*/
int binary_search(int a[],int x,int n) {
	int low,center,high;
	low=0;
	high=n-1;
	while(low<high) {
		center=(low+high)/2;
		if(a[center]==x) {
			return center;
		} else if(a[center]>x) {
			high=center-1;
		} else {
			low=center+1;
		}
	}
	return -1;
}
/*打印数组*/
void print_array(int a[],int n) {
	int i;
	for(i=0; i<n; i++) {
		printf("%d ",a[i]);
	}
	printf("%c",'\n');
}
