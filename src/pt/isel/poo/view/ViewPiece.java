package pt.isel.poo.view;

import isel.leic.pg.Console;
import pt.isel.poo.model.Cell;
import pt.isel.poo.model.Grid;

/**
 * Created by Moreira on 13/11/2016.
 */
public class ViewPiece {
    public ViewPiece[][] viewPieces = new ViewPiece[3][3];

    char aspect =' ';
    Cell cell;

    static final int  [] CELL_COLORS ={
            Console.RED, Console.GREEN, Console.BLUE, Console.BLACK
    };

    char getViewType(Cell cell){
        return ' ';
    }

    char getViewType(){
        return ' ';
    }

    void paintPiece(int line, int col, Grid model){
        for(int i= line; i < line+3; i++ ) {
            for (int j = col; j < col+3; j++) {
                //Console.color(Console.WHITE, Console.RED);
                Console.color(Console.WHITE, CELL_COLORS[model.cells[line/3][col/3].getColor()]);
                Console.cursor(i, j);
                if(i ==line+1 && j==col+1) {
//                    Console.color(Console.WHITE, model.cells[line/3][col/3].getColor());
                    Console.print(getViewType());
                    //Console.print('+');
                }
                else Console.print(' ');
            }
//            System.out.println("linha "+ line/3 + " coluna "+ col/3 +" "+
//                    model.cells[line/3][col/3].getColor());

        }
    }


    public ViewPiece getView(char c){
        if(c == 'E') return new EmptyViewPiece();
        if(c == 'B') return new BlockViewPiece();
        if(c == 'S') return new SideViewPiece();
        if(c == 'C') return new CornerViewPiece();
        if(c == 'I') return new InvertViewPiece();
        if(c == 'L') return new LinkViewPiece();

        return null;
    }

}
