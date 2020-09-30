package com.example.demojsonschemavalidation07;

import static java.util.stream.Collectors.joining;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaException;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import java.io.IOException;
import java.util.Set;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class JsonSchemaValidator {

  private final ObjectMapper objectMapper = new ObjectMapper();

  public void validate(String jsonString, Resource schemaPath) {

    JsonNode jsonNode;
    JsonSchema jsonSchema;
    // schema
    try {
      jsonNode = objectMapper.readTree(jsonString);
      jsonSchema = JsonSchemaFactory.getInstance().getSchema(schemaPath.getInputStream());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // validation
    Set<ValidationMessage> validationResult = jsonSchema.validate(jsonNode);

    if (!validationResult.isEmpty()) {
      String errorMessages = validationResult.stream()
          .map(ValidationMessage::getMessage)
          .collect(joining(" # "));
      throw new JsonSchemaException(errorMessages);
    }
  }

}