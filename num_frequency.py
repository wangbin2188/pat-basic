# 1021

def num_fre(x):
	num_map={}
	for item in x:
		num_map[item]=num_map.get(item,0)+1
	return num_map

def sort_map(map):
	return sorted(map.items(),key=lambda item:item[0])
if __name__=='__main__':
	strs=raw_input()
	maps=num_fre(strs)
	order_list=sort_map(maps)
	for item in  order_list:
		print '%s:%s'%(item[0],item[1])