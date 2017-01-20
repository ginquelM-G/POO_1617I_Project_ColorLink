package pt.isel.poo.view;

import isel.leic.pg.Console;
import isel.leic.pg.Location;
import pt.isel.poo.model.Grid;

/**
 * Created by Moreira on 12/11/2016.
 */
public class Panel {

    Grid model;
    final int PIECE_SIZE =3;
    ViewPiece vP;

    static long  startTime;



    public Panel(Grid model) {
        this.model = model;
        vP = new ViewPiece();
        Console.open("ColorLink", (model.LINE*PIECE_SIZE)+1, model.COL*PIECE_SIZE);
        startTime = System.nanoTime();
    }

    public void repaint() {
        for (int i=0; i <  model.LINE*PIECE_SIZE; i+=3)
            for (int j=0 ; j< model.COL*PIECE_SIZE; j+=3) {
                paintPiece(i, j);
            }
    }

    public void repaintTime() {


        for(int i=0; i < model.COL*PIECE_SIZE; i++){
            Console.cursor((model.LINE*PIECE_SIZE), i );
            Console.color(Console.WHITE, Console.LIGHT_GRAY);
            Console.print(' ');
        }
        Console.cursor((model.LINE*PIECE_SIZE), 0);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        Console.print(""+ duration/1000000000 + " segundos");
    }

    public void close() {}

    public void paintPiece(int line, int col,Grid model){


        vP.getView(model.cells[line][col].getype())
                .paintPiece(line, col, model);
        //System.out.println("line "+line + "col "+ col + " "+model.cells[line/3][col/3].getype() );

    }

    public void paintPiece(int line, int col) {
        //System.out.println("line "+line + "col "+ col + " "+model.cells[line/3][col/3].getype() );
        //paintPiece(line, col, model);
        ViewPiece v = vP.getView(model.cells[line/3][col/3].getype());
                v.paintPiece(line, col, model);

    }

    public boolean toModelLocation(Location l) {
        return false;
    }

    public void message(String winner) {
    }
}
