@ignore
Feature:Auth Helper

Scenario: Get Bearer Token
  Given url authUrl
  And request { "username": "admin", "password": "Abcd@123" }
  When method post
  Then status 200
  *def token = response.data.accessToken