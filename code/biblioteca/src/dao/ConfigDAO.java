package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDAO {
    private static final String CONFIG_FILE = "config.properties";
    private static String url;
    private static String usuario;
    private static String senha;

    static {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            prop.load(fis);
            url = prop.getProperty("url");
            usuario = prop.getProperty("usuario");
            senha = prop.getProperty("senha");
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de configuração: " + e.getMessage());
        }
    }

    public static String getURL() {
        return url;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getSenha() {
        return senha;
    }
}
