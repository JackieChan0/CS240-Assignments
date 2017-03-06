package Homework4;
import java.util.Arrays;


public class ArrayList<T> implements ListInterface<T>
{
	
	private T[] list;
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10;
	
	public ArrayList()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayList(int initialCapacity)
	{
		if(initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else
			checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	}

	@Override
	public void add(T newEntry) 
	{
		
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
		ensureCapacity();
		
	}

	@Override
	public void add(int newPosition, T newEntry) 
	{
		
		
		if((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
		{
			if(newPosition <= numberOfEntries)
				makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity();
		}
		else
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds");
		
	}

	@Override
	public T remove(int givenPosition)
	{
		
		if((givenPosition >= 1)&& (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			T result = list[givenPosition];
			
			if(givenPosition < numberOfEntries)
				removeGap(givenPosition);
			numberOfEntries--;
			return result;
			
		}
		else
			throw new IndexOutOfBoundsException("illegal position to remove");
	}

	@Override
	public void clear() 
	{
		for(int i = 0; i < numberOfEntries; i++)
		{
			remove(i);
			numberOfEntries--;
		}
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) 
	{
		
		
		if((givenPosition >= 1)&& (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
			
		}
		else
			throw new IndexOutOfBoundsException("illegal position to replace");
		
	}

	@Override
	public T getEntry(int givenPosition) 
	{
		
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			return list[givenPosition];
			
		}
		else
			throw new IndexOutOfBoundsException("illegal position to getEntry");
	}

	@Override
	public T[] toArray() 
	{
		
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for(int i = 0;  i < numberOfEntries; i++)
		{
			result[i] = list[i + 1];
		}
		
		return result;
	}

	@Override
	public boolean contains(T anEntry) 
	{
		
		boolean found = false;
		int i = 1;
		while(!found &&(i <= numberOfEntries))
		{
			if(anEntry.equals(list[i]))
				found = true;
			i++;
		}
		return found;
	}

	@Override
	public int getLength() 
	{
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() 
	{
		return numberOfEntries == 0;
	}
	
	private void ensureCapacity()
	{
		int capacity = list.length - 1;
		if(numberOfEntries >= capacity)
		{
			int newCapacity = 2*capacity;
			checkCapacity(newCapacity);
			list = Arrays.copyOf(list, newCapacity + 1);
		}
	}
	
	private void makeRoom (int newPosition)
	{
		assert(newPosition >= 1) && (newPosition <= numberOfEntries + 1);
		
		int newIndex = newPosition;
		int lastIndex = numberOfEntries;
		
		for(int i = lastIndex; i >= newIndex; i--)
			list[i + 1] = list[i];
	}
	
	private void removeGap(int givenPosition)
	{
		assert(givenPosition >= 1) && (givenPosition < numberOfEntries + 1);
		
		int removedIndex = givenPosition;
		int lastIndex = numberOfEntries;
		for(int i = removedIndex; i < lastIndex; i++)
			list[i] = list[i + 1];
	
	}
	
	public void checkCapacity(int capacity)
	{
		if(capacity > MAX_CAPACITY)
			throw new IllegalStateException("Exceeding maximum capacity");
	}

}
