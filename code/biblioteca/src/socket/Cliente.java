import java.net.*;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {

        // Cria o socket para conexão
        Socket socket = new Socket("127.0.0.1", 54321);

        // Define a saida de dados para o servidor
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());

        // Envia mensagem para o servidor
        saida.writeUTF("heverton");

        // Define o recebimento de dados do servidor
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        // Lê a mensagem do servidor
        String novaMensagem = entrada.readUTF();
        System.out.println(novaMensagem);

        // Fechamento das streams de entrada e saida de dados
        entrada.close();
        saida.close();

        // Fechamento do socket de comunição
        socket.close();

    }

}