import java.time.LocalDate;

public class Data implements Ordenavel {
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

    public Data(int ano, int mes, int dia) throws ExcecaoDataInvalida {
        if (ano < 0) {
            throw new ExcecaoDataInvalida("Ano não pode ser negativo: " + ano);
        }
        if (mes < 1 || mes > 12) {
            throw new ExcecaoDataInvalida("Mês deve estar entre 1 e 12: " + mes);
        }
        if (dia < 1 || dia > diasNoMes()) {
            throw new ExcecaoDataInvalida("Dia inválido para o mês atual: " + dia);
        }

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

    public void adicionaDias(int dias) throws ExcecaoDataInvalida {
        LocalDate dataAtual = LocalDate.of(ano, mes, dia);
        LocalDate novaData = dataAtual.plusDays(dias);
        int novoAno = novaData.getYear();
        int novoMes = novaData.getMonthValue();
        int novoDia = novaData.getDayOfMonth();

        if (novoMes != mes || novoAno != ano) {
            throw new ExcecaoDataInvalida("A nova data é inválida.");
        }

        this.ano = novoAno;
        this.mes = novoMes;
        this.dia = novoDia;
    }

    private int diasNoMes() {
        switch (mes) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return eAnoBisexto() ? 29 : 28;
            default:
                return 31;
        }
    }

    public String diaDaSemana() {
        int diaSemana = LocalDate.of(ano, mes, dia).getDayOfWeek().getValue();
        return NOMES_DIAS_SEMANA[diaSemana == 7 ? 0 : diaSemana - 1];
    }

    public boolean eAnoBisexto() {
        return Data.ehAnoBisexto(ano);
    }

    public void proximoDia() throws ExcecaoDataInvalida {
        LocalDate dataAtual = LocalDate.of(ano, mes, dia);
        LocalDate proximoDia = dataAtual.plusDays(1);
        int novoAno = proximoDia.getYear();
        int novoMes = proximoDia.getMonthValue();
        int novoDia = proximoDia.getDayOfMonth();

        if (novoMes != mes || novoAno != ano) {
            throw new ExcecaoDataInvalida("A nova data é inválida.");
        }

        this.ano = novoAno;
        this.mes = novoMes;
        this.dia = novoDia;
    }

    public String porExtenso() {
        return dia + " de " + NOMES_MESES[mes - 1] + " de " + ano;
    }

    private static boolean ehAnoBisexto(int ano) {
        return ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0);
    }

    @Override
    public boolean menorQue(Ordenavel o) {
        Data outraData = (Data) o;
        if (this.ano < outraData.ano) {
            return true;
        } else if (this.ano == outraData.ano && this.mes < outraData.mes) {
            return true;
        } else if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia < outraData.dia) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, ano);
    }

    public void setAno(int ano) throws ExcecaoDataInvalida {
        if (ano < 0) {
            throw new ExcecaoDataInvalida("Ano não pode ser negativo: " + ano);
        }
        this.ano = ano;
    }

    public void setMes(int mes) throws ExcecaoDataInvalida {
        if (mes < 1 || mes > 12) {
            throw new ExcecaoDataInvalida("Mês deve estar entre 1 e 12: " + mes);
        }
        this.mes = mes;
    }

    public void setDia(int dia) throws ExcecaoDataInvalida {
        if (dia < 1 || dia > diasNoMes()) {
            throw new ExcecaoDataInvalida("Dia inválido para o mês atual: " + dia);
        }
        this.dia = dia;
    }

}
