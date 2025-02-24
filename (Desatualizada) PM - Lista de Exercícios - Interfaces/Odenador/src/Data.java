public class Data implements Ordenavel {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
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
}
