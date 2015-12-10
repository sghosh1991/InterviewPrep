package LinkedList;

public class QueueClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = {"Santosh", "Zinnia", "Krishna", "Ashmita","Malay"};
		Queue<String> queue = new Queue<String>();
		
		for(String s:arr){
			
			queue.enqeue(s);
		}
		
		System.out.println("Queue Size: " + queue.size());
		for(String s:queue){
			System.out.println(s + " ");
		}

	}

}
