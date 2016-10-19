public class Player{
    private char color;
    
    public Player(char color){
        this.color = color;
    }
    
    public char getColor(){
        return this.color;
    }
    
    public String toString(){
        if (color == 'w') return "white"; else return "black";
    }
    
}