//Used to connect Java GUI with database. Comments are not implemented.
package functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import UIWindows.QueryDisplay;
import java.util.ArrayList;
 
/**
 * This program demonstrates how to make database connection with Oracle
 
 *
 */
public class OConnect {
    QueryDisplay QD = new QueryDisplay();
    public Object[] createTables(String[] ct){
        Connection conn1 = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String dbURL1 = "REPLACE_WITH_ADDRESS";
            conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                //System.out.println("Connected with connection #1");
            }
            
            try (Statement stmt = conn1.createStatement()) {
                for(String createTableValue : ct){
                    stmt.executeUpdate(createTableValue);
                }
                //PreparedStatement preparedStatement;
//                for(String insertValue : it){
//                    preparedStatement = conn1.prepareStatement(insertValue);
//                    preparedStatement.executeUpdate();
//                    //stmt.executeUpdate(insertValue);
//                }
                
                //stmt.executeUpdate(s);
                System.out.println("Tables have been created sucessfully.");
                return new Object[]{0, "Tables have been created sucessfully."};
            } catch (SQLException e) {
                    System.out.println("Error caught: could not create tables." );
                    System.out.println(e.getErrorCode());
                    return new Object[]{1, "Error caught: could not create tables."};
                    
            }
            
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return new Object[]{1, "Error: connection not found."};
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new Object[]{1, "Error - SQLException: " + ex};
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
     
            } catch (SQLException ex) {
                ex.printStackTrace();
                return new Object[]{1, "Error - SQLException: " + ex};
            }
        }
        
    }
    
    public Object[] dropTables(){
        Connection conn1 = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String dbURL1 = "REPLACE_WITH_ADDRESS";
            conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                //System.out.println("Connected with connection #1");
            }
            
            try (Statement stmt = conn1.createStatement()) {
                String[] dropTableArray = {"accessories", "cardescription", "cardropoff", "carpickup", "coverage",
            "cusdetails", "cusinsurance", "customer", "paymentdetails", "promotion",
            "purchasedetails", "reservation", "services"};
                
                for(String tableName : dropTableArray){
                    String dropTableSQL = "DROP TABLE " + tableName;
                    stmt.executeUpdate(dropTableSQL);
                }
                
                //stmt.executeUpdate(s);
                System.out.println("Tables have been dropped sucessfully.");
                return new Object[]{0, "Tables have been dropped sucessfully."};
                
            } catch (SQLException e) {
                System.out.println("Error caught: " + e);
                System.out.println(e.getErrorCode());
                return new Object[]{1, "Error: could not drop tables."};
            }
            
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return new Object[]{1, "Error: connection not found."};
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new Object[]{1, "Error - SQLException: " + ex};
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
     
            } catch (SQLException ex) {
                ex.printStackTrace();
                return new Object[]{1, "Error - SQLException: " + ex};
            }
        }
        
    }
    
    
    
    public Object[] populateTables(String[] insertArray){
        Connection conn1 = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String dbURL1 = "REPLACE_WITH_ADDRESS";
            conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                //System.out.println("Connected with connection #1");
            }
            
            try (Statement stmt = conn1.createStatement()) {
                String[] dropTableArray = {"accessories", "cardescription", "cardropoff", "carpickup", "coverage",
            "cusdetails", "cusinsurance", "customer", "paymentdetails", "promotion",
            "purchasedetails", "reservation", "services"};
                
                PreparedStatement preparedStatement;
                int addedRows = 0;
                for(String insertValues : insertArray){
                    preparedStatement = conn1.prepareStatement(insertValues);
                    addedRows += preparedStatement.executeUpdate();
                    //stmt.executeUpdate(dropTableSQL);
                }
                
                if(addedRows > 0){
                    System.out.println("" + addedRows + " row(s) inserted successfully.");
                    return new Object[]{0, "" + addedRows + " row(s) inserted successfully."};
                }else{
                    System.out.println("No rows inserted.");
                    return new Object[]{0, "No rows inserted."};
                }
                
                //stmt.executeUpdate(s);
                //System.out.println("Tables have been dropped sucessfully.");
                
            } catch (SQLException e) {
                System.out.println("Error caught: " + e);
                System.out.println(e.getErrorCode());
                return new Object[]{1, "Error: could not populate tables."};
            }
            
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return new Object[]{1, "Error: connection not found."};
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new Object[]{1, "Error - SQLException: " + ex};
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
     
            } catch (SQLException ex) {
                ex.printStackTrace();
                return new Object[]{1, "Error - SQLException: " + ex};
            }
        }
        
        
    }

    
    public void printQuery(String s){
        
        String queryString = "";
        Connection conn1 = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String dbURL1 = "REPLACE_WITH_ADDRESS";
            conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                //System.out.println("Connected with connection #1");
            }
            
            String query = s;
            try (Statement stmt = conn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

                ResultSet rs = stmt.executeQuery(query);
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                String[] vars = new String[columnCount];
                String title = "";
                for(int i = 1; i <= columnCount; i++){
                    vars[i-1] = metaData.getColumnName(i);
                    if(i == 1){
                        title += vars[i-1];
                        queryString += vars[i-1];
                    }
                    else{
                        title += ", " + vars[i-1];
                        queryString += ", " + vars[i-1];
                    }
                }
                System.out.println(title);
                queryString += "\n";
                for(int i = 0; i < title.length(); i++){
                    System.out.print("-");
                    queryString += "-";
                }
                System.out.println("");
                queryString += "\n";
                
                
                rs.last();
                int rows = rs.getRow();
                rs.beforeFirst();
                int currentRow = 0;
                Object[][] rowData = new Object[rows][columnCount];
                while (rs.next()) {
                    for(int i = 1; i <= columnCount; i++){
                        rowData[currentRow][i-1] = rs.getObject(i);
                    }
                    
                    for (int i = 0; i < vars.length; i++){
                        String stringValue = rs.getString(vars[i]);
                        if(stringValue != null){
                            if(i == 0){
                                System.out.print(stringValue);
                                queryString += stringValue;
                            }
                            else{
                                System.out.print(", " + stringValue);
                                queryString += ", " + stringValue;
                            }
                        }else{
                            int intValue;
                            try{
                                intValue = rs.getInt(vars[i]);
                                if(i == 0){
                                    System.out.print("" + intValue);
                                    queryString += "" + intValue;
                                }
                                else{
                                    System.out.print(", " + intValue);
                                    queryString += ", " + intValue;
                                }
                            }catch(SQLException eInt){
                                double doubleValue = rs.getDouble(vars[i]);
                                if(i == 0){
                                    System.out.print("" + doubleValue);
                                    queryString += "" + doubleValue;
                                }
                                else{
                                    System.out.print(", " + doubleValue);
                                    queryString += ", " + doubleValue;
                                }
                            }
                        }
                    }
                    System.out.print("\n");
                    queryString += "\n";
                    currentRow++;
                         
                }
                QD.setDisplay(vars, rowData);
                rs.close();
                stmt.close();
                //If required, use "conn1.close();"
                
            } catch (SQLException e) {
                System.out.println("Error caught: " + e);
                System.out.println(e.getErrorCode());
            }
            
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
     
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
        
        
    }
    
    
    
    
    public static void main(String[] args) {
 
        Connection conn1 = null;

        try {
            // registers Oracle JDBC driver - though this is no longer required
            // since JDBC 4.0, but added here for backward compatibility
            Class.forName("oracle.jdbc.OracleDriver");
 
           
         //   String dbURL1 = "REPLACE_WITH_ADDRESS";  // that is school Oracle database and you can only use it in the labs
																					     
             String dbURL1 = "REPLACE_WITH_ADDRESS";
			/* This XE or local database that you installed on your laptop. 1521 is the default port for database, change according to what you used during installation. 
			xe is the sid, change according to what you setup during installation. */
			
			conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                System.out.println("Connected with connection #1");
            }
 
 		
			
		
            //In your database, you should have a table created already with at least 1 row of data. In this select query example, table testjdbc was already created with at least 2 rows of data with columns NAME and NUM.
			//When you enter your data into the table, please make sure to commit your insertions to ensure your table has the correct data. So the commands that you need to type in Sqldeveloper are
			// CREATE TABLE TESTJDBC (NAME varchar(8), NUM NUMBER);
            // INSERT INTO TESTJDBC VALUES ('ALIS', 67);
            // INSERT INTO TESTJDBC VALUES ('BOB', 345);
            // COMMIT;
			
			String query = "select FIRST, HOUSENUM from CUSDETAILS";
							
			try (Statement stmt = conn1.createStatement()) {

			ResultSet rs = stmt.executeQuery(query);

			//If everything was entered correctly, this loop should print each row of data in your TESTJDBC table.
			// And you should see the results as follows:
			// Connected with connection #1
			// ALIS, 67
			// BOB, 345
			while (rs.next()) {
				String name = rs.getString("FIRST");
				int num = rs.getInt("HOUSENUM");
				System.out.println(name + ", " + num);
			}
			} catch (SQLException e) {
				System.out.println(e.getErrorCode());
			}


 
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
     
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
			

        
        
        
    }
}
