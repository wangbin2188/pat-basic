#include<stdio.h>
#include<ctype.h>
#define MAX 10
void travel(char *s,char *t,char c);
int str2num(char *s);
main() {
	int a,b;
	char m,n;
	char sa[MAX],sb[MAX];
	char sc[MAX],sd[MAX];
	scanf("%s %c %s %c",&sa,&m,&sb,&n);
	travel(sa,sc,m);
	travel(sb,sd,n);
	a=str2num(sc);
	b=str2num(sd);
	printf("%d",a+b);
}

void travel(char *s,char *t,char c) {
	while(*s) {
		if(*s==c) {
			*t=*s;
			t++;
		}
		s++;
	}
}

int str2num(char *s) {
	int num=0;
	while(*s) {
		if(isdigit(*s)) {
			num=num*10+(*s-'0');
		}
		s++;
	}
	return num;
}