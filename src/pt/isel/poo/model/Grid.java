package pt.isel.poo.model;

import java.util.HashMap;
import java.util.Scanner;

/**
 *  Created by Moreira on 12/11/2016.
 */
public class Grid {
    public static int LINE, COL;

    public static Cell [][] cells;
    static HashMap<Character,Cell> list_cell;

    public Grid(){
        //initCell();
    }

    public Grid(int line, int col){}

    public boolean rotate(int line, int col) {
        return false;
    }

    public void load(Scanner level) {
        String [] lineCol = level.nextLine().split(" ");
        LINE = Integer.parseInt(lineCol[0]);
        COL = Integer.parseInt(lineCol[2]);
        cells = new Cell[LINE][COL];
        int i=0, j=0, auxNextLine =0;

        while(level.hasNext()){
            String aux = level.next(); System.out.print(aux + " ");
            int k=0;    char c = aux.charAt(k);
            if(cells[i][j] == null) {
                cells[i][j] = getCell(c);
                if(++k < aux.length() && aux.charAt(k) !='+') {
                    cells[i][j].setColor((aux.charAt(k)) - '0');
                    if(++k < aux.length() )
                        For_end:
                                for(Cell.Direction d: Cell.Direction.values()) {
                                    if (d.getDirection() == aux.charAt(k)) {
                                        cells[i][j].setDir(d);
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

    public Cell getCell(char c){
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
        list_cell = new HashMap<Character,Cell>();
        list_cell.put('E', new Empty());
        list_cell.put('B', new Block());
        list_cell.put('S', new Side());
        list_cell.put('C', new Corner());
        list_cell.put('I', new Invert());
        list_cell.put('L', new Link());
    }
}
