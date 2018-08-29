#1012
def class_num(list):
	new_list=map(lambda x:int(x),list)
	list_0=[]
	list_1=[]
	list_2=[]
	list_3=[]
	list_4=[]
	for num in new_list:
		if num%5==0 and num%2==0:
			list_0.append(num)
		elif num%5==1:
			list_1.append(num)
		elif num%5==2:
			list_2.append(num)
		elif num%5==3:
			list_3.append(num)
		elif num%5==4:
			list_4.append(num)
	print list_3
	sum_1=0
	if len(list_1)>0:
		for i,value in enumerate(list_1):
			if i%2==0:
				sum_1=sum_1+value
			else:
				sum_1=sum_1-value
	else:
		sum_1='N'
	r0=sum(list_0) if len(list_0)>0 else 'N'
	r1=sum_1
	r2=len(list_2) if len(list_2)>0 else 'N'
	r3=1.0*sum(list_3)/len(list_3) if len(list_3)>0 else 'N'
	r4=max(list_4) if len(list_4)>0 else 'N'
	
	return (r0,r1,r2,r3,r4)
	
if __name__=='__main__':
	list=raw_input().split()
	for item in  class_num(list):
		print item,