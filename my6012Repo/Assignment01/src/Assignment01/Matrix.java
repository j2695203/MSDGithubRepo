package Assignment01;

public class Matrix {
  int numRows;
  int numColumns;
  int data[][];

  // Constructor with data for new matrix (automatically determines dimensions)
  public Matrix(int data[][]) {
    numRows = data.length; // d.length is the number of 1D arrays in the 2D array
    if (numRows == 0) {
      numColumns = 0;
    } else {
      numColumns = data[0].length; // d[0] is the first 1D array
    }
    this.data = new int[numRows][numColumns]; // create a new matrix to hold the data
    // copy the data over
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        this.data[i][j] = data[i][j];
      }
    }
  }

  @Override // instruct the compiler that we do indeed intend for this method to override
            // the superclass' (Object) version
  public boolean equals(Object other) {
    if (!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
      return false;
    }
    Matrix matrix = (Matrix) other; // if the above was not true, we know it's safe to treat 'o' as a Matrix

    if( matrix.numRows == this.numRows && matrix.numColumns == this.numColumns ){ // check if two matrices have the same numRows and numColumns
      for( int i = 0; i < numRows; i++ ) {
        for( int j = 0; j < numColumns; j++ ) {
          if( matrix.data[i][j] != this.data[i][j] ){ // check if two matrices have the same value
            return false;
          }
        }
      }
      return true;
    }
    return false; // for diff dimension cases
  }

  @Override // instruct the compiler that we do indeed intend for this method to override
            // the superclass' (Object) version
  public String toString() {
    String matrixString = "";
    for( int i = 0; i < numRows; i++ ) {
      for( int j = 0; j < numColumns; j++ ) {
        matrixString += data[i][j] + " ";
      }
      matrixString += "\n";
    }
    return matrixString;
  }

  public Matrix times(Matrix matrix) {
    // check if the two matrices are compatible for multiplication
    if( this.numColumns != matrix.numRows ){
      return null;
    }
    // determine the dimensions of the resulting matrix
    Matrix result = new Matrix( new int[this.numRows][matrix.numColumns] );

    // fill it in with the correct values for matrix multiplication
    for( int i = 0; i < result.numRows; i++ ) {
      for( int j = 0; j < result.numColumns; j++ ) {
        // calculate the value of result.data[i][j]
        for( int k = 0; k < this.numColumns; k++ ){
          result.data[i][j] += this.data[i][k] * matrix.data[k][j];
        }
      }
    }
    return result;
  }

  public Matrix plus(Matrix matrix) {
    // check if the two matrices are compatible for addition
    if( matrix.numRows != this.numRows || matrix.numColumns != this.numColumns ){
      return null;
    }
    // create a new matrix
    Matrix result = new Matrix( new int[numRows][numColumns] );
    // fill it in with the correct values for matrix addition
    for( int i = 0; i < numRows; i++ ) {
      for( int j = 0; j < numColumns; j++ ) {
        result.data[i][j] = this.data[i][j] + matrix.data[i][j];
      }
    }
    return result;
  }
}
