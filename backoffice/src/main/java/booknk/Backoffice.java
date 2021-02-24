package booknk;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Backoffice_table")
public class Backoffice {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer bookStock;

    @PostPersist
    public void onPostPersist(){
        BookUnregistered bookUnregistered = new BookUnregistered();
        BeanUtils.copyProperties(this, bookUnregistered);
        bookUnregistered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        .external.Product product = new .external.Product();
        // mappings goes here
        Application.applicationContext.getBean(.external.ProductService.class)
            .unregisterProduct(product);


    }

    @PrePersist
    public void onPrePersist(){
        BookRegistered bookRegistered = new BookRegistered();
        BeanUtils.copyProperties(this, bookRegistered);
        bookRegistered.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }




}
