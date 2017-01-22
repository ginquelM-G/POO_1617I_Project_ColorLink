package pt.isel.poo.view;

import isel.leic.pg.Console;
import isel.leic.pg.Location;
import pt.isel.poo.model.Grid;

/**
 * Created by Moreira on 12/11/2016.
 */
public class Panel {

    private Grid model;
    public static final int PIECE_SIZE =3;
    private PieceView pieceView;

    static long  startTime;



    public Panel(Grid model) {
        this.model = model;
        pieceView = new PieceView();
        Console.open("ColorLink", (model.LINE*PIECE_SIZE)+1, model.COL*PIECE_SIZE);
        startTime = System.nanoTime();
    }

    public void repaint() {
        System.out.println("First Time Repaint");
        for (int i=0; i <  model.LINE*PIECE_SIZE; i+=3)
            for (int j=0 ; j < model.COL*PIECE_SIZE; j+=3) {
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

    public void close() {
        Console.close();
    }



    public void paintPiece(int line, int col) {
        // Ajustar os valores de line e col para início de cada celula
        line = (line % 3 == 1) ? line - 1 : (line % 3 == 2) ? line - 2 : line;
        col = (col % 3 == 1) ? col - 1 : (col % 3 == 2) ? col - 2 : col;

        //Apagar a Celula selecionada e repintar a Celula/Peça com uma rotação  de 90º
        for (int i = line; i < line + PIECE_SIZE; i++){
            for (int j = col; j < col + PIECE_SIZE; j++){
                Console.color(Console.BLACK, Console.BLACK);
                Console.cursor(i,j);
                Console.print(' ');
            }
        }
        System.out.println("All area of Piece was paint to BLACK ");

        PieceView v = pieceView.getView(model.pieces[line/PIECE_SIZE][col/PIECE_SIZE].getype());
        v.paintPiece(line, col, model.pieces[line/PIECE_SIZE][col/PIECE_SIZE]);

    }

    public boolean toModelLocation(Location l) {
        return true;
    }

    public void message(String winner) {
    }
}
