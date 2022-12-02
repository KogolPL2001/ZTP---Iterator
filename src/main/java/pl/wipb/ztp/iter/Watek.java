package pl.wipb.ztp.iter;

// ten wątek nie wykorzystuje iteratora
class Watek implements Runnable {

	private Kafelki p;
	private int x, y;

	// x, y to początkowa pozycja do iteracji
	public Watek(Kafelki k, int x, int y) {
		this.p = k;
		this.x = x;
		this.y = y;
	}

	public void run() {
		// klasyczna podwójna pętla do iteracji
		// tutaj kontrolujemy kolejność odwiedzin
		// zostanie to zastąpione pętlą z użyciem iteratora
		/*for (int i = y; i < p.getRows(); ++i) {
			int j;
			if (i == y) {
				j = x;
			} else {
				j = 0;
			}
			for (; j < p.getCols(); ++j) {
				// a w środku - obracamy, odświeżamy i czekamy
				p.getAt(i, j).flip();
				p.repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}*/
		TileIterator i = p.GetIterator(x, y);
		while(i.HasNext()){
			Tile t=i.Next();
			t.flip();
			p.repaint();
			try{
				Thread.currentThread().sleep(100);
			}catch(InterruptedException e){}
		}
	}
}