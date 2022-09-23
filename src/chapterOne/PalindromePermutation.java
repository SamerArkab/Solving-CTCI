package chapterOne;

public class PalindromePermutation {
	int alphabet = 26;

	public boolean isPalindrome(String inputStr) {
		inputStr = inputStr.toLowerCase(); // assuming there's no significance to upper\lower case
		// I would ask if I can assume the character encoding is ascii (assume it is)
		// Also assume there's no significance to space char
		boolean[] strToArr = new boolean[alphabet];
		for (int i = 0; i < alphabet; i++)
			strToArr[i] = true;

		for (int i = 0; i < inputStr.length(); i++)
			if (inputStr.charAt(i) != ' ')
				strToArr[(int) inputStr.charAt(i) - (int) 'a'] = !strToArr[(int) inputStr.charAt(i) - (int) 'a'];
		// flip between true and false

		int falseCounter = 0; // assist in finding out if there's only one odd char or more
		for (int i = 0; i < alphabet; i++)
			if (!strToArr[i])
				falseCounter++;

		if (falseCounter > 1) // means there's more than one odd char in string, so surely a palindrome
			// permutation is not possible
			return false;
		return true;
	}

	public static void main(String[] args) {
		PalindromePermutation objPalindromePermutation = new PalindromePermutation();
		System.out.println(objPalindromePermutation.isPalindrome("bbaxahhxzzgxg"));
		System.out.println(objPalindromePermutation.isPalindrome("tact coa i"));
	}
}

//first, check if there is any significance to upper\lower case characters (I'll assume there isn't)
//for a string to be a palindrome, the number of chars used has to be even and if there's an odd char use,
//then it has to be only one.
//aabbcc, we can make abccba
//aabbccd, one palindrome permutation is abcdcba