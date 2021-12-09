import java.io.*;
public class UpdateLastMove{
  public static void update(int[][] board,boolean turn){
    try{
      FileOutputStream fos = new FileOutputStream("saves/lastMove.txt");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      Save lastMove = new Save(board,turn);
      oos.writeObject(lastMove);
      oos.flush();
      fos.flush();

    }catch(IOException e){}
    
  }  

}
