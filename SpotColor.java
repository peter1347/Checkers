public class SpotColor {
    public boolean isBlack(int x, int y){
        if((x % 2 == 0 && y % 2 == 0)||(x % 2 != 0 && y % 2 != 0 )){
            return(true);
        }
        else if ((x % 2 == 0 && y % 2 !=0)||(x % 2 == 0 && y % 2 != 0)||(x % 2 != 0 && y% 2 == 0)){
            return(false);
        }
        else{
            return(false);
        }

    }
}
