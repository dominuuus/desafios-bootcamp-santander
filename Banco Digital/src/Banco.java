import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContas() {
        System.out.println("=== Lista de Contas do Banco " + nome + " ===");
        for (Conta conta : contas) {
            System.out.println("Titular: " + conta.cliente.getNome() + 
                             " | Agência: " + conta.getAgencia() + 
                             " | Número: " + conta.getNumero() + 
                             " | Saldo: R$ " + conta.getSaldo());
        }
    }

    public String getNome() {
        return nome;
    }
}