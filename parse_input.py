# 1004
def parse_input(line):
	result={}
	list=line.split(' ')
	if len(list)==1 or len(list)>3:
		return
	result['name']=list[0]
	result['sno']=list[1]
	result['value']=list[2]
	return result
	
# sort and print
def max_min(list):
	new_list=sorted(list,key=lambda x:x['value'],reverse=True)
	print new_list[0]['name'],new_list[0]['sno']
	print new_list[-1]['name'],new_list[-1]['sno']
	
# failture
if __name__=='__main__':
	sw=''
	list=[]
	for line in iter(raw_input,sw):
		if parse_input(line)!=None:
			list.append(parse_input(line))
	max_min(list)
	exit(0)
	
