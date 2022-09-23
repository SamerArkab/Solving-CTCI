package chapterOne;

public class URLify {
	public void replaceSpace(String inputStr, int strLen) {
		inputStr = inputStr.trim(); // remove all leading and trailing spaces
		if (inputStr.equals("")) // meaning string only contained spaces or was an empty string
			return;

		char[] strToArr = inputStr.toCharArray();
		int spaceCounter = 0;
		for (int i = 0; i < strToArr.length; i++)
			if (strToArr[i] == ' ')
				spaceCounter++;
		char[] arrToRet = new char[strToArr.length + (spaceCounter * 2)]; // *2 for two ADDITIONAL chars (one will
																			// replace the space and the other two are
																			// extra), %, 2 and 0
		int j = 0;
		for (int i = 0; i < arrToRet.length; i++) {
			if (strToArr[j] == ' ') {
				arrToRet[i++] = '%';
				arrToRet[i++] = '2';
				arrToRet[i] = '0';
			} else
				arrToRet[i] = strToArr[j];
			j++;
		}
		System.out.println(arrToRet);
	}

	public static void main(String[] args) {
		URLify objUrLify = new URLify();
		String str = "Mr John Smith   ";
		int len = 13;
		objUrLify.replaceSpace(str, len);
	}
}

//in the book the solution is actually using the extra space given 
//(which is enough for replacing the space with '%20') and wrote the string backwards 