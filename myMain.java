import java.util.concurrent.CyclicBarrier;

public class myMain {
	public static void main(String[] args) throws InterruptedException {
		
		Turno t = new Turno();
		//CyclicBarrier b = new CyclicBarrier(3, t);
		
		Table gameTable = new Table();
		
		Thread player1 = new Player(1, gameTable, /* b, */ t);
		Thread player2 = new Player(2, gameTable, /* b, */ t);
		Thread player3 = new Player(3, gameTable, /* b, */ t);
		
		
		
		player1.join();
		player2.join();
		player3.join();		
		System.out.println("Game over");
	}
}
