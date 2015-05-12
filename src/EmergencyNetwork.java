import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collections;
import java.util.HashMap;


public class EmergencyNetwork {
	HashMap<Integer,ArrayList<Integer>> children = new HashMap<Integer,ArrayList<Integer>>();
	public int lagTime(int[] bosses) {
		for(int i = 0;i<bosses.length;i++){

			children.put(i, new ArrayList<Integer>());	

		}
		for(int i =1;i<bosses.length;i++){
			children.get(bosses[i]).add(i);
		}
		return calcTime(0);
	}
	public int calcTime(int i){
		int size = children.get(i).size();
		if(size == 0){
			return 0;
		}
		else{
			ArrayList<Integer> times = new ArrayList<Integer>();
			for(int employee : children.get(i)){
				times.add(calcTime(employee));
			}
			return calcLagTime(times);
		}
	}
	public int calcLagTime(ArrayList<Integer> times){
		Collections.sort(times,Collections.reverseOrder());
		for(int i = 1;i<times.size()+1;i++){
			times.set(i-1, times.get(i-1)+i);
		}
		int max = Collections.max(times);
		return max;
	}
	

	public static void main(String[] args){
		EmergencyNetwork myTest = new EmergencyNetwork();
		int[] bosses = new int[]{-1, 0, 0};
		System.out.println(myTest.lagTime(bosses));
	}
}
