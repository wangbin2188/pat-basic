# 1.insertion_sort
def insertion_sort(old_list):
	n=len(old_list)
	k=0
	for i in range(1,n):
		temp=old_list[i]
		j=i
		while j>0 and temp<old_list[j-1]:
			old_list[j]=old_list[j-1]
			j=j-1
		old_list[j]=temp
	return old_list
			

# 2.selection_sort
def selection_sort(old_list):
	n=len(old_list)
	for i in range(n):
		min_index=i
		for j in range(i,n):
			if old_list[j]<old_list[min_index]:
				min_index=j 
		old_list[i],old_list[min_index]=old_list[min_index],old_list[i]
	return old_list


# 3.bubble_sort
def bubble_sort(old_list):
    n=len(old_list)
    for i in range(n-1):
        for j in range(n-1-i):
            if old_list[j]>old_list[j+1]:
                old_list[j],old_list[j+1]=old_list[j+1],old_list[j]
    return old_list

# 4.quick_sort
def quick_sort(L,low,high):
	i = low
	j = high
	if i >= j:
		return L
	key = L[i]
	while i < j:
		while i < j and L[j] >= key:
			j = j-1
		L[i] = L[j]
		while i < j and L[i] <= key:
			i = i+1
		L[j] = L[i]
	L[i] = key
	quick_sort(L, low, i-1)
	quick_sort(L, j+1, high)
	return L

# 5.merge_sort
def merge_sort(lists):
	if len(lists) <= 1:
		return lists
	num = len(lists) / 2
	left = merge_sort(lists[:num])
	right = merge_sort(lists[num:])
	return merge(left, right)

def merge(left, right):
	i, j = 0, 0
	result = []
	while i < len(left) and j < len(right):
		if left[i] <= right[j]:
			result.append(left[i])
			i += 1
		else:
			result.append(right[j])
			j += 1
	result += left[i:]
	result += right[j:]
	return result


# 6.shell_sort
def shell_sort(nums):
    step = len(nums)/2
    while step > 0:
        for i in range(step, len(nums)):
            while i >= step and nums[i-step] > nums[i]:
                nums[i], nums[i-step] = nums[i-step], nums[i]
                i -= step
        step = step/2
    return nums
# 7.heap_sort
# 8.radix_sort
if __name__=='__main__':
    list=[19,8,7,6,32,5,4,13,14,15,10,28]
    print list
    data=insertion_sort(list)
    print data
