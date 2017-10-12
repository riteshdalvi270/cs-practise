package practise;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

	public static void main(String args[]) {
		
		int num = 401;
		
		System.out.println(intToRoman(num));
	}
	
	
	private static String intToRoman(int num) {
		
		if(num == 0) {
			return null;
		}
		
		final Map<Integer,String> romanTable = new HashMap<>();
		
		buildTable(romanTable);
		
		return intToRoman(num,romanTable);
	}
	
	private static void buildTable(final Map<Integer,String> romanTable) {
		
		romanTable.put(1, "I");
		romanTable.put(4, "IV");
		romanTable.put(5, "V");
		romanTable.put(9, "IX");
		romanTable.put(10, "X");
		romanTable.put(40, "XL");
		romanTable.put(50, "L");
		romanTable.put(90, "XC");
		romanTable.put(100, "C");
		romanTable.put(400, "CD");
		romanTable.put(500, "D");
		romanTable.put(900, "CM");
		romanTable.put(1000, "M");
	}
	
	private static String intToRoman(int num, Map<Integer,String> romanTable) {
		
		final StringBuilder st = new StringBuilder();
		
		while(num!=0) {
			
			if(romanTable.containsKey(num)) {
				st.append(romanTable.get(num));
				break;
			}
			
			if(num > 1 && num < 4) {
				num = num - 1;
				st.append(romanTable.get(1));
			}else if(num > 4 && num < 5) {
				num = num - 4;
				st.append(romanTable.get(4));
			}else if(num > 5 && num < 9) {
				num = num - 5;
				st.append(romanTable.get(5));
			}else if(num > 9 && num < 10) {
				num = num - 9;
				st.append(romanTable.get(9));
			}else if(num > 10 && num < 40) {
				num = num - 10;
				st.append(romanTable.get(10));
			}else if(num > 40 && num < 50) {
				num = num - 40;
				st.append(romanTable.get(40));
			}else if(num > 50 && num < 90) {
				num = num - 50;
				st.append(romanTable.get(50));
			}else if(num > 90 && num < 100) {
				num = num - 90;
				st.append(romanTable.get(90));
			}else if(num > 100 && num < 400) {
				num = num - 100;
				st.append(romanTable.get(100));
			}else if(num > 400 && num < 500) {
				num = num - 400;
				st.append(romanTable.get(400));
			}else if(num > 500 && num < 900) {
				num = num - 500;
				st.append(romanTable.get(500));
			}else if(num > 900 && num < 1000) {
				num = num - 900;
				st.append(romanTable.get(900));
			}else if(num > 1000) {
				num = num - 1000;
				st.append(romanTable.get(1000));
			}
		}
		
		return st.toString();
	}
}
