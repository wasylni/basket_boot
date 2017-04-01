######Requirements

######The application should be able to:

_1. Add a quantity of an item to the basket_

_2. Update the quantity of an item in the basket_

_3. Delete the item from the basket_

_4. Get the contents of the basket_

_5. Get to total cost for the basket (an item should have a unit cost)_


![alt text](http://www.free-icons-download.net/images/shopping-cart-logo-icon-70706.png "cart")




Service based on `org.springframework.boot` ver `1.5.2.RELEASE`


###### Compile:

```bash 
mvn compile
```

###### Run:

```bash
mvn exec:java
```

###### Load test items:

<http://localhost:8080/loadItems>

###### List test items:

<http://localhost:8080/listItems>


###### Add item to the basket:

<http://localhost:8080/add/1/10001/10>

###### Calculate basket total:

<http://localhost:8080/total/1/GBP>

###### Show basket:

<http://localhost:8080/content/1>

###### Update basket item count:

<http://localhost:8080/update/1/10001/1>


###### Remove from basket item count:

<http://localhost:8080/remove/1/10001/1>
