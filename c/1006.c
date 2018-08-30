#include<stdio.h>
#include<string.h>

void read(int i);
void print(char c,int n);
main() {
	int i;
	scanf("%d",&i);
	read(i);
}

void read(int i) {
	int n,m;
	char str[10];
	char result[30];
	sprintf(str, "%d", i);
	int len=strlen(str);
	for(n=len; n>0; n--) {
		if(n==3) {
			print('B',str[len-n]-'0');
		}
		if(n==2) {
			print('S',str[len-n]-'0');
		}
		if(n==1) {
			for(m=1; m<=str[len-1]-'0'; m++) {
				printf("%d",m);
			}
		}
	}
}

void print(char c,int n) {
	int i;
	for(i=0; i<n; i++) {
		printf("%c",c);
	}
}
