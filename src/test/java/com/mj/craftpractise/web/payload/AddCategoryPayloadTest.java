package com.mj.craftpractise.web.payload;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class AddCategoryPayloadTest {

    @Test
    void mappingTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{ \"lcateName\" : \"new\", \"mcateName\" : \"newM\" }";
        AddCategoryPayload payload = mapper.readValue(json, AddCategoryPayload.class);
        System.out.println(payload);
    }
}