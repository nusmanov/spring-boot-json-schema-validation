# Example
* https://json-schema.org/learn/miscellaneous-examples.html
* info: https://json-schema.org/understanding-json-schema/reference/schema.html#schema
# JSON Schema
```
{
  "$id": "https://example.com/person.schema.json",
  "$schema": "http://json-schema.org/draft-07/schema#",
  "title": "Person",
  "type": "object",
  "properties": {
    "firstName": {
      "type": "string",
      "description": "The person's first name."
    },
    "lastName": {
      "type": "string",
      "description": "The person's last name."
    },
    "age": {
      "description": "Age in years which must be equal to or greater than zero.",
      "type": "integer",
      "minimum": 0
    }
  }
}
```

# JSON Message - valid one
```
{
  "firstName": "John",
  "lastName": "Doe",
  "age": 21
}
```