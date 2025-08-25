public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, double chequeEspecial) {
        super(cliente);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + chequeEspecial >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente (incluindo cheque especial) para saque!");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
        System.out.println(String.format("Cheque Especial: %.2f", this.chequeEspecial));
        System.out.println("Saldo Disponível: " + (this.saldo + this.chequeEspecial));
    }
}