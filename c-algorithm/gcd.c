#include<stdio.h>
int gcd(int m,int n);
/*求最大公约数的欧几里德算法*/
main(){
	int m,n;
	scanf("%d %d",&m,&n);
	int p=gcd(m,n);
	printf("%d",p);
}

int gcd(int m,int n){
	int rem;
	while(n>0){
		rem=m%n;
		m=n;
		n=rem;
	}
	return m;
}