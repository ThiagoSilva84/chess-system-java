package chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board;
	
	//o tabuleiro (o board), ele tem as peças.
	
	
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	//retornar uma matriz de peças de xadrez correspondete a essa partida (partida ChessPiece)
	//o board tem as peças, e essa peças são do tipo piece.
	//o meu método vai retornar um ChessPiece, pq estou na camada de xadrez
	public ChessPiece[][] getPieces() {
		ChessPiece [][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				//aqui estou fazendo um downCasting. 
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	
}
