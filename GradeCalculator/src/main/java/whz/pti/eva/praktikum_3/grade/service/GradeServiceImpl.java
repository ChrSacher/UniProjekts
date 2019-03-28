package whz.pti.eva.praktikum_3.grade.service;

import java.util.List;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.praktikum_3.grade.domain.Grade;
import whz.pti.eva.praktikum_3.grade.domain.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService
{

	private GradeRepository gradeRepository;

	@Autowired
	public GradeServiceImpl(GradeRepository gradeRepository)
	{
		this.gradeRepository = gradeRepository;
	}

	@Override
	public List<Grade> listAllGrades()
	{
		return gradeRepository.findAll();
	}

	@Override
	public void addGrade(String lecture, String grade)
	{
		gradeRepository.save(new Grade(lecture, grade));
	}

	@Override
	public double calculateAverage()
	{
		OptionalDouble average = gradeRepository.findAll().stream().filter(grade -> grade.getGradeDouble() > 0.9 && grade.getGradeDouble() < 5.1).mapToDouble(Grade::getGradeDouble).average();
		if (average.isPresent())
			return average.getAsDouble();
		return 0;

	}

}
