
public class SpecialEditionDecorator implements LibraryItem {
    private LibraryItem wrappedItem;

    public SpecialEditionDecorator(LibraryItem item) {
        this.wrappedItem = item;
    }

    @Override
    public String getTitle() {
        return wrappedItem.getTitle() + " (Edição Especial)";
    }

    @Override
    public boolean isAvailable() {
        return wrappedItem.isAvailable();
    }

    @Override
    public void borrow() {
        wrappedItem.borrow();
        System.out.println("Inclui extras na edição especial.");
    }

    @Override
    public void returnItem() {
        wrappedItem.returnItem();
    }
}