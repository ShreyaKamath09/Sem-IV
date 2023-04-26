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
		
		String str;
		while(true)
		{
			System.out.println("Enter a sentence:");
			str = stdin.readLine();
			
			out.println(str);
			
			if (str.equals("exit")) {
                break;
            }
			
			String response = in.readLine();
			System.out.println("No. of vowels: "+response);
		}
	}
}
