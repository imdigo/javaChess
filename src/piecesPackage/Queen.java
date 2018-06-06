package piecesPackage;

import managePackage.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import managePackage.Coordinate;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Queen extends Piece {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
    }
	public BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(team == 0)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_QUEEN);
		else if(team == 1)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_QUEEN);
		else if(team == 2)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.RED_QUEEN);
		else if(team == 3)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.GREEN_QUEEN);
		return image1;
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1;; j++) {
                        if (boardPiece[c.x + (i) * j][c.y + (i) * j].piece == null) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y + (i) * j]))
                                boardPiece[c.x + (i) * j][c.y + (i) * j].setBackground(new Color(145, 255, 228));
                        }
                        else {
                            if (boardPiece[c.x + (i) * j][c.y + (i) * j].piece.team % 2 != this.team % 2) {
                                if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y + (i) * j]))
                                    boardPiece[c.x + (i) * j][c.y + (i) * j].setBackground(new Color(255, 97, 160));
                            }
                            break;
                        }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {}
        }
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1;; j++) {
                    if (boardPiece[c.x + (i) * j][c.y - (i) * j].piece == null) {
                        if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y - (i) * j]))
                            boardPiece[c.x + (i) * j][c.y - (i) * j].setBackground(new Color(145, 255, 228));
                    }
                    else {
                        if (boardPiece[c.x + (i) * j][c.y - (i) * j].piece.team % 2 != this.team % 2) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y - (i) * j]))
                                boardPiece[c.x + (i) * j][c.y - (i) * j].setBackground(new Color(255, 97, 160));
                        }
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {}
        }

        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1;; j++) {
                        if (boardPiece[c.x + (i) * j][c.y].piece == null) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y]))
                                boardPiece[c.x + (i) * j][c.y].setBackground(new Color(145, 255, 228));
                        }
                        else {
                            if (boardPiece[c.x + (i) * j][c.y].piece.team % 2 != this.team % 2) {
                                if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y]))
                                    boardPiece[c.x + (i) * j][c.y].setBackground(new Color(255, 97, 160));
                            }
                                break;
                        }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {}
        }
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1;; j++) {
                    if (boardPiece[c.x][c.y + (i) * j].piece == null) {
                        if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + (i) * j]))
                            boardPiece[c.x][c.y + (i) * j].setBackground(new Color(145, 255, 228));
                    }
                    else {
                        if (boardPiece[c.x][c.y + (i) * j].piece.team % 2 != this.team % 2) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + (i) * j]))
                                boardPiece[c.x][c.y + (i) * j].setBackground(new Color(255, 97, 160));
                        }
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {}
        }
	}

}
