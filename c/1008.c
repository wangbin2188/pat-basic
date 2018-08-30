#include<stdio.h>
#define MAXN 100
void move(int a[],int n,int m);
void swap(int *pa,int *pb);
main() {
	int a[MAXN], n, m;
	int i;

	scanf("%d %d", &n, &m);
	for ( i = 0; i < n; i++ ) {
		scanf("%d", &a[i]);
	}
	move(a,n,m);
	for(i=0; i<n; i++) {
		if(i==n-1) {
			printf("%d",a[i]);
		} else {
			printf("%d ",a[i]);
		}
	}
}

void move(int a[],int n,int m) {
	int i;
	for(i=0; i<n-1; i++) {
		swap(&a[i],&a[n-m+i%m]);
	}
}

void swap(int *pa,int *pb) {
	int temp;
	temp=*pa;
	*pa=*pb;
	*pb=temp;
}