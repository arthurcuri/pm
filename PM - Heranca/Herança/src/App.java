public class App {
    public static void main(String[] args) throws Exception {
        Bolsista b1 = new Bolsista(1327, "Casaquistao", "Pedro");
        System.out.println(b1.getNome());
        b1.pagarMensalidade();
        System.out.println(b1.getMatricula());


        
    }
}
