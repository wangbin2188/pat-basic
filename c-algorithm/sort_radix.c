#include<stdio.h>
#include<math.h>
#define SIZE 10
#define C_SIZE 20

/*行数稳定=10，切记！列数务必搞的大一些，避免出现放不下的情况*/
void radix_sort(int *p,int n,int step);
void travel(int *p,int n);
int get_max(int *p,int n);
int get_digit(int x);
void out_sort(int *p,int n);

main() {
	int a[]= {8,7,83,4,39,85,5,9,32,80,97,61,2,38,48,74,26,514};
	int *pa=a;
	int i;
	int n=sizeof(a)/sizeof(int);
	travel(pa,n);

	out_sort(pa,n);

	travel(pa,n);
}


void out_sort(int *p,int n) {
	int max_n=get_max(p,n);
	int loop=get_digit(max_n);
	int i;
	for(i=1; i<=loop; i++) {
		radix_sort(p,n,i);
	}
}

/*基数排序*/
void radix_sort(int *p,int n,int loop) {
	int b[SIZE][C_SIZE]= {0};
	int i,j;
	int tmp  =(int)pow(10,loop-1);
	for(i=0; i<n; i++) {
		int row_index = (*(p+i)/tmp)%10;
		for(j=0; j<C_SIZE; j++) {
			if(b[row_index][j] == 0) {
				b[row_index][j] = *(p+i);
				break;
			}
		}
	}

	int k=0;
	for(i=0; i<SIZE; i++) {
		for(j=0; j<C_SIZE; j++) {
			if(b[i][j]!= 0) {
				*(p+k)=b[i][j];
				b[i][j]=0;
				k++;
			}
		}
	}
}
/*遍历数组*/
void travel(int *p,int n) {
	int i;
	for(i=0; i<n; i++) {
		printf("%d,",*(p+i));
	}
	printf("\n");
}


/*获取最大数字*/
int get_max(int *p,int n) {
	int i;
	int max_num=0;
	for(i=0; i<n; i++) {
		if(*(p+i)>max_num) {
			max_num=*(p+i);
		}
	}
	return max_num;
}

/*获取最大数字的位数*/
int get_digit(int x) {
	int count=1;
	int temp=x/10;
	while(temp!=0) {
		count++;
		temp=temp/10;
	}
	return count;
}
