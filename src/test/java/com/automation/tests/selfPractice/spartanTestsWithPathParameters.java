package com.automation.tests.selfPractice;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class spartanTestsWithPathParameters {

String baseURL="http://3.82.151.163:8000/";
   /*
   Given accept type is Json
   and id parameter valid is 18
   when user sends GET request to /api/spartans/{id}
   then response status code should be 200
   and response content-type: application/json;charset=UTF-8
   and "Allen" should be in response payload
    */

    @Test
    @DisplayName("add id parameter valid is 18 and verify status code should be 200")
    public void addParameterPathTest(){
      given().accept(ContentType.JSON).pathParam("id",18).
      when().get(baseURL).prettyPrint();

    }

    @Test
    public void QueryParam(){
        given().accept(ContentType.JSON).queryParam("gender", "Female").
                                         queryParam("nameContains", "J").
                                          when().get("/api/spartans/search");

    }


}
