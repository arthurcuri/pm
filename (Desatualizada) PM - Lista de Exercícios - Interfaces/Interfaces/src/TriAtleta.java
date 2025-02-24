public class TriAtleta extends Humano implements Ciclista, Corredor, Nadador {


    public TriAtleta(String nome) {
        super(nome);
    }
    
    @Override
    public void correr(){
        System.out.println("Correndo");
    }
    @Override
    public void nadar(){
        System.out.println("Nadando");
    }
    @Override
    public void pedalar(){
        System.out.println("Pedalando");
    }

    public String toString() {
        return "TriAtleta []";
    }

}

    