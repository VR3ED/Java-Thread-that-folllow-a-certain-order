import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends Thread {
	int myId;
	//CyclicBarrier barriera;	
	Table myTable;
	Turno turno;
	
	public Player(int id, Table t, /*CyclicBarrier b,*/ Turno t2){
		this.myId=id;
		this.start();
		this.myTable=t;
		turno = t2;
		//barriera = b;
	}
	
	public void run(){
		boolean doppio=false;
		int dado1;
		int dado2;
		
		while(!myTable.finita()){
			doppio=true;
			while(doppio){
				dado1=(int)(6*Math.random());
				dado2=(int)(6*Math.random());
				doppio=(dado1==dado2);
				try {
					try {
						Thread.sleep(ThreadLocalRandom.current().nextInt(100, 300));
						//barriera.await();	
					} catch (InterruptedException /* | BrokenBarrierException*/ e1 ) {	}
					myTable.mossa(myId, dado1, dado2, turno);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Giocatore "+myId+" ha mosso ");
			}
		
		}
	}
}

