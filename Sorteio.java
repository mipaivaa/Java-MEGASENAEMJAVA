import java.util.Scanner; // Permite a leitura de entradas do usuário
import java.util.Arrays; // Manipular arrays
import java.util.Random; // Usada para gerar números aleatórios

public class Sorteio { // Declaração da classe
    public static void main(String[] args) { // Início do método
        Scanner scanner = new Scanner(System.in); // Objeto para ler entradas
        int[] numerosEscolhidos = new int[7]; // Array dos números escolhidos

        System.out.println("Bem-vindo à Mega-Sena!");
        System.out.println("Por favor, digite 7 números inteiros de 0 a 100.");

        for (int i = 0; i < 7; i++) { // Loop para obter os 7 números
            boolean entradaValida = false; // Loop para garantir que a entrada do usuário seja válida

            while (!entradaValida) {
                System.out.print("Digite o número " + (i + 1) + ": ");

                if (scanner.hasNextInt()) {
                    int numero = scanner.nextInt(); // Verifica se a entrada é um número inteiro

                    if (numero >= 0 && numero <= 100) { // Analisa critérios
                        numerosEscolhidos[i] = numero;
                        entradaValida = true;
                    } else {
                        System.out.println("Por favor, digite um número entre 0 e 100.");
                    }
                } else {
                    System.out.println("Por favor, digite um número inteiro.");
                    scanner.next(); // Limpa o buffer
                }
            }
        }

        int[] numerosSorteados = sortearNumeros(); // Chama a função sortearNumeros
        System.out.println("Números escolhidos: " + Arrays.toString(numerosEscolhidos)); // Converte um array em string para ficar mais legível
        System.out.println("Números sorteados: " + Arrays.toString(numerosSorteados));


        // Compara os resultados e calcula o prêmio
        for (int i = 0; i < 7; i++) { // Percorre os números escolhidos pelo usuário, que estão armazenados no array
            int numeroEscolhido = numerosEscolhidos[i];

            for (int j = 0; j < 7; j++) {
                if (numeroEscolhido == numerosSorteados[j]) {
                    System.out.println("Parabéns! Você acertou o número " + numeroEscolhido + "!");
                }
            }
        }

        // Calcula o prêmio com base nos contadores
        int quantidadeAcertos = contarAcertos(numerosEscolhidos, numerosSorteados);
        int premioTotal = calcularPremio(quantidadeAcertos);
        System.out.println("Prêmio Total: R$" + premioTotal);
    }

    // Segunda parte: Sortear
    private static int[] sortearNumeros() { // Função para sortear os números
        Random random = new Random(); // Objeto para gerar números aleatórios
        int[] numerosSorteados = new int[7]; // Array para armazenar os números sorteados

        for (int i = 0; i < 7; i++) {
            numerosSorteados[i] = random.nextInt(101); // Gera número aleatório de 0 a 100
        }

        return numerosSorteados;
    }

    // Função para contar os acertos
    private static int contarAcertos(int[] escolhidos, int[] sorteados) {
        int acertos = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (escolhidos[i] == sorteados[j]) {
                    acertos++;
                }
            }
        }

        return acertos;
    }

    // Função para calcular o prêmio
    private static int calcularPremio(int acertos) {
        if (acertos == 5) {
            return 10000;
        } else if (acertos == 6) {
            return 50000;
        } else if (acertos == 7) {
            return 200000;
        } else {
            return 0;
        }
    }
}
