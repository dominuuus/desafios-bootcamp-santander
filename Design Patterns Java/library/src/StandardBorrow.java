
public class StandardBorrow implements BorrowStrategy {
    @Override
    public void borrow(LibraryItem item) {
        item.borrow();
        System.out.println("Empréstimo padrão: 7 dias.");
    }
}