package org.example.damespiel;

public class GameBoard {

    public static final int BOARD_SIZE = 8; // Das Damespiel verwendet ein 8x8-Brett
    private Piece[][] board; // Ein zweidimensionales Array von Pieces repräsentiert das Spielbrett



    // Definition der Spielsteine mit ihren möglichen Zuständen
    public enum Piece {
        BLACK_MAN, BLACK_QUEEN, WHITE_MAN, WHITE_QUEEN, EMPTY // Queens und normale Spielsteine für beide Farben
    }

    public GameBoard() {
        this.board = new Piece[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if ((i + j) % 2 != 0) { // Spielsteine werden nur auf schwarzen Feldern platziert
                    if (i < 3) {
                        board[i][j] = Piece.WHITE_MAN;
                    } else if (i > 4) {
                        board[i][j] = Piece.BLACK_MAN;
                    } else {
                        board[i][j] = Piece.EMPTY;
                    }
                } else {
                    board[i][j] = Piece.EMPTY;
                }
            }
        }
    }

    public Piece getPieceAt(int row, int col) {
        if (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE) {
            return board[row][col];
        }
        return null; // Oder eine geeignete Exception werfen
    }

    public void setPieceAt(int row, int col, Piece piece) {
        if (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE) {
            board[row][col] = piece;
        } else {
            // Hier könnten Sie eine geeignete Exception werfen
        }
    }

    public Piece[][] getBoard() {
        return this.board;
    }

    // In der Klasse GameBoard
    public BoardCell[][] getBoardForUI() {
        BoardCell[][] uiBoard = new BoardCell[BOARD_SIZE][BOARD_SIZE];

        // Iteriere über das Array in einer Weise, die das Brett um 90 Grad dreht
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                // Berechne die neuen Indizes für die Drehung
                int newI = BOARD_SIZE - j - 1;
                int newJ = i;

                boolean isBlack = (newI + newJ) % 2 != 0; // Felder sind abwechselnd gefärbt

                // Bestimme, welches Stück (wenn überhaupt) an der neuen Position sein sollte
                Piece piece = board[newI][newJ];

                // Erstelle ein BoardCell-Objekt mit den korrekten Werten
                uiBoard[i][j] = new BoardCell(piece, isBlack);
            }
        }
        return uiBoard;
    }





    // Methode zum Ausdrucken des Spielbretts auf der Konsole – nützlich für Debugging-Zwecke
    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Weitere Methoden zur Handhabung der Spiellogik könnten hier implementiert werden,
    // wie z.B. das Bewegen von Spielsteinen, das Entfernen von Spielsteinen nach einem "Schlagen" etc.

}
