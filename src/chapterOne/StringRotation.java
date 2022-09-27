package chapterOne;

public class StringRotation {
	public boolean stringRotation(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() == 0)
			return false;

		String doubleS2 = s2 + s2; // no need for SB.append since it will anyway use two times the length when
									// concatenating)
		return isSubstring(s1, doubleS2);
	}

	public static void main(String[] args) {
		StringRotation objStringRotation = new StringRotation();
		System.out.println(objStringRotation.stringRotation("check", "ckche"));
		System.out.println(objStringRotation.stringRotation("check", "ckch"));
		System.out.println(objStringRotation.stringRotation("check", "ckech"));
	}
}

//optimal runtime complexity is O(N) since both strings must be of same length
//if they are not of same length, return false
//if they are,
//the rotation begins at a certain point of one string, 
//can use isSubstring only once (which checks if a string is sub string of another...)
//, meaning if I try the following, it has to be a substring (if it is indeed a 
//string rotation):
//checking the following simple example, "abc" and it's rotation "cab", having "cab" + "cab" will result in
//"cabcab" which does contain a sub string of "abc", 
//but if I were to use "cba" as the rotation of "abc", then "cbacba" will in no way contain a sub string "abc"