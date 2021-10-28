package org.com.simian.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.com.simian.dto.SimianRequestDTO;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class SimianResourceTest {

    @Test
    public void testSimianResource() {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        SimianRequestDTO body = new SimianRequestDTO(dna);

        given()
          .contentType("application/json")
                .body(body)
          .when()
                .post("/simian/validate")
          .then()
             .statusCode(200);
    }

    @Test
    public void testSimianResourceVertical() {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CACCTA", "TCACTG"};
        SimianRequestDTO body = new SimianRequestDTO(dna);

        given()
          .contentType("application/json")
                .body(body)
          .when()
                .post("/simian/validate")
          .then()
             .statusCode(200);
    }

    @Test
    public void testSimianResourceDiagonal() {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "ATAGAG", "CCTCTA", "TCATCG"};
        SimianRequestDTO body = new SimianRequestDTO(dna);

        given()
          .contentType("application/json")
                .body(body)
          .when()
                .post("/simian/validate")
          .then()
             .statusCode(200);
    }

    @Test
    public void testSimianResourceDiagonalInv() {
        String [] dna = {"CTGACA", "CTAGGC", "TATTGT", "AGAGGT", "CCACTA", "TCACTA"};
        SimianRequestDTO body = new SimianRequestDTO(dna);

        given()
          .contentType("application/json")
                .body(body)
          .when()
                .post("/simian/validate")
          .then()
             .statusCode(200);
    }

    @Test
    public void testSimianResourceInvalidInput() {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGB", "AGAGGG", "CCCCTA", "TCACTG"};
        SimianRequestDTO body = new SimianRequestDTO(dna);

        given()
          .contentType("application/json")
                .body(body)
          .when()
                .post("/simian/validate")
          .then()
             .statusCode(400);
    }

    @Test
    public void testSimianResourceNotSimian() {
        String [] dna = {"CTGTAA", "CTGAGC", "TATTGT", "AGAGGG", "CCACTA", "TCACTG"};
        SimianRequestDTO body = new SimianRequestDTO(dna);

        given()
          .contentType("application/json")
                .body(body)
          .when()
                .post("/simian/validate")
          .then()
             .statusCode(403);
    }

}