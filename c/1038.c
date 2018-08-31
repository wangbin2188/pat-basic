#include<stdio.h>

main() {
	int i,j;
	int n,m;
	scanf("%d",&n);
	int a[n];
	for(i=0; i<n; i++) {
		scanf("%d",&a[i]);
	}
	scanf("%d",&m);
	int b[m],bn[m];
	for(j=0; j<m; j++) {
		scanf("%d",&b[j]);
		bn[j]=0;
	}

	for(i=0; i<n; i++) {
		for(j=0; j<m; j++) {
			if(a[i]==b[j]) {
				bn[j]++;
			}
		}
	}
	for(j=0; j<m; j++) {
		if(j==m-1) {
			printf("%d",bn[j]);
		} else {
			printf("%d ",bn[j]);
		}
	}
}