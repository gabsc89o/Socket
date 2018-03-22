import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HiloCliente extends Thread {
	Socket sc;
	public HiloCliente(Socket s) {
		this.sc = s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		InputStream entrada=null;
		PrintStream salida = null;
		try {
			entrada = sc.getInputStream();
			salida = new PrintStream(sc.getOutputStream());
			BufferedReader bf = new BufferedReader(new InputStreamReader(entrada));
			int num = Integer.parseInt(bf.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for(int i=1;i<=10;i++) {
				sb.append(num*i+",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("]");
			salida.println(sb.toString());
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
