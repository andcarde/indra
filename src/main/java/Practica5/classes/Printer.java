package Practica5.classes;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Printer {

	public static void print(ResultSet rs) {
		try {
		    ResultSetMetaData md = rs.getMetaData();
		    int columnCount = md.getColumnCount();

		    String[] columnNames = new String[columnCount];
		    int[] columnWidths = new int[columnCount];

		    for (int i = 0; i < columnCount; i++) {
		        columnNames[i] = md.getColumnName(i + 1);
		        columnWidths[i] = columnNames[i].length();
		    }

		    List<String[]> rows = new ArrayList<>();
		    while (rs.next()) {
		        String[] row = new String[columnCount];
		        for (int i = 0; i < columnCount; i++) {
		            row[i] = rs.getString(i + 1);
		            if (row[i] == null) row[i] = "NULL";

		            columnWidths[i] = Math.max(columnWidths[i], row[i].length());
		        }
		        rows.add(row);
		    }

		    Runnable printSeparator = () -> {
		        for (int w : columnWidths) {
		            System.out.print("+");
		            System.out.print("-".repeat(w + 2));
		        }
		        System.out.println("+");
		    };

		    printSeparator.run();

		    for (int i = 0; i < columnCount; i++) {
		        System.out.printf("| %-"+columnWidths[i]+"s ", columnNames[i]);
		    }
		    System.out.println("|");

		    printSeparator.run();

		    for (String[] row : rows) {
		        for (int i = 0; i < columnCount; i++) {
		            System.out.printf("| %-"+columnWidths[i]+"s ", row[i]);
		        }
		        System.out.println("|");
		    }

		    printSeparator.run();
		} catch (SQLException sqle) {
			System.out.println("Error. A SQL issue has happened");
			sqle.printStackTrace();
		}
	}
}
