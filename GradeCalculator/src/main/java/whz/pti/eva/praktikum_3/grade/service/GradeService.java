package whz.pti.eva.praktikum_3.grade.service;

import java.util.List;

import whz.pti.eva.praktikum_3.grade.domain.Grade;

public interface GradeService
{
	public List<Grade> listAllGrades();
	
	public void addGrade(String lecture,String grade);
	
	public double calculateAverage();
}
