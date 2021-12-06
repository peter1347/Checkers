import java.io.*;
public class Save implements Serializable{
    public int[][]board;
    public boolean turn;  
  public Save (int[][]board,boolean turn){
    this.board = board;
    this.turn = turn;
    
  }
  
}