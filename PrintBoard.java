public class PrintBoard {
    SpotColor color = new SpotColor();
    public  void printBoard(int[][]board){
        Main.clearScreen();
        int rank = 8;
        for (int i =8; i>0;i--){
            System.out.print(rank+" ");
            for(int k = 1; k<9;k++){
                if (board[i][k]==1){
                    System.out.print("\u001B[40m"+"\u001B[31m");
                    System.out.print(" ⛂ ");
                    System.out.print ("\u001B[0m");
                }
                else if (board[i][k]==10){
                    System.out.print("\u001B[40m"+"\u001B[31m");
                    System.out.print(" ⛃ ");
                    System.out.print ("\u001B[0m");
                }
                else if (board[i][k] == 2){
                    System.out.print("\u001B[40m"+"\u001B[36m");
                    System.out.print(" ⛂ ");
                    System.out.print ("\u001B[0m");

                }
                else if (board[i][k] == 20) {
                    System.out.print("\u001B[40m" + "\u001B[36m");
                    System.out.print(" ⛃ ");
                    System.out.print("\u001B[0m");

                }
                else if (board[i][k] == 69){
                    System.out.print(" TEST ");
                }

                else if (color.isBlack(i, k)) {
                    System.out.print("\u001B[40m");
                    System.out.print("   ");
                    System.out.print ("\u001B[0m");
                }
                else{
                    System.out.print("\u001B[47m");
                    System.out.print("   ");
                    System.out.print ("\u001B[0m");
                }
            }
            rank --;
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H");
    }

}
