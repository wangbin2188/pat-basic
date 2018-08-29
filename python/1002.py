# 1002
def sum_num(x):
	sum=0
	while(x!=0):
		copy_x=x
		x=x/10
		sum=sum+copy_x%10
	return sum
	
def parse_num(x):
	return {'0':'ling','1':'yi','2':'er','3':'san','4':'si','5':'wu','6':'liu','7':'qi','8':'ba','9':'jiu'}[x]
	
def read_num(x):
	list=[]
	while x!=0:
		copy_x=x
		x=x/10
		list.insert(0,int(copy_x%10))
	return list
if __name__=='__main__':
	num=raw_input()
	result=sum_num(int(num))
	lists= read_num(result)
	for item in lists:
		print parse_num(str(item)),


