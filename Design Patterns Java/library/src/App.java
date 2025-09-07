
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Aplicação do Singleton
        LibraryCatalog catalog = LibraryCatalog.getInstance(); 

        // Aplicação do Factories
        ItemFactory physicalFactory = new PhysicalBookFactory();
        ItemFactory eBookFactory = new EBookFactory();

        // Adicionar itens
        LibraryItem book1 = physicalFactory.createItem("Java Patterns");
        LibraryItem book2 = new SpecialEditionDecorator(eBookFactory.createItem("Design Essentials")); // Aplicação do Decorator

        catalog.addItem(book1);
        catalog.addItem(book2);

        // Aplicação do Observers
        User user1 = new User("Alice");
        catalog.registerObserver(user1);

        // Aplicação do Strategies
        BorrowStrategy standard = new StandardBorrow();
        BorrowStrategy premium = new PremiumBorrow();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Emprestar livro (padrão)\n2. Emprestar livro (premium)\n3. Devolver livro\n4. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) break;

            System.out.print("Título do livro: ");
            String title = scanner.nextLine();

            LibraryItem item = catalog.findItem(title);
            if (item == null) {
                System.out.println("Livro não encontrado.");
                continue;
            }

            if (choice == 1) {
                standard.borrow(item);
            } else if (choice == 2) {
                premium.borrow(item);
            } else if (choice == 3) {
                item.returnItem();
                catalog.notifyObservers("Livro '" + title + "' agora disponível!"); // Aplicação do Observer
            }
        }
        scanner.close();
    }
}
