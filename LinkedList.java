package Homework3;

//linked implementation 

public class LinkedList<T> implements ADTList<T> 
{

	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedList()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	public boolean add(T newEntry) 
	{
		Node newNode = new Node(newEntry, firstNode);
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	
	public boolean addAny(int newPosition, T newEntry)
	{
		boolean success = false;
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
			success = true;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to add to");
			return success;
		
	}


	public boolean removeItem(int givenPosition) 
	{
		
			boolean success = false;
			if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
			{
				assert !isEmpty();
				if(givenPosition == 1)
				{
					
					firstNode = firstNode.getNextNode();
						
				}
				else
				{
					Node nodeBefore = getNodeAt(givenPosition - 1);
					Node nodeToRemove = nodeBefore.getNextNode();
					
					Node nodeAfter = nodeToRemove.getNextNode();
					nodeBefore.setNextNode(nodeAfter);
				}
				numberOfEntries--;
				success = true;
			}
			else
				throw new IndexOutOfBoundsException("Illegal position given to remove operation");
				return success;
	}


	public boolean removeAll()
	{
			firstNode = null;
			return true;
	}


	public boolean replace(int givenPosition, T newEntry)
	{
		boolean success = false;
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
			{
				assert !isEmpty();
				Node desiredNode = getNodeAt(givenPosition);
				T originalEntry = desiredNode.getData();
				desiredNode.setData(newEntry);
				success = true;
			}
			else
				throw new IndexOutOfBoundsException("Illegal position given to remove operation");
				return success;
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

	public int countItems() 
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
