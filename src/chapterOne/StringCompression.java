package chapterOne;

public class StringCompression {
	public String stringCompression(String strToCompress) {
		StringBuilder sbCompressedStr = new StringBuilder(); // appending to SB is O(1), but concatenation to String is
																// O(n^2)
		int countDup = 0;
		for (int i = 0; i < strToCompress.length(); i++) {
			countDup++;
			if (i + 1 == strToCompress.length() || strToCompress.charAt(i) != strToCompress.charAt(i + 1)) {
				sbCompressedStr.append(strToCompress.charAt(i));
				sbCompressedStr.append(countDup);
				countDup = 0;
			}
			if (i + 1 == strToCompress.length())
				break;
		}
		return (strToCompress.length() < sbCompressedStr.length()) ? strToCompress : sbCompressedStr.toString();
	}

	public static void main(String[] args) {
		StringCompression objStringCompression = new StringCompression();
		System.out.println(objStringCompression.stringCompression("aabcccccaaa"));
		System.out.println(objStringCompression.stringCompression("abccc"));
	}
}

//since the input is either upper or lower case characters, then it's easier for the counting process 
//as there'll be no mix-up with numbers in the visible output

//the solution will be as if we're running with two pointers on the String, one for the current character
//and another for the one ahead of our current,
//as soon as they're not the same, we'll need to mark it, meaning adding it to the compressed string and then adding
//the number of same consecutive letters.

//pay attention for the i+1 out of range scenario! if reached, break the loop (nothing more to iterate) 