import Queue

class Node:
	def __init__(self,value=None,left=None,right=None):
		self.value=value
		self.left=left
		self.right=right
		
def preorder_trav(root):
	if root==None:
		return 
	print root.value
	preorder_trav(root.left)
	preorder_trav(root.right)
	
def inorder_trav(root):
	if root ==None:
		return
	inorder_trav(root.left)
	print root.value
	inorder_trav(root.right)
	
def postorder_trav(root):
	if root ==None:
		return 
	postorder_trav(root.left)
	postorder_trav(root.right)
	print root.value

def breadthfirst_trav(root):
	# Create a queue and add the root node to it.
	q=Queue.Queue()
	q.put(root)
	# Visit each node in the tree.
	while not q.empty() :
		# Remove the next node from the queue and visit it.
		node = q.get()
		print( node.value )
		# Add the two children to the queue.
		if node.left is not None :
			q.put( node.left )
		if node.right is not None :
			q.put( node.right )
	
	
if __name__=='__main__':
	root=Node('A',Node('B',Node('D'),Node('E')),Node('C',Node('F'),Node('G'))) 
	print 'preorder_trav:'
	preorder_trav(root)
	print 'inorder_trav:'
	inorder_trav(root)
	print 'postorder_trav:'
	postorder_trav(root)
	print 'breadthfirst_trav:'
	breadthfirst_trav(root)
