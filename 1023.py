def produce_list(x):
	list=[]
	for i,value in enumerate(x):
		for j in range(int(value)):
			list.append(i)
	return list

def produce_num(list,min_num):
	sort_list=sorted(list)
	if sort_list[0]==0:
		for i,item in enumerate(sort_list):
			if item==min_num:
				sort_list[0],sort_list[i]=sort_list[i],sort_list[0]
	return reduce(to_num,sort_list)
	
def to_num(x,y):
	return 10*x+y
		
if __name__=='__main__':
	list=raw_input().strip().split(' ')
	list= produce_list(list)
	min_num=9
	new_list=map(lambda x:int(x),list)
	for item in new_list:
		if item >0 and item <min_num:
			min_num=item
	print produce_num(new_list,min_num)