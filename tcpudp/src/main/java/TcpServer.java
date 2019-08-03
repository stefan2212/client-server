import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("ALL")
public class TcpServer implements Runnable {

    private static final int PORT = 2000;

    private ServerSocket serverSocket;
    private Socket socket;

    public TcpServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
    }

    public void runTask() throws IOException {
        System.out.println("Server listening on port " + PORT);
        System.out.println("Waiting for connections ");
        while(true) {
            socket = serverSocket.accept();
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(readMessage());
            writeMessage("Ceva catre client");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String readMessage() throws IOException {
        DataInputStream stream = new DataInputStream(socket.getInputStream());
        int length = stream.readInt();
        if (length > 0) {
            byte[] message = new byte[length];
            stream.readFully(message, 0, length);
            return new String(message);
        }
        return null;
    }

    public void writeMessage(String message) throws IOException {
        byte[] byteMessage = message.getBytes();
        DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
        stream.writeInt(byteMessage.length);
        stream.write(byteMessage);
    }
}
