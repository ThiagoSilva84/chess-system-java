package boardgame;

public class Board {
	
	//um tabuleiro tem:
	//quantidade de linhas
	private int rows;
	//quantidade de colunas
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	//retornar a matriz na linha 'row' e na coluna 'column'
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	//retornar a peça pela posição
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		//ele vai na matriz de peça do tabuleiro
		//position vai ser um objeto que vai vir com a posição para colocar a peça
		pieces[position.getRow()][position.getColumn()] = piece;
		//como position é protected e está no msm pacote de classes, eu cosigo atribuir valor a ela aqui dessa classe
		piece.position = position;
	}
	
}
