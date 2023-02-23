/**
 * @author : Chavindu
 * created : 2/23/2023-3:10 PM
 **/
package lk.ijse.dep.service;


public class AiPlayer extends Player {

    public AiPlayer(Board newBoard) {
        super(newBoard);
    }

    @Override
    public void movePiece(int col) {
        do{
            col= (int) (Math.random()*6);
        }while (!this.board.isLegalMove(col));
        this.board.updateMove(col,Piece.GREEN);
        this.board.getBoardUI().update(col,false);
        Winner winner=this.board.findWinner();
        if (winner.getWinningPiece()!=Piece.EMPTY){
            this.board.getBoardUI().notifyWinner(winner);
        }else if (!this.board.exitLegalMove()){
            this.board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }
    }

    public int minimax(int depth){
        return 0;
    }

}
