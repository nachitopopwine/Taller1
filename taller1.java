import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class taller1 {

	public static void main(String[] args) throws FileNotFoundException {

		int contCreador = contarLineas("datos_creadores.txt");
		String [][] datosCreadores = new String [contCreador][4];
		leerDatosCreadores (datosCreadores );
		imprimirMatriz(datosCreadores);
		
		int contDatosIa = contarLineas("datos_ia.txt");
		String [][] datosIa = new String [contDatosIa][6];
		leerDatosIa(datosIa);
		imprimirMatriz(datosIa);
		
		int contUsuarios = contarLineas("datos_usuarios.txt");
		String [][] datosusuarios = new String [contUsuarios][4];
		leerDatosUsuarios(datosusuarios);
		imprimirMatriz(datosusuarios);
		/////////////////////////////////////////////////
		
		
		comprobarUsuario(datosusuarios);
		
		
	}
	private static void comprobarUsuario(String [][] datosusuarios) {
		Scanner read = new Scanner ( System.in);
		System.out.println("ingresar usuario: ");
		String nUser = read.nextLine().replaceAll(" ", "");
		int i = buscarElemento(datosusuarios,nUser);
		
		int terminar =0;
		while ( terminar != -1){
		
			if(i!=-1) {
				
				String contraReal = datosusuarios[i][1].toLowerCase().replaceAll(" ", "");
				System.out.println("ingrese contraseña: ");
				String contra = read.nextLine().toLowerCase().replaceAll(" ", "");
				
				if(contra.equals(contraReal)) {
					String tipoUser = datosusuarios[i][2].toLowerCase().replaceAll(" ", "");
					if ( tipoUser == "administrador") {
					abrirMenuAdmin();
					terminar=-1;
					}
					if ( tipoUser=="normal") {
						abrirMenuNormal();
						terminar=-1;
					}
				}
			}
			else {
				System.out.println("contraseña incorrecta: ");
				System.out.println("ingresar usuario: ");
				nUser = read.nextLine().replaceAll(" ", "");
				i = buscarElemento(datosusuarios,nUser);
			}
			terminar=2;
		}read.close();
	}



	//Menus
	private static void abrirMenuNormal() {

		System.out.println("bienvenido al menu normal: ");
	}
	private static void abrirMenuAdmin() {

		System.out.println("bienvenido al menu admin: ");
	}

	//Buscar elementos
	private static int buscarElemento(String[][] datosusuarios, String nUser) {
		for(int i =0;i<datosusuarios.length;i++) {
			if((datosusuarios[i][0].toLowerCase()).equals(nUser)) {
				return i ;
			}
		}return -1;
	}
	//Lectura de datos
	private static void leerDatosUsuarios(String[][] datosusuarios) throws FileNotFoundException {
		File usuarios = new File("datos_usuarios.txt");
		Scanner read = new Scanner(usuarios,"UTF-8");
		int fila=0;
		int columna = 0;
		while ( read.hasNextLine()) {
			columna = 0;
			String [] partes = read.nextLine().replaceAll(" ", "").split(",");
			String nombre =partes[0];
			String contraseña = partes[1];//int Integer.valueOf(partes[1])
			String categoria = partes[2];
			String creador = partes[3];//int Integer.valueOf(partes[3])
			
			datosusuarios[fila][columna] = nombre;
			datosusuarios[fila][columna+=1] = contraseña ;
			datosusuarios[fila][columna+=1] = categoria ;
			datosusuarios[fila][columna+=1] = creador ;
			fila++;
		}read.close();

	}
	private static void leerDatosIa(String[][] datosIa) throws FileNotFoundException {
		File Ia = new File("datos_ia.txt");
		Scanner read = new Scanner(Ia,"UTF-8");
		int fila=0;
		int columna = 0;
		while ( read.hasNextLine()) {
			columna = 0;
			String [] partes = read.nextLine().replaceAll(" ", "").split(",");
			String nombreIa =partes[0];
			String año = partes[1];//int Integer.valueOf(partes[1])
			String vAprendizaje = partes[2];
			String tipo = partes[3];//int Integer.valueOf(partes[3])
			String creador = partes[4];
			String cantMejoras = partes[5];
			
			datosIa[fila][columna] = nombreIa;
			datosIa[fila][columna+=1] = año ;
			datosIa[fila][columna+=1] = vAprendizaje ;
			datosIa[fila][columna+=1] = tipo ;
			datosIa[fila][columna+=1] = creador ;
			datosIa[fila][columna+=1] = cantMejoras ;
			fila++;
		}read.close();
	}
	public static void leerDatosCreadores(String [][] datosCreadores) throws FileNotFoundException {
		File creadores = new File("datos_creadores.txt");
		Scanner read = new Scanner(creadores,"UTF-8");
		int fila=0;
		int columna = 0;
		while ( read.hasNextLine()) {		
			columna = 0;
			String [] partes = read.nextLine().replaceAll(" ", "").split(",");
			String nombre =partes[0];
			String experencia = partes[1];//int Integer.valueOf(partes[1])
			String especialidad = partes[2];
			String edad = partes[3];//int Integer.valueOf(partes[3])
			
			datosCreadores[fila][columna] = nombre;
			datosCreadores[fila][columna+=1] = experencia ;
			datosCreadores[fila][columna+=1] = especialidad ;
			datosCreadores[fila][columna+=1] = edad ;
			fila++;
		}read.close();
	}
	//contar numero de lineas para todos los archivos
	private static int contarLineas(String string) throws FileNotFoundException {
		File creadores = new File(string);
		Scanner read = new Scanner(creadores,"UTF-8");
		
		int fila=0;
		while ( read.hasNextLine()) {
			read.nextLine().replaceAll(" ", "");
			fila++;
		}
		read.close();
		return fila;

	}
	//imprimir matrices
	private static void imprimirMatriz(String[][] datosCreadores) {
			for (int x=0; x < datosCreadores.length; x++) {
				System.out.print("|");
				for (int y=0; y < datosCreadores[x].length; y++) {
					System.out.print (datosCreadores[x][y]);
					if (y!=datosCreadores[x].length-1) System.out.print("\t");
				}
				System.out.println("|");
			}
	}




}