public class Passenger extends Thread {
	
	private int clase;
	private String apellido;
	private String nombre;
	private int edad;
	private String embarque;
	private char superviviente;
	
	public Passenger() {
		
	}
	public Passenger(int clase, String apellido, String nombre, int edad, String embarque, char superviviente) {
		this.clase = clase;
		this.apellido = apellido;
		this.nombre = nombre;
		this.edad = edad;
		this.embarque = embarque;
		this.superviviente = superviviente;
	}
	public int getClase() {
		return clase;
	}
	public String getApellido() {
		return apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public String getEmbarque() {
		return embarque;
	}
	public char getSuperviviente() {
		return superviviente;
	}
	@Override
	public String toString() {
		return "Passenger [clase=" + clase + ", apellido=" + apellido + ", nombre=" + nombre + ", edad=" + edad
				+ ", embarque=" + embarque + ", superviviente=" + superviviente + "]";
	}
	
	

}