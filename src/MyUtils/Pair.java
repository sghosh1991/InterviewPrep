package MyUtils;

public class Pair<P1,P2> {
	
	P1 p1;
	P2 p2;
	
	public Pair(P1 p1, P2 p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public P1 getX(){
		return this.p1;
	}
	
	public P2 getY(){
		return this.p2;
	}

	public void setX(P1 p1){
		this.p1 = p1;
	}
	
	public void setY(P2 p2){
			this.p2 = p2;
		}
	
	public String toString(){
		
		return("("+p1.toString()+"," + p2.toString()+")");
	}
}
