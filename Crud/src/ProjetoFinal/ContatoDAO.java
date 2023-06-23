package ProjetoFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/agenda";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    public void inserirContato(Contato contato) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO contatos (nome, nascimento, sexo, peso, altura, endereco, complemento, cidade, estado, email, instagram, telefone, linkedin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getNascimento());
            statement.setString(3, contato.getSexo());
            statement.setDouble(4, contato.getPeso());
            statement.setDouble(5, contato.getAltura());
            statement.setString(6, contato.getEndereco());
            statement.setString(7, contato.getComplemento());
            statement.setString(8, contato.getCidade());
            statement.setString(9, contato.getEstado());
            statement.setString(10, contato.getEmail());
            statement.setString(11, contato.getInstagram());
            statement.setString(12, contato.getTelefone());
            statement.setString(13, contato.getLinkedin());

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir contato: " + e.getMessage());
        }
    }

    public List<Contato> listarContatos() {
        List<Contato> contatos = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM contatos";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setNascimento(resultSet.getString("nascimento"));
                contato.setSexo(resultSet.getString("sexo"));
                contato.setPeso(resultSet.getDouble("peso"));
                contato.setAltura(resultSet.getDouble("altura"));
                contato.setEndereco(resultSet.getString("endereco"));
                contato.setComplemento(resultSet.getString("complemento"));
                contato.setCidade(resultSet.getString("cidade"));
                contato.setEstado(resultSet.getString("estado"));
                contato.setEmail(resultSet.getString("email"));
                contato.setInstagram(resultSet.getString("instagram"));
                contato.setTelefone(resultSet.getString("telefone"));
                contato.setLinkedin(resultSet.getString("linkedin"));
                
                contatos.add(contato);
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar contatos: " + e.getMessage());
        }
        
        return contatos;
    }
    	
    public Contato buscarContatoPorId(int id) {
        Contato contato = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM contatos WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                contato = new Contato();
                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setNascimento(resultSet.getString("nascimento"));
                contato.setSexo(resultSet.getString("sexo"));
                contato.setPeso(resultSet.getDouble("peso"));
                contato.setAltura(resultSet.getDouble("altura"));
                contato.setEndereco(resultSet.getString("endereco"));
                contato.setComplemento(resultSet.getString("complemento"));
                contato.setCidade(resultSet.getString("cidade"));
                contato.setEstado(resultSet.getString("estado"));
                contato.setEmail(resultSet.getString("email"));
                contato.setInstagram(resultSet.getString("instagram"));
                contato.setTelefone(resultSet.getString("telefone"));
                contato.setLinkedin(resultSet.getString("linkedin"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar contato por ID: " + e.getMessage());
        }

        return contato;
    }
	
    
    
    
    public void atualizarContato(Contato contato) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "UPDATE contatos SET nome = ?, nascimento = ?, sexo = ?, peso = ?, altura = ?, endereco = ?, complemento = ?, cidade = ?, estado = ?, email = ?, instagram = ?, telefone = ?, linkedin = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getNascimento());
            statement.setString(3, contato.getSexo());
            statement.setDouble(4, contato.getPeso());
            statement.setDouble(5, contato.getAltura());
            statement.setString(6, contato.getEndereco());
            statement.setString(7, contato.getComplemento());
            statement.setString(8, contato.getCidade());
            statement.setString(9, contato.getEstado());
            statement.setString(10, contato.getEmail());
            statement.setString(11, contato.getInstagram());
            statement.setString(12, contato.getTelefone());
            statement.setString(13, contato.getLinkedin());
            statement.setInt(14, contato.getId());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar contato: " + e.getMessage());
        }
    }

    public void excluirContato(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM contatos WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir contato: " + e.getMessage());
        }
    }
}
