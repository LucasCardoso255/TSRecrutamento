package Exercicio2;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o número a ser calculado");
        int limite = ler.nextInt();

        if (getFibonnaci(limite).contains(limite))
            System.out.println("Seu número está presente na lista fibonnaci");
        else {
            System.out.println("Seu número não está presente na lista fibonnaci");
        }

        getFibonnaci(limite);

    }

    /*função para calcular a lista fibonacci. eu até pensei em usar um hashset, tornar o acesso privado
     e fazer um código mais bonito e eficiente, mas acho que empresas preferem código menores e mais clean*/

    public static ArrayList<Integer> getFibonnaci(int limite) {
        ArrayList<Integer>lista = new ArrayList<>();

        int primeiro = 1;
        int segundo = 0;
        int soma = 0;

        while (soma<limite){
            soma = primeiro + segundo;
            lista.add(soma);
            if (soma >= limite)
                break;

            /*engraçado que se eu fizer primeira variável receber a segunda,
            e fazer a segunda receber a soma ele faz a conta sozinho*/

            primeiro = segundo;
            segundo = soma;
        }

        return lista;
    }
}