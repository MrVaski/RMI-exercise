import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class NotificationServer implements Notification {

    private List<Event> container = new ArrayList<Event>();

    @Override
    public void submit(Event e) throws RemoteException {
        System.out.println("Dodaje zdarzenie: " + e);

        container.add(e);
    }

    @Override
    public List<Event> get() {
        return container;
    }

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());

        try {
            NotificationServer server = new NotificationServer();
            UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(args[0], server);
            System.out.println("Zarejestrowalem sie");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}