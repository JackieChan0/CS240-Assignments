package Final;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SeperateIterator<T> implements Iterator<T> 
{
	private ListInterface<T> list;
	private int nextPosition;
	private boolean wasNextCalled;
	
	public SeperateIterator(ListInterface<T> myList)
	{
		list = myList;
		nextPosition = 0;
		wasNextCalled = false;
	}

	@Override
	public boolean hasNext() 
	{
		return nextPosition < list.getLength();
	}

	@Override
	public T next() 
	{
		if(hasNext())
		{
			wasNextCalled = true;
			nextPosition++;
			return list.getEntry(nextPosition);
		}
		else
			throw new NoSuchElementException("illegal call to next()");
	}

	@Override
	public void remove() 
	{
		if(wasNextCalled)
		{
			list.remove(nextPosition);
			nextPosition--;
			
			
		}
	}

}
