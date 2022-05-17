package chess;

import boardgame.Board;
import boardgame.Piece;
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
	
	//opera��o movendo a pe�a
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		//converter a posi��o para posi��o da matriz
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		//validar se na posi�ao de origem havia uma pe�a
		validateSourcePosition(source);
		//make move: opera��o responsavel por realizar o movimento da pe�a
		Piece capturedPiece = makeMove(source, target);
		//feito downCasting pois a pe�a capturada era do tipo Piece e tem retornar ChessPiece.
		return (ChessPiece) capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position.");
		}
	}
	
	//esse m�todo vai receber as cordenadas do xadrez
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private Piece makeMove(Position source, Position target) {
		//retirei a pe�a que estava na posi��o de origem
		Piece p = board.removePiece(source);
		//vou remover a posivel pe�a que esteja na posi��o de destino e ela sera a pe�a capturada
		Piece capturedPiece = board.removePiece(target);
		//colocar a posi��o de orgem na posi��o de destino
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	//esse m�todo vai colocar as pe�as no tabuleiro
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
