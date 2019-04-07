import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class CarServer {
	public static void main(String args[]) {
		try {
			CarInterface stub = new CarImpl();
			LocateRegistry.createRegistry(8000);
		    Naming.rebind("rmi://localhost:8000/Server", stub);
		    System.out.println("Server Started!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}