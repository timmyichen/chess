public class Piece{
    private int x;
    private int y;
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
}