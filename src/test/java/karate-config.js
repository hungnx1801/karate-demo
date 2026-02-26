function fn() {
 var env = karate.env || 'test';

 

  // Cấu hình để Karate chấp nhận cert tự ký của localhost
  karate.configure('ssl', true);
  
  // Tự động lấy token dùng chung (callonce giúp chỉ login 1 lần)
  var result = karate.callonce('classpath:helpers/auth-helper.feature', config);
  karate.configure('headers', { 
    'Authorization': 'Bearer ' + result.authToken,
    'Content-Type': 'application/json'
  });
  return config;
}