import java.io.DataInputStream;
// import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// import java.util.List;

// import model.Livro;

public class ThreadSockets extends Thread {

    // Cria uma Thread baseada no socket recebido
    private Socket socket;

    public ThreadSockets(Socket s) {
        this.socket = s;
    }

    public void run() {
        // Printa o nome da Thread e porta.
        System.out.println(Thread.currentThread().getName() + " porta: " + socket.getPort());

        try {

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            String respostaCliente = "";

            while (true) {
                // Define a stream de dados de entrada no servidor
                respostaCliente = entrada.readUTF();
                if (respostaCliente.equals("x")) {
                    break;
                }
                ArrayList<String> livrosDisponiveis = new ArrayList<>();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root",
                        "#241258Aj")) {
                    String sql = "SELECT titulo, isbn, autor, ano_publicacao, categoria FROM tb_livro WHERE quantidade_disponivel>0;";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        String titulo = rs.getString("titulo");
                        // System.out.println(titulo);
                        // String isbn = rs.getString("isbn");
                        // String anoPublicacao = rs.getString("ano_publicacao");

                        // String autor = rs.getString("autor");

                        // String categoria = rs.getString("categoria");

                        // Livro livro = new Livro(titulo, isbn, autor, anoPublicacao, categoria);
                        livrosDisponiveis.add(titulo);
                    }
                    System.out.println("\nBusca concluída com sucesso!\n");
                } catch (SQLException e) {
                    System.out.println("Erro ao obter livros: " + e.getMessage());
                }
                // Define a stream de dados de saida do servidor
                saida.writeObject(livrosDisponiveis);
            }

            // Fechamento das streams de entrada e saida de dados
            System.out.println("Cliente desconectado, porta " + socket.getPort() + " liberada.");
            entrada.close();
            saida.close();

            // Fechamento do socket de comunição
            socket.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e.toString());
        }
    }
}
