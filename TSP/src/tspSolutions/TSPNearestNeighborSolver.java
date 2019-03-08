package tspSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Sacher
 *
 */
public class TSPNearestNeighborSolver implements TSPSolver {

    @Override
    public Tour solveGraph(List<City> cities) {

	// Erstellen der Distanz Matrix, kann theoretisch noch optimiert werden in dem
	// man nur die hälfte der Distanzen berechnet
	List<City> travelList = new ArrayList<City>();
	double[][] adjMatrix = new double[cities.size()][cities.size()];

	for (int i = 0; i < cities.size(); i++) {
	    City tempC = cities.get(i);
	    for (int j = 0; j < cities.size(); j++) {

		adjMatrix[i][j] = tempC.distanceTo(cities.get(j));
	    }
	}

	// Unsere jetztige stadt als Index in die Matrix
	int currentCity = 0;

	// Diese stadt kann nicht mehr besucht werden
	for (int i = 0; i < adjMatrix.length; i++) {
	    adjMatrix[i][currentCity] = -1;
	}

	// Welche Stadt am nächsten liegt
	int targetCity = 0;

	while (travelList.size() < cities.size()) {
	    // Jetzige Stadt wird der Tour hinzugefügt
	    travelList.add(cities.get(currentCity));

	    double minDis = 100000000;

	    boolean found = false;

	    // Suchen der Stadt mit der geringsten Distanz
	    for (int i = 0; i < adjMatrix[currentCity].length; i++) {
		if (adjMatrix[currentCity][i] >= 0 && adjMatrix[currentCity][i] < minDis && currentCity != i) {

		    targetCity = i;
		    minDis = adjMatrix[currentCity][i];
		    found = true;
		}
	    }
	    if (found) {
		// Stadt wird nicht mehr besuchbar gemacht in der Distanzmatrix
		// Es wird nur diese Zeile benötigt, da die Distanzen symmetrisch sind
		for (int i = 0; i < adjMatrix.length; i++) {
		    adjMatrix[i][targetCity] = -1;
		}
		// Unsere jetztige Stadt wird die gefundene Stadt
		currentCity = targetCity;
	    } else {
		// Es wurde keine weitere erreichbare Stadt gefunden
		break;
	    }

	}
	return new Tour(travelList);
    }

}
