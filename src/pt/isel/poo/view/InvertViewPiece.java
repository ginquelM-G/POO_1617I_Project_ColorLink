package pt.isel.poo.view;

import isel.leic.pg.Console;
import pt.isel.poo.model.Cell;
import pt.isel.poo.model.Grid;

/**
 * Created by Moreira on 12/11/2016.
 */
public class InvertViewPiece extends ViewPiece {

    char aspect = 'o';

    @Override
    char getViewType() {
        return aspect;
    }


    void paintPiece(int line, int col, Grid model) {
        int idxLine = line / 3;
        int idxCol = col / 3;
        //System.out.println("Entrou line"+ idxLine + " col " + idxCol +" "+ model.cells[idxLine][idxCol].getype() );

        Cell.Direction d = model.cells[idxLine][idxCol].getDir();

        for (int i = line; i < line + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                Console.color(Console.WHITE, CELL_COLORS[model.cells[idxLine][idxCol].getColor()]);
                Console.cursor(i, j);

                if (i == line + 1 && j == col + 1) Console.print(getViewType());
                else if (d == Cell.Direction.UP) {
                    if (i % 3 == 0 && j % 3 == 1) Console.print('|');
                    if (i % 3 == 1 && j % 3 == 2) Console.print('-');

                    if(i % 3==0 &&  j%3 ==2){
                        Console.color(Console.BLACK, Console.BLACK);
                        Console.print(' ');
                    }else Console.print(' ');

                } else if (d == Cell.Direction.RIGHT) {
                    if (i % 3 == 2 && j % 3 == 1) Console.print('|');
                    if (i % 3 == 1 && j % 3 == 2) Console.print('-');

                    if(i % 3==2 &&  j%3 ==2){
                        Console.color(Console.BLACK, Console.BLACK);
                        Console.print(' ');
                    }else Console.print(' ');


                } else if (d == Cell.Direction.DOWN) {
                    if (i % 3 == 2 && j % 3 == 1) Console.print('|');
                    if (i % 3 == 1 && j % 3 == 0) Console.print('-');
                    if(i % 3==2 &&  j%3 ==0){
                        Console.color(Console.BLACK, Console.BLACK);
                        Console.print(' ');
                    }else Console.print(' ');


                } else if (d == Cell.Direction.LEFT) {
                    if (i % 3 == 0 && j % 3 == 1) Console.print('|');
                    if (i % 3 == 1 && j % 3 == 0) Console.print('-');
                    if(i % 3==0 &&  j%3 ==0){
                        Console.color(Console.BLACK, Console.BLACK);
                        Console.print(' ');
                    }else Console.print(' ');

                }
            }
        }
    }
}
