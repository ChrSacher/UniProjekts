package application.model;

import java.util.Map;

import application.TableInfo.ColumnName;
import application.TableInfo.TableName;

@TableName(name = "Mitarbeiter")
public class Mitarbeiter extends BaseEntity {
    @ColumnName(name = "MitNr")
    private String MitNr;
    @ColumnName(name = "FaName")
    private String faName;
    @ColumnName(name = "VoName")
    private String voName;
    @ColumnName(name = "Gehalt")
    private String gehalt;
    @ColumnName(name = "AbtNr")
    private String abtNr;
    /**
     * 
     */
    public Mitarbeiter() {
	super();
    }
    /**
     * @param mitNr
     * @param faName
     * @param voName
     * @param gehalt
     * @param abtNr
     */
    public Mitarbeiter(String mitNr, String faName, String voName, String gehalt, String abtNr) {
	super();
	MitNr = mitNr;
	this.faName = faName;
	this.voName = voName;
	this.gehalt = gehalt;
	this.abtNr = abtNr;
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
     * @return the faName
     */
    public String getFaName() {
        return faName;
    }
    /**
     * @param faName the faName to set
     */
    public void setFaName(String faName) {
        this.faName = faName;
    }
    /**
     * @return the voName
     */
    public String getVoName() {
        return voName;
    }
    /**
     * @param voName the voName to set
     */
    public void setVoName(String voName) {
        this.voName = voName;
    }
    /**
     * @return the gehalt
     */
    public String getGehalt() {
        return gehalt;
    }
    /**
     * @param gehalt the gehalt to set
     */
    public void setGehalt(String gehalt) {
        this.gehalt = gehalt;
    }
    /**
     * @return the abtNr
     */
    public String getAbtNr() {
        return abtNr;
    }
    /**
     * @param abtNr the abtNr to set
     */
    public void setAbtNr(String abtNr) {
        this.abtNr = abtNr;
    }

    
}
