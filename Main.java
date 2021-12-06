import java.util.Scanner;
import java.io.*;
import static java.lang.Integer.parseInt;

class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    SpotColor color = new SpotColor();
    PrintBoard display = new PrintBoard();
    Setup newGame = new Setup();
    int playerX, playerY, moveX, moveY;
    int[][] board = new int[10][10];
    boolean turn = true;
    String input;

    board = newGame.defaultBoard(); // sets the board array equal to the default positions,
    // board [1][1]= 2;
    // x and y are flipped when entering x y pairs from the board array
    display.printBoard(board);

    while (true) {
      if (turn) {
        display.printBoard(board);
        System.out.println("Player 1 turn");
        input = sc.nextLine();
        if (input.equals("save")) {
          try {
            FileOutputStream fos = new FileOutputStream("save1.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Save save1 = new Save(board, turn);
            oos.writeObject(save1);
            fos.flush();
            oos.flush();
            input = "a3a2";
          } catch (IOException e2) {
            System.out.println("ERROR");
          }
        }
        if (input.equals("load")) {
          try {
            FileInputStream fis = new FileInputStream("save1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Save load1 = (Save) ois.readObject();
            ois.close();
            input = "a1a1";
            board = load1.board;
            turn = load1.turn;
          } catch (IOException e3) {
            System.out.println("IO ERROR");
          } catch (ClassNotFoundException ee) {
            System.out.println("Class not found");
          }
        }

        playerY = toNum(input.substring(0, 1)); // turns first letter to the y
        playerX = parseInt(input.substring(1, 2)); // turns second to the X
        moveY = toNum(input.substring(2, 3));
        moveX = parseInt(input.substring(3, 4));

        if (board[playerX][playerY] == 1) {
          if ((board[moveX][moveY] == 0) && (color.isBlack(moveX, moveY))) {
            if ((moveY == playerY + 1) && (moveX == playerX + 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 1;
              turn = !turn;
              if (moveX == 8) {
                board[moveX][moveY] = 10;
              }
              // diagonal right
            } else if ((moveX == playerX + 1) && (moveY == playerY - 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 1;
              turn = !turn;
              if (moveX == 8) {
                board[moveX][moveY] = 10;
              }
              // diagonal left
            } else if ((moveY == playerY + 2) && (moveX == playerX + 2)) {
              if (board[playerX + 1][playerY + 1] == 2) {
                board[playerX][playerY] = 0;
                board[playerX + 1][playerY + 1] = 0;
                board[moveX][moveY] = 1;
                turn = !turn;
                if (moveX == 8) {
                  board[moveX][moveY] = 10;
                }
                // take right
              }
            }

            else if ((moveY == playerY - 2) && (moveX == playerX + 2)) {
              if (board[playerX + 1][playerY - 1] == 2) {
                board[playerX][playerY] = 0;
                board[playerX + 1][playerY - 1] = 0;
                board[moveX][moveY] = 1;
                turn = !turn;
                if (moveX == 8) {
                  board[moveX][moveY] = 10;
                }
                // take left
              }
            }
          }

        } else if (board[playerX][playerY] == 10) {
          if ((board[moveX][moveY] == 0) && (color.isBlack(moveX, moveY))) {
            if ((moveY == playerY - 1) && (moveX == playerX - 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 10;
              turn = !turn;

              // diagonal right REV
            } else if ((moveX == playerX - 1) && (moveY == playerY + 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 10;
              turn = !turn;

              // diagonal left REV
            } else if ((moveY == playerY - 2) && (moveX == playerX - 2)) {
              if (board[playerX - 1][playerY - 1] == 2 || board[playerX - 1][playerY - 1] == 20) {
                board[playerX][playerY] = 0;
                board[playerX - 1][playerY - 1] = 0;
                board[moveX][moveY] = 10;
                turn = !turn;

                // take right REV
              }
            }

            else if ((moveY == playerY + 2) && (moveX == playerX - 2)) {
              if (board[playerX - 1][playerY + 1] == 2 || board[playerX - 1][playerY - 1] == 20) {
                board[playerX][playerY] = 0;
                board[playerX - 1][playerY + 1] = 0;
                board[moveX][moveY] = 10;
                turn = !turn;

                // take left REV
              }
            } else if ((moveY == playerY + 1) && (moveX == playerX + 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 10;
              turn = !turn;

              // diagonal right
            } else if ((moveX == playerX + 1) && (moveY == playerY - 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 10;
              turn = !turn;

              // diagonal left
            } else if ((moveY == playerY + 2) && (moveX == playerX + 2)) {
              if (board[playerX + 1][playerY + 1] == 2 || board[playerX + 1][playerY + 1] == 20) {
                board[playerX][playerY] = 0;
                board[playerX + 1][playerY + 1] = 0;
                board[moveX][moveY] = 10;
                turn = !turn;

                // take right
              }
            }

            else if ((moveY == playerY - 2) && (moveX == playerX + 2)) {
              if (board[playerX + 1][playerY - 1] == 2 || board[playerX + 1][playerY - 1] == 20) {
                board[playerX][playerY] = 0;
                board[playerX + 1][playerY - 1] = 0;
                board[moveX][moveY] = 10;
                turn = !turn;

                // take left
              }
            }
          }
        }

      }

      if (!turn) {
        display.printBoard(board);
        System.out.println("Player 2 turn");
        input = sc.nextLine();
        if (input.equals("save")) {
          try {
            FileOutputStream fos = new FileOutputStream("save1.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Save save1 = new Save(board, turn);
            oos.writeObject(save1);
            fos.flush();
            oos.flush();
            input = "a3a2";
          } catch (IOException e2) {
            System.out.println("ERROR");
          }
        }
        if (input.equals("load")) {
          try {
            FileInputStream fis = new FileInputStream("save1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Save load1 = (Save) ois.readObject();
            ois.close();
            input = "a1a1";
            board = load1.board;
            turn = load1.turn;
          } catch (IOException e3) {
            System.out.println("IO ERROR");
          } catch (ClassNotFoundException ee) {
            System.out.println("Class not found");
          }
        }
        playerY = toNum(input.substring(0, 1)); // turns first letter to the y
        playerX = parseInt(input.substring(1, 2)); // turns second to the X
        moveY = toNum(input.substring(2, 3));
        moveX = parseInt(input.substring(3, 4));
        if (board[playerX][playerY] == 2) {
          if ((board[moveX][moveY] == 0) && (color.isBlack(moveX, moveY))) {
            if ((moveY == playerY - 1) && (moveX == playerX - 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 2;
              turn = !turn;
              if (moveX == 1) {
                board[moveX][moveY] = 20;
              }
              // diagonal right REV
            } else if ((moveX == playerX - 1) && (moveY == playerY + 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 2;
              turn = !turn;
              if (moveX == 1) {
                board[moveX][moveY] = 20;
              }
              // diagonal left REV
            } else if ((moveY == playerY - 2) && (moveX == playerX - 2)) {
              if (board[playerX - 1][playerY - 1] == 1) {
                board[playerX][playerY] = 0;
                board[playerX - 1][playerY - 1] = 0;
                board[moveX][moveY] = 2;
                turn = !turn;
                if (moveX == 1) {
                  board[moveX][moveY] = 20;
                }
                // take right REV
              }
            }

            else if ((moveY == playerY + 2) && (moveX == playerX - 2)) {
              if (board[playerX - 1][playerY + 1] == 1) {
                board[playerX][playerY] = 0;
                board[playerX - 1][playerY + 1] = 0;
                board[moveX][moveY] = 2;
                turn = !turn;
                if (moveX == 1) {
                  board[moveX][moveY] = 20;
                }
                // take left REV
              }
            }
          }

        } else if (board[playerX][playerY] == 20) {
          if ((board[moveX][moveY] == 0) && (color.isBlack(moveX, moveY))) {
            if ((moveY == playerY - 1) && (moveX == playerX - 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 20;
              turn = !turn;

              // diagonal right REV
            } else if ((moveX == playerX - 1) && (moveY == playerY + 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 20;
              turn = !turn;

              // diagonal left REV
            } else if ((moveY == playerY - 2) && (moveX == playerX - 2)) {
              if (board[playerX - 1][playerY - 1] == 1 || board[playerX - 1][playerY - 1] == 10) {
                board[playerX][playerY] = 0;
                board[playerX - 1][playerY - 1] = 0;
                board[moveX][moveY] = 20;
                turn = !turn;

                // take right REV
              }
            }

            else if ((moveY == playerY + 2) && (moveX == playerX - 2)) {
              if (board[playerX - 1][playerY + 1] == 1 || board[playerX - 1][playerY - 1] == 10) {
                board[playerX][playerY] = 0;
                board[playerX - 1][playerY + 1] = 0;
                board[moveX][moveY] = 20;
                turn = !turn;

                // take left REV
              }
            } else if ((moveY == playerY + 1) && (moveX == playerX + 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 20;
              turn = !turn;

              // diagonal right
            } else if ((moveX == playerX + 1) && (moveY == playerY - 1)) {
              board[playerX][playerY] = 0;
              board[moveX][moveY] = 20;
              turn = !turn;

              // diagonal left
            } else if ((moveY == playerY + 2) && (moveX == playerX + 2)) {
              if (board[playerX + 1][playerY + 1] == 1 || board[playerX + 1][playerY + 1] == 10) {
                board[playerX][playerY] = 0;
                board[playerX + 1][playerY + 1] = 0;
                board[moveX][moveY] = 20;
                turn = !turn;

                // take right
              }
            }

            else if ((moveY == playerY - 2) && (moveX == playerX + 2)) {
              if (board[playerX + 1][playerY - 1] == 1 || board[playerX + 1][playerY - 1] == 10) {
                board[playerX][playerY] = 0;
                board[playerX + 1][playerY - 1] = 0;
                board[moveX][moveY] = 20;
                turn = !turn;

                // take left
              }
            }
          }
        }

      }
    }

  }

  public static int toNum(String input) {
    int files;
    switch (input.toLowerCase()) {
      case "a":
        files = 1;
        break;
      case "b":
        files = 2;
        break;
      case "c":
        files = 3;
        break;
      case "d":
        files = 4;
        break;
      case "e":
        files = 5;
        break;
      case "f":
        files = 6;
        break;
      case "g":
        files = 7;
        break;
      case "h":
        files = 8;
        break;
      default:
        System.out.println("invalid character");
        files = 0;
        break;
    }
    return files;
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
