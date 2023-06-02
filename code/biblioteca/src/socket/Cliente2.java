import java.net.*;
import java.io.DataOutputStream;
// import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente2 {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

        // Cria o socket para conexão
        Socket socket = new Socket("127.0.0.1", 54321);

        // Cria as Streams de entrada e saida.
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());;
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());;

        // String que receberá as respostas do servidor.
        // ArrayList<String> respostaServ = new ArrayList<>();
        
        // Scanner para o cliente enviar mensagens ao servidor.
        Scanner scanner = new Scanner(System.in);

        // Primeiro contato com o servidor.
        saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF("");

        System.out.println("Escreva 'x' para finalizar.");

        while (true) {
            // Resposta do servidor
            ArrayList respostaServ = (ArrayList) entrada.readObject();
            System.out.println(respostaServ);

            // Resposta do cliente
            String op = scanner.nextLine();
            if (op.equals("x")) {
                saida.writeUTF(op);
                break;
            } else {
                saida.writeUTF(op);
            } 
        }

        // Fechamento das streams de entrada e saida de dados, scanner e socket de comunicação
        entrada.close();
        saida.close();
        scanner.close();
        socket.close();

    }

}