# Spring Boot MongoDB
Tutorial of Building Java REST API using Spring Boot and MongoDB

This source code is part of Tutorial of Building Java REST API using Spring Boot and MongoDB

If you think this source code is useful, it will be great if you just give it star or just buy me a cup of coffee.

HTTP Request:
GET http://localhost:8080/products
Content-Type: application/json

{
"id": "",
"prodName": "",
"prodDesc": "",
"prodPrice": 0,
"prodImage": ""
}

<> 2024-06-24T111358.200.json
<> 2024-06-24T111032.200.json

###

POST http://localhost:8080/products
Content-Type: application/json

{
"id": "PROD-001",
"prodName": "Buku Sinar Dunia",
"prodDesc": "Buku Sinar Dunia",
"prodPrice": 2500,
"prodImage": "https://upload.wikimedia.org/wikipedia/commons/c/ce/Intel_Core_i7_Logo_2020.png"
}

###

GET http://localhost:8080/products/PROD-001
Content-Type: application/json

###

PUT http://localhost:8080/products/PROD-001
Content-Type: application/json

{
"id": "PROD-001",
"prodName": "Buku Sinar Dunia Akhirat",
"prodDesc": "Buku Sinar Dunia Akhirat",
"prodPrice": 2500,
"prodImage": "https://upload.wikimedia.org/wikipedia/commons/c/ce/Intel_Core_i7_Logo_2020.png"
}

<> 2024-06-24T111624.200.json

###

DELETE http://localhost:8080/products/PROD-002
Content-Type: application/json
