import java.util.*;
import java.lang.*;

public class ArrayList<T>
{
	int size = 0;
	private T[] arr;
	//arr T[] = new ArrayList<String>();
     
	public ArrayList()
	{
	    arr = (T[]) new Object[20];
	}
	//ArrayList<T> arr = new ArrayList()<T>;
	
	public T remove(int pos) throws Exception
	{
		//check if position is valid
		if (pos<0 || pos>=size)
		{
			throw new Exception();
			//break;
		}
	
		T item = arr[pos];
		//this is to save the item we are deleting in a way 
		for (int i=pos+1; i<size; i++)
		{
			arr[i-1]=arr[i]; //or do arr[i] = arr[i+1]
		}
		--size;
		return item;
	}
	
	
	private void grow_array () 
	{
		T [] new_arr = (T[]) new Object[arr.length*2];
		for (int i = 0; i < arr.length; i++)
		{
			new_arr[i] = arr[i];
		}
		arr = new_arr;
		//then your new array is the same as the the previous one
	}
	
	public boolean add (T item) 
	{
		if (size == arr.length)
		{
			grow_array();
		}
		arr[size++] = item;
		return true;
	}
	
	public void add (int pos, T item) 
	{
		//check position then grow array if needed beforehand but we don’t actually do it in the function
		for(int i = size; i > pos; i--)
		{
			arr[i] = arr[i-1];
		}
		arr[pos] = item;
		++size;
	}
	
	public int size () 
	{
		return size;
	}
	
	public T get(int pos)
	{
		if (pos < 0 || pos >= size)
		{
			System.out.println("Invalid position");
		}
	
		return arr[pos];
	}
	

}
