def count(x):
	if ((x+3)/4)%2==1:
		return (x+3)/4
	else:
		return (x+3)/4-1
	
if __name__=='__main__':
	list=raw_input().split(' ')
	digital,symbol=list[0],list[1]
	n=count(int(digital))
	remainder=int(digital)-(4*n-3)
	for i in range(n,1,-2):
		str='%s'%(symbol*i)
		print str.center(n,' ')
	for i in range(1,n+1,2):
		str='%s'%(symbol*i)
		print str.center(n,' ')
	print remainder