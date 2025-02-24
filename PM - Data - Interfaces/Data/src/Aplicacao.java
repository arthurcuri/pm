public class Aplicacao {
    public static void main(String[] args) {

        Data data1 = new Data(2024, 3, 17);
        System.out.println("Data atual: " + data1.porExtenso());
        System.out.println("Dia da semana: " + data1.diaDaSemana());
        System.out.println("É ano bissexto? " + data1.eAnoBisexto());

        Data data2 = new Data(2024, 3, 18);
        System.out.println("Data atual: " + data2.porExtenso());
        System.out.println("Dia da semana: " + data2.diaDaSemana());
        System.out.println("É ano bissexto? " + data2.eAnoBisexto());

        data1.adicionaDias(7);
        System.out.println("Data após adicionar 5 dias: " + data1.porExtenso());

        data2.adicionaDias(5);
        System.out.println("Data após adicionar 5 dias: " + data2.porExtenso());

        
        data1.menorQue(data2);
        System.out.println("Data1 é menor que Data2? (t/f): " + data1.menorQue(data2));
        
        System.out.println(data2.toString());
    }
}
