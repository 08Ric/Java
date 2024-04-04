import java.util.List;

public interface UserDAO {
    List<User> listarUsuarios();
    User buscarUsuarioPorId(int id);
    void inserirUsuario(User user);
    void atualizarUsuario(User user);
    void deletarUsuario(int id);
}
