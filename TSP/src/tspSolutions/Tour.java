package tspSolutions;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import teaching.WhiteBoard;

/**
 * @author Christian Sacher
 *
 */
public class Tour {
    // Liste aller Städte in der Tour
    private List<City> travelList = new ArrayList<City>();

    // Gesamtdistanz der Tour
    int distance = 0;

    // Farbe zum Zeichnen der Tour
    private Color color = Color.black;

    // Whiteboard Objekte für das Zeichnen
    private List<Object> drawnObjects = new ArrayList<Object>();

    private WhiteBoard whiteboard = null;

    void draw() {

	// nur Zeichnen wenn es etwas zu Zeichnen gibt
	if (travelList.size() == 0)
	    return;
	// Erstellen eines Whiteboards wenn gezeichnet werden soll
	if (whiteboard == null)
	    whiteboard = new WhiteBoard();

	// Whiteboard leeren
	for (Object obj : drawnObjects) {
	    whiteboard.removeShape(obj);
	}

	// Berechnung der Stadt um welche verschoben werden kann. Dadurch sind die
	// Städte nicht irgendwo auf dem Whiteboard
	City bestCity = travelList.get(0);
	for (int i = 0; i < travelList.size() - 1; i++) {
	    if (bestCity.getX() > travelList.get(i).getX() && bestCity.getY() > travelList.get(i).getY()) {
		bestCity = travelList.get(i);
	    }
	}
	double x = bestCity.getX();
	double y = bestCity.getY();

	int scale = 4;

	// Zeichnen der Punkte und Strecken
	for (int i = 0; i < travelList.size(); i++) {
	    drawnObjects.add(whiteboard.drawCircle((travelList.get(i).getX() - x) * scale,
		    (travelList.get(i).getY() - y) * scale, 3, color, true));
	}
	for (int i = 0; i < travelList.size() - 1; i++) {

	    drawnObjects.add(whiteboard.drawLine((travelList.get(i).getX() - x) * scale,
		    (travelList.get(i).getY() - y) * scale, (travelList.get(i + 1).getX() - x) * scale,
		    (travelList.get(i + 1).getY() - y) * scale, color));
	}
    }

    // Erstellt eine neue Tour
    Tour(List<City> list) {
	travelList.addAll(list);
	calculateDistance();
    }

    // gibt City an Index zurück
    public City getCityAt(int index) {
	return travelList.get(index);
    }

    // Berechnet die Gesamtdistanz aller Städte + Anfang zu Ende
    public void calculateDistance() {
	distance = 0;
	for (int i = 0; i < travelList.size() - 1; i++) {
	    distance += travelList.get(i).distanceTo(travelList.get(i + 1));
	}
	distance += travelList.get(0).distanceTo(travelList.get(travelList.size() - 1));
    }

    // Anzahl der Städte
    public int getSize() {
	return travelList.size();
    }

    // Ersetzt die Stadt an index durch city
    public void setCityAt(int index, City city) {
	travelList.set(index, city);
	calculateDistance();
    }

    /**
     * @return the travelList
     */
    public List<City> getTravelList() {
	return travelList;
    }

    /**
     * @param travelList
     *            the travelList to set
     */
    public void setTravelList(List<City> travelList) {
	this.travelList = travelList;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
	return distance;
    }

    /**
     * @param distance
     *            the distance to set
     */
    public void setDistance(int distance) {
	this.distance = distance;
    }

    /**
     * @return the color
     */
    public Color getColor() {
	return color;
    }

    /**
     * @param color
     *            the color to set
     */
    public void setColor(Color color) {
	this.color = color;
    }
}
