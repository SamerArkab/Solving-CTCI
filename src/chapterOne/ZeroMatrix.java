package chapterOne;

public class ZeroMatrix {
	public boolean zeroMatrix(int[][] mat) {
		if (mat.length == 0) // mat is empty
			return false;

		// check if first row\column has a zero
		boolean firstrowHasZero = false, firstcolHasZero = false;
		for (int col = 0; col < mat[0].length; col++) // check if first row has zeroes
			if (mat[0][col] == 0) {
				firstrowHasZero = true;
				break;
			}
		for (int row = 0; row < mat.length; row++) // check if first column has zeroes
			if (mat[row][0] == 0) {
				firstcolHasZero = true;
				break;
			}

		// mark if row\column has zeroes by changing value in first row\column
		for (int row = 1; row < mat.length; row++)
			for (int col = 1; col < mat[0].length; col++)
				if (mat[row][col] == 0) {
					mat[0][col] = 0;
					mat[row][0] = 0;
				}

		// change values to zero in whole row according to zeroes in first column
		for (int row = 0; row < mat.length; row++)
			if (mat[row][0] == 0)
				zeroEntireRow(mat, row);
		// change values to zero in whole column according to zeroes in first row
		for (int col = 0; col < mat[0].length; col++)
			if (mat[0][col] == 0)
				zeroEntireCol(mat, col);
		// if necessary, zero first row and column
		if (firstrowHasZero)
			zeroEntireRow(mat, 0);
		if (firstcolHasZero)
			zeroEntireCol(mat, 0);

		return true;
	}
	
	public void zeroEntireRow(int[][] mat, int row) {
		for (int i = 0; i < mat[0].length; i++)
			mat[row][i] = 0;
	}
	
	public void zeroEntireCol(int[][] mat, int col) {
		for (int i = 0; i < mat.length; i++)
			mat[i][col] = 0;
	}

	public void printMat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ZeroMatrix objZeroMatrix = new ZeroMatrix();
		int[][] mat = { 
				new int[] { 1, 2, 3, 4 }, 
				new int[] { 5, 0, 7, 8 }, 
				new int[] { 9, 10, 11, 12 },
				new int[] { 13, 14, 0, 16 } 
				};

		objZeroMatrix.printMat(mat);// before
		System.out.println(objZeroMatrix.zeroMatrix(mat));
		objZeroMatrix.printMat(mat);// after
	}
}

//optimal runtime is O(n^2) since there's a need to loop through the whole matrix