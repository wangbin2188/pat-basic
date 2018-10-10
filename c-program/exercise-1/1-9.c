#include<stdio.h>

#define NONBLANK 'a'
main(){
	int c,lastc;
	lastc=NONBLANK;
	while((c=getchar())!=EOF){
		if(c != ' '){
			putchar(c);
		}
		if(c == ' '){
			if(lastc!=' '){
				putchar(c);
			}
		}
		lastc=c;
	}
}
//输入到输出，将连续多个空格合并为一个