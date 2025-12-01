package Practica5.classes;

public class Exercise3Printer {

	static void ref_cruz1() {
    	SQLSentence sentence = new SQLSentence();
    	
    	sentence.add("SELECT");
    	sentence.add("LEFT(i.habitacion, 1) AS floor,");
    	sentence.add("SUM(CASE WHEN p.sexo = 'M' THEN 1 ELSE 0 END) AS men,");
    	sentence.add("SUM(CASE WHEN p.sexo = 'F' THEN 1 ELSE 0 END) AS women");
    	sentence.add("FROM internacion i");
    	sentence.add("JOIN pacientes p ON i.codpac = p.codpac");
    	sentence.add("GROUP BY floor");
    	sentence.add("ORDER BY floor;");

        sentence.execute();
	}
}
