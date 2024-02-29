package org.acme.hibernate.orm;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class HumanEndpointTest {

    @Test
    public void test() {
        given()
                .when().get("/humans/test/1")
                .then()
                .statusCode(200);
    }

}
