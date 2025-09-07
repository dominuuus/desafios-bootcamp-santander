
import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private static LibraryCatalog instance;

    private LibraryCatalog() {}

    public static LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public LibraryItem findItem(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}