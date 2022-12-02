package pl.wipb.ztp.iter;

import java.util.Random;

public class RandomIterator implements TileIterator {
    private int x,y;
    private Tile[][] matrix;
    private Random rnd = new Random();
    public RandomIterator(int x,int y,Tile[][] matrix)
    {
        this.x=x;
        this.y=y;
        this.matrix=matrix;
    }
    @Override
    public boolean HasNext(){
        return true;
    }
    @Override
    public Tile Next(){
        return matrix[rnd.nextInt(matrix.length)][rnd.nextInt(matrix[y].length)];
    }
}