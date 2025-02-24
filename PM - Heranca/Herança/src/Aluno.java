public class Aluno extends Pessoa {
    
    protected int matricula;
    protected String curso;

    public void pagarMensalidade(){
        System.out.println("Pagando mensalidade do aluno " + this.getNome());
    }

    


    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;

    }

    public String getCurso() {
        return curso;
    }

    public void setCurso (String curso){
        this.curso = curso;
    }
}
