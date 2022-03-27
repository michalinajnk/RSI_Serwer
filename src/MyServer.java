import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
            return;
        }
        //-- pkt 7
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        //--END
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager()
            );
        try {
            CalcObjectImpl implObiektu = new CalcObjectImpl();
            java.rmi.Naming.rebind(args[0], implObiektu);
            //-- pkt 5
            CalcObjectImpl2 implObiektu2 = new CalcObjectImpl2();
            java.rmi.Naming.rebind(args[1], implObiektu2);
            //--END
            System.out.println("Server is registered now :-)");
            System.out.println("Press Crl+C to stop...");
        } catch (Exception e) {
            System.out.println("SERVER CAN'T BE REGISTERED!");
            e.printStackTrace();
            return;
        }
    }
}