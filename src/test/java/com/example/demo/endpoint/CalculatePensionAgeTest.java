package com.example.demo.endpoint;

import com.example.demo.model.PensionAge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatePensionAgeTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test1() {
        HttpEntity<?> entity = new HttpEntity<>(null, null);
        PensionAge pensionAge =
                testRestTemplate
                        .exchange(
                                "/savings/pension/calculate-pension-age?birthDate=1946-01-01" , HttpMethod.GET, entity, PensionAge.class)
                        .getBody();
        assertNotNull(pensionAge);
        assertEquals(65, pensionAge.years);
        assertEquals(0, pensionAge.months);
    }

    @Test
    public void test2() {
        HttpEntity<?> entity = new HttpEntity<>(null, null);
        PensionAge pensionAge =
                testRestTemplate
                        .exchange(
                                "/savings/pension/calculate-pension-age?birthDate=2000-01-01" , HttpMethod.GET, entity, PensionAge.class)
                        .getBody();
        assertNotNull(pensionAge);
        assertEquals(67, pensionAge.years);
        assertEquals(3, pensionAge.months);
    }


}