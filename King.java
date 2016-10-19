public class King extends Piece{
    private char icon;
    
    public King(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2654';
        } else {
            this.icon = '\u265A';
        }
    }
    
    public String toString(){
        return this.icon+"";
    }
}