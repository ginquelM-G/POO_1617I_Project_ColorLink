package pt.isel.poo.view;

import isel.leic.pg.Console;
import pt.isel.poo.model.Cell;
import pt.isel.poo.model.Grid;

/**
 * Created by Moreira on 12/11/2016.
 */
public class LinkViewPiece extends ViewPiece {

    private char aspect ='o';

    @Override
    public char getViewType(Cell cell) {
        return 0;
    }

    @Override
    char getViewType() {
        return aspect;
    }

    void paintPiece(int line, int col, Grid model) {
        int idxLine = line/3; int idxCol = col/3;
        System.out.println("ENtrou line"+ idxLine + " col " + idxCol +" "+ model.cells[idxLine][idxCol].getype() );
        for (int i = line; i < line + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                Console.color(Console.WHITE, CELL_COLORS[model.cells[idxLine][idxCol].getColor()]);
                Console.cursor(i, j);
                if (i == line + 1 && j == col + 1) Console.print(getViewType());
                else if(i%2 == 0 && j % 2 == 1) Console.print('-');
                else if(i%2 == 1 && j % 2 == 0) Console.print('|');

//                System.out.println("Dir  "+ model.cells[idxLine][idxCol].getDir());
                if(model.cells[idxLine][idxCol].getDir() == Cell.Direction.UP &&
                        i%3 == 0 && j%3 ==0  || i%3 == 2 && j%3 ==2){
                    Console.color(Console.BLACK, Console.BLACK);
                    Console.print(' ');
                }else if(i%3 == 2 && j%3 ==2){
                    Console.color(Console.BLACK, Console.BLACK);
                  //  Console.print(' ');
                }else{ Console.print(' ');}
            }
        }
    }
}



