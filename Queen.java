public class Queen extends Piece{
    private char icon;
    
    public Queen(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2655';
        } else {
            this.icon = '\u265B';
        }
    }
    
    public String toString(){
        return this.icon+"";
    }
}