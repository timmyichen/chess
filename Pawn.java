public class Pawn extends Piece{
    private char icon;
    
    public Pawn(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2659';
        } else {
            this.icon = '\u265F';
        }
    }
    
    public String toString(){
        return this.icon+"";
    }
    
    public boolean isValidMove(int[] moveFrom, int[] moveTo){
        System.out.println("check");
        int direction;
        if (this.getOwner()=='w'){
            direction = -1;
        } else {
            direction = 1;
        }
        int diff = moveTo[0] - moveFrom[0];
        return (diff * direction > 0) &&
               (Math.abs(diff) == 1 ||
               (Math.abs(diff) == 2 && !this.getHasMoved()));
    }
}