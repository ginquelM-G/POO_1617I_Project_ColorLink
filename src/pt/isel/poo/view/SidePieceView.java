package pt.isel.poo.view;

import isel.leic.pg.Console;
import pt.isel.poo.model.Piece;

import static pt.isel.poo.view.Panel.PIECE_SIZE;

/**
 * Created by Moreira on 12/11/2016.
 */
public class SidePieceView extends PieceView {

    char aspect = 'o';

    @Override
    char getViewType() {
        return aspect;
    }


    void paintPiece(int line, int col, Piece piece) {
        System.out.println("Class SidePieceView -> paintPiece() Type"+ piece.getype() );

        Piece.Direction d = piece.getDir();
        System.out.println("Piece.Dirrection = "+ d);

        for (int i = line; i < line + PIECE_SIZE ; i++) {
            for (int j = col; j < col + PIECE_SIZE; j++) {
                Console.color(Console.WHITE, CELL_COLORS[piece.getColor()]);
                Console.cursor(i, j);

                // A parte central da Celula/Peça
                if (i == line + 1  && j == col + 1 ){   Console.print(getViewType());  }
                else {
                    if (d == Piece.Direction.UP || d == Piece.Direction.DOWN) {
                        if (i % 3 == 1 && (j % 3 == 0 || j % 3 == 2)) Console.print('-');
                    }
                    else if (d == Piece.Direction.RIGHT || d == Piece.Direction.LEFT) {
                        if ((i % 3 == 0 || i % 3 == 2) && j % 3 == 1) Console.print('|');
                    }
                    if(d == Piece.Direction.UP && i%3 ==0 || d== Piece.Direction.DOWN && i %3==2 ||
                            d == Piece.Direction.RIGHT && j % 3 == 2 || d == Piece.Direction.LEFT && j % 3 == 0){
                        Console.print(' ');
                    }
                }
            }
        }


    }



}
