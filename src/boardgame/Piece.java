package boardgame;

public class Piece{

	//position - ainda n�o � a posi��o de xadres
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	
	
	
}
