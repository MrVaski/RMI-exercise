package RMI_Plugin;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppClient {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());

        try {
            Registry registry = LocateRegistry.getRegistry(args[0]);
            AppContainer appContainer = (AppContainer) registry.lookup(args[1]);

            Plugin p = new FibPlugin(Integer.parseInt(args[2]));
            System.out.println("Fib dla " + args[2] + " = " + appContainer.run(p));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
