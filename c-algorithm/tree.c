#include<stdio.h>
#include<stdlib.h>
#define SIZE 10
typedef struct Tree {
	int data;
	struct Tree *left;
	struct Tree *right;
} tree;


/*这完全是基于这棵树是二叉搜索树来查找的，二叉搜索树的特征是：
1.树的左子节点都小于父节点，右子节点都大于父节点，因此搜索的时间复杂度是O(logN)*/
int find(tree *t,int x) {
	int i=0;
	if(t==NULL) {
		return -1;
	}
	if(t->data==x) {
		return i;
	} else if(x<t->data) {
		i++;
		find(t->left,x);
	} else if(x>t->data) {
		i++;
		find(t->right,x);
	}
}
/*查找最小值的递归算法*/
tree *findMin(tree *t) {
	if(t==NULL) {
		return NULL;
	} else if(t->left==NULL) {
		return t;
	} else {
		return findMin(t->left);
	}
}

/*查找最大值的非递归算法*/
int findMax(tree *t) {
	if(t!=NULL) {
		while(t->right!=NULL) {
			t=t->right;
		}
	}
	return t->data;
}

/*对二叉搜索树进行初始化，使得每次插入新数据都不破坏二叉排序树形态*/
tree *insert(tree *t,int x) {
	if(t==NULL) {
		t=malloc(sizeof(tree));
		t->data=x;
		t->left=NULL;
		t->right=NULL;
	} else if(x < t->data) {
		t->left=insertSort(t->left,x);
	} else if(x > t->data) {
		t->right=insertSort(t->right,x);
	}
	return t;
}

/*对二叉搜索树节点删除，保证不破坏二叉排序树形态
 * 0.首先通过递归方式找到待删除的节点，这时有三种情况：
 * 1.删除叶子节点一定不破坏顺序，可以直接删；
 * 2.删除只有一个子节点的节点，只需要把子节点放在当前节点上，也没有太大难度；
 * 3.删除两个子节点的节点比较繁琐：
 *  ①首先要找到当前节点右子树的最小节点(原因是这个节点必然是叶子节点，且大于左子树所有节点，小于右子树所有节点)，
 *  ②将这个节点的值赋给当前节点，并递归删除右子树的最小节点*/
tree *delete(tree *t,int x) {
	tree *temp;
	if(t==NULL) {
		printf("error,element not found!");
	} else if( x < t->data ) {/*go left*/
		t->left=delete(t->left,x);
	} else if( x > t->data ) {/*go right*/
		t->right=delete( t->right,x );
	} else if( t->left && t->right) { /*t->data==x and t has two children*/
		temp=findMin( t->right );
		t->data=temp->data;
		t->right=delete( t->right,t->data );
	} else {/*one or zero children */
		temp=t;
		if( t->left!=NULL) {
			t=t->left;
		} else if( t->right != NULL ) {
			t=t->right;
		}
		free(temp);
	}
	return t;
}

void preTravel(tree *t) {
	if(t==NULL) {
		return;
	}
	printf("%d ",t->data);
	preTravel(t->left);
	preTravel(t->right);
}

void midTravel(tree *t) {
	if(t==NULL) {
		return;
	}
	midTravel(t->left);
	printf("%d ",t->data);
	midTravel(t->right);
}

void postTravel(tree *t) {
	if(t==NULL) {
		return;
	}
	postTravel(t->left);
	postTravel(t->right);
	printf("%d ",t->data);
}

main() {
	tree *t;
	int i;
	for(i=0; i<SIZE; i++) {
		t=init(t,i);
	}
	preTravel(t);
	printf("\n");
	midTravel(t);
	printf("\n");
	postTravel(t);
}