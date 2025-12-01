package Practica5.classes;

public class Exercise2Printer {

	static void int_pac1() {
    	SQLSentence sentence = new SQLSentence();
    	
    	sentence.add("SELECT ");
    	sentence.add("    i.numint,");
    	sentence.add("    i.codpac AS codpac_internacion,");
    	sentence.add("    p.codpac AS codpac_paciente,");
    	sentence.add("    p.apellido,");
    	sentence.add("    p.nombre,");
    	sentence.add("    p.localidad,");
    	sentence.add("    p.sexo");
    	sentence.add("FROM internacion i");
    	sentence.add("JOIN pacientes p ");
    	sentence.add("    ON i.codpac = p.codpac");
    	sentence.add("WHERE p.sexo = 'M'");
    	sentence.add("  AND p.codpac % 2 = 0;");

        sentence.execute();
	}

	static void act_int() {
		
	}

	static void int_pac2() {
		
	}

	static void a_pagar1() {
		
	}

	static void a_pagar2() {
		
	}
}
