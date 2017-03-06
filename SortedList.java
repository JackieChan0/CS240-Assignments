package Homework4;

public class SortedList <T extends Comparable<? super T>> implements SortedListInterface<T>
{

	private Node firstNode;
	private int numberOfEntries;
	
	private ListInterface<T> list;
	
	public SortedList()
	{
		list = new LList<T>();
	}
	@Override
	public void add(T newEntry)
	{
		Node newNode = new Node (newEntry);
		Node nodeBefore = getNodeBefore(newEntry);
		
		if(isEmpty() || (nodeBefore == null))
		{
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		}
		else
		{
			Node nodeAfter = nodeBefore.getNextNode();
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
		}
		numberOfEntries++;
		
	}

	@Override
	public boolean remove(T anEntry) 
	{
		boolean result = false;
		int position = getPosition(anEntry);
		
		if(position > 0)
		{
			list.remove(position);
			result = true;
		}
		return result;
	}

	@Override
	public int getPosition(T anEntry)
	{
		int position = 1;
		int length = list.getLength();
		
		while((position <= length) && (anEntry.compareTo(list.getEntry(position)) > 0))
		{
			position++;
		}
		if((position > length) || (anEntry.compareTo(list.getEntry(position)) > 0))
		{
			position = -position;
			
		}
		return position;
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
	public int getLength() 
	{
		return numberOfEntries;
	}

	@Override
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
	
	private Node getNodeBefore(T anEntry)
	{
		Node currentNode = firstNode;
		Node nodeBefore = null;
		
		while((currentNode != null) && (anEntry.compareTo(currentNode.getData()) > 0))
		{
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		return nodeBefore;
		
	}
	
	private Node add(T newEntry, Node currentNode)
	{
		if((currentNode == null) || (newEntry.compareTo(currentNode.getData()) <= 0))
		{
			currentNode = new Node(newEntry, currentNode);
		}
		else
		{
			Node nodeAfter = add(newEntry, currentNode.getNextNode());
			currentNode.setNextNode(nodeAfter);
		}
		return currentNode;
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
