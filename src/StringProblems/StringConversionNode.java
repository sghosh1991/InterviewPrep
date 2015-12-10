package StringProblems;

public class StringConversionNode {

	String child;
	StringConversionNode parent;
	
	public StringConversionNode(String child,StringConversionNode parent){
		this.child = child;
		this.parent = parent;
	}
}
