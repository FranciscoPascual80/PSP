import java.util.ArrayList;

public class Hilo extends Thread{
	
	private ArrayList<Passenger> passengers;
	int pasajeros1 = 0;
	int supervivientes1 = 0;
	int noSupervivientes1 = 0;
	int pasajeros2 = 0;
	int supervivientes2 = 0;
	int noSupervivientes2 = 0;
	int pasajeros3 = 0;
	int supervivientes3 = 0;
	int noSupervivientes3 = 0;
	
	int porcentajeS1;
	int porcentajeNS1;
	int porcentajeS2;
	int porcentajeNS2;
	int porcentajeS3;
	int porcentajeNS3;
	
	public Hilo() {
		
	}
	
	public Hilo(String nombre, ArrayList<Passenger> passengers) {
		super(nombre);
		this.passengers = passengers;
	}
	
	public void run() {

		for(Passenger passenger : passengers) {
			
			int clase = passenger.getClase();
			
			
			switch(clase){
			case 1 : 
				pasajeros2 ++;
				if(currentThread().getName().equals("Primera Clase")) {
					if(passenger.getSuperviviente() == 'S') {
						supervivientes1 ++;
					}else {
						noSupervivientes1 ++;
					}
				}
			case 2 :
				pasajeros1 ++;
				if(currentThread().getName().equals("Segunda Clase")) {
					if(passenger.getSuperviviente() == 'S') {
						supervivientes2 ++;
					}else {
						noSupervivientes2 ++;
					}
				}
			case 3 :
				pasajeros3 ++;
				if(currentThread().getName().equals("Tercera Clase")) {
					if(passenger.getSuperviviente() == 'S') {
						supervivientes3 ++;
					}else {
						noSupervivientes3 ++;
					}
				}
			}
		}
		
		porcentajeS1 = 100 * supervivientes1 / pasajeros1;
		porcentajeNS1 = 100 - porcentajeS1;
		porcentajeS2 = 100 * supervivientes2 / pasajeros2;
		porcentajeNS2 = 100 - porcentajeS2;
		porcentajeS3 = 100 * supervivientes3 / pasajeros3;
		porcentajeNS3 = 100 - porcentajeS3;
		
		
		
		if(currentThread().getName().equals("Primera Clase")) {
			System.out.println("+En " + getName() + " viajaban " + pasajeros1 + " pasajeros. Sobrevivieron " + supervivientes1 +
					"(" + porcentajeS1 + "%) y fallecieron " + noSupervivientes1 + "(" + porcentajeNS1 + "%) pasajeros.");
		}
		if(currentThread().getName().equals("Segunda Clase")) {
			System.out.println("+En " + getName() + " viajaban " + pasajeros2 + " pasajeros. Sobrevivieron " + supervivientes1 +
					"(" + porcentajeS2 + "%) y fallecieron " + noSupervivientes1 + "(" + porcentajeNS2 + "%) pasajeros.");
		}
		if(currentThread().getName().equals("Tercera Clase")) {
			System.out.println("+En " + getName() + " viajaban " + pasajeros3 + " pasajeros. Sobrevivieron " + supervivientes1 +
					"(" + porcentajeS3 + "%) y fallecieron " + noSupervivientes1 + "(" + porcentajeNS3 + "%) pasajeros.");
		}
	}
	
	public void gestionarPassenger(Passenger passenger) {
		
		int clase = passenger.getClase();
		
		
		switch(clase){
		case 1 : 
			pasajeros1 ++;
			if(currentThread().getName().equals("Primera Clase") && clase == 1) {
				if(passenger.getSuperviviente() == 'S') {
					supervivientes1 ++;
				}else {
					noSupervivientes1 ++;
				}
			}
		case 2 :
			pasajeros2 ++;
			if(currentThread().getName().equals("Segunda Clase")) {
				if(passenger.getSuperviviente() == 'S') {
					supervivientes2 ++;
				}else {
					noSupervivientes2 ++;
				}
			}
		case 3 :
			pasajeros3 ++;
			if(currentThread().getName().equals("Tercera Clase")) {
				if(passenger.getSuperviviente() == 'S') {
					supervivientes3 ++;
				}else {
					noSupervivientes3 ++;
				}
			}
		}
		
		
	}

}