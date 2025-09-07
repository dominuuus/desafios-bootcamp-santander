
public class EBookFactory extends ItemFactory {
    @Override
    public LibraryItem createItem(String title) {
        return new EBook(title);
    }
}