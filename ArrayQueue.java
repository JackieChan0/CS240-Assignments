package Homework2;

public final class ArrayQueue <T> implements QueueInterface<T> 
{
	private T[] queue;
	
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_CAPACITY = 10; 
	private static final int MAX_CAPACITY = 10; 
	
	public ArrayQueue()
	{
		this(DEFAULT_CAPACITY);		
	}
	
	public ArrayQueue(int initialCapacity)
	{
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
	
	}
	
	public T getFront()
	{
		
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return queue[frontIndex];
	}

	@Override
	public void enqueue(T newEntry) 
	{
		
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	
	}

	@Override
	public T dequeue() 
	{
		
		if(isEmpty())
			throw new EmptyQueueException();
		else
		{
			T front = queue[frontIndex];
			queue [frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	}
	
	private void ensureCapacity()
	{
		if(frontIndex == ((backIndex + 2) % queue.length))
		{
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			checkCapacity(newSize);
			
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for(int index = 0; index < oldSize - 1; index++)
			{
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}

	@Override
	public boolean isEmpty() 
	{		
		return frontIndex == ((backIndex + 1) % queue.length);		
	}
	
	public void checkCapacity(int capacity)
	{
		if(capacity > MAX_CAPACITY)
			throw new IllegalStateException("Exceeding maximum capacity");
	}

	@Override
	public void clear() 
	{
		queue = null;
		
	}

	
}
