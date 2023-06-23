package ProjetoFinal;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContatoDAO contatoDAO = new ContatoDAO();

        int opcao;
        do {
            System.out.println("==== MENU ====");
            System.out.println("1. Listar contatos");
            System.out.println("2. Inserir contato");
            System.out.println("3. Atualizar contato");
            System.out.println("4. Excluir contato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    List<Contato> contatos = contatoDAO.listarContatos();
                    System.out.println("Lista de contatos:");
                    for (Contato c : contatos) {
                        System.out.println(c.getId() + " - " + c.getNome());
                    }
                    break;
                case 2:
                    // Solicitar os dados do contato para o usuário
                    Contato novoContato = criarContato(scanner);

                    // Inserir o contato na tabela contatos
                    contatoDAO.inserirContato(novoContato);
                    System.out.println("Contato inserido com sucesso!");
                    break;
                case 3:
                    // Solicitar o ID do contato a ser atualizado
                    System.out.print("Digite o ID do contato a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    // Verificar se o contato existe
                    Contato contatoAtualizar = contatoDAO.buscarContatoPorId(idAtualizar);
                    if (contatoAtualizar == null) {
                        System.out.println("Contato não encontrado!");
                    } else {
                        // Solicitar os novos dados do contato para o usuário
                        Contato novoContatoAtualizado = criarContato(scanner);

                        // Atualizar o contato na tabela contatos
                        novoContatoAtualizado.setId(contatoAtualizar.getId());
                        contatoDAO.atualizarContato(novoContatoAtualizado);
                        System.out.println("Contato atualizado com sucesso!");
                    }
                    break;
                case 4:
                    // Solicitar o ID do contato a ser excluído
                    System.out.print("Digite o ID do contato a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    // Verificar se o contato existe
                    Contato contatoExcluir = contatoDAO.buscarContatoPorId(idExcluir);
                    if (contatoExcluir == null) {
                        System.out.println("Contato não encontrado!");
                    } else {
                        // Excluir o contato da tabela contatos
                        contatoDAO.excluirContato(idExcluir);
                        System.out.println("Contato excluído com sucesso!");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

   
        private static Contato criarContato(Scanner scanner) {
            Contato contato = new Contato();

            System.out.print("Digite o nome do contato: ");
            contato.setNome(scanner.nextLine());

            System.out.print("Digite a data de nascimento (formato: yyyy-mm-dd): ");
            contato.setNascimento(scanner.nextLine());

            System.out.print("Digite o sexo do contato: ");
            contato.setSexo(scanner.nextLine());

            System.out.print("Digite o peso do contato: ");
            contato.setPeso(scanner.nextDouble());

            System.out.print("Digite a altura do contato: ");
            contato.setAltura(scanner.nextDouble());

            scanner.nextLine(); 

            System.out.print("Digite o endereço do contato: ");
            contato.setEndereco(scanner.nextLine());

            System.out.print("Digite o complemento do endereço do contato: ");
            contato.setComplemento(scanner.nextLine());

            System.out.print("Digite a cidade do contato: ");
            contato.setCidade(scanner.nextLine());

            System.out.print("Digite o estado do contato: ");
            contato.setEstado(scanner.nextLine());

            System.out.print("Digite o email do contato: ");
            contato.setEmail(scanner.nextLine());

            System.out.print("Digite o Instagram do contato: ");
            contato.setInstagram(scanner.nextLine());

            System.out.print("Digite o telefone do contato: ");
            contato.setTelefone(scanner.nextLine());

            System.out.print("Digite o LinkedIn do contato: ");
            contato.setLinkedin(scanner.nextLine());

            return contato;
        
    }
}
