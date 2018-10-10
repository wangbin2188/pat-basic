#include<stdio.h>
main() {
	int c;
	while(c=getchar()!=EOF) {
		printf("%d",c);
	}
	printf("%d",c);
}
//如果输入==EOF，则c=true=1;否则c=false=0