import java.util.ArrayList;
import java.util.List;

interface ClienteInterface {
    void getInfo();
}

class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String cep;
    private String cidade;
    private String uf;

    public Pessoa(String nome, String endereco, String telefone, String cep, String cidade, String uf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }
}

class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String nome, String endereco, String telefone, String cep, String cidade, String uf, String cpf) {
        super(nome, endereco, telefone, cep, cidade, uf);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}

class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String nome, String endereco, String telefone, String cep, String cidade, String uf, String cnpj) {
        super(nome, endereco, telefone, cep, cidade, uf);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}

abstract class Cliente implements ClienteInterface {
    protected Pessoa pessoa;
    protected double limiteCredito;

    public Cliente(Pessoa pessoa, double limiteCredito) {
        this.pessoa = pessoa;
        this.limiteCredito = limiteCredito;
    }
}

class ClientePessoaFisica extends Cliente {
    private PessoaFisica pessoaFisica;

    public ClientePessoaFisica(PessoaFisica pessoaFisica, double limiteCredito) {
        super(pessoaFisica, limiteCredito);
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public void getInfo() {
        System.out.println("Cliente Pessoa Física: " + pessoaFisica.getNome() +
                ", CPF: " + pessoaFisica.getCpf() +
                ", Endereço: " + pessoaFisica.getEndereco() +
                ", Telefone: " + pessoaFisica.getTelefone() +
                ", CEP: " + pessoaFisica.getCep() +
                ", Cidade: " + pessoaFisica.getCidade() +
                ", UF: " + pessoaFisica.getUf());
    }
}

class ClientePessoaJuridica extends Cliente {
    private PessoaJuridica pessoaJuridica;

    public ClientePessoaJuridica(PessoaJuridica pessoaJuridica, double limiteCredito) {
        super(pessoaJuridica, limiteCredito);
        this.pessoaJuridica = pessoaJuridica;
    }

    @Override
    public void getInfo() {
        System.out.println("Cliente Pessoa Jurídica: " + pessoaJuridica.getNome() +
                ", CNPJ: " + pessoaJuridica.getCnpj() +
                ", Endereço: " + pessoaJuridica.getEndereco() +
                ", Telefone: " + pessoaJuridica.getTelefone() +
                ", CEP: " + pessoaJuridica.getCep() +
                ", Cidade: " + pessoaJuridica.getCidade() +
                ", UF: " + pessoaJuridica.getUf());
    }
}

class Funcionario extends Pessoa implements ClienteInterface {
    private String cargo;
    private double salario;

    public Funcionario(String nome, String endereco, String telefone, String cep, String cidade, String uf, String cargo, double salario) {
        super(nome, endereco, telefone, cep, cidade, uf);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void getInfo() {
        System.out.println("Funcionário: " + getNome() +
                ", Cargo: " + cargo +
                ", Salário: " + salario +
                ", Endereço: " + getEndereco() +
                ", Telefone: " + getTelefone() +
                ", CEP: " + getCep() +
                ", Cidade: " + getCidade() +
                ", UF: " + getUf());
    }
}

class Empresa {
    private List<ClienteInterface> clientes;
    private List<Funcionario> funcionarios;
    private Funcionario presidente;

    public Empresa() {
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
    }

    public void adicionarCliente(ClienteInterface cliente) {
        clientes.add(cliente);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        if (!funcionario.equals(presidente)) {
            funcionarios.add(funcionario);
        }
    }

    public void definirPresidente(Funcionario presidente) {
        this.presidente = presidente;
        adicionarFuncionario(presidente);
    }

    public Funcionario getPresidente() {
        return presidente;
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Clientes:");
            for (ClienteInterface cliente : clientes) {
                cliente.getInfo();
            }
        }
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty() && presidente == null) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                funcionario.getInfo();
            }
            if (presidente != null) {
                System.out.println("Presidente:");
                presidente.getInfo();
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
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

        empresa.listarClientes();
        empresa.listarFuncionarios();
    }
}

