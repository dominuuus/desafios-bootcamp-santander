public class ContaPoupanca extends Conta {
    private double rendimento;

    public ContaPoupanca(Cliente cliente, double rendimento) {
        super(cliente);
        this.rendimento = rendimento;
    }

    public void aplicarRendimento() {
        double rendimentoValor = saldo * rendimento;
        saldo += rendimentoValor;
        System.out.println("Rendimento de R$ " + rendimentoValor + " aplicado!");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
        System.out.println(String.format("Taxa de Rendimento: %.2f%%", this.rendimento * 100));
    }
}