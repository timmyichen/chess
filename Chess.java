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
                Piece p = b.getCell(moveFrom[0],moveTo[0]);
                
                if (p != null && currentPlayer.getColor() == p.getOwner()){ //check if piece is owned by current player
                    if (p.isValidMove(moveFrom,moveTo)){
                        System.out.println("valid");
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