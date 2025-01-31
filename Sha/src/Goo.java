import java.util.*;

class node{
	int position;
	int length;
	
	node(int position,int length){
		this.position=position;
		this.length=length;
	}
}

public class Goo {
	
	public static int findMax(String t){
		int max=0;
		
		StringBuilder sb=sb=new StringBuilder();
		boolean start=true;
		int position=0;
		Stack<node> st=new Stack<node>();
		boolean last=false;
		for(int i=0;i<t.length();i++){
			if(t.charAt(i)=='\n' || last){
				while(!st.isEmpty() && (st.peek().position >= position))
							st.pop();
		
				if(st.isEmpty())
					st.push(new node(position,sb.length()));
				else 
					st.push(new node(position,st.peek().length+sb.length()));
				
				if(max < st.peek().length)
						max=st.peek().length;
				
				sb=new StringBuilder();
				position=0;
				continue;
			}
			
			if(t.charAt(i)==' '){
				position++;
			}
			else{
				sb.append(t.charAt(i));
				if(i==t.length()-1){
					i--;
					last=true;
				}
					
			}
		}
		return max;
	}
	
	
	public static void main(String[] args){
		
		System.out.println(findMax("Dir1\nDir2\n Dir3\n  index.jpeg\n  index234567.png\n Dir4\n  printer1.jpeg"));
		
		
	}
	

}
