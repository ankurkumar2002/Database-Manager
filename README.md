<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Simple JDBC Operations Application</title>
</head>
<body>

  <h1>Simple JDBC Operations Application</h1>

  <h2>Overview</h2>

  <p>This Java Swing application demonstrates basic JDBC operations, allowing users to interact with a MySQL database. The application provides a user-friendly interface for creating a table, inserting data, deleting data, updating data, and retrieving data from the "employee" table in the specified MySQL database.</p>

  <h2>Features</h2>

  <ul>
    <li><strong>Create Table:</strong> Define the structure of the "employee" table with columns for ID, name, and age.</li>
    <li><strong>Insert Data:</strong> Add new records to the "employee" table by providing ID, name, and age.</li>
    <li><strong>Delete Data:</strong> Remove records from the "employee" table based on the provided ID.</li>
    <li><strong>Update Data:</strong> Modify existing records in the "employee" table by updating name and age.</li>
    <li><strong>Retrieve Data:</strong> Display all records from the "employee" table, showing ID, name, and age.</li>
  </ul>

  <h2>Getting Started</h2>

  <ol>
    <li>Clone the repository to your local machine.</li>
    <li>Ensure you have a MySQL server running.</li>
    <li>Update the <code>JDBC_URL</code>, <code>USERNAME</code>, and <code>PASSWORD</code> variables in the <code>App</code> class with your database connection details.</li>
    <li>Compile and run the <code>App</code> class.</li>
    <li>Use the application to perform various JDBC operations on the "employee" table.</li>
  </ol>

  <h2>Requirements</h2>

  <ul>
    <li>Java Development Kit (JDK) 8 or later</li>
    <li>MySQL server</li>
  </ul>

  <h2>Dependencies</h2>

  <ul>
    <li>MySQL Connector/J (version 8.0.26)</li>
  </ul>

  <h2>Contributors</h2>

  <p>Ankur</p>


</body>
</html>
