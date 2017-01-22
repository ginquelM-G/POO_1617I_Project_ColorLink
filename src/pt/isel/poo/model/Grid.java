package pt.isel.poo.model;

import pt.isel.poo.model.Piece.Direction;

import java.util.HashMap;
import java.util.Scanner;

import static pt.isel.poo.model.Piece.Direction.*;

/**
 *  Created by Moreira on 12/11/2016.
 */
public class Grid {
    public static int LINE, COL;

    public static Piece[][] pieces;
    static HashMap<Character,Piece> list_cell;

    public Grid(){
        //initCell();
    }

    public Grid(int line, int col){}

    public boolean rotate(int line, int col) {

        if(pieces[line/3][col/3] instanceof Block||  pieces[line/3][col/3] instanceof Empty)
            return false;

        Direction dir = pieces[line/3][col/3].getDir();
        System.out.println("rotate() -> Direction " +dir +" ordinal "+ dir.ordinal());

//        Direction d = Direction.values()[dir.ordinal()];
//        System.out.println("rotate() -> Direction " + dir +" ordinal "+ d);

        switch(dir){
            case UP: pieces[line/3][col/3].setDir(RIGHT); break;
            case RIGHT: pieces[line/3][col/3].setDir(DOWN); break;
            case DOWN: pieces[line/3][col/3].setDir(LEFT); break;
            case LEFT: pieces[line/3][col/3].setDir(UP); break;
        }
//        for(Direction d: Direction.values()) {
//            if (d.getDirection() == cellDesc.charAt(k)) {
//                pieces[i][j].setDir(d);
//                break For_end;
//            }
//        }

        return true;
    }

    public void load(Scanner level) {
        String [] lineCol = level.nextLine().split(" ");
        LINE = Integer.parseInt(lineCol[0]);
        COL = Integer.parseInt(lineCol[2]);
        pieces = new Piece[LINE][COL];
        //int i=0, j=0, auxNextLine =0;

        for(int i=0, j=0,auxNextLine=0;  level.hasNext() ; ){
            String cellDesc = level.next();
            System.out.print(cellDesc + " ");
            int k=0;
            char letra = cellDesc.charAt(k); // c - Letra do Tipo da Celula

            if(pieces[i][j] == null) {
                pieces[i][j] = getCell(letra);
                if(++k < cellDesc.length() && cellDesc.charAt(k) !='+') {
                    pieces[i][j].setColor((cellDesc.charAt(k)) - '0');
                    if(++k < cellDesc.length() )
                        For_end:
                                for(Direction d: Direction.values()) {
                                    if (d.getDirection() == cellDesc.charAt(k)) {
                                        pieces[i][j].setDir(d);
                                        break For_end;
                                    }
                                }
//                    System.out.println("--> COLOR  i=" +i+" j = "+j+ " C " + ((aux.charAt(k)) - '0') );
                }
            }
            if(++auxNextLine == COL){
                System.out.println();
                i++; j=0; auxNextLine=0;
            }
            else j++;
        }
        System.out.println(" ");
    }

    public boolean isOver() {
        return false;
    }

    public Piece getCell(char c){
        switch(c){
            case 'E':  return new Empty();
            case 'B':  return new Block();
            case 'S':  return new Side();
            case 'C':  return new Corner();
            case 'I':  return new Invert();
            case 'L':  return new Link();
        }
//        if(list_cell.containsKey(c))
//            return list_cell.get(c);

        return null;
    }

    public void initCell(){
        list_cell = new HashMap<Character,Piece>();
        list_cell.put('E', new Empty());
        list_cell.put('B', new Block());
        list_cell.put('S', new Side());
        list_cell.put('C', new Corner());
        list_cell.put('I', new Invert());
        list_cell.put('L', new Link());
    }
}
