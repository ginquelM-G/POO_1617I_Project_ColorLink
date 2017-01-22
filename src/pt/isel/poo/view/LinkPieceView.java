package pt.isel.poo.view;

import isel.leic.pg.Console;
import pt.isel.poo.model.Piece;

import static pt.isel.poo.view.Panel.PIECE_SIZE;

/**
 * Created by Moreira on 12/11/2016.
 */
public class LinkPieceView extends PieceView{

    private char aspect ='o';

    @Override
    public char getViewType(Piece piece) {
        return 0;
    }

    @Override
    char getViewType() {
        return aspect;
    }

    @Override
    void paintPiece(int line, int col, Piece piece) {
        Piece.Direction dir = piece.getDir();
        System.out.println("Class LinkPieceView -> paintPiece()  ");
        System.out.println("Type  "+ piece.getype() + " Piece.Dirrection = "+ dir);

        for (int i = line; i < line + PIECE_SIZE ; i++) {
            for (int j = col; j < col + PIECE_SIZE; j++) {
                Console.color(Console.WHITE, CELL_COLORS[piece.getColor()]);
                Console.cursor(i, j);
                if (i == line + 1 && j == col + 1) Console.print(getViewType()); // A parte central da Celula/Peça
                else if(i%2 == 0 && j % 2 == 1) Console.print('-');
                else if(i%2 == 1 && j % 2 == 0) Console.print('|');
                else {
                    if ((dir == Piece.Direction.UP || dir == Piece.Direction.DOWN)
                            && (i%3 == 0 && j%3 == 2 || i%3 == 2 && j % 3 == 0)) {
                        Console.print(' ');
                    }
                    else if ((dir == Piece.Direction.LEFT || dir == Piece.Direction.RIGHT)
                            && ( i%3 == 0 && j%3 == 0 || i%3 == 2 && j%3 == 2 )){
                        Console.print(' ');
                    }
                }
            }


        }
    }

}



