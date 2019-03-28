package application.model;

public class Taetigkeit extends BaseEntity<Long>
{
	private String TaetName;
	private String TaetStuSatz;

	public Taetigkeit(Long id, String taetName, String taetStuSatz)
	{
		super(id);
		TaetName = taetName;
		TaetStuSatz = taetStuSatz;
	}

	public String getTaetName()
	{
		return TaetName;
	}

	public void setTaetName(String taetName)
	{
		TaetName = taetName;
	}

	public String getTaetStuSatz()
	{
		return TaetStuSatz;
	}

	public void setTaetStuSatz(String taetStuSatz)
	{
		TaetStuSatz = taetStuSatz;
	}

}
