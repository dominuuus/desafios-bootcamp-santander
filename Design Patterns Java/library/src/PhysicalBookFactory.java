
public class PhysicalBookFactory extends ItemFactory {
    @Override
    public LibraryItem createItem(String title) {
        return new PhysicalBook(title);
    }
}