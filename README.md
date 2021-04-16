# MAHA Code Test

## Architecture & Technologies 
- Java 11
- Spring Boot
- Maven

My motivation to use sprint boot was because is easier to up a server, and an endpoint I utilize
it too dependency injection.
I create a interface to database and a Mock implementation that could be replace for a real database in the future without 
too much maintenance.
I Try to keep the code clean and the class with single responsibility 

### Improves
My last year was coding in functional programming using different folders Structs so I think the folder struct here could
be batter but its ways depends from work agreements to a pattern in the company to a folder struct.


## Run The code

- Compile the project in the main folder in terminal execute:
`mvn clean package`
  
- Execute the jar to up the server: `java -jar target/maha-0.0.1-SNAPSHOT.jar`
  (Make sure that your 8080 port is available)

- Now you can call the service on endpoint `http://localhost:8080/checkout` using some app to make POST request our call in terminal using
`curl -d '["001", "002", "001", "004", "003", "007"]' -H "Content-Type: application/json" -X POST http://localhost:8080/checkout`

- If you need change the database go to `src/main/java/com/zyon/maha/infrastructure/database/ProductMemoryDB.java`
to include, change or remove products. After change this class is necessary to repeat this process to make effect
