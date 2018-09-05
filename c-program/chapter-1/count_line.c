#include<stdio.h>
// on linux: EOF=CTRL+D+ENTER
main() {
	int c,nl;
	n1=0;
	while((c=getchar())!=EOF) {
		if(c=='\n') {
			++nl;
		}
	}
	printf("%d\n",nl);
}