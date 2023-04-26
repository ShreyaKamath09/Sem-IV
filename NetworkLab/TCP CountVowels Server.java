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
					
					String sentence = in.readLine();
				
					int count = 0;
					for(int i=0; i<sentence.length(); i++)
					{
						char c = sentence.charAt(i);
						if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
						{
							count++;
						}
					}
					System.out.println("Result sent to Client.");
					out.println(count);
				} catch (NumberFormatException | IOException e) 
				{
					System.err.println("Error handling client request: " + e.getMessage());
				}
		}
	}
}
			
					
			
					
		
