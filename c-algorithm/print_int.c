#include<stdio.h>

void print(int n);
main() {
	int n;
	scanf("%d",&n);
	print(n);
}
/*打印一个整数*/
void print(int n) {
	if(n>10) {
		print(n/10);
	}
	putchar(n%10+'0');
}
