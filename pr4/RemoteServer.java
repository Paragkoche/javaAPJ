
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServer extends UnicastRemoteObject implements RemoteInterface {
    public RemoteServer() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return (a + b);
    }

    public int sub(int a, int b) throws RemoteException {
        return (a - b);
    }

    public int mul(int a, int b) throws RemoteException {
        return (a * b);
    }

    public int div(int a, int b) throws RemoteException {
        return (a / b);
    }

    public int mod(int a, int b) throws RemoteException {
        return (a % b);
    }

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099); // Create and start a registry on port 1099
            System.out.println("RMI registry ready.");
            RemoteServer server = new RemoteServer();
            java.rmi.Naming.rebind("//localhost/RemoteServer", server); // Bind this object instance to the name
                                                                        // "RemoteServer"
            System.out.println("Server ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
