package tspSolutions;

import java.util.List;

/**
 * @author Christian Sacher
 *
 */
// Interface zum Lösen eines TSP Problem
public interface TSPSolver {
    Tour solveGraph(List<City> cities);
}
