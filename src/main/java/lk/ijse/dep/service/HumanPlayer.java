/**
 * @author : Chavindu
 * created : 2/23/2023-3:12 PM
 **/
package lk.ijse.dep.service;

public class HumanPlayer extends Player {

    public HumanPlayer(Board newBoard) {
        super(newBoard);
    }

    @Override
    public void movePiece(int col) {
        if (board.isLegalMove(col)){
            board.updateMove(col,Piece.BLUE);
            board.getBoardUI().update(col,true);
            Winner winner= this.board.findWinner();
            if (winner.getWinningPiece()!=Piece.EMPTY){
                this.board.getBoardUI().notifyWinner(winner);
            }else if (!board.exitLegalMove()){
                this.board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }
        }
    }

}
