public class Knight extends Piece{
    private char icon;
    private int direction;
    
    public Knight(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2658';
            this.direction = -1;
        } else {
            this.icon = '\u265E';
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
        return (Math.abs(diffRow) == 2 && Math.abs(diffCol) == 1) 
                || (Math.abs(diffRow) == 1 && Math.abs(diffCol) == 2);
    }
    
    public boolean isMoveObstructed(int[] moveFrom, int[] moveTo, Board b){
        return true;
    }
}