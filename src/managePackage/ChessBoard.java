package managePackage;

import javax.swing.*;
import java.awt.*;

public class ChessBoard {


    private int i, j;
    JPanel gamePanel = new JPanel();
    JPanel boardPanel = new JPanel();
    ChessPanel[][] boardPiece;
    public static ChessPanel[][] deathPieceLeft1v1;
    public static ChessPanel[][] deathPieceRight1v1;
    public static ChessPanel[][] deathPieceLeft2v2;
    public static ChessPanel[][] deathPieceRight2v2;
    public static ChessPanel[][] deathPieceUp2v2;
    public static ChessPanel[][] deathPieceDown2v2;
        public JPanel makeGamePanel(int type) {
        if(type == 1)
        {	
        	JPanel boardPanel;
        	JPanel[] deathPanel;

        	boardPanel = makeBoard(1);
        	deathPanel = makeDeathBoard(1);

        	gamePanel.setSize(1280, 720);
        	gamePanel.setLayout(null);

        	gamePanel.add(boardPanel);
        	gamePanel.add(deathPanel[0]);
        	gamePanel.add(deathPanel[1]);
        
        	boardPanel.setBounds(340, 60, 600, 600);
        	deathPanel[0].setBounds(170, 60, 600 / 4, 600);
        	deathPanel[1].setBounds(960, 60, 600 / 4, 600);

        /*JPanel forTitle = new JPanel();
        forTitle.setSize(1280, 145);
        game1v1Panel.add(forTitle, BorderLayout.NORTH);
        */
        	return gamePanel;
        }
        else
        {
        	JPanel boardPanel;
        	JPanel[] deathPanel;

        	boardPanel = makeBoard(2);
        	deathPanel = makeDeathBoard(2);

        	gamePanel.setSize(1280, 720);
        	gamePanel.setLayout(null);

        	gamePanel.add(boardPanel);
        	gamePanel.add(deathPanel[0]);
        	gamePanel.add(deathPanel[1]);
        	gamePanel.add(deathPanel[2]);
        	gamePanel.add(deathPanel[3]);
        	boardPanel.setBounds(380, 90, 500, 500);
        	deathPanel[0].setBounds(350-2*(500/14), 90+3*(500/14), 500 / 7, 8*(500/14));
        	deathPanel[1].setBounds(910, 90+3*(500/14), 500 / 7, 8*(500/14));
        	deathPanel[2].setBounds(380+3*(500/14), 60-2*(500/14), 8*(500/14), 500 / 7);
        	deathPanel[3].setBounds(380+3*(500/14), 620, 8*(500/14), 500/7);
        	return gamePanel;
        }
    }

    public JPanel makeBoard(int type) {

		if (type == 1) {
			boardPiece = new ChessPanel[8][8];
			boardPanel.setPreferredSize(new Dimension(600, 600));

			boardPanel.setLayout(new GridLayout(8, 8));

			for (i = 0; i < 8; ++i) {
				for (j = 0; j < 8; ++j) {
					boardPiece[i][j] = new ChessPanel();
					boardPiece[i][j].setSize(600 / 8, 600 / 8);
					boardPiece[i][j].setOpaque(true);
					if ((j + i) % 2 == 0)
						boardPiece[i][j].setBackground(new Color(219, 219, 219));
					else
						boardPiece[i][j].setBackground(new Color(156, 156, 156));

					boardPanel.add(boardPiece[i][j]);

					boardPiece[i][j].setIndex(i, j);

				}
			}
			return boardPanel;
		} else {
			boardPiece = new ChessPanel[14][14];
			boardPanel.setPreferredSize(new Dimension(400, 400));

			boardPanel.setLayout(new GridLayout(14, 14));

			for (i = 0; i < 14; ++i) {
				for (j = 0; j < 14; ++j) {
					boardPiece[i][j] = new ChessPanel();
					boardPiece[i][j].setSize(400 / 14, 400 / 14);
					boardPiece[i][j].setOpaque(true);
					if ((j + i) % 2 == 0)
						boardPiece[i][j].setBackground(new Color(219, 219, 219));
					else
						boardPiece[i][j].setBackground(new Color(156, 156, 156));

					boardPanel.add(boardPiece[i][j]);

					boardPiece[i][j].setIndex(i, j);

				}
			}
			for(i = 0;i<3;i++)
			{
				for(j = 0;j<3;j++)
				{
					boardPiece[i][j].setBackground(new Color(0, 0, 0));
				}
			}
			for(i = 11;i<14;i++)
			{
				for(j = 0;j<3;j++)
				{
					boardPiece[i][j].setBackground(new Color(0, 0, 0));
				}
			}
			for(i = 0;i<3;i++)
			{
				for(j = 11;j<14;j++)
				{
					boardPiece[i][j].setBackground(new Color(0, 0, 0));
				}
			}
			for(i = 11;i<14;i++)
			{
				for(j = 11;j<14;j++)
				{
					boardPiece[i][j].setBackground(new Color(0, 0, 0));
				}
			}
			return boardPanel;
		}
    }

    public JPanel[] makeDeathBoard(int type) {
        if(type == 1)
		{
			JPanel[] deathPanel = new JPanel[2];
			deathPanel[0] = new JPanel(); // left
			deathPanel[1] = new JPanel(); // right

			deathPieceLeft1v1 = new ChessPanel[8][2];
			deathPieceRight1v1 = new ChessPanel[8][2];

			deathPanel[0].setSize(600 / 4, 600);
			deathPanel[0].setLayout(new GridLayout(8, 2));
			deathPanel[1].setSize(600 / 4, 600);
			deathPanel[1].setLayout(new GridLayout(8, 2));

			for (i = 0; i < 8; i++) {
				for (j = 0; j < 2; j++) {
					deathPieceLeft1v1[i][j] = new ChessPanel();
					deathPieceLeft1v1[i][j].setSize(600 / 8, 600 / 8);
					deathPieceLeft1v1[i][j].setOpaque(true);
					deathPieceLeft1v1[i][j].setBackground(new Color(68, 126, 150, 200));
					deathPieceLeft1v1[i][j].setIndex(i, j);
					deathPanel[0].add(deathPieceLeft1v1[i][j]);
				}
			}
			for (i = 0; i < 8; i++) {
				for (j = 0; j < 2; j++) {
					deathPieceRight1v1[i][j] = new ChessPanel();
					deathPieceRight1v1[i][j].setSize(600 / 8, 600 / 8);
					deathPieceRight1v1[i][j].setOpaque(true);
					deathPieceRight1v1[i][j].setBackground(new Color(68, 126, 150, 200));
					deathPieceRight1v1[i][j].setIndex(i, j);
					deathPanel[1].add(deathPieceRight1v1[i][j]);
				}
			}
			return deathPanel;
		}
        else
        {
        	JPanel[] deathPanel = new JPanel[4];
			deathPanel[0] = new JPanel(); // left
			deathPanel[1] = new JPanel(); // right
			deathPanel[2] = new JPanel();
			deathPanel[3] = new JPanel();
			deathPieceLeft2v2 = new ChessPanel[8][2];
			deathPieceRight2v2 = new ChessPanel[8][2];
			deathPieceUp2v2 = new ChessPanel[2][8];
			deathPieceDown2v2 = new ChessPanel[2][8];
			//deathPanel[0].setSize(400 / 14, 400);
			deathPanel[0].setLayout(new GridLayout(8, 2));
			//deathPanel[1].setSize(400 / 14, 400);
			deathPanel[1].setLayout(new GridLayout(8, 2));
			//deathPanel[2].setSize(400, 400 / 14);
			deathPanel[2].setLayout(new GridLayout(2, 8));
			//deathPanel[3].setSize(400, 400 / 14);
			deathPanel[3].setLayout(new GridLayout(2, 8));
			for (i = 0; i < 8; i++) {
				for (j = 0; j < 2; j++) {
					deathPieceLeft2v2[i][j] = new ChessPanel();
					deathPieceLeft2v2[i][j].setSize(500 / 14, 500 / 14);
					deathPieceLeft2v2[i][j].setOpaque(true);
					deathPieceLeft2v2[i][j].setBackground(new Color(68, 126, 150, 200));
					deathPieceLeft2v2[i][j].setIndex(i, j);
					deathPanel[0].add(deathPieceLeft2v2[i][j]);
				}
			}
			for (i = 0; i < 8; i++) {
				for (j = 0; j < 2; j++) {
					deathPieceRight2v2[i][j] = new ChessPanel();
					deathPieceRight2v2[i][j].setSize(500 / 14, 500 / 14);
					deathPieceRight2v2[i][j].setOpaque(true);
					deathPieceRight2v2[i][j].setBackground(new Color(68, 126, 150, 200));
					deathPieceRight2v2[i][j].setIndex(i, j);
					deathPanel[1].add(deathPieceRight2v2[i][j]);
				}
			}
			for (i = 0; i < 2; i++) {
				for (j = 0; j < 8; j++) {
					deathPieceUp2v2[i][j] = new ChessPanel();
					deathPieceUp2v2[i][j].setSize(500 / 14, 500 / 14);
					deathPieceUp2v2[i][j].setOpaque(true);
					deathPieceUp2v2[i][j].setBackground(new Color(68, 126, 150, 200));
					deathPieceUp2v2[i][j].setIndex(i, j);
					deathPanel[2].add(deathPieceUp2v2[i][j]);
				}
			}
			for (i = 0; i < 2; i++) {
				for (j = 0; j < 8; j++) {
					deathPieceDown2v2[i][j] = new ChessPanel();
					deathPieceDown2v2[i][j].setSize(500 / 14, 500 / 14);
					deathPieceDown2v2[i][j].setOpaque(true);
					deathPieceDown2v2[i][j].setBackground(new Color(68, 126, 150, 200));
					deathPieceDown2v2[i][j].setIndex(i, j);
					deathPanel[3].add(deathPieceDown2v2[i][j]);
				}
			}
			return deathPanel;
        }
    }
}


