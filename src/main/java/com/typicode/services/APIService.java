package com.typicode.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class APIService {

    protected RequestSpecification setup(){
        return RestAssured.given().contentType(ContentType.JSON).log().all();
    }
}
