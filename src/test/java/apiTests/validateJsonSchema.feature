Feature: Json schema validator

  Scenario: Validate json schema
    Given url 'https://api.picsart.com/localizations/en/messages?project=reusable_components,photo_editor'
    When  method GET
    Then  status 200
    # Create response_schema variable and assign json schema from the file
    And   def response_schema = read('json-schema.json')
    And   print response_schema
    # Validate json schema key:value pairs with the json-schema.json file
    And   match response == response_schema