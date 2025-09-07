
public class PremiumBorrow implements BorrowStrategy {
    @Override
    public void borrow(LibraryItem item) {
        item.borrow();
        System.out.println("Empréstimo premium: 14 dias + prioridade.");
    }
}