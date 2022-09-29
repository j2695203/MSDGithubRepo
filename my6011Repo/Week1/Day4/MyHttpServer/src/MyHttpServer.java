import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class MyHttpServer {

    // constructor
    public MyHttpServer() throws IOException {
        ServerSocket serversocket = new ServerSocket(8080);

        while (true) {
            Socket clientsocket = serversocket.accept();
            System.out.println("Debug: got new client " + clientsocket.toString());

            InputStream inputstream = clientsocket.getInputStream();
            Scanner sc = new Scanner(inputstream);

            // only read the 1st line once (not value pair)
            String line = sc.nextLine();
            // split into 3 pieces
            String[] splitLine = line.split(" ");
            String path = splitLine[1];

            HashMap<String, String> headers = new HashMap<>();

            // while the line is not blank
            while (!line.equals("")) {
                // read header line
                line = sc.nextLine();
                // break line into key:value pairs
//                splitLine = line.split(": "); // need refresh?
//                // store in hash map
//                headers.put(splitLine[0], splitLine[1]);
            }

            //open the request file ('filename')
            if (path.equals("/")){
                path = "index.html";
            }
            path = "resources/" + path;
            File file = new File(path);
            String result;
            if(file.exists()){
                result = "200 OK";
            }else{
                result = "404 not found";
            }

            // write
            OutputStream outputstream = clientsocket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputstream);

            // send the response header
            pw.println("HTTP/1.1 " + result);
            pw.println("Content-type: text/html");
            pw.println("Content-Length:" + file.length() );
            pw.println("\n");

            // send the data from file
            Path filepath = Paths.get(path);
            String content = Files.readString(filepath);
            pw.println(content);
            

            pw.flush();
            pw.close();
            clientsocket.close();
        }
    }


}
