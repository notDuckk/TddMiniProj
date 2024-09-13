## Order TDD mini proj

### Steps to test this app 
- first run the application using the green arrow in the top right corner of intellij
- next go the url: http://localhost:8080/api/orders and make sure the ports match up with what your spring is running on.
- then change to post request and type in the JSON response body:
- 
 { 

  "customerName": "Luke",
  "orderDate": "2021-11-20",
  "shippingAddress": "day house",
  "total": 69.99

}

- click send
- from there you can do a get request using the /api/orders and se the order you created.
- and for update and delete you can do /api/orders/{id} to update or delete orders based on id

#### if you want to see your database in realtime you can do your localhost url and do /h2-console. The username is: sa and there is no password.
