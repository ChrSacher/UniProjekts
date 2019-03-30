package application.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import application.TableInfo.TableData;
import application.model.Abteilung;
import application.model.BaseEntity;
import application.model.Geleistet;
import application.model.Kunde;
import application.model.Mitarbeiter;
import application.model.Projekt;
import application.model.Taetigkeit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class MainController {
    private Connection connection;
    @FXML
    private TabPane tabView;

    private Map<String, TableData<? extends BaseEntity>> tableData = new HashMap<String, TableData<? extends BaseEntity>>();
    String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "database=PZM1;" + "user=SQLTEACHER;"
	    + "password=12345;";

    @FXML
    public void initialize() {

	try {
	    setConnection(DriverManager.getConnection(connectionUrl));

	}
	// Handle any errors that may have occurred.
	catch (SQLException e) {
	    e.printStackTrace();
	}

	addNewTable("Mitarbeiter",() -> new Mitarbeiter());
	addNewTable("Taetigkeit",() -> new Taetigkeit());
	addNewTable("Kunde",() -> new Kunde());
	addNewTable("Abteilung",() -> new Abteilung());
	addNewTable("Projekt",() -> new Projekt());
	addNewTable("Geleistet",() -> new Geleistet());
	
	try {
	    addTab("Mitarbeiter", "Mitarbeiter");
	    addTab("Taetigkeit", "Taetigkeit");
	    addTab("Kunde", "Kunde");
	    addTab("Abteilung", "Abteilung");
	    addTab("Projekt", "Projekt");
	    addTab("Geleistet", "Geleistet");

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void addTab(String name, String tableName) throws IOException {

	Tab mitTab = new Tab(name);
	tabView.getTabs().add(mitTab);
	FXMLLoader mLoader = new FXMLLoader(getClass().getResource("TableView.fxml"));
	TableView root = mLoader.load();
	TableSQLController con = mLoader.getController();
	con.init(tableName, this);
	mitTab.setContent(root);

    }

    public <T extends BaseEntity<?>> void addNewTable(String tableName, Supplier<T> supplier) {
	try {
	    setConnection(DriverManager.getConnection(connectionUrl));

	    Statement stmt = getConnection().createStatement();
	    String SQL = "SELECT * FROM " + tableName;
	    ResultSet rs = stmt.executeQuery(SQL);
	    tableData.put(tableName, new TableData<T>(supplier, rs));

	}
	// Handle any errors that may have occurred.
	catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public Connection getConnection() {
	return connection;
    }

    public void setConnection(Connection connection) {
	this.connection = connection;
    }
}
