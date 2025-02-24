public class Aplicacao {
    public static void main(String[] args) {

        Data data1 = new Data(2024, 3, 17);
        System.out.println("Data atual: " + data1.porExtenso());
        System.out.println("Dia da semana: " + data1.diaDaSemana());
        System.out.println("É ano bissexto? " + data1.eAnoBisexto());

        data1.adicionaDias(5);
        System.out.println("Data após adicionar 5 dias: " + data1.porExtenso());

        data1.proximoDia();
        System.out.println("Próximo dia: " + data1.porExtenso());
    }
}
