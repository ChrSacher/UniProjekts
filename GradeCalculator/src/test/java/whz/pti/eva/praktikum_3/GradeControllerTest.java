package whz.pti.eva.praktikum_3;



import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import whz.pti.eva.praktikum_3.grade.domain.Grade;
import whz.pti.eva.praktikum_3.grade.service.GradeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GradeControllerTest {

	@LocalServerPort
    private int port;

	@MockBean
	private GradeService gradeService;
	
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    private List<Grade> list;
    

    
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
               .webAppContextSetup(wac)
                .build();
        list = new ArrayList<>();
        list.add(new Grade());list.add(new Grade());
        when(gradeService.calculateAverage()).thenReturn(1.5);
        when(gradeService.listAllGrades()).thenReturn(list);
    }
    
    @Test
    public void testListAllGrades() throws Exception {
    	mockMvc.perform(get("/listAllGrades"))
    			.andExpect(status().isOk())
    			.andExpect(view().name("grades"))
    			.andExpect(model().attribute("Grades", hasSize(2)))
    			.andExpect(model().attribute("GradeAverage", "1.5"))
    			.andDo(print());
    }
    
    @Test
    public void testaddGrade() throws Exception{
    	
    	mockMvc.perform(post("/addGrade")
    			.param("lectureName", "test")
    			.param("grade","1"))
    			.andExpect(status().is3xxRedirection())
    			.andExpect(redirectedUrl("/listAllGrades"));
    }
    
    
} 
