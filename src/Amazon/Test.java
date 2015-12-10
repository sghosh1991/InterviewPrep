package Amazon;

public class Test {

	/**
	 * @param args
	 */
	
	public static class LNode{
		
		public int value;
		public LNode next;
		
		public LNode(){}
		
		
	}
	
	
	public static LNode mergeLists(LNode head1,LNode head2)
	  {
	    // WRITE YOUR CODE HERE
	    
	    LNode temp1 = head1;
	    LNode temp2 = head2;
	    LNode res = null, resTemp = null;
	    LNode resHead = null;
	    
	    
	    if(head1 == null){ return head2; }
	    if(head2 == null){ return head1;}
	    
	    while(temp1 != null && temp2 != null)
	    {
	        
	        if(temp1.value <= temp2.value){
	            
	            res =  new LNode();
	            res.value = temp1.value;
	            res.next = null;
	            
	            if(resHead == null){
	                resHead = res;
	                resTemp = res;
	            }
	            else{
	                 resTemp.next = res;
	                 resTemp = resTemp.next;
	            }
	 
	            temp1 = temp1.next;
	            
	        }
	        else{
	            
	            res =  new LNode();
	            res.value = temp2.value;
	            res.next = null;
	            
	            if(resHead == null){
	                resHead = res;
	                resTemp = res;
	            }
	            else{
	                 resTemp.next = res;
	                 resTemp = resTemp.next;
	            }
	            
	            temp2 = temp2.next;

	            
	        }
	        
	    } //while ends
	    
	    if(temp1==null){
	        
	        while(temp2!=null){
	            
	            res =  new LNode();
	            res.value = temp2.value;
	            res.next = null;
	            
	            resTemp.next = res;
	            
	            resTemp = resTemp.next;
	            
	            temp2 = temp2.next;
	            
	        }
	        
	    }
	    else{
	        
	        
	         while(temp1!=null){
	            
	            res =  new LNode();
	            res.value = temp1.value;
	            res.next = null;
	            
	            resTemp.next = res;
	            
	            resTemp = resTemp.next;
	            
	            temp2 = temp1.next;
	            
	        }
	        
	        
	        
	        
	    }
	    
	    
	    return resHead;
	    
	    
	    
	  }
	
	
	
	public static void printLL(LNode x){
		
		while(x!=null){
			
			System.out.print(x.value + " ");
			x = x.next;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//printPattern(4);
		
		LNode l1 = new LNode();
		l1.value = 1;
		LNode l2 = new LNode();
		l2.value = 1;
		LNode l3 = new LNode();
		l3.value = 2;
		LNode l4 = new LNode();
		l4.value = 3;
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		
		
		LNode m1 = new LNode();
		m1.value = 1;
		LNode m2 = new LNode();
		m2.value = 4;
		LNode m3 = new LNode();
		m3.value = 5;
		LNode m4 = new LNode();
		m4.value = 8;
		
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = null;
		
		
		LNode x = Test.mergeLists(l1, m1);
		
		Test.printLL(x);
		
		
		

	}

}
