package pt.isel.poo.view;

import isel.leic.pg.Console;
import pt.isel.poo.model.Piece;

/**
 *  Created by Moreira on 13/11/2016.
 */
public class PieceView {
    public PieceView[][] pieceViews = new PieceView[3][3];

    char aspect =' ';
    Piece piece;

    static final int  [] CELL_COLORS ={
            Console.RED, Console.GREEN, Console.BLUE, Console.BLACK
    };

    char getViewType(Piece piece){
        return ' ';
    }

    char getViewType(){
        return ' ';
    }

    void paintPiece(int line, int col, Piece piece){
        for(int i= line; i < line+3; i++ ) {
            for (int j = col; j < col+3; j++) {
                Console.color(Console.WHITE, CELL_COLORS[piece.getColor()]);
                Console.cursor(i, j);
                if(i ==line+1 && j==col+1) {
                    Console.print(getViewType()); //Console.print('+');
                }
                else Console.print(' ');
            }
        }
    }


    public PieceView getView(char c){
        if(c == 'E') return new EmptyPieceView();
        if(c == 'B') return new BlockPieceView();
        if(c == 'S') return new SidePieceView();
        if(c == 'C') return new CornerPieceView();
        if(c == 'I') return new InvertPieceView();
        if(c == 'L') return new LinkPieceView();

        return null;
    }

}
