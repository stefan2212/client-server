import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            TcpClient tcpClient = new TcpClient();
            tcpClient.writeMessage("Salut de la client");
            System.out.println(tcpClient.readMessage());
            tcpClient.closeSocket();
        } catch (IOException e) {
            System.out.println("Cannot connect to server");
        }
    }
}
