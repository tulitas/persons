package persons.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import persons.services.PersonsService;

import static javax.swing.UIManager.get;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class OptionsControllerTest {
    private MockMvc mockMvc;
    @Test
    public void loginValidation() throws Exception {
        mockMvc.perform((RequestBuilder) get("/options/create"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("WEB-INF/views/personsList.jsp"))
                .andExpect(model().attributeExists("login exist"));
    }
}