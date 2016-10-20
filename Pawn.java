public class Pawn extends Piece{
    private char icon;
    private int direction;
    
    public Pawn(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2659';
            this.direction = -1;
        } else {
            this.icon = '\u265F';
            this.direction = 1;
        }
    }
    
    public String toString(){
        return this.icon+"";
    }
    
    @Override
    public boolean isValidMove(int[] moveFrom, int[] moveTo){
        int diffRow = moveTo[0] - moveFrom[0];
        int diffCol = moveTo[1] - moveFrom[1];
        // System.out.println(moveTo[0] + " " + moveTo[1]);
        // System.out.println(moveFrom[0] + " " + moveFrom[1]);
        // System.out.println(diffRow + " " + diffCol);
        return (diffRow * this.direction > 0) && //in the correct direction
               (Math.abs(diffCol) <= 1) && //columns moved is 0 or 1
               (Math.abs(diffRow) == 1 || //rows moved is 1
               (Math.abs(diffRow) == 2 && !this.getHasMoved() && Math.abs(diffCol) == 0)); //move forward, only if hasnt moved
    }
    
    @Override
    public boolean isMoveObstructed(int[] moveFrom, int[] moveTo, Board b){
        return b.getCell(moveFrom[0]+direction,moveFrom[1]) != null;
    }
}