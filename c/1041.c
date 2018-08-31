#include<stdio.h>
#include<stdlib.h>
#define LEN 1000
typedef struct student_ {
	char sno[LEN];
	int ano;
	int bno;
} student;

main() {
	int n = 0;
	int m = 0;
	scanf("%d",&n);
	student *students = (student *) malloc(sizeof(student) * n);
	int i = 0;
	int j = 0;
	for (i = 0; i < n; i++ ) {
		student *p = &students[i];
		scanf("%s %d %d", p->sno, &p->ano, &p->bno);
	}
	scanf("%d",&m);
	int a[m];
	for(j =0; j<m; j++) {
		scanf("%d",&a[j]);
	}
	for(j =0; j<m; j++) {
		for (i = 0; i < n; i++ ) {
			if(students[i].ano ==a[j]) {
				printf("%s %d\n",students[i].sno,students[i].bno);
			}
		}
	}
}