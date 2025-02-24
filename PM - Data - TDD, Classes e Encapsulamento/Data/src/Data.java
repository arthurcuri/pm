import java.time.LocalDate;

public class Data {
    private int ano;
    private int mes;
    private int dia;

    private static final String[] NOMES_MESES = {
            "Janeiro", "Fevereiro", "Março", "Abril",
            "Maio", "Junho", "Julho", "Agosto",
            "Setembro", "Outubro", "Novembro", "Dezembro"
    };

    private static final String[] NOMES_DIAS_SEMANA = {
            "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira",
            "Quinta-feira", "Sexta-feira", "Sábado"
    };

    public Data(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public Data() {
        LocalDate dataAtual = LocalDate.now();
        this.ano = dataAtual.getYear();
        this.mes = dataAtual.getMonthValue();
        this.dia = dataAtual.getDayOfMonth();
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void adicionaDias(int dias) {
        LocalDate dataAtual = LocalDate.of(ano, mes, dia);
        LocalDate novaData = dataAtual.plusDays(dias);
        this.ano = novaData.getYear();
        this.mes = novaData.getMonthValue();
        this.dia = novaData.getDayOfMonth();
    }

    public int diasNoMes() {
        return LocalDate.of(ano, mes, 1).lengthOfMonth();
    }

    public String diaDaSemana() {
        int diaSemana = LocalDate.of(ano, mes, dia).getDayOfWeek().getValue();
        return NOMES_DIAS_SEMANA[diaSemana == 7 ? 0 : diaSemana - 1];
    }
    
    public boolean eAnoBisexto() {
        return Data.ehAnoBisexto(ano);
    }

    public void proximoDia() {
        LocalDate dataAtual = LocalDate.of(ano, mes, dia);
        LocalDate proximoDia = dataAtual.plusDays(1);
        this.ano = proximoDia.getYear();
        this.mes = proximoDia.getMonthValue();
        this.dia = proximoDia.getDayOfMonth();
    }
    
    public String porExtenso() {
        return dia + " de " + NOMES_MESES[mes - 1] + " de " + ano;
    }

    private static boolean ehAnoBisexto(int ano) {
        return ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0);
    }
}
