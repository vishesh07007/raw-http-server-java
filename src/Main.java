import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;


public class Main {
    public static void main(String[] args) throws Exception{

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server running on port 8080");
        while(true){

            Socket socket = server.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            OutputStream out= socket.getOutputStream();

            String line;
            while(!(line = in.readLine()).isEmpty()){
                System.out.println(line);
            }

            String response = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/plain\r\n"
                    + "\r\n"
                    + "sabbas!";

            out.write(response.getBytes());
            out.flush();
            socket.close();




        }


    }
}