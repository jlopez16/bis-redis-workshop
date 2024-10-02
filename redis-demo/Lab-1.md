# Lab 1

In this lab we will use the Spring Boot application created in the Spring Boot workshop to add data persistence 
using Cassandra.

## Creating containers

In the `docker-compose.yml` file are defined two services, the first of them correspond to redis and the other one 
to Cassandra. These services use a network named `fusse` that can be used to connect those services.

To execute the script will be necessary to have [Docker](https://www.docker.com/) installed.

Open a terminal and locate to the folder where the project is located and type `docker compose up -d` this command 
will download the images and create the containers for the services.

## Creating the data base

To use Cassandra type the command `docker exec -it cassandra-container cqlsh`, this command will take you to the cql 
prompt.

Lets create the keyspace by copy-pasting the following command:

```sql
CREATE KEYSPACE ledger_keyspace 
WITH REPLICATION = {
    'class': 'SimpleStrategy',
    'replication_factor': 1
};
```

And then this command to define the creation of the table within the keyspace that we have just created.

```sql
CREATE TABLE IF NOT EXISTS ledger_keyspace.ledger (
    accountId text,
    assetType text,
    currency text,
    balance double,
    PRIMARY KEY (accountId)
);
```

## Populating database

In other terminal, let's locate to the `redis-demo` folder, where is a file named `inser_ledger.sql`. To copy this 
file into Cassandra container type `docker cp insert_ledger.cql cassandra-container:/insert_ledger.cql` and to 
execute it `docker exec -it cassandra-container cqlsh -f /insert_ledger.cql`

After the execution of the script has finalized, we can confirm the number of inserted rows by typing `select count
(*) from ledger_keyspace.ledger;` which should show 10,000 rows.

## Adding Cassandra dependency to the project

Let's add the Cassandra Maven dependency to the POM file and reload the file.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-cassandra</artifactId>
</dependency>
```
Additionally it is necessary to add the configurations parameters to `application.properties` file, the lines to be 
specified are these:

```yml
spring.cassandra.contact-points=127.0.0.1 
spring.cassandra.local-datacenter=dc1
spring.cassandra.port=9042  
spring.cassandra.keyspace-name=ledger_keyspace  
spring.cassandra.schema-action=none
```
