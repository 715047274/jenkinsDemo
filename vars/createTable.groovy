@Grab(group='org.xerial.sqlite-jdbc', module='sqlite-jdbc', version='3.36.0.3')
import groovy.sql.Sql

 def call(){
     // SQLite database file path
     def dbFilePath = "./database.db"

     // Connection URL for SQLite (jdbc:sqlite: followed by the database file path)
     def dbUrl = "jdbc:sqlite:${dbFilePath}"

     // SQL command to create a table
     def createTableSql = """
        CREATE TABLE IF NOT EXISTS users (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            username TEXT NOT NULL,
            email TEXT NOT NULL
        );
    """

     // Sample data to insert into the table
     def sampleData = [
             ["Alice", "alice@example.com"],
             ["Bob", "bob@example.com"],
             ["Charlie", "charlie@example.com"]
     ]

     // Use the groovy.sql.Sql class to execute SQL commands
     def sql = Sql.newInstance(dbUrl)

     // Create the table
     sql.execute(createTableSql)

     // Insert sample data into the table
     sampleData.each { data ->
         sql.executeInsert("INSERT INTO users (username, email) VALUES (?, ?)", data)
     }

     // Close the database connection
     sql.close()
 }