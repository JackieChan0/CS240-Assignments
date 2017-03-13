package Final;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Iterable;

public class LinkedDict <K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
{
	
	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedDict()
	{
		initializeDataFields();
	}
	
	@Override
	public V add(K key, V value) 
	{
		V result = null;
		
		Node currentNode = firstNode;
		Node nodeBefore = null;
		
		while((currentNode != null) && key.compareTo(currentNode.getKey()) > 0)
		{
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		if((currentNode != null) && key.equals(currentNode.getKey()))
		{
			result = currentNode,getValue();
			currentNode.setValue(value);
		}
		else
		{
			Node newNode = new Node(key, value);
			
			if(nodeBefore == null)
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else
			{
				newNode.setNextNode(currentNode);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
			
			return result;
		}
	}
	@Override
	public V remove(K key) 
	{
		V result  = null;
		int givenPosition;
		key.getValue() = givenPosition;
		
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
	public V getValue(K key)
	{
		
		if((key >= 1) && (key <= numberOfEntries))
		{
			assert !isEmpty();
			return getNodeAt(key).getData();
		}
		else
			throw new IndexOutOfBoundsException("illegal position given");
	}
	@Override
	public boolean contains(K key)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null))
		{
			if(key.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		return found;
	}
	@Override
	public Iterator<K> getKeyIterator() 
	{
		
		return KeyIterator();
	}
	
	@Override
	public Iterator<V> getValueIterator() 
	{
		return ValueIterator();
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
	public int getSize()
	{
		return numberOfEntries;
	}
	@Override
	public void clear()
	{
		firstNode = null;
		numberOfEntries = 0;
	
	}
	
	private class Node 
	{
		private V data;
		private K key;
		private Node next;
		private Node prev;
		private int numberOfEntries = 0;
		
		Node(K k, V dataPortion)
		{
			this(k, dataPortion, null);
		}
		
		public Node (K k, V dataSection, Node nextNode)
		{
			key = k;
			data = dataSection;
			next = nextNode;
		}
		//------------------------------------------------------------------

		private V getData()
		{
			return data;
		}
		//------------------------------------------------------------------
		private void setData(K key, V newData)
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

		public K getKey() 
		{
			
			return key;
		}
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
	
	private class KeyIterator implements Iterator<K>
	{
		private Node nextNode;
		
		private KeyIterator()
		{
			nextNode = firstNode;
		}
		
		public boolean hasNext()
		{
			return nextNode != null;
		}
		
		public K next()
		{
			K result;
			if(hasNext())
			{
				result = nextNode.getKey();
				nextNode = nextNode.getNextNode();
			}
			else
				throw new NoSuchElementException();
			return result;
		}
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}
