package Practica5.main;

import java.util.Scanner;

public class ScannerVault {

	private static Scanner instance;
	
	static Scanner get() {
		if (instance == null)
			instance = new Scanner(System.in);
		
		return instance;
	}
	
	static void close() {
		if (instance != null)
			instance.close();
	}
}
