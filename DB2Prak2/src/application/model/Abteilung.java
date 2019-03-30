package application.model;

import application.TableInfo.TableName;
import application.TableInfo.ColumnName;

@TableName(name = "Abteilung")
public class Abteilung extends BaseEntity{
    
    @ColumnName(name = "AbtNr")
    private String AbtNr = "";
    
    @ColumnName(name = "AbtName")
    private String AbtName = "";

    /**
     * @param abtNr
     * @param abtName
     */
    public Abteilung(String abtNr, String abtName) {
	super();
	AbtNr = abtNr;
	AbtName = abtName;
    }

    /**
     * 
     */
    public Abteilung() {
	super();
    }

    /**
     * @return the abtNr
     */
    public String getAbtNr() {
        return AbtNr;
    }

    /**
     * @param abtNr the abtNr to set
     */
    public void setAbtNr(String abtNr) {
        AbtNr = abtNr;
    }

    /**
     * @return the abtName
     */
    public String getAbtName() {
        return AbtName;
    }

    /**
     * @param abtName the abtName to set
     */
    public void setAbtName(String abtName) {
        AbtName = abtName;
    }

    
    // @Override
    // public void loadFrom(Map<String, String> dataMap) {
    // setId(dataMap.getOrDefault("AbtNr ", "Null"));
    // abtName = dataMap.getOrDefault("AbtName", "Null");
    //
    // }

}
