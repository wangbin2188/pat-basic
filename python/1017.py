# 1017
def div(x,y):
	q=x/y
	r=x%y
	return (q,r)
	
if __name__=='__main__':
	list=raw_input().split(' ')
	new_list=map(lambda x:int(x),list)
	for item in div(new_list[0],new_list[1]):
		print item,