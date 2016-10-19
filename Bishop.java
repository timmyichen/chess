public class Bishop extends Piece{
    private char icon;
    
    public Bishop(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2657';
        } else {
            this.icon = '\u265D';
        }
    }
    
    public String toString(){
        return this.icon+"";
    }
}