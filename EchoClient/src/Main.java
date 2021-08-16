// By ScarletCoder7

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try(Socket socket = new Socket("localhost", 5000)) {  // 5000 is the port number
            //socket.setSoTimeout(10000);
            BufferedReader receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter send = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String echoScanner;
            String response;
            do {
                System.out.println("enter string to be echoed");
                echoScanner = scanner.nextLine();
                send.println(echoScanner);
                if (!echoScanner.equals("exit")) {
                    response = receive.readLine();
                    System.out.println(response);
                }
            } while (!echoScanner.equals("exit"));

        /*}catch(SocketTimeoutException e){
            System.out.println("SocketTimeoutException : "+e.getMessage());*/
        }catch(IOException e) {
            System.out.println("Client Error : "+e.getMessage());
        }
    }

}

