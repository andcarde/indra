package Practica5.main;

import java.sql.SQLException;

public class Launcher {

	public static void main(String[] args) throws SQLException {
        System.out.println();
		System.out.println("| Testing 1: Consultas simples |\n");

		Exercise1Reader.pac1();
		Exercise1Reader.pac2();
		Exercise1Reader.pac3a();
		Exercise1Reader.pac3b();
		Exercise1Reader.pacxos();
		Exercise1Reader.promXos();
		Exercise1Reader.mod_pre();
		Exercise1Reader.prom_mes();
		Exercise1Reader.est_alta();

        System.out.println();
		System.out.println("| Testing 2: Consultas en tablas relacionadas |\n");
		
		Exercise2Reader.int_pac1();
		Exercise2Reader.act_int();
		Exercise2Reader.int_pac2();
        System.out.println();
        Exercise2Reader.a_pagar1();
        System.out.println();
        Exercise2Reader.a_pagar2();
        System.out.println();
		System.out.println("| Testing 3: Consulta de tabla de referencias cruzadas |\n");
		Exercise3Reader.ref_cruz1();
		
		ScannerVault.close();
	}
}
