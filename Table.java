
public class Table {
	private boolean isFinita=false;
	Table(){
		isFinita=false;
	}
	
	public synchronized void mossa(int playerId, int dado1, int dado2, Turno turno) throws InterruptedException{
		// qui si dovrebbero implementare gli effetti della mossa
		// ma non ci interessa
		
		while( turno.turno %3 != playerId ) {
			wait();
		}
		isFinita=(Math.random()<0.2);
		if(isFinita){
			System.out.println("il giocatore "+playerId+" ha vinto!");
		}
		turno.incrementaTurno();
		notifyAll();
	}
	
	boolean finita(){
		return isFinita;
	}
}
