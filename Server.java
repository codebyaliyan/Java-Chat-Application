import java.io.*;
import java.net.*;
import java.util.*;

//import Chat_Application.Server.ClientHandling;

public class Server {
    private static final int Port = 12345;
    private static List<ClientHandling> allClients = new ArrayList<>();
    private static String adminName = "Admin";

    public static void SendMessage(String msg){
        String adminMessage = adminName + " : "+msg;
        for(ClientHandling client : allClients){
            client.msgout.println(adminMessage);
        }
    }

    public static void main(String[] args) throws IOException {

            ServerSocket serverS = new ServerSocket(Port);
            System.out.println("Server is connected on port : "+Port);

            Thread adminMessage = new Thread(new Runnable(){
                    public void run(){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Your Name : ");
                    String inputName = sc.nextLine();

                    if(!inputName.isEmpty()){
                        adminName = inputName;
                    }
                    while(true){
                        String msg = sc.nextLine();
                        SendMessage(msg);
                    }
                }    
            });
            adminMessage.start();

            while(true){
                Socket clientS = serverS.accept();
                System.out.println("New Client Connected");

                ClientHandling CHandler = new ClientHandling(clientS);
                allClients.add(CHandler);
                CHandler.start();
            }
    }
    
    static class ClientHandling extends Thread{
        private Socket socket;
        private PrintWriter msgout;// to send message
        private BufferedReader msgin;// to receive message

        public ClientHandling(Socket socket){
            this.socket = socket;
            try{
                msgout = new PrintWriter(socket.getOutputStream(), true);
                msgin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            }
            catch(IOException e){
                System.out.println("Can't Connect The Client");
            }
        }

        public void run(){
            try{
                String msg;
                while((msg = msgin.readLine()) != null){
                    System.out.println("Message from client: "+msg);
                    sendToAllClients(msg);
                }
            }
            catch(IOException e){
                System.out.println("Client Got Disconneted");
            }
            finally{
                allClients.remove(this);
                try{
                    socket.close();
                }
                catch(IOException e){
                    System.out.println("Can't Close the Socket");
                }
            }
        }
        private void sendToAllClients(String msg){
            for(ClientHandling client : allClients){
                client.msgout.println(msg);
            }
        }
    }
}
