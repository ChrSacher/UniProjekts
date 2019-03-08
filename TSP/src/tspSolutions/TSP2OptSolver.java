package tspSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Sacher
 *
 */
public class TSP2OptSolver implements TSPSolver {
    // Löst das TSP Problem
    @Override
    public Tour solveGraph(List<City> cities) {
	Tour tour = new Tour(cities);
	Tour compareTour = new Tour(cities);
	// Größe der Tour zwischenspeichern
	int size = tour.getSize();

	// Zähler für die Anzahl misslungener Verbesserungen
	int improveCounter = 0;
	// Nach 2 fehlgeschlagen Verbeserungen wird abgebrochen, weil es sich nichts
	// verändern wird beim nächsten Durchlauf
	while (improveCounter < 2) {
	    // Zwischen 1 und size -1 da Start und Ende nicht verändert werden
	    for (int i = 1; i < size - 1; i++) {
		// Durchprobieren aller Kombinationen
		for (int k = i + 1; k < size; k++) {
		    compareTour = swap(i, k, tour);
		    // Überprüfen ob es Verbesserungen gab
		    if (compareTour.getDistance() < tour.getDistance()) {
			// Es wurde eine Verbesserung gefunden und es wird mit der neuen Tour
			// weitergearbeitet
			improveCounter = 0;
			tour = new Tour(compareTour.getTravelList());

		    }
		}
	    }
	    improveCounter++;
	}
	return tour;
    }

    // 2-Opt Tausch Algorithmus zum verbessern einer Tour/ Zum entfernen von sich
    // kreuzenden Kanten
    private Tour swap(int i, int k, Tour tour) {
	List<City> cities = new ArrayList<City>();
	int size = tour.getSize();

	// 1. route[0] to route[i-1]
	for (int c = 0; c <= i - 1; ++c) {
	    cities.add(tour.getCityAt(c));
	}

	// 2. route[i] to route[k] reversed

	for (int c = i; c <= k; ++c) {
	    // k - (c - i)) berechnet die Position rückwärts
	    cities.add(tour.getCityAt(k - (c - i)));
	}

	// 3.route[k+1] to route[size]
	for (int c = k + 1; c < size; ++c) {
	    cities.add(tour.getCityAt(c));
	}
	return new Tour(cities);
    }

}
