@module_identity
Feature: Định danh khách hàng

  Background:
    * def dbConfig = karate.read('classpath:user-config.json').dbConfig
    * def dbUtils = Java.type('helpers.DbUtils')
    * def db = new dbUtils(dbConfig)

    # Load file template JSON (dùng làm khung)
    * def bodyTemplate = read('classpath:data/identity_template.json')

Scenario Outline: <testCaseId> - Kiểm tra gọi hàm thành công khi truyền đầy đủ các trường thông tin
    # Bước 1: Khởi tạo request body từ template
    # Karate tự động thay thế #(biến) bằng giá trị cột tương ứng trong CSV
    Given path '/api/identity/customer'
    And request bodyTemplate
    When method post
    Then status <expectedStatus>
    
    

    Examples:
      | read('classpath:data/identity_data.csv') |
