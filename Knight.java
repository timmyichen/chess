public class Knight extends Piece{
    private char icon;
    
    public Knight(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2658';
        } else {
            this.icon = '\u265E';
        }
    }
    
    public String toString(){
        return this.icon+"";
    }
}