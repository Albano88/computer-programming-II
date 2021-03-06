package orologio;
import frazioni.Minuto;
import frazioni.Ora;


public class OrologioDaPolso {

	private int oreArabe = 24;
	private int minutiArabi = 60;
	Orologio<Ora> ore = new Orologio<Ora>(oreArabe);
	Orologio<Minuto> minuti = new Orologio<Minuto>(minutiArabi);
	
	public OrologioDaPolso() {
		inizializzaOrologioDaPolso();
		printFrazioni();	
	}
	
	private void inizializzaOrologioDaPolso(){
		for(Integer i = 0; i < ore.size(); i++)
			ore.add(new Ora(i.toString()));
		
		for(Integer i = 0; i < minuti.size(); i++)
			minuti.add(new Minuto(i.toString()));
	}
	
	private void printFrazioni(){
		System.out.println("ORE");
		for(Object o : ore.queue)
			System.out.print( ((Ora)o).getNome() + " ");
		
		System.out.println("\nMINUTI");
		for(Object o : minuti.queue)
			System.out.print( ((Minuto)o).getNome() + " ");
		System.out.println("\n");
	}
	
	public void stopAt(Ora o, Minuto m){
		Ora ora = ore.value();
		Minuto minuto = minuti.value();
		boolean found = false;
		
		while(!found){
			minuti.rotateF();
			minuto = minuti.value();
			
			if(minuto.getNome().equals("0")){
				ore.rotateF();
				ora = ore.value();
			}
			
			if((o.getNome().equals(ora.getNome()) && m.getNome().equals(minuto.getNome())))
				found = true;			
		}
		
		minuti.stop();
		ore.stop();
		System.out.println( "Orario bloccato alle: " +  ora.getNome() + ":" + minuto.getNome());
	}
	
	public void start(){	
		this.ore.restart();
		this.minuti.restart();
	}
	
	//DA RIFARE. VERGOGNARSI
	@Override
	public boolean equals(Object orologioPolso) {
		OrologioDaPolso other = (OrologioDaPolso) orologioPolso;
		Orologio<Ora> otherOre = other.ore;
		Orologio<Minuto> otherMinuti = other.minuti;
		
		String nomeOra1 = ((Ora)this.ore.value()).getNome();
		String nomeMinuto1 = ((Minuto) this.minuti.value()).getNome();
		String nomeOra2 = ((Ora)other.ore.value()).getNome();
		String nomeMinuto2 = ((Minuto)other.minuti.value()).getNome();
		
		return nomeOra1.equals(nomeOra2) && nomeMinuto1.equals(nomeMinuto2);
	}
}
