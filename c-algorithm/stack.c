#include<stdio.h>
#include<stdlib.h>
//用链表实现栈
typedef struct Node {
	int data;
	struct Node *next;
} node;

int IsEmpty(node *p) {
	return p->next==NULL;
}

node *CreateStack() {
	node *p=(node*)malloc(sizeof(node));
	p->next=NULL;
	return p;
}


node *Push(node *p,int x) {
	node *TmpCell=(node*)malloc(sizeof(node));
	TmpCell->data=x;
	TmpCell->next=p->next;
	p->next=TmpCell;
	return p;
}

void Pop(node *p) {
	node *cell;
	if(p->next==NULL) {
		printf("error,-1");
	} else {
		cell=p->next;
		p->next=cell->next;
		free(cell);
	}
}

void display(node *p) {
	node *temp=p;
	while(temp->next) {
		printf("%d",temp->next->data);
		temp=temp->next;
	}
	printf("%c",'\n');
}

main() {
	node *p=CreateStack();
	Push(p,1);
	Push(p,2);
	Push(p,3);
	Push(p,4);
	display(p);
	Pop(p);
	display(p);
	Pop(p);
	display(p);
}