import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSockets extends Thread{
    private Socket socket;
    public ThreadSockets(Socket s) {
        this.socket = s;
    }

    public void run() {
        // Printa o nome da Thread
        System.out.println(Thread.currentThread().getName()); 

        try {
            // Define a stream de dados de entrada no servidor
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            String mensagem = entrada.readUTF();
            String novaMensagem = mensagem.toUpperCase();

            // Define a stream de dados de saida do servidor
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF(novaMensagem);

            // Fechamento das streams de entrada e saida de dados
            entrada.close();
            saida.close();

            // Fechamento do socket de comunição
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.toString());
        }
    }
}
