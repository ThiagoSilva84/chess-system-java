package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		//como verificar se existe uma pe�a adversaria na posi��o passada por parametro?
		ChessPiece p = (ChessPiece)getBoard().piece(position); //estou pegando a pe�a que est� nessa posi��o
		return p != null && p.getColor() != color;
	}
}
