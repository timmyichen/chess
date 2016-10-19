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
        int direction;
        if (this.getOwner()=='w'){
            direction = -1;
        } else {
            direction = 1;
        }
        int diffRow = moveTo[0] - moveFrom[0];
        int diffCol = moveTo[1] - moveFrom[1];
        System.out.println(moveTo[0] + " " + moveTo[1]);
        System.out.println(moveFrom[0] + " " + moveFrom[1]);
        System.out.println(diffRow + " " + diffCol);
        return (diffRow * direction > 0) &&
               (Math.abs(diffCol) <= 1) &&
               (Math.abs(diffRow) == 1 ||
               (Math.abs(diffRow) == 2 && !this.getHasMoved() && Math.abs(diffCol) == 0));
    }
}