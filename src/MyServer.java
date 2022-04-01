import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer {
    /*
    public MyServer() {
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
        } else {
            try {
                Registry var1 = LocateRegistry.createRegistry(1099);
            } catch (RemoteException var4) {
                var4.printStackTrace();
            }

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            try {
                CalcObjectImpl implObiektu = new CalcObjectImpl();
                Naming.rebind(args[0], implObiektu);
                CalcObjectImpl2 implObiektu2 = new CalcObjectImpl2();
                Naming.rebind(args[1], implObiektu2);
                System.out.println("Server is registered now :-)");
                System.out.println("Press Crl+C to stop...");
            } catch (Exception var3) {
                System.out.println("SERVER CAN'T BE REGISTERED!");
                var3.printStackTrace();
            }
        }
    }

     */
}