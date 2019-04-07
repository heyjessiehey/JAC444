import java.rmi.RemoteException;
import java.rmi.Remote;

public interface CarInterface extends Remote {
	String register(Car c) throws RemoteException;
}
