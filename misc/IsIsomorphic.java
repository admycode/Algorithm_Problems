import java.util.Arrays;
import java.util.HashMap;

public class IsIsomorphic{


	public static boolean isIsomorphic(String s, String t){
		if(s.length() != t.length())
			return false;
		if(s.length() == 0 && t.length() == 0)
			return true;

		HashMap<Character, Character> map = new HashMap<Character, Character>();

		for(int i=0; i < s.length(); i++){
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if(map.containsKey(c1)){
				if(c2 != map.get(c1))
					return false;
			}
			else
				map.put(c1,c2);
		}
		return true;

	}
	public static void main(String[] args){

		if(args.length < 2){
			System.out.println("usage : java <program> <string1> <string2>");
		}
		else{
			System.out.println("This program checks if two given string s and t are isomorphic.\n Two Strings are isomorphic if the characters in s can be replaced to get t");

			String s = args[0];
			String t = args[1];
			boolean result = isIsomorphic(s,t);
			if(result)
				System.out.println(s + " and " + t + " are isomorphic");
			else
				System.out.println(s + " and " + t + " are not isomorphic");

		}
	}
}
