import java.rmi.*;
import java.rmi.server.*;

@SuppressWarnings("serial")
public class CarImpl extends UnicastRemoteObject implements CarInterface {
	
	public CarImpl() throws RemoteException {
		super();
	}
	
	
	@Override
	public String register(Car c) throws RemoteException {
		return "DR" + c.hashCode();
	}
}
