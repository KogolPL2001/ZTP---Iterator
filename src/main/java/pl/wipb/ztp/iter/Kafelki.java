package pl.wipb.ztp.iter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;

import java.util.Random;
import javax.swing.JPanel;

//macierz kafelków
class Kafelki extends JPanel {

	private Tile[][] matrix;
	private int tilesize;
	private Random rnd = new Random();
	// kafelek podświetlony (myszką)
	private int hx = -1, hy = -1;

	// inicjalizacja macierzy
	public Kafelki(int cols, int rows, int tilesize) {
		this.setPreferredSize(new Dimension(cols * tilesize, rows * tilesize));
		this.tilesize = tilesize;
		matrix = new Tile[rows][cols];
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				matrix[i][j] = new Tile();
			}
		}
	}

	// rysowanie macierzy (oraz jednego podświetlonego)
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				if (i == hy && j == hx) {
					g.setColor(matrix[i][j].getColor().brighter());
				} else {
					g.setColor(matrix[i][j].getColor());
				}
				g.fillRect(j * tilesize, i * tilesize + 1, tilesize - 1, tilesize - 1);
			}
		}
	}

	// podświetl
	public void highlight(int x, int y) {
		hx = x;
		hy = y;
		repaint();
	}

	// trzy poniższe metody znikną w finalnej wersji
	/*public int getRows() {
		return matrix.length;
	}

	public int getCols() {
		return matrix[0].length;
	}

	public Tile getAt(int row, int col) {
		return matrix[row][col];
	}*/

	// za to pojawi się metoda pobierająca iterator
	// public Iterator<Tile> iterator( ...
	public TileIterator GetIterator(int x,int y)
	{
		int number = rnd.nextInt(3);
		if(number == 0){
             return new FirstIterator(x, y,matrix);

        }else if (number == 1){
            return new ReversedIterator(x, y,matrix);

        
         }else{
            return new RandomIterator(x, y, matrix);
		 }
		
	}
}