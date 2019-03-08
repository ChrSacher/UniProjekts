package tspSolutions;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Christian Sacher
 *
 */
public class Start {

    public static void main(String[] args) {

	// Dateien importieren
	CityImporter imp = new CityImporter();
	List<City> file1 = imp.parseFile("verteilung-1.csv");
	imp.reset();
	List<City> file2 = imp.parseFile("verteilung-2.csv");
	imp.reset();
	List<City> file3 = imp.parseFile("verteilung-3.csv");
	imp.reset();

	// Array zum stoppen der Zeit
	long startTime[] = new long[6];
	long endTime[] = new long[6];

	/*
	 * TSPSolver greedSolver = new TSPNearestNeighborSolver(); startTime[0] =
	 * System.currentTimeMillis(); Tour greedTour1 = greedSolver.solveGraph(file1);
	 * endTime[0] = System.currentTimeMillis();
	 * 
	 * startTime[1] = System.currentTimeMillis(); Tour greedTour2 =
	 * greedSolver.solveGraph(file2); endTime[1] = System.currentTimeMillis();
	 * 
	 * startTime[2] = System.currentTimeMillis(); Tour greedTour3 =
	 * greedSolver.solveGraph(file3); endTime[2] = System.currentTimeMillis();
	 * 
	 * System.out.println("Nearest T1: " + greedTour1.getDistance() + " in " +
	 * (endTime[0] - startTime[0]) + " ms " ); System.out.println("Nearest T2: " +
	 * greedTour2.getDistance() + " in " + (endTime[1] - startTime[1]) + " ms " );
	 * System.out.println("Nearest T3: " + greedTour3.getDistance() + " in " +
	 * (endTime[2] - startTime[2]) + " ms " );
	 */

	// Erstellen eines 2-Opt Solvers
	TSPSolver optsolver = new TSP2OptSolver();

	// Lösen des TSp-Problems und messen der Zeit
	startTime[3] = System.currentTimeMillis();

	Tour optTour1 = optsolver.solveGraph(file1);
	optTour1.draw();

	endTime[3] = System.currentTimeMillis();

	startTime[4] = System.currentTimeMillis();

	Tour optTour2 = optsolver.solveGraph(file2);
	optTour2.draw();

	endTime[4] = System.currentTimeMillis();

	startTime[5] = System.currentTimeMillis();

	Tour optTour3 = optsolver.solveGraph(file3);
	optTour3.draw();

	endTime[5] = System.currentTimeMillis();

	// Ausgabe auf Konsole
	System.out.println("2Opt T1: " + optTour1.getDistance() + " in " + (endTime[3] - startTime[3]) + " ms ");
	System.out.println("2Opt T2: " + optTour2.getDistance() + " in " + (endTime[4] - startTime[4]) + " ms ");
	System.out.println("2Opt T3: " + optTour3.getDistance() + " in " + (endTime[5] - startTime[5]) + " ms ");
	// optTour1.setColor(Color.red);
	// optTour1.draw();

	// In eine Datei schreiben
	try (BufferedWriter bw = new BufferedWriter(new FileWriter("Results.txt", false))) {
	    // bw.write("Greed T1: " + greedTour1.getDistance()+ " in " + (endTime[0] -
	    // startTime[0]) + " ms " + "\n");
	    // bw.write("Greed T2: " + greedTour2.getDistance()+ " in " + (endTime[1] -
	    // startTime[1]) + " ms " + "\n");
	    // bw.write("Greed T3: " + greedTour3.getDistance()+ " in " + (endTime[2] -
	    // startTime[2]) + " ms " + "\n");
	    bw.write("2Opt T1: " + optTour1.getDistance() + " in " + (endTime[3] - startTime[3]) + " ms " + "\n");
	    bw.write("2Opt T2: " + optTour2.getDistance() + " in " + (endTime[4] - startTime[4]) + " ms " + "\n");
	    bw.write("2Opt T3: " + optTour3.getDistance() + " in " + (endTime[5] - startTime[5]) + " ms " + "\n");

	} catch (IOException e) {

	    e.printStackTrace();

	}
    }

}
