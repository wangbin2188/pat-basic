def linearSearch(theValues,target):
    for i in range(len(theValues)):
        if theValues[i]==target:
            return True
    return False

def sortedLinearSearch(theValues,target):
    n=len(theValues)
    for i in range(n):
        if theValues[i]==target:
            return True
        elif theValues[i]>target:
            return False
    return False

def binarySearch( theValues, target ) :
    low = 0
    high = len(theValues) - 1
    while low <= high :
        mid = (high + low)//2
        if theValues[mid] == target :
            return True
        elif target < theValues[mid] :
            high = mid - 1
        else :
            low = mid + 1
    return False

if __name__=='__main__':
    list=[19,8,7,6,32,5,4,13,14,15,10,28]
    sorted_list=[4, 5, 6, 7, 8, 10, 13, 14, 15, 19, 28, 32]
    print binarySearch(sorted_list,28)
