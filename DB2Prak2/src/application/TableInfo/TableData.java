package application.TableInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Handler;

import application.model.BaseEntity;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TableData<T extends BaseEntity> {

    private static Map<Class, Map<String, Field>> classAttributeFieldMap = new HashMap();

    private Supplier<T> supplier;
    private Map<String, TableColumnData> data = new HashMap<>();
    private String tableName = "";
    private ObservableList<T> values = FXCollections.observableArrayList();

    public static void loadTypeConverter() {

    }

    public TableData(Supplier<T> supplier, ResultSet sqlQuery) {
	this.supplier = supplier;
	buildFieldMap();
	loadFromQuery(sqlQuery);
    }

    private void buildFieldMap() {
	T object = supplier.get();
	Class<? extends BaseEntity> clazz = object.getClass();
	if (classAttributeFieldMap.containsKey(clazz))
	    return;
	TableName anno = clazz.getAnnotation(TableName.class);
	if (anno != null) {
	    Field[] fields = clazz.getDeclaredFields();
	    Map<String, Field> attributeFieldMap = new HashMap();
	    for (int i = 0; i < fields.length; i++) {
		ColumnName column = fields[i].getAnnotation(ColumnName.class);
		if (column != null) {
		    fields[i].setAccessible(true);
		    attributeFieldMap.put(column.name(), fields[i]);

		}
	    }
	    classAttributeFieldMap.put(clazz, attributeFieldMap);

	}

    }

    void loadFromQuery(ResultSet sqlQuery) {
	try {
	    data.clear();
	    ResultSetMetaData meta = sqlQuery.getMetaData();
	    tableName = meta.getTableName(1);
	    for (int i = 1; i <= meta.getColumnCount(); i++) {
		TableColumnData newData = new TableColumnData();
		newData.setName(meta.getColumnName(i));
		newData.setType(meta.getColumnTypeName(i));
		newData.setDisplayName(meta.getColumnLabel(i));

	    }
	    loadValues(sqlQuery);

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    void loadValues(ResultSet sqlQuery) {
	values.clear();
	try {
	    while (sqlQuery.next()) {
		T object = supplier.get();
		Map<String, Field> fields = classAttributeFieldMap.get(object.getClass());
		if (fields == null) {
		    System.out.println("Field Error");
		} else {
		    fields.forEach((key, value) -> {
			try {
			    value.set(object, sqlQuery.getString(key));
			} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		    });
		}
		// object.loadFrom(map);

		values.add(object);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * @return the supplier
     */
    public Supplier<T> getSupplier() {
	return supplier;
    }

    /**
     * @param supplier
     *            the supplier to set
     */
    public void setSupplier(Supplier<T> supplier) {
	this.supplier = supplier;
    }

    /**
     * @return the data
     */
    public Map<String, TableColumnData> getData() {
	return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(Map<String, TableColumnData> data) {
	this.data = data;
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
	return tableName;
    }

    /**
     * @param tableName
     *            the tableName to set
     */
    public void setTableName(String tableName) {
	this.tableName = tableName;
    }

    /**
     * @return the values
     */
    public ObservableList<T> getValues() {
	return values;
    }

    /**
     * @param values
     *            the values to set
     */
    public void setValues(ObservableList<T> values) {
	this.values = values;
    }

}
