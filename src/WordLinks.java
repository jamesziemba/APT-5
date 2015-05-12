import java.util.ArrayList;
import java.util.List;


public class WordLinks {
	public int links = 0;
	
//	public String isLinked(boolean isLinked){
//		if(isLinked ==true){
//			return "ladder";
//		}
//		return "none";
//	}

	public String isLinked(String[] words, String from, String to){
		if(isStep(from,to) && links > 0) { 
			return "ladder";
		}
		for(String s:words){
			if(isStep(from,s)){
				String[] copy = new String[words.length-1];
				int index = 0;
				for(String st:words){
					if(st!=s){
						copy[index]=st;
						index++;
					}
				}
				links++;
				if(isLinked(copy,s,to)=="ladder"){
					return "ladder";
				}
			}
		}
		return "none";
	}
	public boolean isStep(String word1,String word2){
		int count = 0;
		for(int i = 0;i<word1.length();i++){
			if(word1.charAt(i)!=word2.charAt(i)){
				count+=1;
			}
		}
		if(count>1){
			return false;
		}
		return true;
	}
	public static void main(String[] args){
		WordLinks myTest = new WordLinks();
		String[] words = new String[]{"most","mist", "fist", "fish"};
		System.out.println(myTest.isLinked(words, "lost", "cost"));
	
	}
}
