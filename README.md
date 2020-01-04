# JavaBrainsDataAccessSpring

### JDBC Without Spring - (Unit 1 - JDBC Without Spring video)
Key learning: use JDBC directly to get data from Derby database. 
Please refer to the JdbcDaoImpl.java class for the code.

### Data Source configuration in Spring - (Unit 2 - Adding Spring and DataSource Configuration video)
Key learning: How Spring can make database connection and data retrieval code simple.
1. ```<context:component-scan base-package="com.lichen.javabrains" />``` makes any java classes annotated by @Component Spring beans.
2. Move the java code for the database coonection to the spring.xml for configuration.
3. DBCP DataSource model is better than Spring's DataSOurce module, because it supports database pooling.

### JDBC Template - (Unit 2 - Using JdbcTemplate video)
Key learning: Using template to define code for: before query execution and after query execution.
1. create JdbcTemplate class and DataSource class. Assign the DataSOurce to JdbcTemplate when it is created. See the JdbcDaoImpl java class for the code.

### Other JDBC Template - (Unit 2 - Return Other Datatypes from JdbcTemplate video)
Key learning: Using template to return String when the sql contains query paramenters. jdbcTemplate.queryForObject() method is used for this.

### Implementing RowMapper - (Unit 2 - Implementing RowMapper video)
Key learning: how to implement the RowMapper to get the custom object from database table in the row format.

### Insert Data into Table - (Unit 2 - Performing Write Operations with JdbcTemplate video)
Key learning: how to implement insert records and create new tables.

### Named Parameter JDBC Template - (Unit 2 - Named Parameter JDBC Template video)
Key learning: 1) NamedParameterJdbcTemplate java class and SqlParameterSource java interface. 2) SimpleJdbcTemplate

### DAO Support Class - (Unit 2 - DAO Support Class)
Key learning: ABstract away DataSOurce creation into spring.xml using the Support class
