/* 
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
*/ 
public class Aplicacao {
    public static void main(String[] args) {
       try {
            Data data1 = new Data(2022, 2, 25);
            System.out.println("Data atual: " + data1.porExtenso());
            System.out.println("Dia da semana: " + data1.diaDaSemana());
            System.out.println("É ano bissexto? " + data1.eAnoBisexto());

            data1.adicionaDias(5);
            System.out.println("Data após adicionar 5 dias: " + data1.porExtenso());

            data1.proximoDia();
            System.out.println("Próximo dia: " + data1.porExtenso());
        } catch (ExcecaoDataInvalida e) {
            System.out.println("Erro ao manipular a data: " + e.getMessage());
        } finally {
            System.out.println("Programa encerrado.");// Sempre Executado
        }
    /* 
        Data[] datas = new Data[5]; 
        Random random = new Random();
        for (int i = 0; i < datas.length; i++) {
            int ano = random.nextInt(3000); 
            int mes = random.nextInt(12) + 1; 
            int dia = random.nextInt(31) + 1; 
            try {
                datas[i] = new Data(ano, mes, dia);
            } catch (ExcecaoDataInvalida e) {
                System.out.println("Erro ao criar data: " + e.getMessage());
            }
        }
    
        System.out.println("Lista original:");
        imprimirDatas(datas);
    
        Ordenavel[] ordenavelCrescente = Ordenador.crescente(datas);
        Data[] crescente = Arrays.copyOf(ordenavelCrescente, ordenavelCrescente.length, Data[].class);
        System.out.println("\nLista ordenada em ordem crescente:");
        imprimirDatas(crescente);
    
        Ordenavel[] ordenavelDecrescente = Ordenador.decrescente(datas);
        Data[] decrescente = Arrays.copyOf(ordenavelDecrescente, ordenavelDecrescente.length, Data[].class);
        System.out.println("\nLista ordenada em ordem decrescente:");
        imprimirDatas(decrescente);
    }
    private static void imprimirDatas(Data[] datas) {
        for (Data data : datas) {
            System.out.println(data);
        }*/
    }
    
}
