public class Square {

  private int value;
  private int pMarkCount;
  private boolean[] pMarks = new boolean[10];
  //Pencil mark at index 0 is true if it is a non-empty square

  public Square() {
    //Constructor for square with no value
    value       = 0;
    pMarks[0]   = false;
    for (int i  = 1; i < 10; i++) {
      pMarks[i] = true;
    }
    pMarkCount  = 9;
  }

  public Square(int value) {
    //Constructor for square with value
    this.value = value;
    pMarks[0]  = true;
  }

  public int value() {
    //If square is empty, value is 0
    return value;
  }

  public boolean isEmpty() {
    return (value == 0);
  }

  public boolean hasUniquePMark() {
    return (pMarkCount == 1);
  }

  public int uniquePMark() {
    assert (hasUniquePMark()) : "Square does not have unique pencil mark.";
    //Returns value of square with one pencil mark
    int i = 1;
    while (!pMarks[i]) {
      i++;
    }
    return (i);
  }

  public void removePMark(int valToRemove) {
    //Removes pencil mark for value in square if it has been marked true
    if (pMarks[valToRemove]) {
      pMarks[valToRemove] = false;
      pMarkCount--;
    }
  }

  public void print() {
    System.out.print(value + " ");
  }

}
