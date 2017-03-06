package Homework4;

public class LList<T> implements ListInterface<T> 
{

	private Node firstNode;
	private int numberOfEntries;
	
	public LList()
	{
		initializeDataFields();
	}
	
	
	@Override
	public void add(T newEntry) 
	{
		Node newNode = new Node(newEntry);
		
		if(isEmpty())
			firstNode = newNode;
		else
		{
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode);
		}
		
		numberOfEntries++;
	}

	@Override
	public void add(int newPosition, T newEntry) 
	{
			if(newPosition >= 1 && (newPosition <= numberOfEntries + 1))
			{
				Node newNode = new Node(newEntry);
				
				if(newPosition == 1)
				{
					newNode.setNextNode(firstNode);
					firstNode = newNode;
				}
				else
				{
					Node nodeBefore = getNodeAt(newPosition - 1);
					Node nodeAfter = nodeBefore.getNextNode();
					newNode.setNextNode(nodeAfter);
					nodeBefore.setNextNode(newNode);
				}
				numberOfEntries++;
			}
			else
				throw new IndexOutOfBoundsException("illegal position given");
		
	}

	@Override
	public T remove(int givenPosition) 
	{
		T result  = null;
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			if(givenPosition >= 1)
			{
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
			}
			else
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getData();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
			}
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException("illegal position given to remove");
			
	}

	@Override
	public void clear() 
	{
		firstNode = null;
		numberOfEntries = 0;
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) 
	{
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException("illegal position given to replace");
			
	}

	@Override
	public T getEntry(int givenPosition) 
	{
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		}
		else
			throw new IndexOutOfBoundsException("illegal position given");
			
	}

	@Override
	public T[] toArray() 
	{
		@SuppressWarnings("unchecked")
		T[]result = (T[])new Object[numberOfEntries];
		
		int i = 0;
		Node currentNode = firstNode;
		while((i < numberOfEntries) && (currentNode != null))
		{
			result [i] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			i++;
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) 
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null))
		{
			if(anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		return found;
	}

	@Override
	public int getLength() 
	{
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if(numberOfEntries == 0)
		{
			assert firstNode == null;
			result = true;	
		}
		
		else
		{
			assert firstNode != null;
			result = false;
		}
		return result;
	}
	
	private class Node 
	{
		private T data;
		private Node next;
		private Node prev;
		private int numberOfEntries = 0;
		
		Node(T dataPortion)
		{
			this(dataPortion, null);
		}
		
		public Node (T dataSection, Node nextNode)
		{
			data = dataSection;
			next = nextNode;
		}
		//------------------------------------------------------------------

		private T getData()
		{
			return data;
		}
		//------------------------------------------------------------------
		private void setData(T newData)
		{
			data = newData;
		}
		//------------------------------------------------------------------
		Node getNextNode()
		{
			return next;
		}
		//------------------------------------------------------------------
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		}
		//------------------------------------------------------------------
		public void setPreviousNode(Node previousNode)
		{
			prev = previousNode;
		}
		//------------------------------------------------------------------
		public Node getPreviousNode()
		{
			return prev;
		}
		//------------------------------------------------------------------	
	}
	
	private void initializeDataFields()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	private Node getNodeAt(int givenPosition)
	{
		assert(firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		
		for(int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		assert currentNode != null;
		
		return currentNode;
	}

}
