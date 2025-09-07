
public abstract class Book implements LibraryItem {
    protected String title;
    protected boolean available = true;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Livro '" + title + "' emprestado.");
        } else {
            System.out.println("Livro '" + title + "' não disponível.");
        }
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("Livro '" + title + "' devolvido.");
    }
}