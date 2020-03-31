import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface Notification extends Remote {
    void submit(Event e) throws RemoteException;
    List<Event> get() throws RemoteException;
}