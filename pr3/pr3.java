import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pr3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Loading MySQL JDBC driver

            // Establishing connection to the MySQL database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            Statement st = con.createStatement();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int ch = 0, rno, n;
            String na;

            // Menu-driven program for basic CRUD operations
            do {
                System.out.println("Database manipulation using JDBC");
                System.out.println("1.Insert\n2.Delete\n3.Update\n4.Display\n5.Exit");
                System.out.println("Enter your choice:");
                ch = Integer.parseInt(br.readLine());

                switch (ch) {
                    case 1: // Insert
                        System.out.println("Enter id to insert:");
                        rno = Integer.parseInt(br.readLine());
                        System.out.println("Enter name to insert:");
                        na = br.readLine();
                        try (PreparedStatement insertStmt = con
                                .prepareStatement("INSERT INTO student (id, name) VALUES (?, ?)")) {
                            insertStmt.setInt(1, rno);
                            insertStmt.setString(2, na);
                            n = insertStmt.executeUpdate();
                            System.out.println(n + " row(s) Inserted!");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2: // Delete
                        System.out.println("Enter Id to delete:");
                        rno = Integer.parseInt(br.readLine());
                        try (PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM student WHERE id = ?")) {
                            deleteStmt.setInt(1, rno);
                            n = deleteStmt.executeUpdate();
                            System.out.println(n + " row(s) Deleted!");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3: // Update
                        System.out.println("Enter Id to edit:");
                        rno = Integer.parseInt(br.readLine());
                        System.out.println("Enter new name:");
                        na = br.readLine();
                        try (PreparedStatement updateStmt = con
                                .prepareStatement("UPDATE student SET name = ? WHERE id = ?")) {
                            updateStmt.setString(1, na);
                            updateStmt.setInt(2, rno);
                            n = updateStmt.executeUpdate();
                            System.out.println(n + " row(s) Updated!");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4: // Display
                        try (ResultSet rs = st.executeQuery("SELECT * FROM student")) {
                            System.out.println("ID\tName\n*****************");
                            while (rs.next()) {
                                System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5: // Exit
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } while (ch != 5);

            // Closing resources
            br.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
