package org.example.damespiel;

public class BoardCell {
    private final GameBoard.Piece piece;
    private final boolean isBlack;

    public BoardCell(GameBoard.Piece piece, boolean isBlack) {
        this.piece = piece;
        this.isBlack = isBlack;
    }

    public GameBoard.Piece getPiece() {
        return piece;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public boolean hasPiece() {
        return this.piece != GameBoard.Piece.EMPTY;
    }

    public boolean isPieceBlack() {
        return this.piece == GameBoard.Piece.BLACK_MAN || this.piece == GameBoard.Piece.BLACK_QUEEN;
    }

    public boolean isPieceWhite() {
        return this.piece == GameBoard.Piece.WHITE_MAN || this.piece == GameBoard.Piece.WHITE_QUEEN;
    }
}
