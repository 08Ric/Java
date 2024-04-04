import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDAO implements UserDAO {
    private Connection connection;

    public JDBCUserDAO() {
        // Configurar a conexão com o banco de dados
        try {
            String url = "jdbc:mysql://localhost:3306/meu_banco_de_dados";
            String user = "usuario";
            String password = "senha";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> listarUsuarios() {
        List<User> usuarios = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                usuarios.add(new User(id, nome, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public User buscarUsuarioPorId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                return new User(id, nome, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void inserirUsuario(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (nome, email) VALUES (?, ?)");
            statement.setString(1, user.getNome());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarUsuario(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE usuarios SET nome = ?, email = ? WHERE id = ?");
            statement.setString(1, user.getNome());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarUsuario(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fechar a conexão com o banco de dados
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
