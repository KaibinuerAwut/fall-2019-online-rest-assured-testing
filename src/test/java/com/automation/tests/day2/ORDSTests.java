package com.automation.tests.day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ORDSTests {

String Base_URL="http://3.90.112.152:1000/ords/hr";


    @Test
    @DisplayName("get list of all employees")
    public void getAllEmployees(){
       //response can be saved in the Response object
        //prettyPeek() - method that prints response info in nice format
        //also ths method returns Response object
        //response contains body, header and status line
        //body (payload) - contains content that we requested from the web service
        //header - contains meta data

        Response response = given().baseUri(Base_URL).when().get("/employees").prettyPeek();
        /**
         * RestAssured request has similar structure to BDD scenarios:
         * Start building the request part of the test
         *
         * given() - used for request setup and authentication
         * Syntactic sugar,
         * when() - to specify type of HTTP request: get, put, post, delete, patch, head, etc...
         * then() - to verify response, perform assertions
         */
    }

    @Test
    @DisplayName("get employee under specific ID")

    //in URL we can specify path and query parameters
    //path parameters are used to retrieve specific resource: for example 1 employee not all of them
    //{id} - path variable, that will be replace with a value after comma
    //after when() we specify HTTP request type/method/verb
    //The path parameters. E.g. if path is "/book/{hotelId}/{roomNumber}" you can do <code>get("/book/{hotelName}/{roomNumber}", "Hotels R Us", 22);</code>.

    public void getOneEmployee(){
      Response response = given().baseUri(Base_URL).when().get("/employees/" + 100).prettyPeek();

      //how we verify response? - use assertions
      response.then().statusCode(200);  // to verify that status is 200
        int statusCode = response.statusCode(); // to save status code in var

    }
    @Test
    @DisplayName("get list of all countries and verify that status code is 200")
    public void getAllCountries(){
                given().
                       baseUri(Base_URL).
                when().
                      get("/countries").prettyPeek().
               then().
                       statusCode(200);

    }

    @Test
    @DisplayName("get countries name by the ID and verify that status code is 200")
    public void getCountriesByID(){
        given().
                baseUri(Base_URL).
                when().
                get("/countries/{id}", "AU" ).prettyPeek().
                then().
                statusCode(200);

    }

}
