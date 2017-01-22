package pt.isel.poo.controller;

import isel.leic.pg.*;
import isel.leic.pg.Console;
import isel.leic.pg.Location;
//import model.Grid;
import pt.isel.poo.model.Grid;
import pt.isel.poo.view.Panel;
//import view.Panel;

import java.io.*;
import java.util.*;

public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
    
    private Grid model = new Grid();
    private Panel view;

    private void run() {
        if (!loadLevel("Level1")) return;
        view = new Panel(model);
        view.repaint();
        Console.enableMouseEvents(true);
        while ( ! winGame() && play() )
            view.repaintTime();
        view.close();
    }

    private boolean winGame() {

        if (model.isOver()) {
            view.message("Winner");
            return true;
        }
        return false;
    }

    private boolean loadLevel(String filename) {
        try {
            Scanner level = new Scanner(new FileInputStream(filename+".txt"));
            model.load(level);
            level.close();
            return true;
        } catch (FileNotFoundException | InputMismatchException e) {
            System.out.println("Error loading file "+e.getMessage());
            return false;
        }
    }

    private boolean play() {
        //System.out.println("Start play");
        int key = Console.waitKeyPressed(100);
        if (key==' ') return false;
        if (key==Console.MOUSE_EVENT) {
            Location l = Console.getMouseEvent(MouseEvent.DOWN);
            if (l != null && l.line < model.LINE* view.PIECE_SIZE
                    && view.toModelLocation(l) && model.rotate(l.line, l.col)) {
                System.out.println("\nplay() -> Call view.paintPiece() ");
                view.paintPiece(l.line, l.col);
                while( Console.getMouseEvent(MouseEvent.UP) == null) ;
            }
        }
        return true;
    }
}
