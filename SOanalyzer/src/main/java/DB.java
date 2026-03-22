import com.google.gson.JsonParser;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import org.json.JSONObject;
import com.j256.ormlite.support.ConnectionSource;

import java.io.*;
import java.sql.SQLException;

public class DB {
    public static ConnectionSource getConnection() throws SQLException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:SOPosts";
        // create a connection source to our database
         return new JdbcConnectionSource(databaseUrl);
    }
    public static void createTable() {

    }
    public static void main(String[] args) {

        // The name of the file to open.
        String fileName = "versions.json";
        ConnectionSource connection;
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                JSONObject obj = null;
                try {
                    obj = new JSONObject(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
