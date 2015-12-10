package RecursionDP;


public class SplitPoints implements Comparable<SplitPoints>{

	
	int splitPoint;
	int numOfPartitions;
	
	
	SplitPoints(int splitPoint,int partitions){
		this.splitPoint  = splitPoint;
		this.numOfPartitions = partitions;
		
		//System.out.println("In SPLIT CLASS New split: point -->" + this.splitPoint + " splits: "+this.numOfPartitions);
		
	}
	
	public int compareTo(SplitPoints s){
		
		
		return this.numOfPartitions - s.numOfPartitions;
	}
}
