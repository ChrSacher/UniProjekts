package application.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class MainController
{
	private Connection connection;
	@FXML
	private TabPane tabView;

	@FXML
	public void initialize()
	{
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "database=PZM1;" + "user=SQLTEACHER;"
				+ "password=12345;";

		try
		{
			setConnection(DriverManager.getConnection(connectionUrl));
			Statement stmt = getConnection().createStatement();
			String SQL = "SELECT * FROM Mitarbeiter";
			ResultSet rs = stmt.executeQuery(SQL);
			
			// Iterate through the data in the result set and display it.
			while (rs.next())
			{
				System.out.println(rs.getString("faName") + " " + rs.getString("voName"));
				System.out.println(rs.getMetaData().getColumnName(1));
			}
			
			
			
		}
		// Handle any errors that may have occurred.
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
		try {
			Tab mitTab = new Tab("Mitarbeiter");
			tabView.getTabs().add(mitTab);
			FXMLLoader mLoader = new FXMLLoader(getClass().getResource("view/TableView.fxml"));
			Pane root = mLoader.load();
			TableSQLController con = mLoader.getController();
			con.init("Mitarbeiter", this);
			mitTab.setContent(root);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection()
	{
		return connection;
	}

	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}
}
