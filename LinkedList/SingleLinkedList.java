package LinkedList;
import java.util.Iterator;
import java.util.HashMap;



public class SingleLinkedList<Item> implements Iterable<Item>{
	
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
	
	/*public int compareTo(Item i){
		
		int item = 
		return Integer.compare(item, i);
		
	}*/
	
	public Iterator<Item> iterator(){
		return new SLL_Iterator();
	}
	
	private class SLL_Iterator implements Iterator<Item>{
		
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
	
	public void insertBegining(Item item){
		
		Node oldFirst = first;
		first = new Node(item);
		if(isEmpty()) last = first;
		else first.next = oldFirst;
		N++;
		
		
	}
	
	public Item removeBegining(){
		
		if(isEmpty()) return null;
		Item item = first.item;
		first = first.next;
		N--;
		if(isEmpty()) last = first;
		return item;
	}
	
	
	public void insertEnd(Item item){
		
		Node oldLast = last;
		last = new Node(item);
		if(isEmpty()) first = last;
		else oldLast.next = last;
		N++;
		
	}

	public void removeEnd(){
		// more effiicient with DLL
		Node currentNode = null;
		Node nextNode = null;
		
		if(isEmpty()){
			System.out.println("List Empty nothing to remove");
			return;
		}
		else if(size()==1){
			
			//only one item in list
			removeBegining();
		}
		else{
			currentNode=first;
			nextNode = currentNode.next;
			while(nextNode.next!=null){
				currentNode=nextNode;
				nextNode=currentNode.next;
				}
		}
		
		//now remove
		currentNode.next = null;
	}
	
	public void insertAt_NthPos(Item item,int n){
		//Not more efficient with DLL as client gives only the index so we must first get a reference to that index
		
		// if the index to insert is more than size exit with error
		if(n>size()+1){
			System.out.println("Insert out of index. Failed Insert");
			return;
		}
		Node current = first;
		int count=1;
		
		if(n==1){
			
			//this is the special case for inserting at the begining
			insertBegining(item);
			return;
			
		}
		
		//Loop till the node at index n-1. If current = NULL then this is a case of insert at the beginging
		while(count<n-1){
			
			current=current.next;
			count++;
		}
		Node oldNext = current.next;
		current.next = new Node(item);
		current.next.next = oldNext;
		
		
	}
	
	
	public void SortedInsert(Item item){
		
		Node head = first;
		Node current=null;
		//Node newNode = new Node(item);
		int cmp;
		cmp = Integer.compare((Integer)head.item, (Integer)item);
		if(head == null || cmp >=0){
			
			// need to insert at the begining
			insertBegining(item);
			return;
			
		}
		
		else{
			current = first;
			cmp = Integer.compare((Integer)current.next.item, (Integer)item);
			while(current.next!=null && cmp<0){
				cmp = Integer.compare((Integer)current.next.item, (Integer)item);
				current=current.next;
			}
			
			Node oldNext = current.next;
			current.next = new Node(item);
			current.next.next=oldNext;
			
		}
		
	}
	
	
	
	public void removeDuplicates(){
		 HashMap<Item,Node> map = new HashMap<Item,Node>();
		 Node front = first;
		 Node back = null;
		 
		 while(front!= null){
			 
			 //front.next != null use korle last node ta chek hobe na
			 if(map.containsKey(front.item)){
				 
				 //we have a duplicate
				 //remove the front node and link back.next to front.next
				 
				 back.next=front.next;
				 front = front.next;
				 
			 }
			 
			 else{

				 map.put(front.item, front);
				 back=front;
				 front=front.next;
				 
			 } 
			  
		 }	
		 
		 
	}
	
	
	
	
	public void reverseLinkedListTwoPointers(){
		
		Node result=null; //result contains the head node after the reversal
		Node current=first;
		Node next;
		
		if(size()==1) return;
		else{
			
			while(current!=null){
				
				next=current.next;
				current.next = result;
				result = current;
				current = next;
			}
			
			
		first = result;
		}
		
	}
	

	public void reverseLinkedListThreePointers(){
		
		Node back=null;
		Node mid = first;
		Node front = first.next;
		
		while(front != null){
			
			mid.next = back;
			back = mid;
			mid = front;
			front = front.next;
		}
		
		// Important Have to do this
		mid.next = back;
		first = mid;
		
		
	}
	
	
	public void show(SingleLinkedList<Integer> sll){
		
		for(Integer i:sll)
			System.out.print(i + " ");
		System.out.print("\n");
	}
	
	public Node getHead(){
		 return first;
	 }
	
}
