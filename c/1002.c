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
	char str[50];
	sprintf(str, "%d", result);
	char *s;
	s=str;
	while(*s) {
		switch(*s) {
		case '0':
			printf("ling");
			break;
		case '1':
			printf("yi");
			break;
		case '2':
			printf("er");
			break;
		case '3':
			printf("san");
			break;
		case '4':
			printf("si");
			break;
		case '5':
			printf("wu");
			break;
		case '6':
			printf("liu");
			break;
		case '7':
			printf("qi");
			break;
		case '8':
			printf("ba");
			break;
		case '9':
			printf("jiu");
			break;
		default:
			break;
		}
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