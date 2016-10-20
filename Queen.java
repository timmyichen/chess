public class Queen extends Piece{
    private char icon;
    private int direction;
    
    public Queen(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2655';
            this.direction = -1;
        } else {
            this.icon = '\u265B';
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
        return Math.abs(diffRow) == Math.abs(diffCol) ||
                (diffRow == 0 && diffCol != 0) || 
                (diffRow != 0 && diffCol == 0);
    }
    
    public boolean isMoveObstructed(int[] moveFrom, int[] moveTo, Board b){
        return true;
    }
}