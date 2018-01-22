public class Grid {

  private Square[][] grid = new Square[9][9];

  public Grid(int[][] values) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int value = values[i][j];
        if (value == 0) {
          grid[i][j] = new Square();
        } else {
          grid[i][j] = new Square(value);
        }
      }
    }
    removeExcessPMarks();
  }

  public boolean hasFreeSpace() {
    //Returns false if grid has been filled
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (grid[i][j].isEmpty()) {
          return true;
        }
      }
    }
    return false;
  }

  public Square getSquare(int row, int col) {
    return grid[row][col];
  }

  public void makeMove(int row, int col) {
    assert (grid[row][col].hasUniquePMark()) : "Square must have one pencil mark";
    int newValue   = grid[row][col].uniquePMark();
    grid[row][col] = new Square(newValue);
  }

  private void removeExcessPMarks() {
    //Scans through grid and removes unnecessary pencil marks
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        removePMarks(i, j);
      }
    }
  }

  public void removePMarks(int row, int col) {
    //Removes invalid pencil marks in square by checking values in column,
    //row, and the 3x3 box containing the square
    int value = grid[row][col].value();
    checkCol(col, value);
    checkRow(row, value);
    checkBox(row, col, value);
  }

  private void checkCol(int col, int value) {
    for (int i = 0; i < 9; i++) {
      grid[i][col].removePMark(value);
    }
  }

  private void checkRow(int row, int value) {
    for (int i = 0; i < 9; i++) {
      grid[row][i].removePMark(value);
    }
  }

  private void checkBox(int row, int col, int value) {
    int startRow = getStartIndex(row);
    int startCol = getStartIndex(col);
    for (int i = startRow; i < startRow + 3; i++) {
      for (int j = startCol; j < startCol + 3; j++) {
        grid[i][j].removePMark(value);
      }
    }
  }

  private int getStartIndex(int n) {
    //Returns index of first square in 3x3 box
    return ((n / 3) * 3);
  }

  public void print() {
    //Prints grid out with characters separating each 3x3 box
    for (int i = 0; i < 9; i++) {
      System.out.println();
      for (int j = 0; j < 9; j++) {
        grid[i][j].print();
        if (j == 2 || j == 5) {
          System.out.print("| ");
        }
      }
      if (i == 2 || i == 5) {
        System.out.println();
        System.out.print("---------------------");
      }
    }
    System.out.println();
  }

}
