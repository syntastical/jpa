## Micronaut 3.0.3 Documentation

- [User Guide](https://docs.micronaut.io/3.0.3/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.0.3/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.0.3/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Working with Docker
1. List only running containers  ```docker ps```
2. List all containers ```docker ps -a```
3. Get a shell in a docker container ```docker exec -it some-mysql bash```

## Working with MYSQL
1. Connect to the database ```mysql -pmy-secret-pw```
2. Select all columns from a table ```select * from TABLE_NAME```
3. Delete all records/rows from a table ```delete from TABLE_NAME```
4. Insert record/row into a table ```insert into TABLE_NAME(COL1, COL2) values (COL1_VALUE, COL2_VALUE)```
5. Drop table ```drop TABLE_NAME```
6. List databases ```show databases;```
7. List tables ```show tables;```