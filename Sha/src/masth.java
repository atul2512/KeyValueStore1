import java.math.BigInteger;
import java.util.HashMap;


public class masth {

	static boolean isInRange(boolean leftInclude,boolean rightInclude,BigInteger left,BigInteger right,BigInteger id){
		
		//	System.out.println(leftInclude+" "+rightInclude+" "+left +" "+right+" "+id);
			if(left.compareTo(right)>=0){ 
				return isInRange(leftInclude,false,left,new BigInteger("2").pow(3),id) || 
						
						(rightInclude==false && right.compareTo(new BigInteger("0"))==0 && new BigInteger("0").compareTo(id)==0 )?false:isInRange(true,rightInclude,(new BigInteger("0")),right,id);
			}
			
			
			if(leftInclude && rightInclude){
				if(id.compareTo(left)>=0 && id.compareTo(right)<=0){
					return true;
				}
			}
			else if(leftInclude){
				if(id.compareTo(left)>=0 && id.compareTo(right)<0){
					return true;
				}
			}
			else if(rightInclude){
				if(id.compareTo(left)>0 && id.compareTo(right)<=0){
					return true;
				}
			}
			else if(id.compareTo(left)>0 && id.compareTo(right)<0){
					return true;
			}
			
			return false;
		}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println (new BigInteger("-2").mod(new BigInteger("8")));
		//System.out.println(masth.isInRange(false, false, new BigInteger("2"),  new BigInteger("0") ,  new BigInteger("2")));
		
		
		HashMap<BigInteger,String> temp=new HashMap<BigInteger,String>();
		
		temp.put(new BigInteger("123123"), "sdfasdf");
		temp.put(new BigInteger("5533"), "sdfasdf");
		
		temp.clear();
		
		System.out.println(temp);
		
		
	}

}
