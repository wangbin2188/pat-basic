import Queue

class Node:
	def __init__(self,value=-1,left=None,right=None):
		self.value=value
		self.left=left
		self.right=right
		
class BinaryTree:	
	def __init__(self):
		self.root=Node()
		
	def add(self, value):
		node = Node(value)
		if self.root.value == -1:
			self.root = node
		else:                     
			myQueue = []
			curNode = self.root
			myQueue.append(curNode)
			while myQueue:                     
				curNode = myQueue.pop(0)
				if curNode.left == None:
					curNode.left = node
					return
				elif curNode.right == None:
					curNode.right = node
					return
				else:
					myQueue.append(curNode.left)
					myQueue.append(curNode.right)
					
	def preorder_trav(self,root):
		if root==None:
			return 
		print root.value
		self.preorder_trav(root.left)
		self.preorder_trav(root.right)
		
	def inorder_trav(self,root):
		if root ==None:
			return
		self.inorder_trav(root.left)
		print root.value,
		self.inorder_trav(root.right)
		
	def postorder_trav(self,root):
		if root ==None:
			return 
		self.postorder_trav(root.left)
		self.postorder_trav(root.right)
		print root.value,

	def breadthfirst_trav(self,root):
		myQueue=Queue.Queue()
		myQueue.put(root)
		while not myQueue.empty() :
			curNode = myQueue.get()
			print( curNode.value ),
			if curNode.left is not None :
				myQueue.put( curNode.left )
			if curNode.right is not None :
				myQueue.put( curNode.right )
				
	def front_stack(self, root):	
		if root == None:
			return
		myStack = []
		curNode = root
		while curNode or myStack:
			while curNode:                 
				print curNode.value,
				myStack.append(curNode)
				curNode = curNode.left
			curNode = myStack.pop()            
			curNode = curNode.right
			
	def middle_stack(self, root):		
		if root == None:
			return
		myStack = []
		curNode = root
		while curNode or myStack:
			while curNode:
				myStack.append(curNode)
				curNode = curNode.left
			curNode = myStack.pop()
			print curNode.value,
			curNode = curNode.right

	def later_stack(self, root):		
		if root == None:
			return
		myStack1 = []
		myStack2 = []
		curNode = root
		myStack1.append(curNode)
		while myStack1:                   
			curNode = myStack1.pop()
			if curNode.left:
				myStack1.append(curNode.left)
			if curNode.right:
				myStack1.append(curNode.right)
			myStack2.append(curNode)
		while myStack2:                        
			print myStack2.pop().value,

	def level_queue(self, root):		
		if root == None:
			return
		myQueue = []
		curNode = root
		myQueue.append(curNode)
		while myQueue:
			curNode = myQueue.pop(0)
			print curNode.value,
			if curNode.left != None:
				myQueue.append(curNode.left)
			if curNode.right != None:
				myQueue.append(curNode.right)
	
	
if __name__=='__main__':
	test=BinaryTree()
	for item in range(5):
		test.add(item)
	print 'preorder_trav:'
	test.preorder_trav(test.root)
	# print '\n','inorder_trav:'
	# test.inorder_trav(test.root)
	# print '\n','postorder_trav:'
	# test.postorder_trav(test.root)
	# print '\n','breadthfirst_trav:'
	# test.breadthfirst_trav(test.root)
	# print '\n','front_stack:'
	# test.front_stack(test.root)
	# print '\n','middle_stack:'
	# test.middle_stack(test.root)
	# print '\n','later_stack:'
	# test.later_stack(test.root)
	# print '\n','level_queue:'
	# test.level_queue(test.root)
