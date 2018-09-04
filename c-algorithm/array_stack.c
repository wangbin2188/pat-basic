#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 10
#define FALSE 0
#define TRUE 1
//用数组实现栈
typedef struct stack {
	int data[MAX_SIZE];
	int top;
} stack;

void init(stack *s) {
	s->top=-1;
}

int isEmpty(stack *s) {
	if(s->top==-1) {
		return TRUE;
	} else {
		return FALSE;
	}
}
int isFull(stack *s) {
	if(s->top==MAX_SIZE-1) {
		return TRUE;
	} else {
		return FALSE;
	}
}
void push(stack *s,int x) {
	if(!isFull(s)) {
		s->top++;
		s->data[s->top]=x;
	} else {
		printf("stack is full!");
	}
}

void pop(stack *s) {
	if(!isEmpty(s)) {
		s->data[s->top]=0;
		s->top--;
	} else {
		printf("stack is empty!");
	}
}

int getTop(stack *s) {
	if(!isEmpty(s)) {
		return s->data[s->top];
	} else {
		printf("stack is empty!");
	}
}


main() {
	int i;
	stack *s;
	init(s);
	for(i=0; i<10; i++) {
		push(s,i);
	}
	printf("%d %d",s->top,getTop(s));
	pop(s);
	printf("%d %d",s->top,getTop(s));
	pop(s);
	printf("%d %d",s->top,getTop(s));
}