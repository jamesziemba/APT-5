public class MaxBoggle { 
	private static long mod = (long)10000000000000L;
	private static long way = 0;
	public long maxPoints(String[] matrix, String[] words){
		long retval = 0;
		for(String word : words){
			retval+=calcScore(word,matrix)%(long)10000000000000L;
		}
		retval%=(long)10000000000000L;
		return retval;
	}
	private long calcScore(String word, String[] matrix){
		long ways = 0L;
		long[][] curr = new long[4][4];
		for(int i = 0;i<word.length();i++){
			if(i==0){
				for(int j=0;j<4;j++){
					for(int k=0;k<4;k++){
						if (matrix[j].charAt(k) == word.charAt(0)){
							curr[j][k] = 1L%mod;
						}
					}
				}
			}
			else{
				long[][] prev = curr;
				curr = new long[4][4];
				for(int j=0;j<4;j++){
					for(int k=0;k<4;k++){
						if (matrix[j].charAt(k) == word.charAt(i)) {
							curr[j][k] = neighborSum(prev,j,k)%(long)10000000000000L;
						}
					}
				}
			}
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				way+=curr[i][j];
				ways+=curr[i][j]%(long)10000000000000L;
			}
		}
		long retval = (long) (ways%(long)10000000000000L*(long)Math.pow(word.length(), 2))%(long)10000000000000L;
		return retval%(long)10000000000000L;

	}


	private long neighborSum(long[][] previous, int i, int j){
		long retval = 0;
		if(i==0 && j==0){
			retval+= previous[0][1]%mod;
			retval+= previous[1][0]%mod;
			retval+= previous[1][1]%mod;
			retval%=mod;
			return retval;
		}
		if(i==0 && j==1){
			retval+= previous[0][0]%mod;
			retval+= previous[0][2]%mod;
			retval+= previous[1][0]%mod;
			retval+= previous[1][1]%mod;
			retval+= previous[1][2]%mod;
			retval%=mod;
			return retval;
		}
		if(i==0 && j==2){
			retval+= previous[0][1]%mod;
			retval+= previous[0][3]%mod;
			retval+= previous[1][1]%mod;
			retval+= previous[1][2]%mod;
			retval+= previous[1][3]%mod;
			retval%=mod;
			return retval;
		}
		if(i==0 && j==3){
			retval+= previous[0][2]%mod;
			retval+= previous[1][2]%mod;
			retval+= previous[1][3]%mod;
			retval%=mod;
			return retval;
		}
		if(i==1 && j==0){
			retval+= previous[0][0]%mod;
			retval+= previous[0][1]%mod;
			retval+= previous[1][1]%mod;
			retval+= previous[2][0]%mod;
			retval+= previous[2][1]%mod;
			retval%=mod;
			return retval;
		}
		if(i==1 && j==1){
			retval+= previous[0][0]%mod;
			retval+= previous[0][1]%mod;
			retval+= previous[0][2]%mod;
			retval+= previous[1][0]%mod;
			retval+= previous[1][2]%mod;
			retval+= previous[2][0]%mod;
			retval+= previous[2][1]%mod;
			retval+= previous[2][2]%mod;
			retval%=mod;
			return retval;
		}
		if(i==1 && j==2){
			retval+= previous[0][1]%mod;
			retval+= previous[0][2]%mod;
			retval+= previous[0][3]%mod;
			retval+= previous[1][1]%mod;
			retval+= previous[1][3]%mod;
			retval+= previous[2][1]%mod;
			retval+= previous[2][2]%mod;
			retval+= previous[2][3]%mod;
			retval%=mod;
			return retval;
		}
		if(i==1 && j==3){
			retval+= previous[0][2]%mod;
			retval+= previous[0][3]%mod;
			retval+= previous[1][2]%mod;
			retval+= previous[2][2]%mod;
			retval+= previous[2][3]%mod;
			retval%=mod;
			return retval;
		}
		if(i==2 && j==0){
			retval+= previous[1][0]%mod;
			retval+= previous[1][1]%mod;
			retval+= previous[2][1]%mod;
			retval+= previous[3][0]%mod;
			retval+= previous[3][1]%mod;
			retval%=mod;
			return retval;
		}
		if(i==2 && j==1){
			retval+= previous[1][0]%mod;
			retval+= previous[1][1]%mod;
			retval+= previous[1][2]%mod;
			retval+= previous[2][0]%mod;
			retval+= previous[2][2]%mod;
			retval+= previous[3][0]%mod;
			retval+= previous[3][1]%mod;
			retval+= previous[3][2]%mod;
			retval%=mod;
			return retval;
		}
		if(i==2 && j==2){
			retval+= previous[1][1]%mod;
			retval+= previous[1][2]%mod;
			retval+= previous[1][3]%mod;
			retval+= previous[2][1]%mod;
			retval+= previous[2][3]%mod;
			retval+= previous[3][1]%mod;
			retval+= previous[3][2]%mod;
			retval+= previous[3][3]%mod;
			retval%=mod;
			return retval;
		}
		if(i==2 && j==3){
			retval+= previous[1][2]%mod;
			retval+= previous[1][3]%mod;
			retval+= previous[2][2]%mod;
			retval+= previous[3][2]%mod;
			retval+= previous[3][3]%mod;
			retval%=mod;
			return retval;
		}
		if(i==3 && j==0){
			retval+= previous[2][0]%mod;
			retval+= previous[2][1]%mod;
			retval+= previous[3][1]%mod;
			retval%=mod;
			return retval;
		}
		if(i==3 && j==1){
			retval+= previous[3][0]%mod;
			retval+= previous[3][2]%mod;
			retval+= previous[2][0]%mod;
			retval+= previous[2][1]%mod;
			retval+= previous[2][2]%mod;
			retval%=mod;
			return retval;
		}
		if(i==3 && j==2){
			retval+= previous[3][1]%mod;
			retval+= previous[3][3]%mod;
			retval+= previous[2][1]%mod;
			retval+= previous[2][2]%mod;
			retval+= previous[2][3]%mod;
			retval%=mod;
			return retval;
		}
		if(i==3 && j==3){
			retval+= previous[2][2]%mod;
			retval+= previous[2][3]%mod;
			retval+= previous[3][2]%mod;
			retval%=mod;
			return retval;
		}
		return retval%mod;
	}


	public static void main(String[] args){
		MaxBoggle myTest = new MaxBoggle();
		String[] matrix = new String[]{"XXXX", "XXXX", "XXXX", "XXXX"};
		String[] words = new String[]{"XXX"};
		System.out.println(myTest.maxPoints(matrix, words));
		System.out.println(way);
	}
}


