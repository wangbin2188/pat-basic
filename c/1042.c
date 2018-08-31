#include<stdio.h>
#include<ctype.h>
#define LEN 26
#define MAX 1000
main() {
	int i;
	int a[LEN];
	char str[MAX];
	char *p;
	char c;
	int m=0;
	char n;
	p=str;
	for(i=0; i<LEN; i++) {
		a[i]=0;
	}
	scanf("%[^\n]",&str);//can input string who contains space ,end of \n
	while(*p++) {
		c=*p;
		if(isalpha(c)) {
			if(isupper(c)) {
				c=tolower(c);
			}
			a[c-'a']++;
		}
	}
	for(i=0; i<LEN; i++) {
		if(a[i]>m) {
			m=a[i];
			n=i+'a';
		}
	}
	printf("%c %d",n,m);
}
