package MultiThreaded;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    
    
    public   Consumer<Socket> getConsumer(){
        
        return (clientSocket)->{
            
            try{
                
                PrintWriter toClent=new PrintWriter(clientSocket.getOutputStream());
                toClent.println("Hello from server");
                toClent.close();
                clientSocket.close();
                
                
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        };
    }
    public static void main(String[] args) {
          

         int port=8010;
         Server server=new Server();

         try{
            ServerSocket serverSocket=new ServerSocket(port);

            serverSocket.setSoTimeout(10000);

            System.out.println("Server is listening on port" + port);

            while (true) {
                Socket acceptSocket=serverSocket.accept();
                Thread thread=new Thread(()->server.getConsumer().accept(acceptSocket));
                thread.start();
            }
            
        }
         catch(Exception exception){
            exception.printStackTrace();
         }

        }

}
