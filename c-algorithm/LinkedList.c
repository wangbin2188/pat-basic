#include<stdio.h>
#include<stdlib.h>

typedef struct Node {
	int data;
	struct Node *next;
} node;

/*初始化链表：
1.首先给头指针分配空间，将头指针赋给temp
2.其次给每一个元素分配空间
3.将内容赋给当前节点的data,NULL赋给当前节点的next指针
4.把当前节点赋给(头指针)上一个节点的next指针
5.上一节点指针后移，准备初始化下个元素
6.最后返回当前链表的头指针*/
node *initnode() {
	int i;
	node *p = (node*)malloc(sizeof(node));
	node *temp = p;
	for (i = 0; i < 10; i++) {
		node *a = (node*)malloc(sizeof(node));
		a->data = i;
		a->next = NULL;
		temp->next = a;
		temp = temp->next;
	}
	return p;
}

/*指定位置插入元素：
1.将头指针赋给temp
2.temp一直遍历直到指定位置
3.给需要插入的元素分配空间，并将内容赋给分配好空间的元素
4.将插入位置的后一元素赋给要插入元素的next指针
5.将插入元素赋给temp的next指针
6.最后返回当前链表的头指针*/
node *insertElem(node *p, int elem, int pos) {
	int i;
	node *temp = p;
	for ( i = 0; i < pos; i++) {
		temp = temp->next;
	}
	node *c = (node*)malloc(sizeof(node));
	c->data = elem;
	c->next = temp->next;
	temp->next = c;
	return p;
}

/*删除指定位置的元素:
1.将头指针赋给temp
2.temp一直遍历直到指定位置
3.声明一个变量代表待删除节点
4.将待删除节点的下一节点赋给待删除节点的上一节点的next指针
5.释放待删除节点空间
6.最后返回当前链表的头指针*/
node *delElem(node *p, int pos) {
	int i;
	node *temp = p;
	for ( i = 0; i < pos; i++) {
		temp = temp->next;
	}
	node *c = temp->next;
	temp->next = c->next;
	free(c);
	return p;
}

/*查询指定元素的位置：
1.将头指针赋给temp
2.temp一直遍历直到temp节点的值等于要查询的元素
3.返回当前节点的index
4.如果链表遍历结束也未找到指定节点，返回-1
*/
int selectElem(node *p, int elem) {
	node *temp = p;
	int i = 0;
	while (temp->next) {
		temp = temp->next;
		if (temp->data == elem) {
			return i;
		}
		i++;
	}
	return -1;
}

/*更新链表指定节点的值*/
node *amendElem(node *p, int pos, int newElem) {
	int i;
	node *temp = p;
	for ( i = 0; i < pos; i++) {
		temp = temp->next;
	}
	node *amend = temp->next;
	amend->data = newElem;
	return p;
}

/*遍历链表*/
void display(node *p) {
	node *temp = p;
	while (temp->next) {
		temp = temp->next;
		printf("%d ", temp->data);
	}
	printf("\n");
}

//以下内容来自《数据结构与算法-C语言描述》
int IsEmpty(node *p) {
	return p->next==NULL;
}

int IsLast(node *pos,node *p) {
	return pos->next==NULL;
}

//删除指定位置的元素
node *Delete(node *p,int elem) {
	node *temp=p;
	node *tmp;
	while(temp->next) {
		if(temp->next->data==elem) {
			tmp=temp->next;
			temp->next=tmp->next;
			free(tmp);
		}
		temp=temp->next;
	}
	return p;
}

//在指定位置插入元素
node *Insert(node *p,int pos,int elem) {
	node *temp=p;
	int i;
	for(i=0; i<pos; i++) {
		temp=temp->next;
	}
	node *cell =(node*)malloc(sizeof(node));
	cell->data=elem;
	cell->next=temp->next;
	temp->next=cell;
	return p;
}
//删除list
void DeleteList(node *p) {
	node *temp=p;
	node *tmp;
	p->next=NULL;
	while(temp->next) {
		tmp=temp->next;
		free(tmp);
		temp=temp->next;
	}
}


int main() {
	node *p = initnode();
	display(p);
	printf("在第4的位置插入元素5：\n");
	p = Insert(p, 4, 5);
	display(p);
	printf("删除第3个元素：\n");
	p = delElem(p, 3);
	display(p);
	printf("查找元素2的位置为：\n");
	int address = selectElem(p, 2);
	if (address == -1) {
		printf("没有该元素\n");
	} else {
		printf("元素2的位子为：%d\n", address);
	}
	printf("更改第3的位置的数为7：\n");
	p = amendElem(p, 3, 7);
	display(p);
	printf("delete7\n");
	p=Delete(p,7);
	display(p);
	printf("删除\n");
	DeleteList(p);
	display(p);
}