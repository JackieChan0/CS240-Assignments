package Homework3;


public interface ADTList<T>
{
	//these methods will add items to either the end of any point in the list
	public void add(T newEntry);
	public void addAny(int newPosition, T newEntry);
	
	//these methods will either remove a single specified entry or every entry
	public T removeItem(int givenPosition);
	public void removeAll();
	
	//this will replace an entry
	public T replace(int givenPosition, T newEntry);
	
	//these methods will allow us to look at either an item in the list or the whole list
	public T lookAt(int givenPosition);
	public T[] toArray();
	
	//this method will check for the presence of a specific item
	public boolean checkForItem(T anEntry);
	
	//this method will check if the item is empty
	public boolean isEmpty();
	
	//this will count all the items in the list and return an integer value
	public int countItems(int listCount);
	
	
}
