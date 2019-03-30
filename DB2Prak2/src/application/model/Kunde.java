package application.model;

import java.util.Map;

import application.TableInfo.ColumnName;
import application.TableInfo.TableName;

@TableName(name = "Kunde")
public class Kunde extends BaseEntity {
    
    @ColumnName(name = "KuNr")
    private String KuNr;
    
    @ColumnName(name = "KuName")
    private String KuName;

    @ColumnName(name = "PLZ")
    private String PLZ;

    @ColumnName(name = "Ort")
    private String Ort;

    /**
     * 
     */
    public Kunde() {
	super();
    }

    /**
     * @param kuNr
     * @param kuName
     * @param pLZ
     * @param ort
     */
    public Kunde(String kuNr, String kuName, String pLZ, String ort) {
	super();
	KuNr = kuNr;
	KuName = kuName;
	PLZ = pLZ;
	Ort = ort;
    }

    /**
     * @return the kuNr
     */
    public String getKuNr() {
        return KuNr;
    }

    /**
     * @param kuNr the kuNr to set
     */
    public void setKuNr(String kuNr) {
        KuNr = kuNr;
    }

    /**
     * @return the kuName
     */
    public String getKuName() {
        return KuName;
    }

    /**
     * @param kuName the kuName to set
     */
    public void setKuName(String kuName) {
        KuName = kuName;
    }

    /**
     * @return the pLZ
     */
    public String getPLZ() {
        return PLZ;
    }

    /**
     * @param pLZ the pLZ to set
     */
    public void setPLZ(String pLZ) {
        PLZ = pLZ;
    }

    /**
     * @return the ort
     */
    public String getOrt() {
        return Ort;
    }

    /**
     * @param ort the ort to set
     */
    public void setOrt(String ort) {
        Ort = ort;
    }

    

}
