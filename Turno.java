
public class Turno implements Runnable {
	public int turno = 1;
	public synchronized void incrementaTurno() { turno ++; }

	@Override
	public void run() {
		System.out.println("concluso un giro");
	}
}
