package model;
import static java.lang.Thread.sleep;
import static java.lang.Math. *;

class Cliente extends Thread {
	private Barbero bar;


	public Cliente( Barbero b) {
		this.bar = b;
	}

	@Override
	public void run() {
		try {
			bar.ocuparSilla(Math.random()*4 + 1);
			
			
			bar.inicioCorte();
			
			sleep(800);
			bar.finCorte();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
