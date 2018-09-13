class ListNode:
	def __init__(self,data):
		self.data=data
		self.next=None
		
class LinkList :
	def __init__( self ):
		self.head = None
		self._size = 0
	def is_empty(self):
		return self.head is None
	def __len__( self ):
		return self._size
	def __contains__( self, target ):
		curNode = self.head
		while curNode is not None and curNode.data != target :
			curNode = curNode.next
		return curNode is not None
	def search(self,target):
		curNode =self.head
		while curNode is not None and curNode.data !=target:
			curNode=curNode.next
		return curNode is not None
	def pre_add(self,data ):
		newNode = ListNode(data )
		newNode.next = self.head
		self.head = newNode
		self._size += 1
	def append(self,data):
		newNode=ListNode(data)		
		if self.head is None:
			self.head=newNode
			self._size+=1
			return 
		curNode=self.head
		while curNode.next is not None:
			curNode=curNode.next
		curNode.next=newNode
		self._size+=1
	def pre_del(self):
		if self.head is None:
			return 
		curNode=self.head
		print curNode.data
		self.head=curNode.next
	def pop(self):
		if self.head is None:
			return
		preNode=None
		curNode=self.head
		while curNode.next is not None:
			preNode=curNode
			curNode=curNode.next
		if curNode is self.head:
			print curNode.data
			self.head=None
			self._size-=1
		else:
			print curNode.data
			preNode.next=curNode.next
			self._size -=1	
		
	def travel(self,head):
		curNode=self.head
		while curNode is not None:
			print curNode.data
			curNode=curNode.next
	def remove( self, data ):
		predNode = None
		curNode = self.head
		while curNode is not None and curNode.data != data :
			predNode = curNode
			curNode = curNode.next

		self._size -= -1
		if curNode is self.head :
			self.head = curNode.next
		else :
			predNode.next = curNode.next
		return curNode.data

		
if __name__=='__main__':		
	test=LinkList()
	for i in range(10):
		test.append(i)
	test.pop()
	test.pop()
	print '*********************'
	test.pre_del()
	test.pre_del()
	print '*********************'
	print test.remove(4)
	print test.remove(5)
	print '*********************'
	test.travel(test.head)
	print test.search(5)
	print test.search(6)
	
	
	

