#include<stdio.h>

int step(int num){
	int count=0;
	while(num!=1){
		if(num%2==0){
			num=num/2;
			count++;
		}
		else{
			num=(3*num+1)/2;
			count++;
		}
	}
	return count;
}

main(){
	int i1;
	scanf("%d",&i1);
	printf("%d",step(i1));
}

