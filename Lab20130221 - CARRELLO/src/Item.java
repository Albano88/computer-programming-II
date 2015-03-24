import articoli.Articolo;


public class Item {
	private Articolo articolo;
	private int quantita;
	
	public Item(Articolo articolo, int quantit�) {
		this.articolo = articolo;
		this.quantita = quantit�;
	}
	
	public Articolo getArticolo(){
		return this.articolo;
	}
	
	public int getQuantita(){
		return this.quantita;
	}
}
