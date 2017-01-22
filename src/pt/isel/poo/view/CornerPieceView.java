package pt.isel.poo.view;

import isel.leic.pg.Console;
import pt.isel.poo.model.Piece;

import static pt.isel.poo.view.Panel.PIECE_SIZE;

/**
 * Created by Moreira on 12/11/2016.
 */
public class CornerPieceView extends PieceView {

    private char aspect = 'o';

    @Override
    char getViewType(Piece piece) {
        return super.getViewType(piece);
    }

    @Override
    char getViewType() {
        return aspect;
    }


    void paintPiece(int line, int col, Piece piece) {
        Piece.Direction dir = piece.getDir();
        System.out.println("Class CornerPieceView -> paintPiece()  ");
        System.out.println("Type  " + piece.getype() + " Piece.Dirrection = " + dir);

        for (int i = line; i < line + PIECE_SIZE; i++) {
            for (int j = col; j < col + PIECE_SIZE; j++) {
                Console.color(Console.WHITE, CELL_COLORS[piece.getColor()]);
                Console.cursor(i, j);
                if (i == line + 1 && j == col + 1) Console.print(getViewType());
                else if (dir == Piece.Direction.UP) {
                    if (i % 3 == 0 && j % 3 == 1) Console.print('|');
                    if (i % 3 == 1 && j % 3 == 2) Console.print('-');
                    if (i % 3 == 0 && j % 3 == 2) Console.print(' ');
                }
                else if (dir == Piece.Direction.LEFT) {
                    if (i % 3 == 0 && j % 3 == 1) Console.print('|');
                    if (i % 3 == 1 && j % 3 == 0) Console.print('-');
                    if (i % 3 == 2 || j % 3 == 2) {
                        Console.color(Console.BLACK, Console.BLACK);
                        Console.print(' ');
                    } else {
                        Console.print(' ');
                    }
                }else if (dir == Piece.Direction.RIGHT) {
                    if (i % 3 == 2 && j % 3 == 1) Console.print('|');
                    if (i % 3 == 1 && j % 3 == 2) Console.print('-');
                    if (i % 3 == 2 && j % 3 == 2) Console.print(' ');
                }
                else if (dir == Piece.Direction.DOWN) {
                    if (i % 3 == 2 && j % 3 == 1) Console.print('|');
                    if (i % 3 == 1 && j % 3 == 0) Console.print('-');
                    if (i % 3 == 0 || j % 3 == 2) {
                        Console.color(Console.BLACK, Console.BLACK);
                        Console.print(' ');
                    } else {
                        Console.print(' ');
                    }
                }


            }
        }

    }
}