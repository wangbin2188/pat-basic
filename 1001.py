# 1001
def callatz(x):
	n=0
	# print 'x=',x,'n=',n
	while x!=1:
		if x%2==0:
			x=x/2
			n=n+1
			# print 'x=',x,'n=',n
		else:
			x=(3*x+1)/2
			n=n+1
			# print 'x=',x,'n=',n
	return n
		
if __name__=='__main__':
	origin=int(raw_input())
	result=callatz(origin)
	print result
	
	
