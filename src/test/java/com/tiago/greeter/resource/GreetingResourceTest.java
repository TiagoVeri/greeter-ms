package com.tiago.greeter.resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingResourceTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingResourceTestWithoutParam() {
        String body = this.restTemplate.getForObject("/greeter", String.class);
        assertThat(body).isEqualTo("Hello, World!");
    }

    @Test
    public void greetingResourceTestWithParam() {
        String body = this.restTemplate.getForObject("/greeter?name=John", String.class);
        assertThat(body).isEqualTo("Hello, World! John");
    }

}