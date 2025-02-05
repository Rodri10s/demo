package com.ramon.principal;

import java.util.ArrayList;

import com.ramon.basicas.Cliente;
import com.ramon.basicas.Endereco;
import com.ramon.basicas.Funcionario;
import com.ramon.basicas.HistoricoServico;
import com.ramon.basicas.Servico;
import com.ramon.basicas.Veiculo;
import com.ramon.dao.ClienteDao;
import com.ramon.dao.EnderecoDAO;
import com.ramon.dao.FuncionarioDAO;
import com.ramon.dao.HistoricoServicoDAO;
import com.ramon.dao.ServicoDAO;
import com.ramon.dao.VeiculoDAO;

public class Main {
    public static void main(String[] args) {

        // Criando Endereços e associando aos clientes
        Endereco endereco1 = new Endereco();
        endereco1.setCidade("São Paulo");
        endereco1.setBairro("Centro");
        endereco1.setRua("Av. Paulista");
        endereco1.setNumero("1000");
        endereco1.setCep("01310-000");

        Endereco endereco2 = new Endereco();
        endereco2.setCidade("Rio de Janeiro");
        endereco2.setBairro("Copacabana");
        endereco2.setRua("Rua Atlântica");
        endereco2.setNumero("500");
        endereco2.setCep("22070-000");

        Endereco endereco3 = new Endereco();
        endereco3.setCidade("Belo Horizonte");
        endereco3.setBairro("Savassi");
        endereco3.setRua("Av. do Contorno");
        endereco3.setNumero("3000");
        endereco3.setCep("30110-000");

        // Criando Clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João da Silva");
        cliente1.setEmail("joao@email.com");
        cliente1.setCpf("123.456.789-00");
        cliente1.setEndereco(endereco1);
        cliente1.setVeiculo(new ArrayList<>());

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Souza");
        cliente2.setEmail("maria@email.com");
        cliente2.setCpf("987.654.321-00");
        cliente2.setEndereco(endereco2);
        cliente2.setVeiculo(new ArrayList<>());

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Carlos Pereira");
        cliente3.setEmail("carlos@email.com");
        cliente3.setCpf("111.222.333-44");
        cliente3.setEndereco(endereco3);
        cliente3.setVeiculo(new ArrayList<>());

        // Criando Veículos e associando aos clientes
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setModelo("Civic");
        veiculo1.setMontadora("Honda");
        veiculo1.setCliente(cliente1);
        cliente1.getVeiculo().add(veiculo1);

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setModelo("Corolla");
        veiculo2.setMontadora("Toyota");
        veiculo2.setCliente(cliente2);
        cliente2.getVeiculo().add(veiculo2);

        Veiculo veiculo3 = new Veiculo();
        veiculo3.setModelo("Gol");
        veiculo3.setMontadora("Volkswagen");
        veiculo3.setCliente(cliente3);
        cliente3.getVeiculo().add(veiculo3);

        // Criando Funcionários
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("Ana Oliveira");
        funcionario1.setCpf("222.333.444-55");
        funcionario1.setFuncao("Mecânica");
        funcionario1.setHistoricoServico(new ArrayList<>());

        Funcionario funcionario2 = new Funcionario();
        funcionario2.setNome("Bruno Santos");
        funcionario2.setCpf("555.666.777-88");
        funcionario2.setFuncao("Atendente");
        funcionario2.setHistoricoServico(new ArrayList<>());

        Funcionario funcionario3 = new Funcionario();
        funcionario3.setNome("Fernanda Lima");
        funcionario3.setCpf("999.888.777-66");
        funcionario3.setFuncao("Gerente");
        funcionario3.setHistoricoServico(new ArrayList<>());

        // Criando Serviços
        Servico servico1 = new Servico();
        servico1.setDescricao("Troca de óleo");
        servico1.setValor(150.00);

        Servico servico2 = new Servico();
        servico2.setDescricao("Alinhamento e balanceamento");
        servico2.setValor(120.00);

        Servico servico3 = new Servico();
        servico3.setDescricao("Revisão completa");
        servico3.setValor(500.00);

        // Criando Histórico de Serviços e associando aos funcionários
        HistoricoServico historico1 = new HistoricoServico(veiculo1, servico1, funcionario1);
        HistoricoServico historico2 = new HistoricoServico(veiculo2, servico2, funcionario2);
        HistoricoServico historico3 = new HistoricoServico(veiculo3, servico3, funcionario3);

        funcionario1.getHistoricoServico().add(historico1);
        funcionario2.getHistoricoServico().add(historico2);
        funcionario3.getHistoricoServico().add(historico3);

        ClienteDao clienteDao = new ClienteDao();
        clienteDao.add(cliente1);
        clienteDao.add(cliente2);
        clienteDao.add(cliente3);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.add(funcionario1);
        funcionarioDAO.add(funcionario2);
        funcionarioDAO.add(funcionario3);

        ServicoDAO servicoDAO = new ServicoDAO();
        servicoDAO.add(servico1);
        servicoDAO.add(servico2);
        servicoDAO.add(servico3);

        HistoricoServicoDAO historicoServicoDAO = new HistoricoServicoDAO();
        historicoServicoDAO.add(historico1);
        historicoServicoDAO.add(historico2);
        historicoServicoDAO.add(historico3);

    }

}