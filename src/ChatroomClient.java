import java.io.*;
import java.net.*;
import java.util.Scanner;	
import java.net.ServerSocket;
import java.net.Socket;

public class ChatroomClient {

	public static void main(String[] args) throws Exception {
		
		try {
			Socket sockets - new Socket("ip addreess", 4545);
			
			DataOutputStream outside = new DataOutputStream(sockets.getOutputStream());
			DataInputStream inside = new DataInputStream(sockets.getInputStream());
			
			Socket connection = new Socket("localhost", 80);
			
			DataOutputStream os = new DataOutputStream(connection.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
			String message = is.readLine();
			System.out.println("FROM SERVER: " + message);

			os.close();
			connection.close();
		} 
		
	}

}
