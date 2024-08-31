package Exercicio5;

//o mais fácil, acho que nem preciso comentar nada

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite a palavra para ser invertida: ");
        String palavra = ler.nextLine();
        String palavraInvertida = "";

        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInvertida = palavraInvertida + palavra.charAt(i);
        }
        System.out.println(palavraInvertida);
    }
}
