package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	//o tabuleiro (o board), ele tem as pe�as.
	
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	//retornar uma matriz de pe�as de xadrez correspondete a essa partida (partida ChessPiece)
	//o board tem as pe�as, e essa pe�as s�o do tipo piece.
	//o meu m�todo vai retornar um ChessPiece, pq estou na camada de xadrez
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
	
	//esse m�todo vai colocar as pe�as no tabuleiro
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}
