// By ScarletCoder7
import java.io.IOException;
import java.net.ServerSocket;


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try(ServerSocket serverSocket = new ServerSocket(5000)){  // 5000 is the port number
            //we can allocate any port number between 0 and 65,535
            while(true){
                new ServerThread(serverSocket.accept()).start();
            }
           // Socket socket = serverSocket.accept();
                //When multiple clients are connected to a server, then we use the same port number but each client will have it's own Socket !
        }catch(IOException e) {
            System.out.println("Into IOException : "+e.getMessage());
        }
    }

}


