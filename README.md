# Starting
For execute this project you should have the following programs installed:
- [JDK 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven](http://maven.apache.org/download.cgi)

### Construção

For construct the project using Maven execute the following commands: 

```shell
mvn clean install
```
The command will install all project dependencies.

## Running

```
mvn spring-boot:run
```

## Docker running
```
git clone https://github.com/hickmann/BFF.git
cd BFF
docker-compose up
```
## Comments
```
The project doesn't have unit tests because I had no time to finish then because of the huge return from the Client.
```