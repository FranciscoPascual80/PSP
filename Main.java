import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Passenger>passengers = new ArrayList<>();
		getPassengers(passengers);
	}
	
	static void getPassengers(ArrayList<Passenger> passengers) {
		File file = new File("Titanic.csv");
		if (file.exists() && file.isFile()) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String pasajero;
				while((pasajero = br.readLine()) != null){
					
					String[] datos = pasajero.split(",");
					int clase = Integer.parseInt(datos[0]);
					String apellido = datos[1];
					String nombre = datos[2];
					int edad = Integer.parseInt(datos[3]);
					String embarque = datos[4];
					char superviviente = datos[5].charAt(0);
						
					Passenger passenger = new Passenger(clase, apellido, nombre, edad, embarque, superviviente);
					passengers.add(passenger);
					
				}
				br.close();
				
			}catch (FileNotFoundException e ) {
				System.out.println(e.getMessage());
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Este archivo no existe");
		}
		
		Hilo hilo1 = new Hilo("Primera Clase", passengers);
		Hilo hilo2 = new Hilo("Segunda Clase", passengers);
		Hilo hilo3 = new Hilo("Tercera Clase", passengers);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("FIN DE LA TRAVESIA");
		
	}

}

