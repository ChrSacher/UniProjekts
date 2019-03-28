package whz.pti.eva.pizzaservice;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import whz.pti.eva.pizzaservice.pizza.domain.Pizza;
import whz.pti.eva.pizzaservice.pizza.service.PizzaService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PizzaControllerTest
{

    @LocalServerPort
    private int port;
    
    @MockBean
    private PizzaService pizzaService;
        
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    private List<Pizza> list;
    
    
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
               .webAppContextSetup(wac)
                .build();
        list = new ArrayList<>();
        list.add(new Pizza("thunfisch"));
        list.add(new Pizza("marg"));
        when(pizzaService.listAllPizzas()).thenReturn(list);
    }
    
    @Test
    public void testListAllPizzas() throws Exception {
           /* mockMvc.perform(get("/buyPizzas"))
                            .andExpect(status().isOk())
                            .andExpect(view().name("pizza"))
                            .andExpect(model().attribute("Pizzas", hasSize(2)))
                            .andDo(print());*/
    }

}
