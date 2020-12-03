package resources142;

public class ArrayLeftRotation {
	
	public static void main(String[] args) {
		int[] ar = {1, 2, 3, 4, 5, 6};
		ar = leftRotate(ar, 4);
		System.out.println(java.util.Arrays.toString(ar));
	}
	
	public static int[] leftRotate(int[] ar, int k) {
		int n = ar.length;
		int temp = 0;
        for(int i=0; i<k; i++) {
            temp = ar[0];
            for(int j=0; j<n-1; j++) {
                  ar[j] = ar[j+1];   
            }
            ar[n-1] = temp;
        }
		return ar;
	}
}