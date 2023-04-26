import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args)throws IOException{
		String serverHostname = "localhost";
		int serverPort = 8080;
		Socket socket = new Socket(serverHostname, serverPort);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		String num1;
		while(true)
		{
			System.out.println("Enter a number:");
			num1 = stdin.readLine();
			
			out.println(num1);
			
			if (num1.equals("exit")) {
                break;
            }
			
			String response = in.readLine();
			System.out.println("Reversed Number: "+response);
		}
	}
}
