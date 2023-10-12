package ejercicio2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class MainApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, Hashtable<String,String>> productos = new Hashtable<String, Hashtable<String,String>>();
		//nombre producto
		crearProductos(productos);
		pagarInfoProductos(productos);
		
	}
	
	public static void crearProductos(Hashtable<String,Hashtable<String,String>> productos) {
		System.out.println("Cuantos productos tienes?");
		int cantidadProductos = sc.nextInt();
		for(int i = 0; i < cantidadProductos; i++) {
			System.out.println("Nombre del producto: ");
			String nombreProducto = sc.next();
			System.out.println("Precio del producto");
			String precioProducto = sc.next();
			System.out.println("Cantidad comprada: ");
			String cantidadProducto = sc.next();
			System.out.println("Iva del producto(21 o 4)");
			String ivaProducto = sc.next();
			if(!ivaProducto.equals("21")&&!ivaProducto.equals("4")) {
					ivaProducto = "21";
			}
			Hashtable<String,String> hashInformation = new Hashtable<String,String>();
			hashInformation.put("Precio", precioProducto);
			hashInformation.put("Cantidad", cantidadProducto);
			hashInformation.put("Iva", ivaProducto);
			
			productos.put(nombreProducto, hashInformation);
		}
	}
	
	public static void pagarInfoProductos(Hashtable<String, Hashtable<String,String>> hash) {
		Enumeration<String> productos;
		productos = hash.keys();
		double suma = 0;
		double sumaIva = 0;
		int sumaArticulos = 0;
		int sumaIva21 = 0;
		while(productos.hasMoreElements()) {
			String producto = productos.nextElement();
			Hashtable<String,String> infoProducto = new Hashtable<String,String>();
			infoProducto = hash.get(producto);
			double precio = Double.parseDouble(infoProducto.get("Precio"));
			int cantidad = Integer.parseInt(infoProducto.get("Cantidad"));
			double iva = Double.parseDouble(infoProducto.get("Iva"));
			suma += precio * cantidad;
			sumaIva += (precio*(iva/100) + precio) * cantidad;
			sumaArticulos += cantidad;
			if(iva == 21) {
				sumaIva21++;
			}
		}
		System.out.println("Precio Sin Iva: " + String.format("%.2f", suma) + "€");
		System.out.println("Precio con Iva: " + String.format("%.2f", sumaIva)   + "€");
		System.out.println("Cantidad: " + sumaArticulos);
		System.out.println("Iva: " + sumaIva21 + " Articulos con un 21% y " + (hash.size() - sumaIva21) + " articulos con 4%");
		
		System.out.println("Con cuanto pagarás?");
		int pago = sc.nextInt();
		
		while(pago < sumaIva) {
			sumaIva -= pago;
			System.out.println("Te faltan " + String.format("%.2f",sumaIva) + "€ por pagar");
			pago = sc.nextInt();
		}
		System.out.println("Perfecto, su cambio es de " + String.format("%.2f",(pago - sumaIva)) + "€");
		 
	}
}
