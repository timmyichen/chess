public class Rook extends Piece{
    private char icon;
    private int direction;
    
    public Rook(int x, int y, char owner){
        super(x,y,owner);
        if (owner=='w'){
            this.icon = '\u2656';
            this.direction = -1;
        } else {
            this.icon = '\u265C';
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
        return (diffRow == 0 && diffCol != 0) || (diffRow != 0 && diffCol == 0);
    }
    
    public boolean isMoveObstructed(int[] moveFrom, int[] moveTo, Board b){
        int diffRow = moveTo[0] - moveFrom[0];
        int diffCol = moveTo[1] - moveFrom[1];
        
        System.out.println(diffRow + " " + diffCol);
        if (diffRow == 0){ //horizontal
            int moveDirection = diffCol / Math.abs(diffCol);
            System.out.println(moveDirection);
            for(int i=1;i<Math.abs(diffCol);i++){
                if (b.getCell(moveFrom[0],moveFrom[1]+i*moveDirection) != null) return true;
            }
            return false;
        } else { //vertical
            int moveDirection = diffRow / Math.abs(diffRow);
            System.out.println(diffRow);
            for(int i=1;i<Math.abs(diffRow);i++){
                System.out.println((moveFrom[0]+i*moveDirection)+" "+moveFrom[1]);
                if (b.getCell(moveFrom[0]+i*moveDirection,moveFrom[1]) != null) return true;
            }
            return false;
        }
    }
}