
//Como teóricamente esse programa lida com dados monetários, decidi deixar tudo como private por segurança.

package Exercicio3;

public class DadosFaturamento {

    //getters e setters básicos

    private int dia;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    private double faturamento;

    //função para devolver os valores do arquivo
    @Override
    public String toString(){
        return "\nDia: " + dia + "\nFaturamento: " + faturamento;
    }
}
