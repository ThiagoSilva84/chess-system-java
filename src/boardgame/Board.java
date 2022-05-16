package boardgame;

public class Board {
	
	//um tabuleiro tem:
	//quantidade de linhas
	private int rows;
	//quantidade de colunas
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creatin board: there must be al least 1 row and 1 column.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	//retornar a matriz na linha 'row' e na coluna 'column'
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[row][column];
	}
	
	//retornar a pe�a pela posi��o
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		//antes de colocar essa pe�a na posi��o, tenhoq testar se ja tem uma pe�a nessa posi��o
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);		}
		//ele vai na matriz da pe�a do tabuleiro
		//position vai ser um objeto que vai vir com a posi��o para colocar a pe�a
		pieces[position.getRow()][position.getColumn()] = piece;
		//como position � protected e est� no msm pacote de classes, eu cosigo atribuir valor a ela aqui dessa classe
		piece.position = position;
	}
	
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		return piece(position) != null;
	}
}
