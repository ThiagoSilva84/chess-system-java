package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPostion. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	//coverter a chessPosition para a position normal
	//esse método vai retornar uma nova position
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//operação inversa: dada uma posição na matriz, eu tenho que converte-la para uma posição de xadrez
	//converter para uma posição de xadrez
	protected static ChessPosition fromPosition(Position position) {
								//vai converter para caracter
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
