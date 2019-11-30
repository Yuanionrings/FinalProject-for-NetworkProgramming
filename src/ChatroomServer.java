import java.io.*;
import java.net.*;
import java.util.Scanner;	
import java.net.ServerSocket;
import java.net.Socket;

public class ChatroomServer {
	
	public static void main(String[] args) throws Exception {
	
			try {
			
			System.out.print("testing");
			
			ServerSocket serversockets = new ServerSocket(4545);
	
			Socket sockets = serversockets.accept();
			
			DataOutputStream outside = new DataOutputStream(sockets.getOutputStream());
			DataInputStream inside = new DataInputStream(sockets.getInputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(inside));
			
			String inMessage;
			String outMessage = " ";

			   inMessage = inside.readUTF();

			while(!inMessage.isEmpty()) {
				
				inMessage = inside.readUTF();
				System.out.print(inMessage);
				
				outside.writeUTF(outMessage);
				outside.flush();
			}
			
			System.out.print("Text chat has ended");

			sockets.close();
			serversockets.close();
			
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
}
