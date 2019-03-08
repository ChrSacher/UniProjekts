package tspSolutions;

import java.util.List;

/**
 * @author Christian Sacher
 *
 */
// Interface zum L�sen eines TSP Problem
public interface TSPSolver {
    Tour solveGraph(List<City> cities);
}
