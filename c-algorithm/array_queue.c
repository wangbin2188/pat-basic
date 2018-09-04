#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 10
/* 用一个动态数组来实现队列 */

typedef struct Queue {
	int Capacity;
	int Front;
	int Rear;
	int Size;
	int data[MAX_SIZE];
} Queue;

void Error(char *error) {
	printf("%s",error);
}

void FatalError(char *fatalerror) {
	printf("%s",fatalerror);
}

int IsEmpty(Queue *Q) {
	return Q->Size == 0;
}

int IsFull(Queue *Q) {
	return Q->Size == Q->Capacity;
}

void Init( Queue *Q ) {
	Q->Size = 0;
	Q->Front = 1;
	Q->Rear = 0;
	Q->Capacity = MAX_SIZE;
}


static int Succ(int value,Queue *Q) {
	if(++value == Q->Capacity) {
		value = 0;
	}
	return value;
}


void Enqueue(int X,Queue *Q) {
	if( IsFull( Q ) )
		FatalError("Full queue");
	else {
		Q->Size++;
		Q->Rear = Succ(Q->Rear,Q);
		Q->data[ Q->Rear ] = X;
	}
}

 
void Dequeue(Queue *Q) {
	if(IsEmpty(Q))
		FatalError("Empty queue");
	else {
		Q->Size--;
		Q->Front = Succ(Q->Front,Q);
	}
}


int FrontAndDequeue(Queue *Q) {
	int Tmp;
	if(IsEmpty(Q))
		Error("Empty queue");
	else {
		Q->Size--;
		Tmp = Q->data[Q->Front];
		Q->Front = Succ(Q->Front,Q);
		return Tmp;
	}
}


void DisposeQueue( Queue *Q ) {
	free(Q->data);
	free(Q);
}



main() {
	Queue *q ;
	Init(q);
	int i;
	for(i = 0; i <MAX_SIZE; i++) {
		Enqueue(i,q);
	}
	for(i = 0; i <MAX_SIZE; i++) {
		printf("%d\n",FrontAndDequeue(q));
	}
}