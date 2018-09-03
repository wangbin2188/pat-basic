#include<stdio.h>
/*求数列的最大子序列*/
int max_sub_sum1(int a[] ,int n);
int max_sub_sum2(int a[] ,int n);
int max_sub_sum3(int a[] ,int n);
main() {
	int a[] = {4,-3,2,-5,7,-32,90,1,-8,43,-9,2};
	int n=sizeof(a)/sizeof(0);
	int m=max_sub_sum3(a,n);
	printf("%d",m);
}

int max_sub_sum1(int a[],int n) {
	int i,j,k;
	int total,max=0;
	for(i=0; i<n; i++) {
		for(j=i; j<n; j++) {
			int total=0;
			for(k=i; k<j; k++) {
				total+=a[k];
			}
			if(max<total) {
				max=total;
			}
		}
	}
	return max;
}

int max_sub_sum2(int a[],int n) {
	int i,j,k;
	int total,max=0;
	for(i=0; i<n; i++) {
		total=0;
		for(j=i; j<n; j++) {
			total+=a[j];
			if(max<total) {
				max=total;
			}
		}
	}
	return max;
}

int max_sub_sum3(int a[],int n) {
	int i;
	int total=0,max=0;
	for(i=0; i<n; i++) {
		total+=a[i];
		if(total>max) {
			max=total;
		} else if(total<0) {
			total=0;
		}
	}
	return max;
}

