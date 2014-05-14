package check;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import def.MT;
import parse.ParseMT;

public class MainCheck {

	public static void main(String[] args) {
		//Cargamos MT en txt
		MT test = ParseMT.parseMt(new File("turing/turing1.txt"));
		System.out.println("Introduzca la cadena a comprobar:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cadena = null;
		try {
			cadena = br.readLine();
		} catch (IOException ioe) {
			System.out.println("Error leyendo cadena.");
			System.exit(1);
		}
		System.out.println(test.prodMt(cadena));
	}

}