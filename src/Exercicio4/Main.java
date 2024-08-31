package Exercicio4;

//O exercicio 3 levou muito tempo, então vou tentar deixar esse bem curto

public class Main {
    public static void main(String[] args) {

        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double total = sp + rj + mg + es + outros;

        double percentualSP = getSomaPercentuais(sp, total);
        double percentualRJ = getSomaPercentuais(rj, total);
        double percentualMG = getSomaPercentuais(mg, total);
        double percentualES = getSomaPercentuais(es, total);
        double percentualOutros = getSomaPercentuais(outros, total);

        System.out.printf("Valor total: %.2f\n", total);
        System.out.printf("Percentual de SP: %.2f%%\n", percentualSP);
        System.out.printf("Percentual de RJ: %.2f%%\n", percentualRJ);
        System.out.printf("Percentual de MG: %.2f%%\n", percentualMG);
        System.out.printf("Percentual de ES: %.2f%%\n", percentualES);
        System.out.printf("Percentual de Outros: %.2f%%\n", percentualOutros);

    }

    //sempre tento pôr uma função para facilitar a manutenção, nesse caso não foi tão necessário mas não quero perder o costume.

    public static double getSomaPercentuais(double valorEstado, double valorTotal) {

        return (valorEstado / valorTotal) * 100;
    }
}