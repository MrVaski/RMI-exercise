import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;


public class NotificationClient {

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());

        String host = args[0];
        String name = args[1];

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Notification client = (Notification) registry.lookup(name);

            if(args[2].equals("add")) {
                Event event = new Event(System.currentTimeMillis(), args[1]);
                client.submit(event);
            } else {
                List<Event> list = client.get();
                System.out.println("size " + list.size());

                for (Event event : list) {
                    System.out.println("Event: " + event);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}