package com.farzan.webservices.web;

import com.farzan.webservices.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerUnitTest {

    /*
    MockMvc offers a powerful way to quickly test mvc controller without needing to start a full http server
    @WebMvcTest autoconfigures MockMvc
     */
    @Autowired
    private MockMvc mockMvc;

    /*
     mocking dogService bean
     this annotation creates a Mockito mock of the services which are dependencies for our controller
     */
    @MockBean
    DogService dogService;

    @Test
    @WithMockUser(username = "admin", password = "password", roles = "USER")
    public void getAllDogs() throws Exception {
        // mockmvc simulates an http request to the server and here where basic authing
        this.mockMvc.perform(get("/dogs"))
                // here are our expectations: since we use basic auth here, without it it should give 401
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        // verify the number of times a mock method has been called
        verify(dogService, times(1)).retrieveDogs();
    }
}
