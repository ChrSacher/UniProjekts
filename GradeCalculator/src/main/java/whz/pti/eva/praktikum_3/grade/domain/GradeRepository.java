package whz.pti.eva.praktikum_3.grade.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/*public class GradeRepository
{
	private List<Grade> grades = new ArrayList<Grade>();
	
	public List<Grade> findAll()
	{
		return grades;
	}
	
	public void save(Grade grade)
	{
		grades.add(grade);
	}
}
*/

public interface GradeRepository extends JpaRepository<Grade, Integer>
{
	public List<Grade> findAll();
	
	public <S extends Grade> S save(Grade grade);
}