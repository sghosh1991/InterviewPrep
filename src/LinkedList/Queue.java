package LinkedList;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	
	private Node first,last;
	int N;
	private class Node{
		Item item;
		Node next;
		
	Node(Item item){
			this.item = item;
			this.next = null;
		}
	}
	
	public Iterator<Item> iterator(){
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>{
		
		private Node current = first;
		
		public boolean hasNext(){
			return (current !=null);
		}
		
		public Item next(){
			
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		public void remove() {}
		
	}
	
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		
		return N;
	}
	
	public void enqeue(Item item){
		
		Node oldLast = last;
		last = new Node(item);
		//last.next = null;
		if( isEmpty()) {
			first = last;
		}
		else oldLast.next =last;
		N++;
	}
	
	public Item dequeue(){
		
		if(N==0) return null;
		else{
			
			Item item = first.item;
			first = first.next;
			N--;
			if(isEmpty()) last = null;
			return item;
			
		}
	}

}
