package whz.pti.eva.praktikum_3.grade.boundary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.praktikum_3.grade.domain.Grade;
import whz.pti.eva.praktikum_3.grade.service.GradeService;

@Controller
public class GradeController
{
	@Autowired
	private GradeService gradeService;
	
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	
	
	@RequestMapping(value = "/listAllGrades", method = RequestMethod.GET)
	public String listAllGrades(Model model)
	{
		List<Grade> l = gradeService.listAllGrades();
		model.addAttribute("Grades", l);
		model.addAttribute("GradeAverage",Double.toString(gradeService.calculateAverage()));
		logger.info("Request for list of grades");
		return "grades";
	}
	
	 @RequestMapping(value = "/addGrade", method = RequestMethod.POST)
	public String addGrade(@RequestParam String lectureName,@RequestParam String grade)
	{
		logger.info("Request to add grade");
		gradeService.addGrade(lectureName, grade);
		return "redirect:/listAllGrades";
	}
}
