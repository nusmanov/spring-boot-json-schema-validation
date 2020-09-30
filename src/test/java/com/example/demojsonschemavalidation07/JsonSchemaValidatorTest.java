package com.example.demojsonschemavalidation07;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

class JsonSchemaValidatorTest {

  private final JsonSchemaValidator cut = new JsonSchemaValidator();

  @Test
  void test_valid_message() {

    String json = "{"
        + "  \"firstName\": \"John\","
        + "  \"lastName\": \"Doe\","
        + "  \"age\": 21"
        + "}";

    cut.validate(json, new ClassPathResource("poc/schema-07.json"));

  }
}