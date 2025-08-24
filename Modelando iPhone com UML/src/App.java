public class App {
    public static void main(String[] args) {
        IPhone meuIPhone = new IPhone();

        meuIPhone.selecionarMusica("Bohemian Rhapsody");
        meuIPhone.tocar();
        meuIPhone.pausar();

        meuIPhone.ligar("081 99999-9999");
        meuIPhone.atender();
        meuIPhone.iniciarCorreioVoz();

        meuIPhone.exibirPagina("www.github.com/dominuuus");
        meuIPhone.adicionarNovaAba();
        meuIPhone.atualizarPagina();
    }
}
