import java.io.*;
public class LoadLastMove{
  public static boolean lastTurn;
  public static int[][] lastBoard;
  public static void undo (){
try{
  FileInputStream fis = new FileInputStream("saves/lastMove.ser");
  ObjectInputStream ois = new ObjectInputStream(fis);
  Save lastMove = (Save) ois.readObject();
  lastBoard = lastMove.board;
  lastTurn = lastMove.turn;
  
}catch(IOException e3){}catch(ClassNotFoundException e9){}
  }
    }