package chapterOne;

public class OneAway {
	public boolean oneAway(String str1, String str2) {
		if (Math.abs(str1.length() - str2.length()) > 1) // meaning there's more than one insertion\deletion
			return false;

		int len1 = str1.length();
		int len2 = str2.length();
		if (len1 == len2)
			return oneAwayReplace(str1, str2);
		else if (len1 + 1 == len2)
			return oneAwayInsertion(str1, str2);
		return oneAwayInsertion(str2, str1); // else (len1 - 1 == len2), simply swap str1 and str2
	}

	public boolean oneAwayReplace(String str1, String str2) {
		int replacesCounter = 0;
		for (int i = 0; i < str1.length(); i++)
			if (str1.charAt(i) != str2.charAt(i))
				replacesCounter++;
		if (replacesCounter <= 1)
			return true;
		return false;
	}

	public boolean oneAwayInsertion(String str1, String str2) {
		int insertCounter = 0, i = 0, j = 0;
		while (str1.length() > i && str2.length() > j) {
			if (str1.charAt(i) != str2.charAt(j)) { // meaning this is the char which was added to str1
				insertCounter++;
				i++;
			}
			i++;
			j++;
		}
		if (insertCounter > 1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		OneAway objOneAway = new OneAway();
		System.out.println(objOneAway.oneAway("pale", "ple")); // delete
		System.out.println(objOneAway.oneAway("pale", "pales")); // insert
		System.out.println(objOneAway.oneAway("pale", "bale")); // replace
		System.out.println(objOneAway.oneAway("pale", "bake")); // two replaces (illegal)
		System.out.println(objOneAway.oneAway("pale", "bales")); // illegal
		System.out.println(objOneAway.oneAway("pale", "paless")); // illegal
		System.out.println(objOneAway.oneAway("pale", "fal")); // illegal
	}
}

//similar to previous problems, check if the encoding is ASCII (assume it is, easier with size 128 characters)
//understand that zero\one edits mean there can be only replace\insert\delete separate edits
//first I'd check the length, if there's a 2 length difference then it surely is not
//secondly, if same length, then the edit is a replace
//then check the length difference, if it's 1 at most, then there was delete\insert