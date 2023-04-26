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
					
					int fact = 1;
					for(int i=n; i>=1; i--)
					{
						fact = fact*i;
					}
					System.out.println("Result sent to Client.");
					out.println(fact);
				} catch (NumberFormatException | IOException e) 
				{
					System.err.println("Error handling client request: " + e.getMessage());
				}
		}
	}
}
