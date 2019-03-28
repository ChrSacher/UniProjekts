package whz.pti.eva.praktikum_3.grade.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade
{

	@Id
	@GeneratedValue
	private int id;

	private String lecture = "Default Lecture";
	private String grade = "0";

	public Grade(String lecture, String grade)
	{
		super();
		this.lecture = lecture;
		setGrade(grade);
	}

	public Grade()
	{
		super();
	}

	public String getLecture()
	{
		return lecture;
	}

	public void setLecture(String lecture)
	{
		this.lecture = lecture;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		try
		{
			double gra = Double.parseDouble(grade);
			if (gra > 5 || gra < 1)
			{
				System.out.println("Grade must be betwen 1 and 5 ([1,5]).");
				return;
			}
			this.grade = grade;
			
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public double getGradeDouble()
	{
		try
		{
			return Double.parseDouble(grade);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return 0;
		}

	}
}
