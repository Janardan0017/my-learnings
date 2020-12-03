package resources142;

public class MakeAnagram {

		public static void main(String[] args) {
		
			System.out.println(makeAnagram("abc", "cde"));
			System.out.println(makeAnagram("", "cde"));
			System.out.println(makeAnagram("abc", ""));
			System.out.println(makeAnagram("", ""));
			System.out.println(makeAnagram("aaa", "aaa"));
			System.out.println(makeAnagram("abc", "de"));
			
		}
	
		static int makeAnagram(String a, String b) {
			char[] A = a.toCharArray();
			char[] B = b.toCharArray();
			int count = 0;
			for(int i=0; i<A.length; i++){
				for(int j=0; j<B.length; j++){
					if(A[i] == B[j]){
						B[j] = ' ';
						count += 2;
						break;
					}
				}
			}
			return A.length + B.length - count;
		}
}