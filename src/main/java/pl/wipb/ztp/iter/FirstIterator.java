package pl.wipb.ztp.iter;

public class FirstIterator implements TileIterator {
    private int x,y;
    private Tile[][] matrix;
    public FirstIterator(int x,int y,Tile[][] matrix)
    {
        this.x=x;
        this.y=y;
        this.matrix=matrix;
    }
    @Override
    public boolean HasNext(){
        if(y==matrix.length-1 && x==matrix[y].length)
            return false;
        return true;
    }
    @Override
    public Tile Next(){
        if(matrix[y].length==x){
            x=0;
            return matrix[++y][x++];
        }
        return matrix[y][x++];
    }
}

