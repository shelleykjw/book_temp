package BOOK;

public class Disposaled extends AbstractEvent {

    private Long id;

    public Disposaled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}