import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class MyHttpServer {
    // VARIABLES /////////////////////
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private String path;

    // CONSTRUCTORS /////////////////////
    public MyHttpServer() {

        try{
            serverSocket = new ServerSocket(8080);  // create http server with certain port
            while (true) {
                clientSocket = serverSocket.accept();
                HTTPRequest();
                HTTPResponse();
            }
        }catch( Exception e){
            System.out.println(e);
        }
    }

    // Read HTTP request /////////////////////
    public void HTTPRequest() {

        InputStream inputstream = null;
        try {
            inputstream = clientSocket.getInputStream();
            Scanner sc = new Scanner(inputstream);

            String line = sc.nextLine();                 // only read the 1st line once (not value pair)
            String[] splitLine = line.split(" ");  // split into 3 pieces
            path = splitLine[1];

            HashMap<String, String> headers = new HashMap<>();
            while (!line.equals("")) {   // while the line is not blank
                line = sc.nextLine();    // read header line
                // break line into key:value pairs
                // store in hash map
            }
            //sc.close();                // why fail when close sc here ????
        } catch (IOException e) {
            System.out.println("HTTP Request fail");
            throw new RuntimeException(e);
        }
    }

    // Write HTTP response /////////////////////
    public void HTTPResponse(){

        //open the request file ('filename')
        if (path.equals("/")){
            path = "index.html";
        }
        path = "resources/" + path;

        String result;
        File file = new File(path);
        try{
            if(file.exists()){
                result = "200 OK";
            }else{
                throw new FileNotFoundException();
            }
        }catch (FileNotFoundException e){
            result = "404 not found";
        }


        OutputStream outputstream = null;
        try {
            outputstream = clientSocket.getOutputStream();
        } catch (IOException e) {
            System.out.println("Client Output Stream fail");
            throw new RuntimeException(e);
        }
        PrintWriter pw = new PrintWriter(outputstream);

        // send the response header
        pw.println("HTTP/1.1 " + result);
        pw.println("Content-type: text/html");
        pw.println("Content-Length:" + file.length() );
        pw.println("\n");

        // send the data from file
        Path filepath = Paths.get(path);
        String content = null;
        try {
            content = Files.readString(filepath);
        } catch (IOException e) {
            System.out.println("Unable to find file");
            throw new RuntimeException(e);
        }
        pw.println(content);

        pw.flush();
        pw.close();
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("close client socket fail");
            throw new RuntimeException(e);
        }
    }
}
