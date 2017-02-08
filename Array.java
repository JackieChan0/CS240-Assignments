package Homework2;

import java.util.*;

public final class Array<T> implements StackInterface
{

	private T[] stack;
	private int topIndex;
	private boolean initialized = false;
	public static final int DEFAULT_CAPACITY = 10;
	public static final int MAX_CAPACITY = 10;
	
	public Array()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public Array(int initialCapacity)
	{
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}
	@Override
	public void push(Object newEntry) 
	{
		
		ensureCapacity();
		stack[topIndex + 1] = (T) newEntry;
		topIndex++;
	
	}
	
	private void ensureCapacity()
	{
		if(topIndex == stack.length -1)
		{
			int newLength = 2*stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}
	}

	@Override
	public Object pop() 
	{
		
		if(isEmpty())
			throw new EmptyStackException();
		else
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
		
	}

	@Override
	public Object peek() 
	{
		
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack [topIndex];
	}

	@Override
	public boolean isEmpty() 
	{
		
		return topIndex < 0;
	}

	@Override
	public void clear() 
	{
		stack = null;	
	}
	
	public void checkCapacity(int capacity)
	{
		if(capacity > MAX_CAPACITY)
			throw new IllegalStateException("Exceeding maximum capacity");
	}

}
