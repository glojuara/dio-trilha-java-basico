import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ContaTerminal.ContaTerminalBuilder contaTerminalBuilder = new ContaTerminal.ContaTerminalBuilder();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o numero da conta: ");
        contaTerminalBuilder.numero(Integer.parseInt(scanner.nextLine()));

        System.out.print("Informe a agencia: ");
        contaTerminalBuilder.agencia(scanner.nextLine());

        System.out.print("Informe o nome do cliente: ");
        contaTerminalBuilder.nomeCliente(scanner.nextLine());

        System.out.print("Informe o saldo inicial da conta: ");
        contaTerminalBuilder.saldo(Double.parseDouble(scanner.nextLine()));

        ContaTerminal contaTerminal = contaTerminalBuilder.build();

        System.out.println("Conta criada com sucesso: " + contaTerminal);
        scanner.close();
    }


}