import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] palavras = {
                "cacto", "advogado", "entrevista", "prodígio", "ventilador",
                "computador", "celular", "cadeira", "teclado", "janela",
                "guitarra", "cachorro", "gato", "abacaxi", "banana",
                "camiseta", "sapato", "escova", "caderno", "chocolate",
                "elefante", "girafa", "zebra", "hipopótamo", "tartaruga",
                "morango", "pera", "uva", "pêssego", "melancia",
                "montanha", "oceano", "floresta", "deserto", "cidade",
                "inverno", "verão", "primavera", "outono", "neve",
                "praia", "parque", "shopping", "escola", "trabalho",
                "felicidade", "amor", "alegria", "paz", "sucesso"
        };
        Random random = new Random();

        boolean jogarNovamente;

        do {
            int indiceAleatorio = random.nextInt(palavras.length);
            String palavraAleatoria = palavras[indiceAleatorio];
            int tentativasRestantes = 6;
            char[] letrasCorretas = new char[palavraAleatoria.length()];

            JOptionPane.showMessageDialog(null, "Olá, seja Bem-Vindo ao jogo da Forca");
            JOptionPane.showMessageDialog(null, "Você terá 6 tentativas para acertar a palavra");
            JOptionPane.showMessageDialog(null, "Bom Jogo!!");

            while (tentativasRestantes > 0) {
                String palavraExibida = exibirPalavra(palavraAleatoria, letrasCorretas);
                String mensagem = "Quantidade de letras: " + palavraAleatoria.length() + "\nTentativas restantes: " + tentativasRestantes + "\nPalavra: " + palavraExibida + "\nQual seu palpite:";
                String mensagem_input = JOptionPane.showInputDialog(mensagem);

                if (mensagem_input == null || mensagem_input.isEmpty()) {
                    System.out.println("Insira uma letra!");
                    continue; // volta pro JOptionpane
                }

                char letra = mensagem_input.charAt(0); // local que fica armazenado o input do usuário

                if (palavraAleatoria.contains(String.valueOf(letra))) {
                    letrasCorretas = atualizarLetrasCorretas(palavraAleatoria, letrasCorretas, letra);

                    if (ganhouJogo(palavraAleatoria, letrasCorretas)) {
                        JOptionPane.showMessageDialog(null, "Parabéns, você ganhou!\nA palavra era: " + palavraAleatoria);
                        break;
                    }
                } else {
                    tentativasRestantes--;

                    if (tentativasRestantes == 0) {
                        JOptionPane.showMessageDialog(null, "Você perdeu. A palavra era: " + palavraAleatoria);
                        break;
                    }
                }
            }

            // Pergunte ao usuário se deseja jogar novamente
            int escolha = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?");
            jogarNovamente = (escolha == JOptionPane.YES_OPTION);
        } while (jogarNovamente);

        JOptionPane.showMessageDialog(null, "Obrigado por jogar!");
    }


    public static String exibirPalavra(String palavraSorteada, char[] letrasCorretas) {
        StringBuilder palavraExibida = new StringBuilder();

        for (char letra : palavraSorteada.toCharArray()) {
            palavraExibida.append(letrasCorretasContains(letrasCorretas, letra) ? letra : '_');
        }

        return palavraExibida.toString();
    }

    public static boolean letrasCorretasContains(char[] letrasCorretas, char letra) {
        for (char c : letrasCorretas) {
            if (c == letra) {
                return true;
            }
        }
        return false;
    }

    public static char[] atualizarLetrasCorretas(String palavraSorteada, char[] letrasCorretas, char letra) {
        for (int i = 0; i < palavraSorteada.length(); i++) {
            if (palavraSorteada.charAt(i) == letra) {
                letrasCorretas[i] = letra;
            }
        }
        return letrasCorretas;
    }

    public static boolean ganhouJogo(String palavraSorteada, char[] letrasCorretas) {
        for (char letra : palavraSorteada.toCharArray()) {
            if (!letrasCorretasContains(letrasCorretas, letra)) {
                return false;
            }
        }
        return true;
    }
}
