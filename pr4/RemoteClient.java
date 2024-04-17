
import java.io.DataInputStream;
import java.rmi.Naming;
import java.util.Scanner;

public class RemoteClient {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            RemoteInterface obj = (RemoteInterface) Naming.lookup("//localhost/RemoteServer");
            System.out.println("ENTER THE VALUES FOR a & b:");
            int a = input.nextInt();
            int b = input.nextInt();
            System.out.println(a + "  " + b);
            System.out.println("ADDITION=" + obj.add(a, b));
            System.out.println("SUBTRACTION=" + obj.sub(a, b));
            System.out.println("MULTIPLICATION=" + obj.mul(a, b));
            System.out.println("DIVISION=" + obj.div(a, b));
            System.out.println("MODULODIVISION=" + obj.mod(a, b));
            input.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
