## spring-boot-hibernate-crud-demo
#Blogs
Database used is postgres and it is very easy to use and can handle much data and is now most active database which is used for handling data.

Curl For getting  blogs
curl --location --request GET 'http://localhost:8089/blog'


Curl For getting blog by id
curl --location --request GET 'http://localhost:8089/blog/1'

Curl for posting blog
curl --location --request POST 'http://localhost:8089/blog' \
--header 'Content-Type: application/json' \
--data-raw '{
    "BlogTitle":"Java",
    "BlogDate":"30-07-2021",
    "BlogContent":"Development"
}'



Curl for updating blog
curl --location --request POST 'http://localhost:8089/blog' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":1,
    "BlogTitle":"Java",
    "BlogDate":30-07-2021,
    "BlogContent":"Development"
}'


Curl for deleting blog

curl --location --request Delete 'http://localhost:8089/blog/1'



TECH STACK USED
• Lombok
• Dev-tools
• Spring-starter
• Postman
• Postgres
• Hibernate



