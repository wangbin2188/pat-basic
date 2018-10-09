// 实现一个函数，求N个集合元素S[]中的最大值，其中集合元素的类型为自定义的ElementType

#include <stdio.h>

#define MAXN 10
typedef float ElementType;

ElementType Max( ElementType S[], int N );

int main ()
{
    ElementType S[MAXN];
    int N, i;

    scanf("%d", &N);
    for ( i=0; i<N; i++ )
        scanf("%f", &S[i]);
    printf("%.2f\n", Max(S, N));

    return 0;
}


ElementType Max( ElementType S[], int N ){
	ElementType max=S[0];
	int i;
	for(i=0;i<N;i++){
		if(S[i]>max){
			max=S[i];
		}
	}
	return max;
}