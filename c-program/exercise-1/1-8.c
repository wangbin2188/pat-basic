#include<stdio.h>

main(){
	int c,nb,nt,nl;
	nb=0;
	nt=0;
	nl=0;
	while((c=getchar())!=EOF){
		if(c ==' '){
			++nb;
		}
		if(c =='\t'){
			++nt;
		}
		if(c =='\n'){
			++nl;
		}
	}
	printf("%d %d %d\n",nb,nt,nl);
}

//统计一段输入中的空格，制表符和换行符