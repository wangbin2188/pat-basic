#include<stdio.h>
#include <stdlib.h>

int travel_sum(char *str) {
	int result=0;
	while (*str) {
		result += (*str-'0');
		str +=1;
	}
	return result;
}

void read(int result) {
	char *name[] = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
	char str[50];
	sprintf(str, "%d", result);
	char *s;
	s=str;
	while(*s) {
		printf("%s",name[*s-'0']);
		s++;
	}
}

main() {
	int result;
	char str[100];
	scanf("%s",str);
	result=travel_sum(str);
	read(result);
}