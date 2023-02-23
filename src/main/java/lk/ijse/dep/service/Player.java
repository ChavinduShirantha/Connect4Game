/**
 * @author : Chavindu
 * created : 2/23/2023-3:14 PM
 **/
package lk.ijse.dep.service;

public abstract class Player {
    protected Board board;

    public Player(Board board) {
        this.board=board;
    }

    public Player() {

    }

    public abstract void movePiece(int col);

}
