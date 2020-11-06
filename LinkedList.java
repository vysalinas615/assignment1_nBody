import java.util.*;

public class LinkedList<T>
{
	int size;
	
	public LinkedList()
	{
		head = new Node<T>(null);
		size = 0;
	}
	
	private class Node<T>
	{
		T data;
		Node<T> next;

		public Node(T value) 
		{  
			data = value;
			next = null;
		}
	}
	
	private Node<T> head;
	private Node<T> tail; 

	public int getSize()
	{
		return size;
	}
	
	public void add(T item)
	{
		Node<T> previous = new Node<T>(null); 
		previous = head;

		if (head == null)
		{
			head = new Node<T>(item);
			++size;
		}
		
		else
		{
			previous = head;
			while(previous.next != null)
			{
				previous = previous.next;
			}
		}

		Node<T> node = new Node<T>(item);
		previous.next = node;
		++size;
	}

}
