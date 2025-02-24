public class Bolsista extends Aluno {
    
    private String bolsa;

    public void renovarBolsa(){
        System.out.println("Renovando bolsa do bolsista " + this.getNome() + "para" + this.getBolsa());
    }

    public Bolsista(int matricula, String curso, String nome) {
        this.matricula = matricula;
        this.curso = curso;
        this.setNome("Pedro");
    }

    @Override
    public void pagarMensalidade(){
        System.out.println("Pagando mensalidade do bolsista " + this.getNome());
    }

    public String getBolsa() {
        return bolsa;
    }

    public void setBolsa(String bolsa) {
        this.bolsa = bolsa;
    }

    
}

