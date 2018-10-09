//实现一个函数，对给定的正整数N，打印从1到N的全部正整数。

void PrintN ( int N ){
  int i;
  for(i=1;i<=N;i++){
    if(i==N){
      printf("%d",i);
    }else{
      printf("%d\n",i);
    }
  }
}