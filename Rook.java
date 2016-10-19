public class Rook extends Piece{
    private char icon;
    
    public Rook(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2656';
        } else {
            this.icon = '\u265C';
        }
    }
    
    public String toString(){
        return this.icon+"";
    }
}