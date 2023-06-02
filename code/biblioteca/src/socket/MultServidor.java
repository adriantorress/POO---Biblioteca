import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultServidor {
    public static void main(String[] args) throws IOException {
        // Abre conexão (não há fechamento do socket do servidor pois o mesmo deve ficar sempre disponivel.)
        ServerSocket serverSocket = new ServerSocket(54321);

        // Mensagem de confirmação da disponibilidade da porta
        System.out.println("A porta 54321 foi aberta!");
        System.out.println("Servidor esperando receber mensagens dos clientes...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado.");

            ThreadSockets thread = new ThreadSockets(socket);
            thread.start();
        }
    }
}
