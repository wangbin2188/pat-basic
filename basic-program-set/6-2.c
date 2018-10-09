//实现一个函数，计算阶数为n，系数为a[0] ... a[n]的多项式f(x)在x点的值。

#include <stdio.h>
#include <math.h>
#define MAXN 10

double f( int n, double a[], double x );

int main() {
	int n, i;
	double a[MAXN], x;

	scanf("%d %lf", &n, &x);
	for ( i=0; i<=n; i++ ) {
		scanf("%lf", &a[i]);
	}
	printf("%.1f\n", f(n, a, x));
	return 0;
}

double f( int n, double a[], double x ){
	double sum=0;
	int i;
	for(i=0;i<=n;i++){
		sum+=a[i]*pow(x,i);
	}
	return sum;
}
	