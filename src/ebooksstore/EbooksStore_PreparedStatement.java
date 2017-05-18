package ebooksstore;

import java.sql.*;
import java.util.Formatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EbooksStore_PreparedStatement {

    public static void insertAutori(String sISBN, String sSECOND_NAME, String sFIRST_NAME) throws SQLException, ClassNotFoundException {
        String user = "APPP";
        String password = "APPP";
        String url = "jdbc:derby://localhost:1527/BOOK;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            String DML = "INSERT INTO AUTORI (ISBN,SECOND_NAME,FIRST_NAME)VALUES (?,?,?)";
            PreparedStatement pstmnt = connection.prepareStatement(DML);
            pstmnt.setString(1, sISBN);
            pstmnt.setString(2, sSECOND_NAME);
            pstmnt.setString(3, sFIRST_NAME);
            pstmnt.execute();
            System.out.println("A new author is inserted into AUTORI table!");
            resultSet = statement.executeQuery("SELECT * FROM AUTORI");

            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                String currentISBN = "";
                String currentSECOND_NAME = "";
                String currentFIRST_NAME = "";
                System.out.println("ISBN           SECOND_NAME      FIRST_NAME");
                System.out.println("==========================================");
                do {
                    currentISBN = resultSet.getString(1);
                    currentSECOND_NAME = resultSet.getString(2);
                    currentFIRST_NAME = resultSet.getString(3);
                    //System.out.println(currentISBN + "   " + currentFirst_Name + "   " + currentFamily_Name); 
                    StringBuilder sb = new StringBuilder();
                    Formatter formatter = new Formatter(sb, Locale.US);
                    formatter.format("%1$-13s   %2$-14s %3$-25s ", currentISBN, currentSECOND_NAME, currentFIRST_NAME);
                    System.out.println(sb.toString());
                    // display the content of table AUTHORS row by row 
                } while (resultSet.next());
            } else {
                System.out.println("No rows found in ResultSet");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public static void insertCarti(String sISBN, String sTITLE, String sPUBLISHING, String sCATEGORY, float sPRICE, int sPAGE) throws SQLException, ClassNotFoundException {
        String user = "APPP";
        String password = "APPP";
        String url = "jdbc:derby://localhost:1527/BOOK;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            //statement.execute("DELETE FROM EBOOKS WHERE ISBN='9786069267974'"); 
            String DML = "INSERT INTO CARTI (ISBN,TITLE,PUBLISHING,CATEGORY,PRICE,PAGE)VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmnt = connection.prepareStatement(DML);
            pstmnt.setString(1, sISBN);
            pstmnt.setString(2, sTITLE);
            pstmnt.setString(3, sPUBLISHING);
            pstmnt.setString(4, sCATEGORY);
            pstmnt.setFloat(5, (float) sPRICE);
            pstmnt.setInt(6, (int) sPAGE);
            pstmnt.execute();
            System.out.println("A new book is inserted into CARTI table!");
            resultSet = statement.executeQuery("SELECT * FROM CARTI");

            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                String currentISBN = "";
                String currentTITLE = "";
                String currentPUBLISHING = "";
                String currentCATEGORY = "";
                double currentPRICE = 0;
                int currentPAGE = 0;
                System.out.println("  ISBN            TITLE                  PUBLISHING                CATEGORY              PRICE     PAGE");
                System.out.println("==========================================================================================================");
                do {
                    currentISBN = resultSet.getString(1);
                    currentTITLE = resultSet.getString(2);
                    currentPUBLISHING = resultSet.getString(3);
                    currentCATEGORY = resultSet.getString(4);
                    currentPRICE = resultSet.getFloat(5);
                    currentPAGE = resultSet.getInt(6);
                    //System.out.println(currentISBN + "     " + currentTitle + "      " + currentPublishing + "       " + currentCategory + "       " + currentPrice + "       " + currentPages); 
                    StringBuilder sb = new StringBuilder();
                    Formatter formatter = new Formatter(sb, Locale.US);
                    formatter.format("%1$-13s   %2$-25s %3$-25s %4$-21s %5$-10s %6$-3s ", currentISBN, currentTITLE, currentPUBLISHING, currentCATEGORY, currentPRICE, currentPAGE);
                    System.out.println(sb.toString());
                } while (resultSet.next());

            } else {
                System.out.println("No rows found in ResultSet");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public static void deletCARTI(String sISBN) throws SQLException {

        String user = "APPP";
        String password = "APPP";
        String url = "jdbc:derby://localhost:1527/BOOK;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            String DML = "DELETE FROM CARTI WHERE ISBN=? ";
            PreparedStatement pstmnt = connection.prepareStatement(DML);
            pstmnt.setString(1, sISBN);
            /*pstmnt.setString(2, sTitle); 
             pstmnt.setString(3, sPublishing); 
             pstmnt.setString(4, sCategory); 
             pstmnt.setFloat(5, (float) sPrice); 
             pstmnt.setInt(6, (int) sPages);;*/
            pstmnt.execute();

            System.out.println("The book number: " + sISBN + " was deleted from the database!");

            resultSet = statement.executeQuery("SELECT * FROM CARTI");

            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                String currentISBN = "";
                String currentTITLE = "";
                String currentPUBLISHING = "";
                String currentCATEGORY = "";
                double currentPRICE = 0;
                int currentPAGE = 0;
                System.out.println("  ISBN            TITLE                  PUBLISHING                CATEGORY              PRICE     PAGE");
                System.out.println("==========================================================================================================");
                do {
                    currentISBN = resultSet.getString(1);
                    currentTITLE = resultSet.getString(2);
                    currentPUBLISHING = resultSet.getString(3);
                    currentCATEGORY = resultSet.getString(4);
                    currentPRICE = resultSet.getFloat(5);
                    currentPAGE = resultSet.getInt(6);
                    //System.out.println(currentISBN + "     " + currentTitle + "      " + currentPublishing + "       " + currentCategory + "       " + currentPrice + "       " + currentPages); 
                    StringBuilder sb = new StringBuilder();
                    Formatter formatter = new Formatter(sb, Locale.US);
                    formatter.format("%1$-13s   %2$-25s %3$-25s %4$-21s %5$-10s %6$-3s ", currentISBN, currentTITLE, currentPUBLISHING, currentCATEGORY, currentPRICE, currentPAGE);
                    System.out.println(sb.toString());
                } while (resultSet.next());

            } else {
                System.out.println("No rows found in ResultSet");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public static void displayCARTI() throws SQLException {

        String user = "APPP";
        String password = "APPP";
        String url = "jdbc:derby://localhost:1527/BOOK;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM CARTI");

            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                String currentISBN = "";
                String currentTITLE = "";
                String currentPUBLISHING = "";
                String currentCATEGORY = "";
                double currentPRICE = 0;
                int currentPAGE = 0;
                System.out.println("  ISBN            TITLE                  PUBLISHING                CATEGORY              PRICE     PAGE");
                System.out.println("==========================================================================================================");
                do {
                    currentISBN = resultSet.getString(1);
                    currentTITLE = resultSet.getString(2);
                    currentPUBLISHING = resultSet.getString(3);
                    currentCATEGORY = resultSet.getString(4);
                    currentPRICE = resultSet.getFloat(5);
                    currentPAGE = resultSet.getInt(6);
                    //System.out.println(currentISBN + "     " + currentTitle + "      " + currentPublishing + "       " + currentCategory + "       " + currentPrice + "       " + currentPages); 
                    StringBuilder sb = new StringBuilder();
                    Formatter formatter = new Formatter(sb, Locale.US);
                    formatter.format("%1$-13s   %2$-25s %3$-25s %4$-21s %5$-10s %6$-3s ", currentISBN, currentTITLE, currentPUBLISHING, currentCATEGORY, currentPRICE, currentPAGE);
                    System.out.println(sb.toString());
                } while (resultSet.next());

            } else {
                System.out.println("No rows found in ResultSet");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public static void addRATING(String sISBN, Integer sUSER_RATING, String sUSER_CNP, String sBOOK_TITLE) throws SQLException {

        String user = "APPP";
        String password = "APPP";
        String url = "jdbc:derby://localhost:1527/BOOK;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            String DML = "INSERT INTO RATING (ISBN, USER_RATING, USER_CNP, BOOK_TITLE)VALUES (?,?,?,?)";
            PreparedStatement pstmnt = connection.prepareStatement(DML);
            pstmnt.setString(1, sISBN);
            pstmnt.setInt(2, sUSER_RATING);
            pstmnt.setString(3, sUSER_CNP);
            pstmnt.setString(4, sBOOK_TITLE);
            pstmnt.execute();

            System.out.println("A book was rated!");
            resultSet = statement.executeQuery("SELECT * FROM RATING");
            //statement.execute("SELECT * FROM RATINGS"); 
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                String currentISBN = "";
                Integer currentUSER_RATING = 0;
                String currentUSER_CNP = "";
                String currentBOOK_TITLE = "";

                System.out.println("    ISBN       USER_RATING     USER_CNP             BOOK_TITLE");
                System.out.println("==================================================================");
                do {
                    currentISBN = resultSet.getString(1);
                    currentUSER_RATING = resultSet.getInt(2);
                    currentUSER_CNP = resultSet.getString(3);
                    currentBOOK_TITLE = resultSet.getString(4);
                    System.out.println(currentISBN + "     " + currentUSER_RATING + "     " + currentUSER_CNP + "      " + currentBOOK_TITLE);
                } while (resultSet.next());

            } else {
                System.out.println("No rows found in ResultSet");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public static void displayRecords() throws SQLException {

        String user = "APPP";
        String password = "APPP";
        String url = "jdbc:derby://localhost:1527/BOOK;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT CARTI.ISBN, CARTI.TITLE, AUTORI.SECOND_NAME, AUTHORS.FIRST_NAME, CARTI.PUBLISHING, CARTI.CATEGORY, CARTI.PRICE, CARTI.PAGE, RATING.USER_RATING\n"
                    + "FROM CARTI,AUTORI, RATING\n"
                    + "WHERE CARTI.ISBN=AUTORI.ISBN AND CARTI.ISBN=RATING.ISBN AND AUTORI.ISBN=RATING.ISBN");

            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                String currentISBN = "";
                String currentTITLE = "";
                String currentSECOND_NAME = "";
                String currentFIRST_NAME = "";
                String currentPUBLISHING = "";
                String currentCATEGORY = "";
                String currentPRICE = "";
                String currentPAGE = "";
                String currentUSER_RATING = "";

                System.out.println("    ISBN             TITLE                  AUTHOR               PUBLISHING           CATEGORY       PRICE     PAGE    RATING");
                System.out.println("==================================================================================================================================");
                do {
                    currentISBN = resultSet.getString(1);
                    currentTITLE = resultSet.getString(2);
                    currentSECOND_NAME = resultSet.getString(3);
                    currentFIRST_NAME = resultSet.getString(4);
                    currentPUBLISHING = resultSet.getString(5);
                    currentCATEGORY = resultSet.getString(6);
                    currentPRICE = resultSet.getString(7);
                    currentPAGE = resultSet.getString(8);
                    currentUSER_RATING = resultSet.getString(9);

                    //System.out.println(currentISBN + "     " + currentTitle+ "     " + currentFirst_Name + "     " + currentFamily_Name + "      " + currentPublishing + "      " + currentCategory + "       " + currentPrice + "       " + currentPages + "       " + currentRating); 
                    StringBuilder sb = new StringBuilder();
                    Formatter formatter = new Formatter(sb, Locale.US);
                    formatter.format("%1$-14s %2$-22s %3$-11s %4$-15s %5$-18s %6$-15s %7$-10s %8$-10s %9$-3s", currentISBN, currentTITLE, currentSECOND_NAME, currentFIRST_NAME, currentPUBLISHING, currentCATEGORY, currentPRICE, currentPAGE, currentUSER_RATING);
                    System.out.println(sb.toString());
                } while (resultSet.next());

            } else {
                System.out.println("No rows found in ResultSet");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            insertAutori("978606926793", "IOAN", "SLAVICI");
            insertCarti("9786069267973", "MARA", "CORINT", "LITERATURA", (float) 21.50, 160);
            deleteCarti("9786069267973");
            displayCarti();

            displayRecords();
        } catch (SQLException ex) {
            Logger.getLogger(EbooksStore_PreparedStatement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void deleteCarti(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void displayCarti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void addRating(String string, String jocuri_de_cazino, int i, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
