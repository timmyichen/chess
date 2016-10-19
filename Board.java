public class Board{
    Piece[][] board = new Piece[8][8];
    private String letters = "ABCDEFGH";
    
    public Board(){
        for(int x=0;x<8;x++){
            board[1][x] = new Pawn(x,1,'b'); //black pawns
            board[6][x] = new Pawn(x,6,'w'); //white pawns
        }
        
        //black rooks
        board[0][0] = new Rook(0,0,'b');
        board[0][7] = new Rook(0,7,'b');
        //white rooks
        board[7][0] = new Rook(7,0,'w');
        board[7][7] = new Rook(7,7,'w');
        
        //black knights
        board[0][1] = new Knight(0,1,'b');
        board[0][6] = new Knight(0,6,'b');
        //white knights
        board[7][1] = new Knight(7,1,'w');
        board[7][6] = new Knight(7,6,'w');
        
        //black bishops
        board[0][2] = new Bishop(0,2,'b');
        board[0][5] = new Bishop(0,5,'b');
        //white bishops
        board[7][2] = new Bishop(7,2,'w');
        board[7][5] = new Bishop(7,5,'w');
        
        //black royals
        board[0][3] = new Queen(0,3,'b');
        board[0][4] = new King(0,4,'b');
        //white royals
        board[7][3] = new Queen(7,3,'w');
        board[7][4] = new King(7,4,'w');
        
        
    }
    
    public void move(int[] moveFrom, int[] moveTo){
        board[moveTo[0]][moveTo[1]] = board[moveFrom[0]][moveFrom[1]];
        board[moveFrom[0]][moveFrom[1]] = null;
    }
    
    public String toString(){
        String res = "";
        for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){
                if (board[x][y] != null){
                    res += ""+board[x][y]+"";
                } else {
                    if (x == y || (x+y)%2 == 0){
                        res += "\u25B0";
                    } else {
                        res += "\u25B1";
                    }
                }
            }
            res+= " " + this.letters.charAt(x)+"\n";
        }
        res+= "1 2 3 4 5 6 7 8";
        return res;
    }
    
    public boolean checkIfValidMove(String input){
        String moveFrom = "", moveTo = "";
        try{
            moveFrom = input.split(" ")[0];
            moveTo = input.split(" ")[1];
            if (this.letters.indexOf(moveFrom.charAt(0)) == -1 ||
            this.letters.indexOf(moveTo.charAt(0)) == -1 ||
            (int)moveFrom.charAt(1)-48 < 0 || //-48 to convert char to int
            (int)moveFrom.charAt(1)-48 > 7 || //where A=1, B=2, etc
            (int)moveTo.charAt(1)-48 < 0 ||
            (int)moveTo.charAt(1)-48 > 7
            ){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    public int[] getOriginMove(String input){
        String moveFrom = input.split(" ")[0];
        int[] coords = new int[2];
        //i think A starts at 65 and digits start at 49?
        coords[0] = moveFrom.charAt(0)-65;
        coords[1] = moveFrom.charAt(1)-49;
        return coords;
    }
    
    public int[] getTargetMove(String input){
        String moveTo = input.split(" ")[1];
        int[] coords = new int[2];
        coords[0] = moveTo.charAt(0)-65;
        coords[1] = moveTo.charAt(1)-49;
        return coords;
    }
    
    public Piece getCell(int row, int col){
        return board[row][col];
    }
    
    public void display(){
        System.out.println(this);
    }
}