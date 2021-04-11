package com.farzan.webservices.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
// very useful to start the application on a random port to avoid conflicts in a test environment
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/*
this annotation simulates calling the code from the client exactly the same way as if we were processing
a real http request.
 */
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate
            = new TestRestTemplate("admin", "password");

    @Test
    public void getAllDogs() {
        ResponseEntity<List> response =
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/dogs/", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

//    @Test
//    public void getBreed() {
//        ResponseEntity<String> response =
//                this.testRestTemplate.getForEntity("http://localhost:" + port + "/1/breed", Dog.class);
//
//        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//    }

}
