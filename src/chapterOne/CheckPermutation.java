package chapterOne;

public class CheckPermutation {
	public boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		int len = str1.length();
		// assuming it's ASCII strings
		int asciiCharCount = 128;

		int[] str1Occurrences = new int[asciiCharCount];
		int[] str2Occurrences = new int[asciiCharCount];
		for (int i = 0; i < len; i++)
			str1Occurrences[str1.charAt(i)]++;
		for (int i = 0; i < len; i++)
			str2Occurrences[str2.charAt(i)]++;
		for (int i = 0; i < asciiCharCount; i++)
			if (str1Occurrences[i] != str2Occurrences[i])
				return false;

		return true;
	}

	public static void main(String[] args) {
		CheckPermutation objCheckPermutation = new CheckPermutation();
		System.out.println(objCheckPermutation.checkPermutation("abbcc", "bcvac"));
		System.out.println(objCheckPermutation.checkPermutation("ababgd", "bbgaad"));
	}
}

//for two strings (or anything...) to be permutation of each other, they need to have the same length, same chars
//and same number of occurrences for each char

//i didn't check for spaces, meaning if "abc  " is a permutation of "bca", same goes for checking 
//uppercase and lowercase letters