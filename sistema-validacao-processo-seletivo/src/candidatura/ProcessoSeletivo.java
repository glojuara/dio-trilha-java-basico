package candidatura;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    private static final double SALARIO_BASE = 2_000.00;
    private static final int LIMITE_CANDIDATOS_SELECIONADOS = 5;
    private static final int NUMERO_CANDIDATOS = 50;



    public static void main(String[] args) {

        System.out.println("Iniciando o processo seletivo");

        String[] candidatosSelecionados = selecaoCandidatos();
        System.out.println("# ENTRANDO EM CONTATO COM OS CANDIDATOS #");
        imprimirCandidatosSelecionados(candidatosSelecionados);

    }

    static String [] selecaoCandidatos() {
        String [] candidatos = obterCandidatos(NUMERO_CANDIDATOS);
        String [] candidatosSelecionados = new String[LIMITE_CANDIDATOS_SELECIONADOS];
        int selecionados = 0;

        for (int i = 0; i < candidatos.length && selecionados < LIMITE_CANDIDATOS_SELECIONADOS; i++) {
            double salarioPretendido = obterSalarioPretendidoDeFormaAleatoria();
            String candidato = candidatos[i];
            System.out.println(
                    MessageFormat.format("O candidato {0} solicitou o salario de {1}", candidato, salarioPretendido)
            );
            if (devoLigarParaCandidato(salarioPretendido)) {
                candidatosSelecionados[selecionados++] = candidato;
            }
        }

        System.out.println(MessageFormat.format("{0} candidato(s) foram selecionados para vaga", selecionados));

        return candidatosSelecionados;

    }

    static void imprimirCandidatosSelecionados(String [] candidatos) {
        for (String candidato : candidatos) {
            if (candidato != null) {
                System.out.println(" >>>>>>>>>>>>>>>>>>>> ");
                System.out.println(
                        MessageFormat.format("O candidato {0} foi selecionado para vaga", candidato)
                );
                entrandoEmContato(candidato);
            }
        }

    }

    static void ligarParaCandidatosSelecionados(String [] candidatos) {
        for (String candidato : candidatos) {
            if (candidato != null) {
                entrandoEmContato(candidato);
            }
        }
    }

    static double obterSalarioPretendidoDeFormaAleatoria() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static String[] obterCandidatos(int numeroCandidatos) {

        String[] candidatos = new String[numeroCandidatos];
        for (int i = 0; i < numeroCandidatos; i++) {
            candidatos[i] = MessageFormat.format("Candidato {0}", i + 1);
        }

        return candidatos;
    }

    static boolean devoLigarParaCandidato(double salarioPretendido) {
        if (SALARIO_BASE > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
            return true;
        } else if (SALARIO_BASE == salarioPretendido) {
            System.out.println("LIGAR COM CONTRA PROPOSTA");
            return true;
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
            return false;
        }
    }

    static void entrandoEmContato(String cadidato) {
        int tentativasRealizadas = 0;
        boolean continuarTentando = true;
        boolean atendeu;

        do {
            if (tentativasRealizadas == 3) {
                continuarTentando = false;
            }

            atendeu = atender();
            if (atendeu) {
                continuarTentando = false;
            }

            tentativasRealizadas++;
        } while (continuarTentando);

        if (atendeu) {
            System.out.println(MessageFormat.format(
                    "Candidato {0} atendeu na tentativa de numero {1}", cadidato, tentativasRealizadas
            ));
        } else {
            System.out.println(MessageFormat.format(
                    "Candidato {0} não atendeu", cadidato
            ));
        }

    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

}
