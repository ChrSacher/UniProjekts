package application.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import application.TableInfo.ColumnName;
import application.TableInfo.TableName;

@TableName(name = "Geleistet")
public class Geleistet extends BaseEntity {
    
    @ColumnName(name = "GelNr")
    private String GelNr;
    
    @ColumnName(name = "MitNr")
    private String MitNr;
    
    @ColumnName(name = "TaetNr")
    private String TaetNr;
    
    @ColumnName(name = "ProNr")
    private String ProNr;
    
    @ColumnName(name = "Anfang")
    private String Anfang;
    
    @ColumnName(name = "Ende")
    private String Ende;

    public Geleistet() {

    }

    /**
     * @param gelNr
     * @param mitNr
     * @param taetNr
     * @param proNr
     * @param anfang
     * @param ende
     */
    public Geleistet(String gelNr, String mitNr, String taetNr, String proNr, String anfang, String ende) {
	super();
	GelNr = gelNr;
	MitNr = mitNr;
	TaetNr = taetNr;
	ProNr = proNr;
	Anfang = anfang;
	Ende = ende;
    }

    /**
     * @return the gelNr
     */
    public String getGelNr() {
        return GelNr;
    }

    /**
     * @param gelNr the gelNr to set
     */
    public void setGelNr(String gelNr) {
        GelNr = gelNr;
    }

    /**
     * @return the mitNr
     */
    public String getMitNr() {
        return MitNr;
    }

    /**
     * @param mitNr the mitNr to set
     */
    public void setMitNr(String mitNr) {
        MitNr = mitNr;
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
     * @return the proNr
     */
    public String getProNr() {
        return ProNr;
    }

    /**
     * @param proNr the proNr to set
     */
    public void setProNr(String proNr) {
        ProNr = proNr;
    }

    /**
     * @return the anfang
     */
    public String getAnfang() {
        return Anfang;
    }

    /**
     * @param anfang the anfang to set
     */
    public void setAnfang(String anfang) {
        Anfang = anfang;
    }

    /**
     * @return the ende
     */
    public String getEnde() {
        return Ende;
    }

    /**
     * @param ende the ende to set
     */
    public void setEnde(String ende) {
        Ende = ende;
    }

    

}
