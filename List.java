package Homework3;

public class List<T> implements ADTList<T> 
{

	private Node firstNode;
	private int numberOfEntries;
	
	public List()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
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

	
	public void addAny(int newPosition, T newEntry)
	{
		if((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
		{
			Node newNode = new Node(newEntry);
			if(newPosition == 1)
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else
			{
				Node nodeBefore = getNodeAt(newPosition -1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to add to");
		
	}


	public T removeItem(int givenPosition) 
	{
			T result = null;
			
			if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
			{
				assert !isEmpty();
				if(givenPosition == 1)
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
				throw new IndexOutOfBoundsException("Illegal position given to remove operation");
	}


	public void removeAll()
	{
		for(int i = numberOfEntries; i > 0; i--)
		{
			firstNode = null;
		}
			numberOfEntries = 0;
	}


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
				throw new IndexOutOfBoundsException("Illegal position given to remove operation");
	}


	public T lookAt(int givenPosition) 
	{
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation");	
	}


	public T[] toArray() 
	{
		{
			@SuppressWarnings("unchecked")
			T[] result = (T[])new Object[numberOfEntries];
			
			int index = 0;
			Node currentNode = firstNode;
			while((index <  numberOfEntries) && (currentNode != null))
			{
				result[index] = currentNode.getData();
				currentNode = currentNode.getNextNode();
				index++;
			}
			return result;
		}
	}


	public boolean checkForItem(T anEntry) 
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

	
	public boolean isEmpty() 
	{
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

	
	public int countItems(int listCount) 
	{
		return numberOfEntries;
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
		private Node getNextNode()
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
	
	private Node getNodeAt(int givenPosition)
	{
		assert (firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		
		for(int counter = 1; counter < givenPosition; counter++)
		{
			currentNode = currentNode.getNextNode();
		}
		
		assert currentNode != null;
		
		return currentNode;
	}
	
	

}
