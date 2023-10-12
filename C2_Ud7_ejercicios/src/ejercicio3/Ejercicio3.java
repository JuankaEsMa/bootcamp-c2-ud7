package ejercicio3;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio3 {

	private static final String PRECIO = "Precio";	
	private static final String CANTIDAD = "Cantidad";	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,Hashtable<String,String>> stockTienda = new Hashtable<String,Hashtable<String,String>>();
		
		crearStock(stockTienda);
		//añadirProducto(stockTienda);
		mostrarProductos(stockTienda);
	}
	
	public static void mostrarProductos(Hashtable<String,Hashtable<String,String>> stockTienda) {
		Enumeration<String> enumeration = stockTienda.keys();
		while (enumeration.hasMoreElements()) {
			mostrarProducto(stockTienda, enumeration.nextElement());
			System.out.println("------------------------------------");
		}
	}
	
	public static void mostrarProducto(Hashtable<String,Hashtable<String,String>> stockTienda, String producto) {
		try {
			System.out.println("Nombre: " + producto);
			System.out.println("Precio: " + stockTienda.get(producto).get(PRECIO) + "€");
			System.out.println("Cantidad: " + stockTienda.get(producto).get(CANTIDAD));
			}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void crearStock(Hashtable<String,Hashtable<String,String>> stockTienda) {
		Hashtable<String,String> info = new Hashtable<String,String>();
		Hashtable<String,String> info2 = new Hashtable<String,String>();
		Hashtable<String,String> info3 = new Hashtable<String,String>();
		Hashtable<String,String> info4 = new Hashtable<String,String>();
		Hashtable<String,String> info5 = new Hashtable<String,String>();
		Hashtable<String,String> info6 = new Hashtable<String,String>();
		Hashtable<String,String> info7 = new Hashtable<String,String>();
		Hashtable<String,String> info8 = new Hashtable<String,String>();
		Hashtable<String,String> info9 = new Hashtable<String,String>();
		Hashtable<String,String> info10 = new Hashtable<String,String>();

		
		info.put(PRECIO, "4.5");
		info.put(CANTIDAD, "40");
		stockTienda.put("Pelota", info);
		
		info2.put(PRECIO, "0.05");
		info2.put(CANTIDAD, "400");
		stockTienda.put("Chicle", info2);
		
		info3.put(PRECIO, "2.50");
		info3.put(CANTIDAD, "50");
		stockTienda.put("Cereales", info3);
		
		info4.put(PRECIO, "2");
		info4.put(CANTIDAD, "28");
		stockTienda.put("Helado de menta y chocolate", info4);
		
		info5.put(PRECIO, "1");
		info5.put(CANTIDAD, "200");
		stockTienda.put("Boquillas", info5);
		
		info6.put(PRECIO, "4.5");
		info6.put(CANTIDAD, "20");
		stockTienda.put("Tabaco", info6);
		
		info7.put(PRECIO, "1.2");
		info7.put(CANTIDAD, "60");
		stockTienda.put("Coca-Cola", info7);
		
		info8.put(PRECIO, "3");
		info8.put(CANTIDAD, "20");
		stockTienda.put("Suavizante", info8);
		
		info9.put(PRECIO, "0.40");
		info9.put(CANTIDAD, "200");
		stockTienda.put("Cerveza", info9);
		
		info10.put(PRECIO, "2");
		info10.put(CANTIDAD, "20");
		stockTienda.put("Baecon", info10);
	}
	
	public static void añadirProducto(Hashtable<String,Hashtable<String,String>> stockTienda) {
		Hashtable<String,String> info = new Hashtable<String,String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe el nombre de tu producto");
		String nombre = sc.nextLine();
		System.out.println("Escribe el precio de tu producto");
		String precio = sc.next();
		while(!isNumeric(precio)) {
			 System.out.println("el precio ha de ser un número(y los decimales separados por punto)");
			 System.out.println("Precio: ");
			 precio = sc.next();
		}
		System.out.println("Cuanto hay en stock?");
		String cantidad = sc.next();
		while(!isNumeric(cantidad)) {
			System.out.println("La cantidad ha de ser un número");
			System.out.println("Cantidad: ");
			cantidad = sc.next();
		}
		
	}
	
	public static boolean isNumeric(String string) {
		try {
			Double.parseDouble(string);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
