import java.util.Random;

public class Aplicacao {
    public static void main(String[] args) {
        
        Data[] datas = new Data[5];
        Random rand = new Random();
        for (int i = 0; i < datas.length; i++) {
            datas[i] = new Data(rand.nextInt(31) + 1, rand.nextInt(12) + 1, rand.nextInt(100) + 2000);
        }

        System.out.println("Lista original:");
        for (Data data : datas) {
            System.out.println(data);
        }
        System.out.println();

        Ordenavel[] crescente = Ordenador.crescente(datas);
        System.out.println("Lista ordenada em ordem crescente:");
        for (Ordenavel data : crescente) {
            System.out.println((Data)data);
        }
        System.out.println();

        Ordenavel[] decrescente = Ordenador.decrescente(datas);
        System.out.println("Lista ordenada em ordem decrescente:");
        for (Ordenavel data : decrescente) {
            System.out.println((Data)data);
        }
    }
}
