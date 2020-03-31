package RMI_Plugin;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AppServer extends UnicastRemoteObject implements AppContainer {

    protected AppServer() throws RemoteException {
    }

    @Override
    public Object run(Plugin p) {
        System.out.println("Uruchamiam obliczenie: " + p.getClass());
        return p.compute();
    }

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());

        try {
            AppServer server = new AppServer();

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(args[0], server);

            System.out.println("Server zarejestrowal sie");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
