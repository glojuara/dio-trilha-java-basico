package contador;

import javax.swing.*;
import java.util.Scanner;

public class ContadorDinamico {

    public static void main(String[] args) {


        Scanner terminal = new Scanner(System.in);

        System.out.print("Informe o primeiro numero: ");
        int parametro1 = Integer.parseInt(terminal.nextLine());

        System.out.print("Informe o segundo numero: ");
        int parametro2 = Integer.parseInt(terminal.nextLine());

        contar(parametro1, parametro2);


    }


    public static void contar(int parametro1, int parametro2) {

        if (parametro1 > parametro2) {
            throw new ParametrosInvalidosException("O parametro 2 deve ser maior que o parametro 1");
        }

        if (parametro1 < 0 ) {
            throw new ParametrosInvalidosException("Os parametros devem ser um numero inteiro positivo");
        }

        for (int i = 1; i <= parametro2 - parametro1; i++) {
            System.out.println(i);
        }



    }


}
