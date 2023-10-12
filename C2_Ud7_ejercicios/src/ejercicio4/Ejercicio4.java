package ejercicio4;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio4 {

	private static final String PRECIO = "Precio";	
	private static final String CANTIDAD = "Cantidad";	
	private static final String IVA = "Iva";	
	private static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,Hashtable<String,String>> stockTienda = new Hashtable<String,Hashtable<String,String>>();
		Hashtable<String,Integer> carritoCompra = new Hashtable<String,Integer>();
		crearStock(stockTienda);
		int opcion = 0;

		while(opcion != 5) {

			System.out.println("1) añadir productos al carrito");
			System.out.println("2) añadir productos al stock");
			System.out.println("3) mostrar lista de productos en stock");
			System.out.println("4) buscar producto en stock");
			System.out.println("5) pagar");

			opcion = sc.nextInt();
			
			switch(opcion) {
			case 1:
				añadirAlCarrito(stockTienda, carritoCompra);
				break;
			case 2:
				añadirProducto(stockTienda);
				break;
			case 3:
				mostrarProductos(stockTienda);
				break;
			case 4:
				System.out.println("Escriba el producto que quiere buscar");
				mostrarProducto(stockTienda, sc.next());
				break;
			case 5: 
				pagarCarrito(stockTienda, carritoCompra);
				break;
			default:
				System.out.println("Opción elegida no válida");
			}
		}


	}

	public static void añadirAlCarrito(Hashtable<String,Hashtable<String,String>> stockTienda, Hashtable<String,Integer> carritoCompra) {
		System.out.println("escribe exit para salir");
		System.out.println("Que producto quieres? ");
		sc.nextLine();
		String producto = sc.nextLine();
		while(!producto.equals("exit")) {
			if(!stockTienda.containsKey(producto)) {
				System.out.println("No tenemos éste producto, porfavo elija otro");
			}else {
				int cantidad = 0;
				while(cantidad == 0) {
					try {
						System.out.println("Cuantos quiere?(ha de ser mayor de 0 y un numero entero)");
						cantidad = sc.nextInt();
					}catch(NumberFormatException e) {
						sc.next();
					}
				}
				sc.nextLine();
				carritoCompra.put(producto, cantidad);
			}
			System.out.println("Que producto quieres? ");
			producto = sc.nextLine();
		}

	}

	//Pagar ex2
	public static void pagarCarrito(Hashtable<String, Hashtable<String,String>> hash, Hashtable<String,Integer> carrito) {
		Enumeration<String> productos;
		productos = carrito.keys();
		double suma = 0;
		double sumaIva = 0;
		int sumaArticulos = 0;
		int sumaIva21 = 0;
		while(productos.hasMoreElements()) {
			String producto = productos.nextElement();
			Hashtable<String,String> infoProducto = new Hashtable<String,String>();
			infoProducto = hash.get(producto);

			double precio = Double.parseDouble(infoProducto.get(PRECIO));
			int cantidad = carrito.get(producto);
			double iva = Double.parseDouble(infoProducto.get(IVA));
			suma += precio * cantidad;
			sumaIva += (precio*(iva/100) + precio) * cantidad;
			sumaArticulos += cantidad;
			if(iva == 21) {
				sumaIva21 += cantidad;
			}
		}
		System.out.println("Precio Sin Iva: " + String.format("%.2f", suma) + "€");
		System.out.println("Precio con Iva: " + String.format("%.2f", sumaIva)   + "€");
		System.out.println("Cantidad: " + sumaArticulos);
		System.out.println("Iva: " + sumaIva21 + " Articulos con un 21% y " + (sumaArticulos - sumaIva21) + " articulos con 4%");

		System.out.println("Con cuanto pagarás?");
		int pago = sc.nextInt();

		while(pago < sumaIva) {
			sumaIva -= pago;
			System.out.println("Te faltan " + String.format("%.2f",sumaIva) + "€ por pagar");
			pago = sc.nextInt();
		}
		System.out.println("Perfecto, su cambio es de " + String.format("%.2f",(pago - sumaIva)) + "€");
	}

	//Stock
	public static void mostrarProductos(Hashtable<String,Hashtable<String,String>> stockTienda) {
		Enumeration<String> enumeration = stockTienda.keys();
		while (enumeration.hasMoreElements()) {
			mostrarProducto(stockTienda, enumeration.nextElement());
			System.out.println("------------------------------------");
		}
	}

	public static void mostrarProducto(Hashtable<String,Hashtable<String,String>> stockTienda, String producto) {
		if(stockTienda.contains(producto)) {
			System.out.println("Nombre: " + producto);
			System.out.println("Precio: " + stockTienda.get(producto).get(PRECIO) + "€");
			System.out.println("Cantidad: " + stockTienda.get(producto).get(CANTIDAD));
		}else {
			System.out.println("Ese producto no existe");
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
		info.put(IVA, "21");

		stockTienda.put("Pelota", info);

		info2.put(PRECIO, "0.05");
		info2.put(CANTIDAD, "400");
		info2.put(IVA, "21");

		stockTienda.put("Chicle", info2);

		info3.put(PRECIO, "2.50");
		info3.put(CANTIDAD, "50");
		info3.put(IVA, "21");

		stockTienda.put("Cereales", info3);

		info4.put(PRECIO, "2");
		info4.put(CANTIDAD, "28");
		info4.put(IVA, "4");

		stockTienda.put("Helado de menta y chocolate", info4);

		info5.put(PRECIO, "1");
		info5.put(CANTIDAD, "200");
		info5.put(IVA, "4");

		stockTienda.put("Boquillas", info5);

		info6.put(PRECIO, "4.5");
		info6.put(CANTIDAD, "20");
		info6.put(IVA, "4");

		stockTienda.put("Tabaco", info6);

		info7.put(PRECIO, "1.2");
		info7.put(CANTIDAD, "60");
		info7.put(IVA, "4");

		stockTienda.put("Coca-Cola", info7);

		info8.put(PRECIO, "3");
		info8.put(CANTIDAD, "20");
		info8.put(IVA, "21");

		stockTienda.put("Suavizante", info8);

		info9.put(PRECIO, "0.40");
		info9.put(CANTIDAD, "200");
		info9.put(IVA, "21");

		stockTienda.put("Cerveza", info9);

		info10.put(PRECIO, "2");
		info10.put(CANTIDAD, "20");
		info10.put(IVA, "21");

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
		System.out.println("Escriba el Iva: ");
		String iva = sc.next();
		while(!isNumeric(iva)) {
			System.out.println("El Iva ha de ser 21 o 4");
			System.out.println("Iva: ");
			cantidad = sc.next();
		}
		if(!iva.equals("4")) {
			iva = "21";
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
