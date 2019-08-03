import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TcpServer tcpServer = null;
        try {
            tcpServer = new TcpServer();
            tcpServer.runTask();
        } catch (IOException e) {
            System.out.println("We cannot connect to server");
        }

    }

    public  static Runnable serve() {
        return () -> System.out.println("asdasd");
    }
}
