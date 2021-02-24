package booknk;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import book.external.Delivery;
import book.external.DeliveryService;

@Entity
@Table(name="Reservation_table")
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long productId;
    private Integer statusCode;

    @PostPersist
    public void onPostPersist(){
        Reserved reserved = new Reserved();
        BeanUtils.copyProperties(this, reserved);
        reserved.publishAfterCommit();

////////////////////////////////////////////////////////        
//        //Following code causes dependency to external APIs
//        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
//
//        .external.Delivery delivery = new .external.Delivery();
//        // mappings goes here
//        Application.applicationContext.getBean(.external.DeliveryService.class)
//            .deliver(delivery);
////////////////////////////////////////////////////////

    }

////////////////////////////////////////////////////////    
//    @PostUpdate
//    public void onPostUpdate(){
//        Canceled canceled = new Canceled();
//        BeanUtils.copyProperties(this, canceled);
//        canceled.publishAfterCommit();
//
//    }
////////////////////////////////////////////////////////

    @PreRemove
    public void onPreRemove(){
        Canceled canceled = new Canceled();
        BeanUtils.copyProperties(this, canceled);
        canceled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        Delivery delivery = new Delivery();
        // mappings goes here
        ReservationApplication.applicationContext.getBean(DeliveryService.class)
            .cancel(delivery);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }




}
