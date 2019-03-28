package application.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableController
{

	private MainController parent;

	@FXML
	private TableView<Map<String,StringProperty>> table;
	
	
	private ObservableList<Map<String,StringProperty>> values =FXCollections.observableArrayList(new HashMap());
	
	public void init(ResultSet rs, MainController parent)
	{
		this.parent = parent;

		Statement stmt;
		try
		{

			
				for(int i = 1 ; i  <= rs.getMetaData().getColumnCount();i++)
				{
					final String columnName  = rs.getMetaData().getColumnName(i);
					TableColumn<Map<String,StringProperty>, String> column =
							new TableColumn<Map<String, StringProperty>, String>(columnName);
					column.setCellValueFactory(value -> value.getValue().get(columnName));
					
					
				}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void refresh(ResultSet rs)
	{
		try
		{
			int count = rs.getMetaData().getColumnCount();
			values.clear();
			while (rs.next())
			{
				Map<String,StringProperty> map = new HashMap();
				for(int i = 1 ; i <= count ; i ++)
				{
					map.put(rs.getMetaData().getColumnName(i),new SimpleStringProperty(rs.getString(i)));
				}
				values.add(map);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
