import java.util.Set;
import java.util.HashSet;

public class MagicSquare {

	public static void main(String[] args){

		long x = System.currentTimeMillis();
		// int[][] box = {{2,9,4},{7,5,3},{6,1,8}};
		int[][] box = getMagicSquare();
		long count = 0;
		while(!validateBox(box)){
			// System.out.println(count);
			// printBox(box);
			box = getMagicSquare();
			count++;
		}
		printBox(box);
		long y = System.currentTimeMillis();
		System.out.println("Time taken: "+(y-x) +"ms and total checks is: "+count);
	}

	static int[][] getMagicSquare(){
		int[][] box = new int[3][3];
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				int digit = getRandomNumber(set);
				box[i][j] = digit;
				set.add(digit);
			}
		}
		return box;
	}

	static boolean validateBox(int[][] box){
		// row check
		for(int i=0; i<3; i++){
			int sum = box[i][0] + box[i][1] + box[i][2];
			if(sum != 15)
				return false;
		}
		// column check
		for(int i=0; i<3; i++){
			int sum = box[0][i] + box[1][i] + box[2][i];
			if(sum != 15)
				return false;
		}
		// digonal check
		int digonal1 = box[0][0] + box[1][1] + box[2][2];
		if(digonal1 != 15)
				return false;
		int digonal2 = box[0][2] + box[1][1] + box[2][0];
		if(digonal2 != 15)
				return false;
		return true;
	}

	static int getRandomNumber(Set<Integer> set){
		int n = (int) (Math.random()*10);
		if(n > 0 && !set.contains(n))
			return n;
		else
			return getRandomNumber(set);
	}

	static void printBox(int[][] box){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				sb.append(box[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}