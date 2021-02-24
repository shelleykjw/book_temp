package BOOKNK;

public class BookUnregistered extends AbstractEvent {

    private Long bookId;
    private Integer bookStock;

    public BookUnregistered(){
        super();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }
}