package tspSolutions;

/**
 * @author Christian Sacher
 *
 */
public class City {
    // 2D Position der Stadt
    private double x;

    private double y;

    // Constructs a city at x, y location
    public City(double x2, double y2) {
	this.x = x2;
	this.y = y2;
    }

    public double getX() {
	return this.x;
    }

    public double getY() {
	return this.y;
    }

    // Euklidische Distanz quadratisch zu city
    public double distanceToSquared(City city) {
	double xDis = Math.abs(getX() - city.getX());
	double yDis = Math.abs(getY() - city.getY());
	return (xDis * xDis) + (yDis * yDis);
    }

    // Euklidische Distanz zu city
    public double distanceTo(City city) {
	double xDis = Math.abs(getX() - city.getX());
	double yDis = Math.abs(getY() - city.getY());
	double distance = Math.sqrt((xDis * xDis) + (yDis * yDis));

	return distance;
    }

    @Override
    public String toString() {
	return "(" + getX() + "," + getY() + ")";
    }
}
