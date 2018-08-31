#include<stdio.h>

int compare(char x,char y);
main() {
	int n,i;
	scanf("%d",&n);
	char a[n];
	char b[n];
	int as[3];
	int bs[3];
	int result;
	for(i=0; i<n; i++) {
		scanf("%c %c",&a[i],&b[i]);
	}
	for(i=0; i<n; i++) {
		result=compare(a[i],b[i]);
		if(result==1) {
			as[0]++;
			bs[2]++;
		} else if(result==0) {
			as[1]++;
			bs[1]++;
		} else {
			as[2]++;
			bs[0]++;
		}
	}
	printf("%d %d %d",as[0],as[1],as[2]);
	printf("%d %d %d",bs[0],bs[1],bs[2]);
}

int compare(char x,char y) {
	if(x==y) {
		return 0;
	} else if(x=='C') {
		return (y=='J')?1:-1;
	} else if(x=='J') {
		return (y=='B')?1:-1;
	}else if(x=='B') {
		return (y=='C')?1:-1;
	}
}

