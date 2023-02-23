/**
 * @author : Chavindu
 * created : 2/23/2023-3:12 PM
 **/
package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private final Piece[][] pieces=new Piece[NUM_OF_COLS][NUM_OF_ROWS];
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        for (int i=0;i<NUM_OF_COLS;i++){
            for (int j=0;j<NUM_OF_ROWS;j++){
                this.pieces[i][j]=Piece.EMPTY;
            }
        }
        this.boardUI=boardUI;
    }

    @Override
    public BoardUI getBoardUI() {
        return this.boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for (int i=0;i<NUM_OF_ROWS;i++){
            if (this.pieces[col][i]==Piece.EMPTY){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        return this.findNextAvailableSpot(col)!=-1;
    }

    @Override
    public boolean exitLegalMove() {
        for (int i=0;i<NUM_OF_COLS;i++){
            if (this.isLegalMove(i)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        this.pieces[col][findNextAvailableSpot(col)]=move;
    }

    @Override
    public void updateMove(int col, int row, Piece move) {

    }


    @Override
    public Winner findWinner() {
        for (int col = 0; col < NUM_OF_COLS; col++) {
            int rowLength = findNextAvailableSpot(col) == -1 ? NUM_OF_ROWS : findNextAvailableSpot(col);
            int rowCount = 1;
            for (int row = 1; row <rowLength; row++) {
                if (pieces[col][row] .equals(pieces[col][row-1])) {
                    rowCount++;
                    if (rowCount == 4) {
                        return new Winner(pieces[col][row], col, row-3, col, row );
                    }
                } else {
                    rowCount = 1;
                }
            }

        }


        for(int row = 0; row <NUM_OF_ROWS; ++row) {
            int colCount = 1;
            for(int col = 1; col <NUM_OF_COLS; ++col) {
                if (pieces[col][row] == pieces[col-1][row] ) {
                    colCount++;
                    if (colCount == 4) {
                        return new Winner(pieces[col][row], col - 3, row, col, row);
                    }
                } else {
                    colCount = 1;

                }
            }
        }
        return new Winner(Piece.EMPTY);
    }


}
