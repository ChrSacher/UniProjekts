package application.TableInfo;

public class TableColumnData {
    private String name = "";
    private String displayName = "";
    private String type = "";
    private TableData foreignKeySQL = null;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }
    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return the foreignKeySQL
     */
    public TableData getForeignKeySQL() {
        return foreignKeySQL;
    }
    /**
     * @param foreignKeySQL the foreignKeySQL to set
     */
    public void setForeignKeySQL(TableData foreignKeySQL) {
        this.foreignKeySQL = foreignKeySQL;
    }
    
}
