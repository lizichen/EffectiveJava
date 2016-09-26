package basic;

import java.util.Random;

public class OverrideEquals {
	public static void main(String[] args){
		OverrideRandom overrideRandomNum = new OverrideRandom();
		System.out.println(overrideRandomNum.equals(new Random()));
		Random randomNum = new Random();
		System.out.println(randomNum.equals(new Random()));
	}
}

class test{
	private int i;
	public test(int i){
		this.i = i;
	}
}

class OverrideRandom extends Random{
	public boolean equals(Object r){
		
		if(r instanceof Random){
			int i = this.nextInt(10);
			int j = ((Random)r).nextInt(10);
			
			System.out.println("i = "+i+" j= "+j);
			
			if(i == j)
				return false;
			else
				return true;
		}
		else{
			return false;
		}
	}
}

// Violate Symmetry!
class CaseInsensitiveString{
	
	public static void main(String[] args){
		CaseInsensitiveString newObjString = new CaseInsensitiveString("haha");
		String newString = "haha";
		
		System.out.println(newObjString.equals(newString));
		System.out.println(newString.equals(newObjString));
	}
	
	private final String s;
	public CaseInsensitiveString(String s){
		if(s == null)
			throw new NullPointerException();
		this.s = s;
	}
	
	public boolean equals(Object o){
		if(o instanceof CaseInsensitiveString)
			return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
		if(o instanceof String)
			return s.equalsIgnoreCase((String)o);
		return false;
	}
}

















