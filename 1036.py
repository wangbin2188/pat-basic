def print_square(num,symbol):
	col=num/2
	for i in range(col):
		if i==0 or i==col-1:
			print '%s'%(symbol*num)
		else:
			print '%s%s%s'%(symbol,' '*(num-2),symbol)

if __name__=='__main__':
	list=raw_input().split(' ')
	digital,symbol=list[0],list[1]
	print_square(int(digital),symbol)