package LinkedList;
public class LinkedListClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
		
		sll.insertBegining(5);
		sll.insertEnd(9);
		//sll.removeBegining();
		//sll.removeBegining();
		//sll.removeEnd();
		//sll.insertAt_NthPos(8,1);
		//sll.insertAt_NthPos(78, 2);
		sll.insertEnd(10);
		sll.SortedInsert(6);
		sll.insertEnd(5);
		sll.insertAt_NthPos(10, 2);
		
		/*sll.show(sll);
		sll.reverseLinkedListThreePointers();
		sll.show(sll);
		sll.reverseLinkedListTwoPointers();*/
		
		sll.show(sll);
		sll.removeDuplicates();
		
		sll.show(sll);
		
	}

}
