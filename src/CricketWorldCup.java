import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CricketWorldCup  {
	public String[] standings(String[] teams, String[] eliminatedBy) {
		ArrayList<String> teamlist = new ArrayList<String>();
		for(String s:teams){
			teamlist.add(s);
		}
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(String s :teams){
			map.put(s, 0);
		}
		map.put("", -10);
		for(String s :eliminatedBy){
			if(s!=""){
				map.put(s, map.get(s)+1);
			}
		}

		String[] retval = new String[teams.length];
		int index = 0;
		ArrayList<String> tracker = new ArrayList<String>();
		while(index!=teams.length){
			String del = "";
			int count = -1;
			for(String s : map.keySet()){
				if(s!="" && !tracker.contains(s)){
					if(del ==""){
						del = s;
						count = map.get(s);
					}
					if(map.get(s)>count &&!tracker.contains(s)){
						del = s;
						count = map.get(s);
					}
					if(map.get(s)==count && s!=del && !tracker.contains(s)){
						String challenge = eliminatedBy[teamlist.indexOf(s)];
						String reign = eliminatedBy[teamlist.indexOf(del)];
						if(map.get(challenge)>map.get(reign) && !tracker.contains(s)){
							del = s;
							count = map.get(s);
						}
						if(map.get(challenge)==map.get(reign) && !tracker.contains(s)){
							String challenge1 = eliminatedBy[teamlist.indexOf(challenge)];
							String reign1 = eliminatedBy[teamlist.indexOf(reign)];
							if(map.get(challenge1)>map.get(reign1) && !tracker.contains(s)){
								del = s;
								count = map.get(s);
							}
							if(map.get(challenge1)==map.get(reign1) && !tracker.contains(s)){
								String challenge2 = eliminatedBy[teamlist.indexOf(challenge1)];
								String reign2 = eliminatedBy[teamlist.indexOf(reign1)];
								if(map.get(challenge2)>map.get(reign2) && !tracker.contains(s)){
									del = s;
									count = map.get(s);
								}
								if(map.get(challenge2)==map.get(reign2) && !tracker.contains(s)){
									String challenge3 = eliminatedBy[teamlist.indexOf(challenge2)];
									String reign3 = eliminatedBy[teamlist.indexOf(reign2)];
									if(map.get(challenge3)>map.get(reign3) && !tracker.contains(s)){
										del = s;
										count = map.get(s);
									}
								}
							}
						}
					}
				}
			}
			tracker.add(del);
			retval[index] = del;
			index++;
		}
		return retval;
	}
	
	public static void main(String[] args){
		String[] teams = new String[]{"SOUTH AFRICA", "ENGLAND", "NEW ZEALAND", "PAKISTAN"};
		String[] eliminatedBy = new String[]{"ENGLAND", "PAKISTAN", "PAKISTAN", ""};
		CricketWorldCup myTest = new CricketWorldCup();
		for(String s : myTest.standings(teams, eliminatedBy)){
			System.out.println(s);
		}

	}
}