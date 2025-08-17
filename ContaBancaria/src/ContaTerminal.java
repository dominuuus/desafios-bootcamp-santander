import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor, digite o número da agência: ");
        String agencia = scan.nextLine();

        System.out.println("Por favor, digite o número da conta: ");
        String conta = scan.nextLine();

        String nomeCliente = "MARIO DE ANDRADE";
        double saldo = 237.48;

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + conta + " e seu saldo de R$ " + saldo + " já está disponível para saque.");
        scan.close();

    }
}
