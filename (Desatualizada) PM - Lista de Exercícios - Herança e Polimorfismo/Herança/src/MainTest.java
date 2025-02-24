import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    @Test
    void testePessoaFisica() {
        PessoaFisica pessoaFisica = new PessoaFisica("Arthur Curi Kramberger", "Rua Professor Nardelli Benfica, nº 382", "(31) 99341-6474", "31910-450", "Belo Horizonte", "MG", "122.797.686-07");

        assertNotNull(pessoaFisica);
        assertNotEquals("John Doe", pessoaFisica.getNome());
        assertTrue(pessoaFisica.getEndereco().contains("Rua"));
        assertFalse(pessoaFisica.getCep().isEmpty());
    }

    @Test
    void testePessoaJuridica() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica("PUC Minas", "Avenida Dom José Gaspar, nº 500", "(31) 3319-4444", "98765-432", "Belo Horizonte", "MG", "17.178.195/0001-67");

        assertNotNull(pessoaJuridica);
        assertNotEquals("Apple Inc.", pessoaJuridica.getNome());
        assertTrue(pessoaJuridica.getEndereco().contains("Avenida"));
        assertFalse(pessoaJuridica.getTelefone().isEmpty());
    }

    @Test
    void testeClientePessoaFisica() {
        PessoaFisica clientePessoaFisica = new PessoaFisica("Arthur Curi Kramberger", "Rua Professor Nardelli Benfica, nº 382", "(31) 99341-6474", "31910-450", "Belo Horizonte", "MG", "122.797.686-07");
        ClientePessoaFisica cliente = new ClientePessoaFisica(clientePessoaFisica, 1000.00);

        assertSame(clientePessoaFisica, cliente.pessoa);
        assertNotEquals(2000.00, cliente.limiteCredito);
    }

    @Test
    void testeClientePessoaJuridicaGetInfo() {
        PessoaJuridica clientePessoaJuridica = new PessoaJuridica("PUC Minas", "Avenida Dom José Gaspar, nº 500", "(31) 3319-4444", "98765-432", "Belo Horizonte", "MG", "17.178.195/0001-67");
        ClientePessoaJuridica cliente = new ClientePessoaJuridica(clientePessoaJuridica, 5000.00);
        
        String saidaEsperada = "Cliente Pessoa Jurídica: PUC Minas, CNPJ: 17.178.195/0001-67, Endereço: Avenida Dom José Gaspar, nº 500, Telefone: (31) 3319-4444, CEP: 98765-432, Cidade: Belo Horizonte, UF: MG";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        cliente.getInfo();
        System.setOut(System.out);
        assertEquals(saidaEsperada.trim(), outContent.toString().trim());
    }

    @Test
    void testeFuncionario() {
        Funcionario funcionario = new Funcionario("Cloé Pinheiro", "Rua Felipe dos Santos, nº 63", "(31)9585909663", "30180-160", "Belo Horizonte", "MG",
                "Gerente", 5000.00);

        assertNotNull(funcionario);
        assertFalse(funcionario.getCargo().isEmpty());
        assertFalse(funcionario.getSalario() < 0);
    }

    @Test
    void testeEmpresa() {
        PessoaFisica clientePessoaFisica = new PessoaFisica("Arthur Curi Kramberger", "Rua Professor Nardelli Benfica, nº 382", "(31) 99341-6474", "31910-450", "Belo Horizonte", "MG", "122.797.686-07");
        PessoaJuridica clientePessoaJuridica = new PessoaJuridica("PUC Minas", "Avenida Dom José Gaspar, nº 500", "(31) 3319-4444", "98765-432", "Belo Horizonte", "MG", "17.178.195/0001-67");

        Funcionario funcionario = new Funcionario("Cloé Pinheiro", "Rua Felipe dos Santos, nº 63", "(31)9585909663", "30180-160", "Belo Horizonte", "MG",
                "Gerente", 5000.00);

        Empresa empresa = new Empresa();

        empresa.adicionarCliente(new ClientePessoaFisica(clientePessoaFisica, 1000.00));
        empresa.adicionarCliente(new ClientePessoaJuridica(clientePessoaJuridica, 5000.00));
        empresa.adicionarFuncionario(funcionario);

        Funcionario presidente = new Funcionario("Thomaz Couto", "Alameda Oscar Niemeyer, nº 119", "(31) 99607-7975", "34006-049", "Belo Horizonte", "MG",
                "Presidente", 10000.00);
        empresa.definirPresidente(presidente);

        assertNotNull(empresa.getPresidente());
    }
}
