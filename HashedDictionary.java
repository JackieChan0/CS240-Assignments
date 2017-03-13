package Final;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashedDictionary<K,V> implements DictionaryInterface<K,V>
{
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 5;
	private static final int MAX_CAPACITY = 10000;
	
	private TableEntry<K,V>[] hashTable;
	private int tableSize;
	private static final int MAX_SIZE = 2*MAX_CAPACITY;
	private boolean initialized = false;
	private static final double MAX_LOAD_FACTOR = 0.5;
	
	public HashedDictionary()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public HashedDictionary(int initialCapacity)
	{
		checkCapacity(initialCapacity);
		numberOfEntries = 0;
		
		int tableSize = getNextPrime(initialCapacity);
		checkSize(tableSize);
		
		@SuppressWarnings("unchecked")
		TableEntry<K,V>[] temp = (TableEntry<K,V>[])new TableEntry[tableSize];
		hashTable = temp;
		initialized = true;
	}
	
	
	
	@Override
	public V add(K key, V value) 
	{
		checkInitialization();
		if((key == null) || (value == null))
			throw new IllegalArgumentException();
		else
		{
			V oldValue;
			
			int index = getHashIndex(key);
			index = probe(index, key);
			
			assert (index >= 0) && (index < hashTable.length)
			
			if((hashTable[index] == null) || hashTable[index].isRemoved())
			{
				hashTable[index] = new TableEntry<>(key, value);
				numberOfEntries++;
				oldValue = null;
 			}
			else
			{
				oldValue = hashTable[index].getValue();
				hashTable[index].setValue(value);
			}
			
			if(tableSize > MAX_SIZE)
				enlargeHashTable();
			
			return oldValue;
		}
	}

	@Override
	public V remove(K key) 
	{
		checkInitialization();
		V removedValue = null;
		
		int index = getHashIndex(key);
		index = locate(index, key);
		
		if(index != -1)
		{
			removedValue = hashTable[index].getValue();
			hashTable[index].setToRemoved();
			numberOfEntries--;
		}
		return removedValue;
	}

	@Override
	public V getValue(K key) 
	{
		checkInitialization();
		V result = null;
		
		int index = getHashIndex(key);
		index = locate(index, key);
		
		if(index != -1)
			result = hashTable[index].getValue();
		
		return result;
	}

	@Override
	public boolean contains(K key) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<K> getKeyIterator() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() 
	{
		return numberOfEntries;
	}

	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		
	}
	
	private int probe(int index, K key)
	{
		boolean found = false;
		int removedStateIndex = -1;
		while(!found && (hashTable[index] != null))
		{
			if(hashTable[index].isIn())
			{
				if(key.equals(hashTable[index].getKey()))
					found = true;
				else
					index  = (index + 1)% hashTable.length;
			}
			else
			{
				if(removedStateIndex == -1)
					removedStateIndex = index;
				index = (index  + 1) % hashTable.length;
			}
		}
		if(found || (removedStateIndex == -1))
			return index;
		else
			return removedStateIndex;
		
	}
	
	private int locate(int index, K key)
	{
		boolean found = false;
		
		while(!found && (hashTable[index] != null))
		{
			if(hashTable[index].isIn() && key.equals(hashTable[index].getKey()))
				found = true;
			else
				index = (index + 1) % hashTable.length;
		}
		
		int result = -1;
		if(found)
			result = index;
		
		return result;
	}
	
	private void enlargeHashTable()
	{
		TableEntry<K, V>[] oldTable = hashTable;
		int oldSize = hashTable.length;
		int newSize = getNextPrime(oldSize + oldSize)
	}
	
	private static class TableEntry<S, T>
	{
		private S key;
		private T value;
		private States state;
		private enum States {CURRENT, REMOVED}
		
		private TableEntry(S searchKey, T dataValue)
		{
			key = searchKey;
			value = dataValue;
			state = States.CURRENT;
		}
	}
	
}
