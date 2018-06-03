package chessDemo;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Pawn extends Piece {

    ChessPieceSprite instance = ChessPieceSprite.getInstace();
	
	BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(team == 1)
			return instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_PAWN);
		else if(team == 2)
			return instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_PAWN);
		else {
            System.out.println("There's Error~ Fuck you~");
            return instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KING);
        }
            
            
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c)
	{
		if (this.team == 1) {


            if (boardPiece[c.x-1][c.y].image == null) {
                boardPiece[c.x-1][c.y].setBackground(new Color(145, 255, 228));
                if(c.x == 6 && boardPiece[c.x-2][c.y].image == null)
                    boardPiece[c.x-2][c.y].setBackground(new Color(145, 255, 228));
            }



			try {
				if (boardPiece[c.x-1][c.y+1].image != null && boardPiece[c.x-1][c.y+1].piece.team % 2 == 0)
					boardPiece[c.x-1][c.y+1].setBackground(new Color(255, 97, 160));
			} catch (ArrayIndexOutOfBoundsException a) {}
			try {
				if (boardPiece[c.x-1][c.y-1].image != null && boardPiece[c.x-1][c.y-1].piece.team % 2 == 0)
					boardPiece[c.x-1][c.y-1].setBackground(new Color(255, 97, 160));
			} catch (ArrayIndexOutOfBoundsException a) {}

			
			if (c.y == 1) {
				// case of promotion
			}
			if (c.y == 3) {
				// case of en passant
			}
		}
		else if(this.team == 2)
		{

            if (boardPiece[c.x+1][c.y].image == null) {
                boardPiece[c.x+1][c.y].setBackground(new Color(145, 255, 228));
                if(c.x == 1 && boardPiece[c.x+2][c.y].image == null)
                    boardPiece[c.x+2][c.y].setBackground(new Color(145, 255, 228));
            }

			try {
				if (boardPiece[c.x+1][c.y+1].image != null && boardPiece[c.x+1][c.y+1].piece.team % 2 == 1)
					boardPiece[c.x+1][c.y+1].setBackground(new Color(255, 97, 160));
			} catch (ArrayIndexOutOfBoundsException a) {}
			try {
				if (boardPiece[c.x+1][c.y-1].image != null && boardPiece[c.x+1][c.y-1].piece.team % 2 == 1)
					boardPiece[c.x+1][c.y-1].setBackground(new Color(255, 97, 160));
			} catch (ArrayIndexOutOfBoundsException a) {}
			if(c.x == 6) { 
				// case of promotion
			}
			if(c.x == 4) {  
				// case of en passant
			}
		}

		else {}  // case of 2vs2

	}
}
