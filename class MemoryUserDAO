import java.util.ArrayList;
import java.util.List;

public class MemoryUserDAO implements UserDAO {
    private List<User> usuarios = new ArrayList<>();

    @Override
    public List<User> listarUsuarios() {
        return usuarios;
    }

    @Override
    public User buscarUsuarioPorId(int id) {
        for (User user : usuarios) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void inserirUsuario(User user) {
        usuarios.add(user);
    }

    @Override
    public void atualizarUsuario(User user) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == user.getId()) {
                usuarios.set(i, user);
                return;
            }
        }
    }

    @Override
    public void deletarUsuario(int id) {
        usuarios.removeIf(user -> user.getId() == id);
    }
}
