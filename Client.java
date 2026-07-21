import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        Socket socket = new Socket("localhost",12345);
        
        PrintWriter msgout = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader msgin = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
        
        System.out.println("Connected To The Server");
        
        System.out.println("Enter your Name : ");
        String clientName = sc.nextLine();

        Thread sendingMessage = new Thread(new Runnable(){
                public void run(){
                try{
                    String msg;
                    while((msg = msgin.readLine()) != null){
                        System.out.println(msg);
                    }
                }
                catch(IOException e){
                    System.out.println("Message Cannot Be Sent");
                }
            }        
        });

        sendingMessage.start();
        
        while(true){
                    String msg = sc.nextLine();
                    msgout.println("[" + clientName + "]: " + msg); 
        }
    }
}
