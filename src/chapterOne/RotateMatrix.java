package chapterOne;

public class RotateMatrix {
	public boolean rotateMatrix(int[][] mat) { // work by reference
		if (mat.length == 0 || mat[0].length != mat.length) // mat is empty
			return false;
		for (int i = 0; i < mat.length; i++) // check if mat is not NxN (need to iterate through each column)
			for (int j = 0; j < mat[i].length; j++)
				if (mat[i].length != mat.length) // check if column length == row length
					return false;

		// matrix is NxN
		int n = mat.length;
		// iterate through layers, by rotating we'll move first row to last column and
		// so on
		for (int layer = 0; layer < n / 2; layer++) {
			int firstRowCol = layer; // this will result in first column or row (depending where it's used)
			int lastRowCol = n - layer - 1; // results in last
			for (int i = 0; i < lastRowCol - firstRowCol; i++) { // "depth" inside the same layer
				int temp = mat[firstRowCol][i + layer]; // i+layer to reach the wanted element (store first row's i'th
														// element)
				mat[firstRowCol][i + layer] = mat[lastRowCol - i][firstRowCol]; // swap with last row first column's
																				// element
				mat[lastRowCol - i][firstRowCol] = mat[lastRowCol][lastRowCol - i]; // swap with last row and column
																					// element
				mat[lastRowCol][lastRowCol - i] = mat[i + layer][lastRowCol]; // swap with i'th row in layer and last
																				// column
				mat[i + layer][lastRowCol] = temp;
			}
		}
		return true;
	}

	public void printMat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		RotateMatrix objRotateMatrix = new RotateMatrix();
		int[][] mat = { 
				new int[] { 1, 2, 3, 4 }, 
				new int[] { 5, 6, 7, 8 }, 
				new int[] { 9, 10, 11, 12 },
				new int[] { 13, 14, 15, 16 } 
				};

		// print mat before rotation
		objRotateMatrix.printMat(mat);

		System.out.println(objRotateMatrix.rotateMatrix(mat));

		// print after rotation
		objRotateMatrix.printMat(mat);
	}
}

//each pixel is 4 bytes, so an integer representation
//it is possible to view the matrix as if it's made from separate layers, so in a 3x3 matrix:
//1 2 3 4
//5 6 7 8
//9 10 11 12
//13 14 15 16
//there are two layers, inner and outer (this is a simple case), where the outer layer is 1 2 3 4 5 8 9 12 13 14 15 16
//and the inner is 6 7 10 11
//meaning we have N/2 layers (we'll iterate starting from 0)
//in short, the method will rotate the corners first, then "move" in the row of SAME layer, rotate those elements
//then do the same in the next layer, and so on
//optimal solution is O(n^2) since there's a need to iterate through the NxN matrix...