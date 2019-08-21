# E-commerce-
An interactive web application full stack project for users to add products(admin only), put listing products to the shopping cart, and check out the items in the shopping cart.  

## Tech Stack
* Front end: JavaScript
* Back end: JAVA8(Eclipse JEE)
* Database: MYSQL 
* Java servlet: Apache Tomcat v9.0
* Framework: Spring, Hibernate

## Configuration
* Spring Security(in memory for admin and JDBC for users)
* Applications(dataSource, sessionFactory, multipartResolver)
* pom.xml(frameworks support)
* server.xml in your server(add a folder to store product images)

## Spring Bean
In order to use inversion of control and dependency injection, we need to use configure classes as Spring Beans. They are done in my xml files.

## Controller 
I use Spring MVC to deal with HTTP request and response.
![alt text](/demo/mvc.jpg)
* HomePage(login and logout)
* Register
* Cart(show cart items)
* CartItem(add and remove items)
* Order
* Product(list all products)

### login
![alt text](/demo/login.png)

### logout
![alt text](/demo/logout.png)

### register
![alt text](/demo/register.png)

### shopping cart
![alt text](/demo/cart.png)

### product listing
![alt text](/demo/product.png)

## Database
I use Hibernate to support database CRUD operations instead of using SQL scripts. In the model package, I build each schema as class, and the dao package provides database operation methods.
![alt text](/demo/db.png)

## Spring Web Flow

### details
![alt text](/demo/1.png)

### confirm
![alt text](/demo/2.png)

### receipt
![alt text](/demo/3.png)

### done
![alt text](/demo/4.png)
