package Homework3;

import java.util.Arrays;

//vector implementation

public class Vector<T> implements ADTList<T>
{
	
	private T[] array;
	private int numberOfEntries = 0;
	private boolean init = false;
	private final static int DEFAULT_SIZE = 25;
	
	public Vector()
	{
		this(DEFAULT_SIZE);
	}
	
	public Vector(int length)
	{
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[length];
		array = temp;
		init = true;
	}
	
	private boolean arrayIsFull()
	{		
		return numberOfEntries >= array.length;
	}
	
	private void ensureCapacity()
	{
        if(numberOfEntries == array.length -1)
        {
            int newLength = 2*array.length;
            
            array = Arrays.copyOf(array, newLength);
        }
    }

	@Override
	public boolean add(T newEntry)
	{
		ensureCapacity();
		if(init == true){
			if(!arrayIsFull()){
			array[numberOfEntries] = newEntry;
			numberOfEntries++;
			}
			else
				return false;
		}		
		else
			throw  new SecurityException();		
			return true;
		
	}

	@Override
	public boolean addAny(int newPosition, T newEntry) 
	{
		ensureCapacity();
		if(!(newPosition >= array.length))
		{
			if(!(array[newPosition] == null))
			{
			   for(int i = 0; i < numberOfEntries; i++)
			   {
				   T oldEntry = array[newPosition];
				   array[newPosition] = newEntry;
				   newEntry = oldEntry;
				   newPosition++;
				   if(array[newPosition] == null)
					   break;
			   }	   
			}
			 else if((array[newPosition + 1] == null))
			 {
				while(!(array[newPosition + 1] == null))
				{
					newPosition++;
				}
				array[newPosition] = newEntry; 
			 }
			 else 
				 array[newPosition] = newEntry;
				 numberOfEntries++;	
	    }
		else
		{
			System.out.println("please put in order");
		}

		return true;
	
		
	}

	@Override
	public boolean removeItem(int givenPosition) 
	{
		boolean success = false;
		int index = 0;
	    int location = 0;
		while(success && index < numberOfEntries){
			if(array[index].equals(givenPosition)){
				success = true;
				location = index;
				
			}
			index++;
			success = true;
		}
	
		array[location] = array[numberOfEntries - 1];
		array[numberOfEntries - 1] = null;
		return success;
	}

	@Override
	public boolean removeAll() 
	{
		while(!isEmpty())
		{
			removeItem(numberOfEntries);
		}
		return true;
		
	}
	
	public boolean remove() throws Exception
	{
    	boolean success = false;
   
    	if(numberOfEntries < 0)
    	{
    
    		array[numberOfEntries -1] = null;
    		success = true;
    		numberOfEntries--;
    	}
    	else
    	{
    		throw new Exception();
    	}
    	return success;
    }

	@Override
	public boolean replace(int givenPosition, T newEntry)
	{
		boolean replaced = false;
		if( givenPosition < numberOfEntries)
		{
			array[givenPosition] = newEntry;
			replaced = true;
		}
		return replaced;
	}

	@Override
	public T lookAt(int givenPosition) 
	{
		T item = null;
		
		if(isEmpty())
			item = array[numberOfEntries -1];
		
		return item;
	}

	@Override
	public T[] toArray()
	{
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[numberOfEntries];
		
		for(int i = 0; i < numberOfEntries; i++){
			temp[i] = array[i];
		}
		return temp;
	}

	@Override
	public boolean checkForItem(T anEntry)
	{
		boolean success = false;
		int index = 0;
		while(success && index < numberOfEntries)
		{
			if(array[index].equals(anEntry))
			{
				success = true;
				
			}
			index++;
		}
		return success;
	}

	@Override
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}

	@Override
	public int countItems() 
	{
		return numberOfEntries;
	}

}
