import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // HW1 Question 2
        Traceroute tr1 = new Traceroute();
        Traceroute tr2 = new Traceroute();
        tr1.traceRoute("hops1.txt");
        tr2.traceRoute("hops2.txt");

        // HW1 Question 3
        Ping p = new Ping();
        p.pingDelay("ping.txt");
    }
}