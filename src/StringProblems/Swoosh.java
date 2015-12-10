package StringProblems;
import java.util.*;

import java.io.ObjectInputStream.GetField;

public class Swoosh {

	/**
	 * @param args
	 */
	
	//private char
	
	public static float getAspectRatio(int width){
		
		return (float)width/2;
	}
	
	public static  int getOffsetMaxWidthLine(double width){ return (int)Math.ceil(width/8); }
	
	
	public static void compute(char [][] logo){
		
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		
		int offsetMaxLine = getOffsetMaxWidthLine(logo[0].length);
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(0);
		row.add(logo[0].length);
		map.put(offsetMaxLine,row);
		
		//double shiftRatio = 0.25;
		//int shiftBy = (int)(logo[0].length * shiftRatio);
		int shiftBy = 4;
		
		for(int i = offsetMaxLine + 1;shiftBy <= logo[0].length/2;i++){
			
			
			row = new ArrayList<Integer>();
			row.add(0,(int)logo[0].length - shiftBy);
			shiftBy *= 2;
			
			map.put(i, row);

		}
		
		row = new ArrayList<Integer>();
		//map.put(i,)
		
		
		
		
		
	}
	
	
	
	public static void drawLowerHalf(char [][] logo){
		 
		System.out.println("Drawing lower half");
		 int maxWidthOffset = getOffsetMaxWidthLine((double)logo[0].length);
		 
		 int k=2;
		 int numOfPixels = (int)(logo[0].length - Math.pow(2, k));
		 int i=1;
		 for(;numOfPixels >= (int)(logo[0].length/2);i++ ){
			 
			 //System.out.println("numOfPixels : " + numOfPixels + " i = " + i + " maxwidthoffset :" + maxWidthOffset + " k " + k); 
			 
			 for(int j = 0;j<numOfPixels;j++){ 
				 logo[maxWidthOffset + 1 + i][j] = 'X';			 			 
			 }
			 //System.out.println("num = " + (logo[0].length - logo[0].length/Math.pow(2, ++k)));
			 numOfPixels = (int)(logo[0].length - Math.pow(2, ++k));
			 
		 }
		 
		 System.out.println(" i = " + i);
		 
		 numOfPixels = (int)(logo[0].length/2 * 0.75); 
		 
		 System.out.println(" numOfPixels :" + numOfPixels);
		  
		 int shift = 1;
		 for(k = i;k<logo.length-1;k++){	
			 
			 
			 for(int j = 0;j<numOfPixels;j++){
				 System.out.println("k : " + k + " j: " + (j+shift)); 
				 logo[maxWidthOffset + k][j+shift] = 'X';
			 }
			 shift += 2;
		 }
		 
		 shift += 2;
		 
		 for(int j = 0;j<numOfPixels;j++){
			 
			 logo[logo.length][j+shift] = 'X';
		 }
		 
		 printLogo(logo);
		 
	 }
	
	
	
	public static void printLogo(char [][]logo){
		
		for(int i =0 ;i<logo.length;i++){
			System.out.println();
			 for(int j=0;j< logo[0].length;j++){
				 System.out.print(logo[i][j]);
			 }
		 }	
	}
	
	
	 
	 public static void drawUpperHalf(){
		 
		 
	 }
	
	
	 public static char[][] initLogo(char [][] logo){
		 
		 for(int i =0 ;i<logo.length;i++){
			 for(int j=0;j< logo[0].length;j++){
				 logo[i][j] = '-';
			 }
		 }
		 
		 return logo;
	 }
	
	
	 
	 public static void drawSwoosh(int width){
		
		int height = (int)getAspectRatio(width);
		
		char [][] logo = new char[height][width];
		System.out.println("height :" + logo.length + " width :" + logo[0].length);
		logo = initLogo(logo);
		
		drawLowerHalf(logo);
		
		
		
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		drawSwoosh(16);

	}

}
