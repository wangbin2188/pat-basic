#include<stdio.h>

/*高效率的求幂方法*/
int bpow(int m,int n);
main() {
	int m,n;
	scanf("%d %d",&m,&n);
	int p=bpow(m,n);
	printf("%d",p);
}

int bpow(int m,int n) {
	if(n==0) {
		return 1;
	}
	if (n==1) {
		return m;
	}
	if(n%2==0) {
		return bpow(m*m,n/2);
	} else {
		return bpow(m*m,n/2)*m;
	}
}
