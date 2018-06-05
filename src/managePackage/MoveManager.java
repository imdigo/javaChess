package managePackage;

import java.awt.Color;

import piecesPackage.Piece;

public class MoveManager {

	private static MoveManager instance = new MoveManager();
	TurnManager turnChecker = new TurnManager();
	private MoveManager() {
		System.out.println("Loading MoveManager instance");
	}

	private ChessPanel[][] boardPiece;
	Coordinate selectedCoordinate;

	public static MoveManager getInstance() {
		return instance;
	}

	public void setBoard(ChessPanel[][] boardPiece) {
		this.boardPiece = boardPiece;
	}

	public void setPiece(Coordinate selectedCoordinate) {
		this.selectedCoordinate = selectedCoordinate;
	}

	public void move(int sequence, Coordinate destinationC) {
	    int turn;
		CheckCheck checkInstance = CheckCheck.getInstance();
		if (sequence == 1)
		{
			System.out.println("Sequence 1 entered");
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (boardPiece[i][j].piece != null)
						boardPiece[i][j].removeMouseListener(GameManager.boardMouseController);
				}
			}



			boardPiece[selectedCoordinate.x][selectedCoordinate.y].piece.highlight(boardPiece, selectedCoordinate);
            System.out.print("\nThe Highlighting has completed..!\n");
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					boardPiece[i][j].addMouseListener(GameManager.pieceMouseController);
				}
			}
		}
		else if(sequence == 2) {
            turn = TurnManager.turn;
            if(boardPiece[selectedCoordinate.x][selectedCoordinate.y].isKing[turn]) {
            	System.out.println("Moving King");
                boardPiece[selectedCoordinate.x][selectedCoordinate.y].notKing();
                boardPiece[destinationC.x][destinationC.y].setIsKing(turn);
            }
            else
				boardPiece[destinationC.x][destinationC.y].notKing();

            removePMC();
            Piece bPiece = boardPiece[selectedCoordinate.x][selectedCoordinate.y].getPiece();
            System.out.println("Moving Piece is " + bPiece.getClass().getName() + " and its team is " + bPiece.team);
			boardPiece[selectedCoordinate.x][selectedCoordinate.y].resetPiece();
            boardPiece[destinationC.x][destinationC.y].resetPiece();
			boardPiece[destinationC.x][destinationC.y].setPiece(bPiece, bPiece.team);

			boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(false);
			boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(true);
			boardPiece[destinationC.x][destinationC.y].setVisible(false);
			boardPiece[destinationC.x][destinationC.y].setVisible(true);

			System.out.println("Check judgement started");
			checkInstance.checkCheck(boardPiece);

			turnChecker.nextTurn();
			turnChecker.turnCheck();
			reInsertBMC();

			System.out.println("reInsert Listener Completed");
		}
		else if(sequence == 3) {
            removePMC();
            reInsertBMC();
            System.out.println("Wrong Destination Clicked so reInserted BListener..");
        }
	}

	private void reInsertBMC() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardPiece[i][j].piece != null)
                    boardPiece[i][j].addMouseListener(GameManager.boardMouseController);
            }
        }
    }

    private void removePMC() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardPiece[i][j].removeMouseListener(GameManager.pieceMouseController);
                if((j + i) % 2 == 0)
                    boardPiece[i][j].setBackground(new Color(219, 219, 219));
                else
                    boardPiece[i][j].setBackground(new Color(156, 156, 156));
            }
        }
    }
}