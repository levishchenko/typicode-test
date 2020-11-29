package com.typicode.services;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class APIService {

    protected RequestSpecification setup() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(LogDetail.METHOD), new RequestLoggingFilter(LogDetail.URI),
                        new RequestLoggingFilter(LogDetail.BODY), new ResponseLoggingFilter(LogDetail.STATUS),
                        new ResponseLoggingFilter(LogDetail.BODY));
    }
}
