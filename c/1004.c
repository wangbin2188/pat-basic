#include<stdio.h>
#include<stdlib.h>
#define LEN 10
typedef struct student_ {
        char name[LEN];
        char sno[LEN];
        int score;
} student;

main() {
        int n = 0;
        int s_max=0;
        int s_min=100;
        scanf("%d",&n);
        student *students = (student *) malloc(sizeof(student) * n);
        int i = 0;

        for (i = 0; i < n; i++ ) {
                student *p = &students[i];
                scanf("%s %s %d", p->name, p->sno, &p->score);
                if((p->score)>s_max) {
                        s_max=p->score;
                }
                if((p->score)<s_min) {
                        s_min=p->score;
                }
        }

        for (i = 0; i < n; i++ ) {
                if(students[i].score==s_max) {
                        printf("%s %s\n", students[i].name,students[i].sno);
                }
        }

        for (i = 0; i < n; i++ ) {
                if(students[i].score==s_min) {
                        printf("%s %s\n", students[i].name,students[i].sno);
                }
        }

}