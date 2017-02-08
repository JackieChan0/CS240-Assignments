package Homework2;

import java.util.EmptyStackException;
import java.util.Vector;

public final class VectorStack<T> implements StackInterface<T> 
{
	
	private Vector<T> stack;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public VectorStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public VectorStack(int initialCapacity)
	{	
		stack = new Vector<T>(initialCapacity);
		initialized = true;
	}
	

	@Override
	public void push(T newEntry) 
	{	
		stack.addElement(newEntry);
		
	}

	@Override
	public T pop()
	{
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack.remove(stack.size() - 1);
	}

	@Override
	public T peek()
	{
		
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack.lastElement();
	}

	@Override
	public boolean isEmpty() 
	{
		return stack.isEmpty();
	}

	@Override
	public void clear() 
	{
		while(!isEmpty())
			pop();
	}

}
