public class Solver {

  public static void main(String[] args) {
    int[][][] testGames = Tests.getTests();
    Grid grid;
    for (int[][] testGame : testGames) {
      grid = new Grid(testGame);
      System.out.println();
      System.out.println("The grid to be solved is: ");
      grid.print();
      while (grid.hasFreeSpace()) {
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            if (grid.getSquare(i, j).hasUniquePMark()) {
              grid.makeMove(i, j);
              grid.removePMarks(i, j);
            }
          }
        }
      }
      System.out.println();
      System.out.println("The solution calculated is: ");
      grid.print();
    }
  }

}
