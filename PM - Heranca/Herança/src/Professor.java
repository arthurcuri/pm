public class Professor {
    
    private String especialidade;
    private float salario;

    public void receberAumento(){
        this.setSalario(this.getSalario() + 1000.50f);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    
}
