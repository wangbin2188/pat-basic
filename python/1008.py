# 1008
from sys import stdin

def move(list,n,m):
	for i in range(n-1):
		# if i<=n-m+i%m:
		list[i],list[n-m+i%m]=list[n-m+i%m],list[i]	
		print list
	return map(lambda x:int(x),list)
	
if __name__=='__main__':
	count=0
	while True:
		line=stdin.readline().strip()
		count=count+1
		if line=='':
			break
		if count==1:
			nm_list=line.split(' ')
		elif count==2:
			arr_list=line.split(' ')		
	for item in  move(arr_list,int(nm_list[0]),int(nm_list[1])):
		print item,




