public class ContaTerminal {

    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    private ContaTerminal() {}

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    private void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    private void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static class ContaTerminalBuilder {

        private ContaTerminal contaTerminal;

        public ContaTerminalBuilder() {
            contaTerminal = new ContaTerminal();
        }

        public ContaTerminalBuilder numero(int numero) {
            contaTerminal.setNumero(numero);
            return this;
        }

        public ContaTerminalBuilder agencia(String agencia) {
            contaTerminal.setAgencia(agencia);
            return this;
        }

        public ContaTerminalBuilder nomeCliente(String nomeCliente) {
            contaTerminal.setNomeCliente(nomeCliente);
            return this;
        }

        public ContaTerminalBuilder saldo(double saldo) {
            contaTerminal.setSaldo(saldo);
            return this;
        }

        public ContaTerminal build() {
            return contaTerminal;
        }

    }

    @Override
    public String toString() {
        return "ContaTerminal{" +
                "numero=" + numero +
                ", agencia='" + agencia + '\'' +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
