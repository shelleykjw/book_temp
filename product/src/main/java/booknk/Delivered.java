package booknk;

public class Delivered extends AbstractEvent {

    private Long id;
    private Integer statusCode;
    private Long productId;
    private Long reservationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getOrderId() {
        return reservationId;
    }

    public void setOrderId(Long reservationId) {
        this.reservationId = reservationId;
    }
}