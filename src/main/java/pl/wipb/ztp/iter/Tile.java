package pl.wipb.ztp.iter;

import java.awt.Color;

// pojedynczy kafelek
class Tile {

	// schowek na wartość logiczną
	private boolean value = false;
	// kolory
	private static final Color on = new Color(0xffd700), off = new Color(0x1e90ff);

	// odczyt koloru
	public Color getColor() {
		return value ? on : off;
	}

	// zmiana koloru
	public void flip() {
		value = !value;
	}
}