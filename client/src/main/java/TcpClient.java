import java.io.*;
import java.net.Socket;

@SuppressWarnings("ALL")
public class TcpClient {

    private static final String IP = "127.0.0.1";
    private static final int PORT = 2000;
    private Socket clientSocket;

    public TcpClient() throws IOException {
        clientSocket = new Socket(IP, PORT);
    }

    public void writeMessage(String message) throws IOException {
        byte[] byteMessage = message.getBytes();
        DataOutputStream stream = new DataOutputStream(clientSocket.getOutputStream());
        stream.writeInt(byteMessage.length);
        stream.write(byteMessage);

    }

    public String readMessage() throws IOException {
        DataInputStream stream = new DataInputStream(clientSocket.getInputStream());
        int length = stream.readInt();
        if (length > 0) {
            byte[] message = new byte[length];
            stream.readFully(message, 0, length);
            return new String(message);
        }
        return null;
    }

    public void closeSocket() throws IOException {
        clientSocket.close();
    }

}
