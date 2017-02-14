package Homework3;

public interface DequeInterface<T> 
{
	public void addToFront(T newEntry);
	public void addToBack(T newEntry);
	
	
	public T removeFront();
	public T removeBack();
	
	public boolean isEmpty();
	
	public void clear();
}
