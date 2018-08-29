# 1019
def fn(x,y):
	return 10*int(x)+int(y)

def produce_num(x):
	origin_list=[]
	for i in x:
		origin_list.append(i)
	min_list=sorted(origin_list)
	max_list=sorted(origin_list,reverse=True)
	print '%04d - %04d = %04d'%(reduce(fn,max_list),reduce(fn,min_list),reduce(fn,max_list)-reduce(fn,min_list))
	return reduce(fn,max_list)-reduce(fn,min_list)
	
if __name__=='__main__':
	init_num=raw_input()
	result=produce_num(init_num)
	while result not in (6174,0):
		result=produce_num(str(result))