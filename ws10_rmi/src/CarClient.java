import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CarClient {
	public static void main(String[] args) throws RemoteException {
		try {
			CarInterface c = (CarInterface) Naming.lookup("rmi://localhost:8000/Server");
			System.out.println("Client Started!");

			Car[] cars = new Car[3];
			cars[0] = new Car("Toyata Corolla", "Dawn M", 1000);
			cars[1] = new Car("Honda Civic", "Edward H", 2000);
			cars[2] = new Car("Volvo S70", "Raymond B", 3000);
			for(int i = 0; i < 3; i++ ){
				System.out.println("\n### send this car to the server for registration:\n" + cars[i]);
				cars[i].getRegistered(c.register(cars[i]));
				System.out.println("\t###### the car returned by the server:\n"+ cars[i]);
			}
		} catch (MalformedURLException murle) {
			System.out.println("MalformedURLException");
			System.out.println(murle);
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (NotBoundException nbe) {
			System.out.println("NotBoundException");
			System.out.println(nbe);
		} catch (java.lang.ArithmeticException ae) {
			System.out.println("java.lang.ArithmeticException");
			System.out.println(ae);
		}
	}
}
