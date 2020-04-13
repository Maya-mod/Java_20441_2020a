/**
 * @author Maya
 * @version 29/12/19
 * This class represents a two dimensional Matrix array
 * 
 */
public class Matrix {
	//properties
	private int[][] _matrix;
	private final int MAX_INT = 255;
	
	//constructors:
	/**
	 * init the array and then copy the cells
	 * @param array from two diamentional array
	 */
	public Matrix(int[][] array) {//construct a Matrix from two dimensional array
		
		_matrix = new int[array.length][array[0].length]; // 
		
        for (int i = 0; i <array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
            	
            	_matrix[i][j] = array[i][j];
            }
        }
	}//end of method Matrix
	
	/**
	 * Constructs a size1 by size2 Matrix of zeroes.
	 * @param size1 the num of rows
	 * @param size2 the num of cols
	 */
	public Matrix(int size1, int size2) {	
		
		_matrix = new int[size1][size2];
		
	}//end of method Matrix constructor

	/**
	 * return a string representing the matrix							
	 *@return string
	 */
	public String toString() {//element in the same row will be separate by tab "\t"

		 String str = "";
		
		    for (int i = 0; i < size(); i++) {
		      for (int j = 0; j < innerSize() - 1; j++) {
		        str += _matrix[i][j] + "\t";
		      }
		      	str += _matrix[i][innerSize() - 1] + "\n"; //last one
		    }
		    return str;
	}//end of method toString
	
	/**
	 * create a new image with negative value 
	 * @return negativeArray
	 */
	public Matrix makeNegative() {
		
		int[][] negativeArray = new int[size()][innerSize()];
		
		for (int i=0; i<size(); i++) {
			for (int j=0; j<innerSize(); j++) {
				negativeArray[i][j] = MAX_INT-(_matrix[i][j]);
			}
		}
		return new Matrix(negativeArray);
	}//end of method makeNegative
	
	/**
	 * create a new image after removing all the noise
	 * average of neighbors
	 * @return filteMat
	 */
	public Matrix imageFilterAverage() {
		
		Matrix filterMat = new Matrix(_matrix.length, _matrix[0].length);
		
		for(int i=0;i<_matrix.length;i++) {
			for(int j=0;j<_matrix[0].length;j++) {
				filterMat._matrix[i][j]=avgNeighborsOf(i, j);
			}
		}
		return filterMat;
	}//end of method imageFilterAverage

	/**
	 * rotate the Matrix clockwise (to the right)
	 * @return clockWiseR
	 */
	public Matrix rotateClockwise() {
		
		Matrix clockWiseR=new Matrix(_matrix[0].length, _matrix.length);
		
		for (int i = 0; i < _matrix.length; i++) {
			for (int j = 0; j < _matrix[i].length; j++) {
				clockWiseR._matrix[j][_matrix.length-i-1]=_matrix[i][j];
			}
		}
		return clockWiseR;
	}//end of  method rotateClockwise
	
	/**
	 * rotate the Matrix counter clockwise (to the left)
	 * @return clockWiseL 
	 */
	public Matrix rotateCounterClockwise() {
		
		Matrix clockWiseL=new Matrix(_matrix[0].length, _matrix.length);
		
		for (int i = 0; i < _matrix.length; i++) {
			for (int j = 0; j < _matrix[i].length; j++) {
				clockWiseL._matrix[_matrix[i].length-j-1][i]=_matrix[i][j];
			}
		}
		return clockWiseL;
	}//end of  method rotateCounterClockwise()
	
	// returns the outer array length
	private int size() {
		
	  return _matrix.length;
	}//end of private method size()
	  
	// returns the inner parameter length
	private int innerSize() {
		
	  return _matrix[0].length;
	}//end of private method innerSize()
	
	//count the num of neighbors of a given cell, sums them and return the average 
	private int avgNeighborsOf(int row, int col) {
		//*mark my place
		//< > ^ v mark which cell im testing
		int sum =_matrix[row][col];// | |*| | - sum the first cell
		int count = 1;
		if(col>0) {//check if im in col 1+ 
			sum+=_matrix[row][col-1];// |<|*| | - sum left cell from first cell
			count++;
			if (row>0) {// check if i have neighbors above me
				sum+=_matrix[row-1][col-1];// |<| | | - sum bottom left diagonal cell
				count++;
			}
			if(row<_matrix.length-1) {// check if i have neighbors under me
				sum+=_matrix[row+1][col-1];// |<| | | - sum top left cell from first cell
				count++;
			}
		}
		if(col<_matrix[0].length-1) {// check if i have neighbors from my right
			sum+=_matrix[row][col+1];// | |*|>| - sum Right cell from first cell
			count++;
			if(row>0) {// check if i have neighbors above me
				sum+=_matrix[row-1][col+1];//| | |>| - sum top right diagonal cell 
				count++;
			}
			if(row<_matrix.length-1) {// check if i have neighbors under me
				sum+=_matrix[row+1][col+1];//| | |>| - sum bottom right diagonal cell
				count++;
			}
		}
		if(row>0) { // check if i have neighbors above me
			sum+=_matrix[row-1][col];// | |^| | - sum top same col
			count++;
		}
		if(row<_matrix.length-1) {// check if i have neighbors under me
			sum+=_matrix[row+1][col];// | |v| | - sum bottom same col
			count++;
		}
		return sum/count;
	}//end of  method avgNeighborsOf
	
}//end of class Matrix
