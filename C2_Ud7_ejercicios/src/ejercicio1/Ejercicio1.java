package ejercicio1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable notasAlumnos = new Hashtable<String,ArrayList<Double>>();
		Hashtable notasMediasAlumnos = new Hashtable<String,Double>();
		Scanner sc = new Scanner(System.in);
		ArrayList notas = new ArrayList<Double>();


		notasAlumnos.put("Xom", notasAleatorias(5));
		notasAlumnos.put("Adri",notasAleatorias(5));
		notasAlumnos.put("Alex",notasAleatorias(5));
		notasAlumnos.put("Dani",notasAleatorias(5));
		
		rellenarNotasMedias(notasAlumnos, notasMediasAlumnos);
		mostrarHash(notasMediasAlumnos);
	}
	
	public static void mostrarHash(Hashtable hash) {
		DecimalFormat format = new DecimalFormat("###.##");

		Enumeration alumnos;
		alumnos = hash.keys();
		while(alumnos.hasMoreElements()) {
			String alumno = alumnos.nextElement().toString();
			System.out.println("Alumno: " + alumno);
			System.out.println("Nota: " + format.format(hash.get(alumno)));
			System.out.println("-------------");
		}
	}
	
	public static ArrayList<Double> notasAleatorias(int cantidad){
		ArrayList notas = new ArrayList<Double>();

		for (int i = 0; i < cantidad; i++) {
			Double nota = Math.random() * 10;
			notas.add(nota);
		}
		return notas;
	}

	public static void rellenarNotasMedias(Hashtable<String,ArrayList<Double>> notasAlumnos,Hashtable<String,Double> notasMedias  ) {
		Enumeration alumnos;
		alumnos = notasAlumnos.keys();
		while (alumnos.hasMoreElements()) {
			String alumno = alumnos.nextElement().toString();
			notasMedias.put(alumno, calcularMedia((ArrayList)notasAlumnos.get(alumno)));
		}
	}
	
	public static double calcularMedia(ArrayList<Double> notas) {
		double suma = 0;
		for (Double nota : notas) {
			suma += nota;
		}
		 
		return  suma / notas.size();
	}
}
