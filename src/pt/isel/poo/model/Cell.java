package pt.isel.poo.model;

import isel.leic.pg.Console;

/**
 *  Created by Moreira on 12/11/2016.
 */
public abstract class Cell {
    char type;
    int color;
    Direction dir;

     public enum Direction{
        UP('u'),
        RIGHT('r'),
        DOWN('d'),
        LEFT('l');

        private char dirr;

        Direction(char dir){
            this.dirr = dir;
        }

        public char getDirection(){
            return dirr;
        }

    }

    static final int  [] CELL_COLORS ={
            Console.RED, Console.GREEN, Console.BLUE
    };

    public Cell(){ }

    public Cell(String type, int color, Direction dir){}

//    void setColor(int color){
//        this.color = color;
//    }
    abstract void setColor(int color);

    public abstract int getColor();

    public abstract char getype();

    public abstract  Direction getDir();
    public abstract  void setDir(Direction dir);
//    public Direction gerDir(){
//        for(Direction d: Direction.values()){
//            if(d.getDirection() == 'u')
//                return d;
//            if(d.getDirection() == 'r')
//                return d;
//            if(d.getDirection() == 'd')
//                return d;
//            if(d.getDirection() == 'l')
//                return d;
//        }
//        return null;
//    }
}
