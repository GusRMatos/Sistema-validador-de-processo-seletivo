package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("processo seletivo");
        String [] cadidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (String candidato : cadidatos) {
            entrandoEmContado(candidato);
        }
    }
    static void entrandoEmContado(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas ++;
            }else {
                System.out.println("Contato realizado com sucesso");
            }
        }while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu){
            System.out.println("Conseguimos contato com "+ candidato + " na " + tentativasRealizadas +" tentativa");
        }else {
            System.out.println("Nao conseguimos realizar contato com "+ candidato + ", numero maximo de tentativas "+ tentativasRealizadas );
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String [] cadidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        for ( String cadidato: cadidatos) {
            System.out.println("O candidato selecionado foi "+ cadidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA" };
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou esse valor de salario " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual ++;
        }
    }

    static double valorPretendido (){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato (double pretencaoSalarial) {
        double salarioBase = 2000.0;
        if(salarioBase > pretencaoSalarial){
            System.out.println("Ligar para o candidato");
        }
        else if (salarioBase == pretencaoSalarial){
            System.out.println("ligar para o candidato com contra proposta");
        }else {
            System.out.println("aguardando demais candidatos");
        }
    }
}
