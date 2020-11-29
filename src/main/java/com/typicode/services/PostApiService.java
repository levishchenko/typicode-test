package com.typicode.services;

import com.typicode.assertions.AssertableResponse;
import com.typicode.dto.Post;

public class PostApiService extends APIService {

    public AssertableResponse sendPostRequest(Post post) {
        return new AssertableResponse(setup().body(post).when().post("posts"));
    }

    public AssertableResponse sendPutRequest(Post post, int id) {
        return new AssertableResponse(setup().body(post).when().put("posts/" + id));
    }

    public AssertableResponse sendPatchRequest(Post post, int id) {
        return new AssertableResponse(setup().body(post).when().patch("posts/" + id));
    }

    public AssertableResponse sendDeleteRequest(int id) {
        return new AssertableResponse(setup().when().delete("posts/" + id));
    }

    public AssertableResponse sendGetRequest() {
        return new AssertableResponse(setup().when().get("posts"));
    }

    public AssertableResponse sendGetRequestById(int id) {
        return new AssertableResponse(setup().when().get("posts/" + id));
    }

    public AssertableResponse sendGetRequestToComments(int id) {
        return new AssertableResponse(setup().when().get("posts/" + id + "/comments"));
    }
}
