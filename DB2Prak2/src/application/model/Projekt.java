package application.model;

import java.util.Map;

import application.TableInfo.ColumnName;
import application.TableInfo.TableName;

@TableName(name = "Projekt")
public class Projekt extends BaseEntity {

    @ColumnName(name = "ProNr")
    private String ProNr;
    
    @ColumnName(name = "ProName")
    private String ProName;

    @ColumnName(name = "GepiStuUmfang")
    private String GepiStuUmfang;

    @ColumnName(name = "KuNr")
    private String KuNr;

    /**
     * 
     */
    public Projekt() {
	super();
    }

    /**
     * @param proNr
     * @param proName
     * @param gepiStuUmfang
     * @param kuNr
     */
    public Projekt(String proNr, String proName, String gepiStuUmfang, String kuNr) {
	super();
	ProNr = proNr;
	ProName = proName;
	GepiStuUmfang = gepiStuUmfang;
	KuNr = kuNr;
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
     * @return the proName
     */
    public String getProName() {
        return ProName;
    }

    /**
     * @param proName the proName to set
     */
    public void setProName(String proName) {
        ProName = proName;
    }

    /**
     * @return the gepiStuUmfang
     */
    public String getGepiStuUmfang() {
        return GepiStuUmfang;
    }

    /**
     * @param gepiStuUmfang the gepiStuUmfang to set
     */
    public void setGepiStuUmfang(String gepiStuUmfang) {
        GepiStuUmfang = gepiStuUmfang;
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

    
}
