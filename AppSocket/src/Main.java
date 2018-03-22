import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(9000);
			System.out.println("Esperando peticiones......");
			while(true) {
				Socket sc = server.accept();
				System.out.println("Peticion recibida");
				new HiloCliente(sc).start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
