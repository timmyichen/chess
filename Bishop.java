public class Bishop extends Piece{
    private char icon;
    private int direction;
    
    public Bishop(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2657';
            this.direction = -1;
        } else {
            this.icon = '\u265D';
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
        return Math.abs(diffRow) == Math.abs(diffCol);
    }
    
    public boolean isMoveObstructed(int[] moveFrom, int[] moveTo, Board b){
        return true;
    }
}