#include<stdio.h>
#include <stdlib.h>

int travel_sum(char *str){
        int result=0;
        while (*str != 0){
                result=result+(*str-'0');
                str +=1;
        }
        return result;
}

void read(int result){
}
main(){
        int result;
        char str[100];
        scanf("%s",str);
        result=travel_sum(str);
        printf("%d",result);
}