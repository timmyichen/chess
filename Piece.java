public abstract class Piece{
    public int x;
    public int y;
    private char owner;
    private boolean hasMoved = false;
    
    public Piece(int x, int y, char owner){
        this.x = x;
        this.y = y;
        this.owner = owner;
    }
    
    public boolean getHasMoved(){
        return this.hasMoved;
    }
    
    public void moved(){
        this.hasMoved = true;
    }
    
    public char getOwner(){
        return this.owner;
    }
    
    public boolean isTargetFriendly(int[] moveTo, Board b){
        return b.getCell(moveTo[0],moveTo[1]) != null && b.getCell(moveTo[0],moveTo[1]).owner == this.owner;
    }
    
    abstract public boolean isValidMove(int[] moveFrom, int[] moveTo);
    
    abstract public boolean isMoveObstructed(int[] moveFrom, int[] moveTo, Board b);
}