#####Requirements

######The application should be able to:

1. Add a quantity of an item to the basket

1. Update the quantity of an item in the basket

1. Delete the item from the basket

1. Get the contents of the basket

1. Get to total cost for the basket (an item should have a unit cost)


Service based on `org.springframework.boot` ver `1.5.2.RELEASE`


###### Compile:

```bash 
mvn compile
```

###### Run:

```bash
mvn exec:java
```

######Load test items:

<http://localhost:8080/loadItems>

######List test items:

<http://localhost:8080/listItems>


######Add item to the basket:

<http://localhost:8080/add/1/10001/10>

######Calculate basket total:

<http://localhost:8080/total/1/GBP>

######Show basket:

<http://localhost:8080/content/1>

######Update basket item count:

<http://localhost:8080/update/1/10001/1>


######Remove from basket item count:

<http://localhost:8080/remove/1/10001/1>
