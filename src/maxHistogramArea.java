import java.util.*;


class maxHistogramArea{

		int calculateRectArea(int[] heights){

			int size=heights.length;
			Stack<Integer> st=new Stack<Integer>();
			int maxArea=0;

			for(int i=0;i<size;i++){

				if(st.isEmpty()||heights[st.peek()]<heights[i]){
					st.push(i);
				}else{
					if(heights[st.peek()]==heights[i])
						continue;
					int lastIndex=0;
					while(!st.isEmpty()){

						if(heights[st.peek()]>heights[i]){
							int data=st.pop();
							lastIndex=data;
							if(heights[data]*(i-data)>maxArea)
								maxArea=heights[data]*(i-data);
						}else{
							if(heights[st.peek()]<=heights[i])
								break;
						}
					}
					if(heights[st.peek()]<heights[i])
						st.push(lastIndex);//lastIndex
				}
			}

			while(!st.isEmpty()){
				int data=st.pop();
				if(heights[data]*(size-data)>maxArea)
					maxArea=heights[data]*(size-data);
			}

			return maxArea;
		}
	}
 

