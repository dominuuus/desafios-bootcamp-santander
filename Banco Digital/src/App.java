public class App {
    public static void main(String[] args) {

        Banco banco = new Banco("Dom Bank");

        System.out.println("Bem vindo ao " + banco.getNome() + "\n");
        
        Cliente cliente1 = new Cliente("João Victor Martins", "123.456.789-78");
        Cliente cliente2 = new Cliente("Carla Martins", "355.654.541-58");
        Cliente cliente3 = new Cliente("Viviane Pessoa", "652.654.616-85");
        Cliente cliente4 = new Cliente("Nicolas Ferreira", "795.654.851-00");
        Cliente cliente5 = new Cliente("Francisca Silva", "855.542.861-86");
        Cliente cliente6 = new Cliente("Maria Clara Medeiros de Moraes", "987.654.578-03");
        
        Conta cc1 = new ContaCorrente(cliente1, 8500);
        Conta cc2 = new ContaCorrente(cliente2, 5400);
        Conta cc3 = new ContaCorrente(cliente3, 800);
        Conta cc4 = new ContaCorrente(cliente4, 2100);
        Conta cp1 = new ContaPoupanca(cliente5, 0.10);
        Conta cp2 = new ContaPoupanca(cliente6, 0.05);
        
        banco.adicionarConta(cc1);
        banco.adicionarConta(cc2);
        banco.adicionarConta(cc3);
        banco.adicionarConta(cc4);
        banco.adicionarConta(cp1);
        banco.adicionarConta(cp2);
        
        System.out.println("=== OPERAÇÕES BANCÁRIAS ===\n");
        
        cc1.depositar(2000);
        cc1.sacar(500);
        cc2.depositar(101);
        cc3.sacar(800);
        cc3.depositar(2000);
        cc4.sacar(3000);
        cc3.transferir(300, cc4);

        cp1.depositar(1000);
        cp2.sacar(200);
        cp2.depositar(500);
        cp1.transferir(200, cp2);
        
        ((ContaPoupanca) cp1).aplicarRendimento();
        
        System.out.println("\n");
        cc1.imprimirExtrato();

        System.out.println("\n");
        cc2.imprimirExtrato();

        System.out.println("\n");
        cc3.imprimirExtrato();

        System.out.println("\n");
        cc4.imprimirExtrato();

        System.out.println("\n");
        cp1.imprimirExtrato();

        System.out.println("\n");
        cp2.imprimirExtrato();

        System.out.println("\n");
        
        banco.listarContas();
    }
}