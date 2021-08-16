// By ScarletCoder7

import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;

public class ServerThread extends Thread{
    Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client Connected ");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            while(true){  //infinite loop
                String echoString = input.readLine();
                System.out.println("Input From Client : "+echoString);
                if(echoString.equals("exit")){
                    break;
                }
                try{
                    Thread.sleep(15000);
                }catch(InterruptedException e){
                    System.out.println("Thread Interrupted : "+e.getMessage());
                }
                output.println("Echoed from server : "+echoString);
            }
        }catch(IOException e){
            System.out.println("in IOException : "+e.getMessage());
        }finally{
            try{
                socket.close();
            }catch(IOException e){
                System.out.println("Unable to close socket : "+e.getMessage());
            }
        }
    }
}
