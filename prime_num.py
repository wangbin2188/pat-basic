# 1007
def prime(x):
	for i in range(2,x):
		if x%i==0:
			return False
	return True

def count_pair(list):
	count=0
	for i,value in enumerate(list):
		if i+1<len(list):
			if list[i+1]-value==2:
				count=count+1
	return count
	
if __name__=='__main__':
	list=[]
	num=raw_input()
	for i in range(2,int(num)):
		if prime(i)==True:
			list.append(i)
	print count_pair(list)
			
