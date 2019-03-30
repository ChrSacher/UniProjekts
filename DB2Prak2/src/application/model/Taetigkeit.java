package application.model;

import java.util.Map;

import application.TableInfo.ColumnName;
import application.TableInfo.TableName;

@TableName(name = "Taetigkeit")
public class Taetigkeit extends BaseEntity{
    
    @ColumnName(name = "TaetNr")
    private String TaetNr;
    
    @ColumnName(name = "TaetName")
    private String TaetName;
    
    @ColumnName(name = "TaetStuSatz")
    private String TaetStuSatz;

    /**
     * 
     */
    public Taetigkeit() {
	super();
    }

    /**
     * @param taetNr
     * @param taetName
     * @param taetStuSatz
     */
    public Taetigkeit(String taetNr, String taetName, String taetStuSatz) {
	super();
	TaetNr = taetNr;
	TaetName = taetName;
	TaetStuSatz = taetStuSatz;
    }

    /**
     * @return the taetNr
     */
    public String getTaetNr() {
        return TaetNr;
    }

    /**
     * @param taetNr the taetNr to set
     */
    public void setTaetNr(String taetNr) {
        TaetNr = taetNr;
    }

    /**
     * @return the taetName
     */
    public String getTaetName() {
        return TaetName;
    }

    /**
     * @param taetName the taetName to set
     */
    public void setTaetName(String taetName) {
        TaetName = taetName;
    }

    /**
     * @return the taetStuSatz
     */
    public String getTaetStuSatz() {
        return TaetStuSatz;
    }

    /**
     * @param taetStuSatz the taetStuSatz to set
     */
    public void setTaetStuSatz(String taetStuSatz) {
        TaetStuSatz = taetStuSatz;
    }

  

}
