package BOOKNK;

public class ProductRegistered extends AbstractEvent {

    private Long id;
    private Integer stock;

    public ProductRegistered(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}