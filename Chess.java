import java.util.Scanner;

public class Chess{
    public static void main(String[] args){
        Board b = new Board();
        Scanner in = new Scanner(System.in);
        boolean gameOver = false;
        Player white = new Player('w');
        Player black = new Player('b');
        Player currentPlayer = white;
        while (!gameOver){
            b.display();
            System.out.println("Enter " + white + "'s move:");
            String move = in.nextLine().toUpperCase();
            if (b.checkIfValidMove(move)){ //check input
                int[] moveFrom = b.getOriginMove(move);
                int[] moveTo = b.getTargetMove(move);
                // System.out.println(moveFrom[0] + " " + moveFrom[1]);
                // System.out.println(moveTo[0] + " " + moveTo[1]);
                Piece p = b.getCell(moveFrom[0],moveFrom[1]);
                
                if (p != null && currentPlayer.getColor() == p.getOwner()){ //check if piece is owned by current player
                    if (p.isValidMove(moveFrom,moveTo)){ //check if piece can move as directed
                        if (!p.isTargetFriendly(moveTo,b)){
                            if (!p.isMoveObstructed(moveFrom,moveTo,b)){
                                System.out.println("valid move");
                            } else {
                                System.out.println("Invalid move (move is obstructed), try again.");
                            }
                        } else {
                            System.out.println("Invalid move (target is friendly), try again.");
                        }
                    } else {
                        System.out.println("Invalid move (cant move there), try again.");
                    }
                } else {
                    System.out.println("Invalid move (not owner), try again.");
                }
                //swap
            } else {
                System.out.println("Invalid move (bad input), try again.");
            }
        }
    }
}