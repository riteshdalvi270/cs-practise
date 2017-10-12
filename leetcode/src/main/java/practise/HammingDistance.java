package practise;

public class HammingDistance {
	
	public static void main(String args[]) {
		
		int x = 1;
		int y = 4;
		
		System.out.println(hammingDistance(x,y));
	}

	private static int hammingDistance(int x, int y) {
		int xor = x^y;
		System.out.println(xor);

        int res = 0;
        while(xor!=0) {
            System.out.println("XOR:"+xor);

        		System.out.println(xor & 1);
            res+= xor & 1;
            //System.out.println(res);
            xor >>= 1;
          }
        return res;
	}
}
