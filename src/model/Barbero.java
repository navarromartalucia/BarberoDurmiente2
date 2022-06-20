package model;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

class Barbero {
	public boolean ocupado;
	public boolean[] sillas = new boolean[5];

	public Barbero(boolean ocupado) {
		this.ocupado = ocupado;
	}

	//sillas true = ocupada
	//sillas false = desocupada
	public synchronized void ocuparSilla(double cantClientesNuevos) {
		
		if(sillasTodasOcupadas() == true) {
			System.out.println("Todas las sillas estan ocupadas, marchese");
		}else {
			for(int j = 0; j< cantClientesNuevos ; j++) {
				for(int i = 0; i < this.sillas.length; i++) {
					if(this.sillas[i] == false) {
						System.out.println("Silla ocupada por el cliente nuevo numero: " + i);
						this.sillas[i] = true;
						i = this.sillas.length;
					}
				}
			}
		}
		
		
		
		
	}

	public synchronized void dejarSilla() {
	
		for(int i = 0; i < this.sillas.length ; i++) {
			if(this.sillas[i] == true) {
				this.sillas[i] = false;
				i = this.sillas.length;
			}
			
		}
	}

	public synchronized void inicioCorte() {
		while (sillasTodasDesocupadas() == true) {
			System.out.println("Barbero durmiendo");
		}
		if(hayCliente() == true) {
			dejarSilla();
			this.setOcupado(true);
			System.out.println("El barbero empieza a cortar el pelo al cliente");	
		}
		
	}

	public synchronized void finCorte() {
		this.setOcupado(false);
		System.out.println("El barbero termina de cortar el pelo al cliente ");
		notify();
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public boolean sillasTodasOcupadas() {
		int contador = 0;
		boolean ocupadas = false;
		for(int i = 0; i < this.sillas.length ; i++) {
			if(this.sillas[i] == true) {
				contador++;
			}
		}
		if(contador == this.sillas.length) {
			ocupadas = true;
		}
		return ocupadas;
	}
	public boolean sillasTodasDesocupadas() {
		int contador = 0;
		boolean desocupadas = false;
		for(int i = 0; i < this.sillas.length ; i++) {
			if(this.sillas[i] == false) {
				contador++;
			}
		}
		if(contador == this.sillas.length) {
			desocupadas = true;
		}
		return desocupadas;
	}
	
	public boolean hayCliente() {
		boolean hay = false;
		for(int i =0; i < this.sillas.length ; i++) {
			if(this.sillas[i] == true) {
				hay = true;
			}
			i = this.sillas.length;
		}
		return hay;
	}
}