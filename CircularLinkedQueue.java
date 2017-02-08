package Homework2;

public final class CircularLinkedQueue <T> implements QueueInterface<T>
{

	private Node queueNode;
	private Node freeNode;
	
	public CircularLinkedQueue()
	{
		freeNode = new Node(null, null, null);
		freeNode.setNextNode(freeNode);
		queueNode = freeNode;
	}
	@Override
	public void enqueue(T newEntry) 
	{
		freeNode.setData(newEntry);
		if(isChainFull())
		{
			Node newNode = new Node(null, null, freeNode.getNextNode());
			freeNode.setNextNode(newNode);
		}
		freeNode.setNextNode(freeNode);
	}

	@Override
	public T dequeue() 
	{
		T front = getFront();
		assert !isEmpty();
		queueNode.setData(null);
		queueNode = queueNode.getNextNode();
		
		return front;
	}

	@Override
	public T getFront() 
	{
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return queueNode.getData();
	}

	@Override
	public boolean isEmpty() 
	{
		return queueNode == freeNode;
	}
	
	private boolean isChainFull()
	{
		return queueNode == freeNode.getNextNode();
	}

	@Override
	public void clear() 
	{
		while(!isEmpty())
			dequeue();
	}
	
	public class Node
	{
		private T data;
		private Node next;
		private Node prev;
		private int numberOfEntries = 0;
		
		
		public Node (Node prevNode, T dataSection, Node nextNode)
		{
			data = dataSection;
			next = nextNode;
		}
		

		private T getData()
		{
			return data;
		}
		
		private void setData(T newData)
		{
			data = newData;
		}
		
		public Node getNextNode()
		{
			return next;
		}
		
		public void setNextNode(Node nextNode)
		{
			next = nextNode;
		}
		
		public void setPreviousNode(Node previousNode)
		{
			prev = previousNode;
		}
		
		public Node getPreviousNode()
		{
			return prev;
		}
		
	}
	
}
