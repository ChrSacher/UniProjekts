package application.model;

public class Abteilung extends BaseEntity<Long>
{
	private String abtName = "";

	public Abteilung(Long id, String abtName)
	{
		super(id);
		this.abtName = abtName;
	}

	public String getAbtName()
	{
		return abtName;
	}

	public void setAbtName(String abtName)
	{
		this.abtName = abtName;
	}
	
	
}
