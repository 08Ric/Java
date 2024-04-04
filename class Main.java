public class Main {
    public static void main(String[] args) {
        // Usando DAO com armazenamento em memória
        UserDAO memoryDAO = new MemoryUserDAO();

        // Usando DAO com JDBC
        UserDAO jdbcDAO = new JDBCUserDAO();

        // Testando operações de CRUD
        User user1 = new User(1, "John Doe", "john.doe@example.com");
        User user2 = new User(2, "Jane Doe", "jane.doe@example.com");

        // Inserir usuários
        memoryDAO.inserirUsuario(user1);
        jdbcDAO.inserirUsuario(user1);
        memoryDAO.inserirUsuario(user2);
        jdbcDAO.inserirUsuario(user2);

        // Listar usuários
        System.out.println("Usuários cadastrados (memória): " + memoryDAO.listarUsuarios());
        System.out.println("Usuários cadastrados (JDBC): " + jdbcDAO.listarUsuarios());

        // Atualizar usuário
        user1.setNome("John Smith");
        memoryDAO.atualizarUsuario(user1);
        jdbcDAO.atualizarUsuario(user1);

        // Buscar usuário por ID
        System.out.println("Usuário com ID 1 (memória): " + memoryDAO.buscarUsuarioPorId(1));
        System.out.println("Usuário com ID 1 (JDBC): " + jdbcDAO.buscarUsuarioPorId(1));

        // Deletar usuário
        memoryDAO.deletarUsuario(2);
        jdbcDAO.deletarUsuario(2);

        // Listar usuários após exclusão
        System.out.println("Usuários após exclusão (memória): " + memoryDAO.listarUsuarios());
        System.out.println("Usuários após exclusão (JDBC): " + jdbcDAO.listarUsuarios());

        // Fechar conexão JDBC
        ((JDBCUserDAO) jdbcDAO).closeConnection();
    }
}
