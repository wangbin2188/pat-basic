from math import sqrt
def prime(x):
	for i in range(2,int(sqrt(x))+1):
		if x%i==0:
			return False
	return True
	
if __name__=='__main__':
	list=raw_input().split(' ')
	m,n=int(list[0]),int(list[1])
	list=[]
	for i in range(2,10001):
		if prime(i):
			list.append(i)
	count=0
	for item in  list[m-1:n]:
		count=count+1
		print item,
		if count%10==0:
			print 