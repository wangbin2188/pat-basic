from sys import stdin

def sequence(list,n):
	new_list=map(lambda x:float(x),list)
	list_sum=0
	for i in range(n+1):
		for j in range(i):
			list_sum=list_sum+sum(new_list[j:i])
	return '%.2f'%list_sum

if __name__=='__main__':
	count=0
	while True:
		line=stdin.readline().strip()
		count=count+1
		if line=='':
			break
		if count==1:
			n=int(line)
		elif count==2:
			arr_list=line.split(' ')
	print sequence(arr_list,n)