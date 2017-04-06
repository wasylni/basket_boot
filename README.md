#### (simpified) spring boot shopping basket implementation/sample
`org.springframework.boot`  `v1.5.2.RELEASE`


###### requirements:

_1. Add a quantity of an item to the basket_

_2. Update the quantity of an item in the basket_

_3. Delete the item from the basket_

_4. Get the contents of the basket_

_5. Get to total cost for the basket (an item should have a unit cost)_


![alt text](http://www.free-icons-download.net/images/shopping-cart-logo-icon-70706.png "cart")


###### Compile:

```bash 
mvn compile
```

###### Run:

```bash
mvn exec:java
```

###### Test:

```bash
mvn test
```


###### Add item to the basket:

`/add/{basketId}/{itemSku}/{itemQuantity}`

POST <http://localhost:8080/add/1/10001/10>

###### Calculate basket total:

`/total/{basketId}/{currencyCode}`

GET <http://localhost:8080/total/1/GBP>

###### Show basket:

`/content/{basketId}`

GET <http://localhost:8080/content/1>

###### Update basket item count:

`/update/{basketId}/{itemSku}/{itemQuantity}`

POST <http://localhost:8080/update/1/10001/1>

###### Remove from basket item count:

`/remove/{basketId}/{itemSku}/{itemQuantity}`

DELETE <http://localhost:8080/remove/1/10001/1>
