class DListNode:
	def __init__(self,item):
		self.item=item
		self.next=None
		self.prev=None
		
class DLinkList:
	def __init__(self):
		self._head=None
		self._tail=None
		self._count=0
	def __len__(self):
		return self._count
	def isEmpty(self):
		return self._head is None
	def pre_add(self,item):
		newNode=DListNode(item)
		if self._head is None:
			self._head=newNode
			self._tail=newNode
			self._count+=1
			return
		newNode.next=self._head
		self._head=newNode
		self._count+=1	
	def append(self,item):
		newNode=DListNode(item)
		if self._tail is None:
			self._tail=newNode
			self._head=newNode
			self._count+=1
		else:
			self._tail.next=newNode
			self._tail=newNode
			self._count+=1

	def remove(self,item):
		pass
	def pre_del(self):
		pass 
	def pop(self):
		pass 
	def travel(self):
		curNode=self._head
		while curNode is not None:
			print curNode.item
			curNode=curNode.next
		
if __name__=='__main__':
	test=DLinkList()
	test.pre_add('A')
	test.pre_add('B')
	test.pre_add('E')
	test.append('C')
	test.append('D')
	test.append('F')
	test.travel()
	
	