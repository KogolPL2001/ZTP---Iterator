package pl.wipb.ztp.iter;

public class ReversedIterator implements TileIterator {
    private int x,y;
    private Tile[][] matrix;
    public ReversedIterator(int x,int y,Tile[][] matrix)
    {
        this.x=x;
        this.y=y;
        this.matrix=matrix;
    }
    @Override
    public boolean HasNext(){
        if(y==0 && x==-1)
            return false;
        return true;
    }
    @Override
    public Tile Next(){
        if(x==-1){
            x=matrix[y].length-1;
            return matrix[--y][x--];
        }
        return matrix[y][x--];
    }
}