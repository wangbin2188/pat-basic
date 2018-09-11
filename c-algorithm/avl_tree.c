#include<stdio.h>
#include<stdlib.h>
#define SIZE 10
typedef struct Tree {
	int data;
	struct Tree *left;
	struct Tree *right;
	int height;
} tree;

int get_height(tree *t) {
	if(t==NULL) {
		return -1;
	}
	return t->height;
}

tree *insert(tree *t,int x) {
	if(t==NULL) {
		t=malloc(sizeof(tree));
		t->data=x;
		t->left=NULL;
		t->right=NULL;
		t->height=0;
	} else if(x < t->data) {
		t->left=insertSort(t->left,x);
		if(get_height(t->left)-get_height(t->right)==2) {
			if(x <t->left->data) {
				t=single_rotate_with_left(t);
			} else {
				t=double_rotate_with_left(t);
			}
		}
	} else if(x > t->data) {
		t->right=insertSort(t->right,x);
		if(get_height(t->left)-get_height(t->right)==-2) {
			if(x >t->right->data) {
				t=single_rotate_with_right(t);
			} else {
				t=double_rotate_with_right(t);
			}
		}
	}
	t->height=max(get_height(t->left),get_height(t->right))+1;
	return t;
}

tree *single_rotate_with_left(tree *t2){
	tree *t1;
	t1=t2->left;
	t2->left=t1->right;
	t1->right=t2;
	t2->height=max(get_height(t2->left),get_height(t2->right))+1;
	t1->height=max(get_height(t1->left),t2->height)+1;
	return t1;
}

tree *single_rotate_with_right(tree *t2){
	tree *t1;
	t1=t2->right;
	t2->right=t1->left;
	t1->left=t2;
	t2->height=max(get_height(t2->left),get_height(t2->right))+1;
	t1->height=max(get_height(t1->right),t2->height)+1;
	return t1;
}

tree *double_rotate_with_left(tree *k3){
	k3->left=single_rotate_with_right(k3->left);
	return single_rotate_with_left(k3);
}

tree *double_rotate_with_right(tree *k3){
	k3->right=single_rotate_with_right(k3->right);
	return single_rotate_with_right(k3);
}

int max(int a,int b) {
	if(a>=b) {
		return a;
	} else {
		return b;
	}
}