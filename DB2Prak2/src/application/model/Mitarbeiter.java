package application.model;

public class Mitarbeiter extends BaseEntity<Long>
{
	private String faName;
	private String voName;
	private String gehalt;
	
	

	public Mitarbeiter(Long id, String faName, String voName, String gehalt)
	{
		super(id);
		this.faName = faName;
		this.voName = voName;
		this.gehalt = gehalt;
	}

	public String getFaName()
	{
		return faName;
	}

	public void setFaName(String faName)
	{
		this.faName = faName;
	}

	public String getVoName()
	{
		return voName;
	}

	public void setVoName(String voName)
	{
		this.voName = voName;
	}

	public String getGehalt()
	{
		return gehalt;
	}

	public void setGehalt(String gehalt)
	{
		this.gehalt = gehalt;
	}

}
