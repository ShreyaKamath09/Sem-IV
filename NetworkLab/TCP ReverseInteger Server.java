import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args) throws IOException {
		int portNumber = 8080;
		ServerSocket serverSocket = new ServerSocket(portNumber);
		System.out.println("Server Started.");
		
		while(true)
		{
			try(Socket clientSocket = serverSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
					System.out.println("Client Connected.");
					
					String number = in.readLine();
					int n = Integer.parseInt(number);
					
					int rev = 0;
					int a;
					while(n!=0)
					{
						a = n%10;
						rev = rev*10 + a;
						n = n/10;
					}
					System.out.println("Result sent to Client.");
					out.println(rev);
				} catch (NumberFormatException | IOException e) 
				{
					System.err.println("Error handling client request: " + e.getMessage());
				}
		}
	}
}
