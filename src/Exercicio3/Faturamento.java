/*
Admito que nunca tinha tentado ler um JSON pra usar seus dados antes, então me baseei em um tutorial de 6 anos atrás.
Talvez a biblioteca que eu usei seja não seja a ideal, já que é de 2008,
mas preferi usar mesmo assim, por ser um tutorial muito bom.
O código pode não ser o mais robusto, bonito de se ler, ou eficiente... mas eu honestamente gastei tempo demais fazendo isso
(comecei as 18:16 e acabei as 21:33) e ta funcionando... então acho que já serve.
vou tentar comentar bastante esse código pra explicar o que estou fazendo, já que a biblioteca é bem antiga
 */

package Exercicio3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Faturamento {
    public static void main(String[] args) {

        // instancia básica da outra classe
        DadosFaturamento dados = new DadosFaturamento();

        JSONParser parser = new JSONParser();

        //variaveis para fazer as funções
        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0.0;
        int diasAcimaDaMedia = 0;
        int totalDias = 0;

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/resources/faturamentoDiario.json"));

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;

                //por algum motivo, os dados são lidos como long, então tenho que passar para int
                dados.setDia(((Long) jsonObject.get("dias")).intValue());
                String faturamentoStr = (String) jsonObject.get("Faturamento");

                double faturamento = 0.0;

                if (faturamentoStr != null && !faturamentoStr.isEmpty()) {
                    faturamentoStr = faturamentoStr.replace("$", "").replace(",", "");
                    faturamento = Double.parseDouble(faturamentoStr);
                }

                dados.setFaturamento(faturamento);

                //essa parte é pra evitar que faturamento nulo seja adicionado na variavel de menor faturamento
                if (faturamento > 0) {
                    if (faturamento < menorFaturamento) {
                        menorFaturamento = faturamento;
                    }
                    if (faturamento > maiorFaturamento) {
                        maiorFaturamento = faturamento;
                    }
                    somaFaturamento += faturamento;
                    totalDias++;
                }

                System.out.println(dados.toString());
            }

            double mediaMensal = somaFaturamento / totalDias;

            //foreach para iterar a parte importante
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String faturamentoStr = (String) jsonObject.get("Faturamento");
                double faturamento = 0.0;

                //redundante, mas não consigo pensar em outra forma de fazer essa parte
                if (faturamentoStr != null && !faturamentoStr.isEmpty()) {
                    faturamentoStr = faturamentoStr.replace("$", "").replace(",", "");
                    faturamento = Double.parseDouble(faturamentoStr);
                }

                if (faturamento > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("\nMenor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
