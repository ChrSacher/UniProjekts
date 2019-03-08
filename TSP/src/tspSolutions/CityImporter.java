package tspSolutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Christian Sacher
 *
 */
public class CityImporter {
    // Hashset zum überprüfen ob doppelte Punkte exisitieren
    private HashSet<String> checkerHashSet = new HashSet<String>();

    // Städte die bereits eingelesen wurden
    private List<City> parsedCities = new ArrayList<City>();

    // Stellt Importer auf Anfangszustand zurück
    public void reset() {
	checkerHashSet.clear();
	parsedCities.clear();
    }

    public List<City> parseFile(String fileName) {

	// Liste aller Zeilen der Datei
	ArrayList<String> lines = new ArrayList<String>();

	// Einlesen der Zeilen
	try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
	    stream.forEach(lines::add);
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	}

	// Jede Zeile wird untersucht
	lines.forEach(this::parseLine);

	return new ArrayList<City>(parsedCities);

    }

    public boolean parseLine(String lineString) {

	// Überprüfe ob die Stadt bereits existiert
	if (checkerHashSet.contains(lineString)) {
	    System.out.println("Duplicate Value in Line: " + lineString);
	    return false;
	} else {
	    checkerHashSet.add(lineString);
	}
	// ; ist das Trennungszeichen zwischen den Koordinaten
	String[] stringParts = lineString.split(";");

	// Versuche die Stücke zu parsen
	double x = -1, y = -1;
	try {
	    x = new Double(stringParts[0]);
	    y = new Double(stringParts[1]);
	} catch (NumberFormatException nfe) {
	    System.out.println("Error: line " + lineString + " could not be parsed into doubles");
	    return false;
	}

	// Neue Stadt wird den geparsten Städten hinzugefügt
	parsedCities.add(new City(x, y));
	return true;
    }
}
