package chapterOne;

public class IsUnique {
	public boolean isUnique(String checkUnique) {
		// Depends if the string is ASCII or unicode,
		// in case of ASCII:
		int asciiCharCount = 128;
		if (checkUnique.length() > asciiCharCount)
			return false; // meaning there will be duplicate chars
		boolean[] checkDup = new boolean[asciiCharCount];
		// in case of unicode we'll need to assign an appropriate size boolean array

		for (int i = 0; i < checkUnique.length(); i++) {
			if (checkDup[checkUnique.charAt(i)])
				return false;
			checkDup[checkUnique.charAt(i)] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		IsUnique objIsUnique = new IsUnique();
		System.out.println(objIsUnique.isUnique("abc"));
		System.out.println(objIsUnique.isUnique("abcb"));
	}
}

//the brute case is to double loop and compare each char i with i+1 (O(n^2)
//another approach is to convert the String to chars array and use sort() method (O(NlogN)), then iterate through
//the array by i and i+1