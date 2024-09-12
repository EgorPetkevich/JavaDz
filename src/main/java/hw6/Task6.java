package hw6;
import java.net.*;
import java.io.IOException;
public class Task6 {
    public static void main(String[] args) {
        int[] portsToScan = {135, 137, 138, 139, 445, 843, 1900, 3702, 5040, 5050,
            5353, 5355, 5939, 6463, 6942, 17500, 27017, 42420};

        for (int port : portsToScan) {
            scanPort("127.0.0.1", port);
        }
    }

    public static void scanPort(String host, int port) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 1000); // Timeout: 1 second
            socket.close();

            System.out.println("TCP\t" + port + "\t" + getServiceName(port));
        } catch (IOException e) {

            System.out.println("UDP\t" + port + "\t" + getServiceName(port));
        }
    }

    public static String getServiceName(int port) {
        switch (port) {
            case 135:
                return "EPMAP";
            case 137:
                return "NetBIOS Name Service";
            case 138:
                return "NetBIOS Datagram Service";
            case 139:
                return "NetBIOS Session Service";
            case 445:
                return "Microsoft-DS Active Directory";
            case 843:
                return "Adobe Flash";
            case 1900:
                return "Simple Service Discovery Protocol (SSDP)";
            case 3702:
                return "Dynamic Web Services Discovery";
            case 5040:
                return "Unknown Service";
            case 5050:
                return "Unknown Service";
            case 5353:
                return "Multicast DNS";
            case 5355:
                return "Link-Local Multicast Name Resolution (LLMNR)";
            case 5939:
                return "Unknown Service";
            case 6463:
                return "Unknown Service";
            case 6942:
                return "Unknown Service";
            case 17500:
                return "Dropbox";
            case 27017:
                return "MongoDB";
            case 42420:
                return "Unknown Service";
            default:
                return "Unknown Service";
        }
    }
}
