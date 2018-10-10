#include<stdio.h>

main() {
	int c;
	while((c=getchar())!=EOF) {
		if(c == '\t') {
			printf("\\t");
		} else if(c == '\b') {
			printf("\\b");
		} else if(c == '\\') {
			printf("\\\\");
		} else {
			putchar(c);
		}
	}
}
//输入到输出，将制表符替换为\t,回退符替换为\b，反斜杠替换为\\,这样可以将制表符和回退符可见