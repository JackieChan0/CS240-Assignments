package Homework3;

public class DoublyLinkedDeque <T extends Comparable<? super T>> implements DequeInterface <T>
{
	private DLNode firstNode;
	private DLNode lastNode;
	private int numberOfEntries;
	 
	public DoublyLinkedDeque()
	{
		firstNode = null;
		lastNode = null;
	}
	
	
	public void addToBack (T newEntry)
	{
		DLNode newNode = new DLNode(lastNode, newEntry, null);
		
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		
		lastNode = newNode;
	}
	
	public void addToFront(T newEntry)
	{
		DLNode newNode = new DLNode(null, newEntry, firstNode);
		
		if(isEmpty())
			lastNode = newNode;
		else
			firstNode.setPreviousNode(newNode);
		
		firstNode = newNode;
	}
	
	public T removeFront()
	{
		T front = getFront();
		
		assert firstNode != null;
		
		firstNode = firstNode.getNextNode();
		
		if(firstNode == null)
			lastNode = null;
		else
			firstNode.setPreviousNode(null);
		
		return front;
	}
	 
	public T removeBack()
	{
		T back = getBack();
		assert lastNode != null;
		lastNode = lastNode.getPreviousNode();
		
		if(lastNode == null)
			firstNode = null;
		else
			lastNode.setNextNode(null);
		return back;
	}
	 
	public T getFront()
	{
		return firstNode.getData();
	}
	 
	public T getBack()
	{
		return lastNode.getData();
	}
	 
	//contains methods needed for using DoublyLinked nodes
	private class DLNode
	{
		private T data;
		private DLNode next;
		private DLNode prev;
		
		private DLNode (DLNode prevNode, T dataSection, DLNode nextNode)
		{
			data = dataSection;
			next = nextNode;
			prev = prevNode;
		}
	
		private T getData()
		{
			return data;
		}

		private void setData(T newData)
		{
			data = newData;
		}
		 
		private DLNode getNextNode()
		{
			return next;
		}
		 
		private void setNextNode(DLNode nextNode)
		{
			next = nextNode;
		}
	 
		public void setPreviousNode(DLNode previousNode)
		{
			prev = previousNode;
		}
		 
		public DLNode getPreviousNode()
		{
			return prev;
		}
		 
	}
 
	//returns true if empty
	@Override
	public boolean isEmpty() 
	{
		if(numberOfEntries > 0)
		return false;
		
		else
			return true;
	}
	 
	//clears elements
	@Override
	public void clear() 
	{
		for(int i = numberOfEntries; i > 0; i--)
		{
			removeFront();
		}
			numberOfEntries = 0;
		
	}
	 
}


