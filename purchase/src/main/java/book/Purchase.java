package book;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Purchase_table")
public class Purchase {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer typeCode;
    private Long productId;
    private Integer stock;

    @PrePersist
    public void onPrePersist(){
        Buyed buyed = new Buyed();
        BeanUtils.copyProperties(this, buyed);
        buyed.publishAfterCommit();


        Disposaled disposaled = new Disposaled();
        BeanUtils.copyProperties(this, disposaled);
        disposaled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        .external.Product product = new .external.Product();
        // mappings goes here
        Application.applicationContext.getBean(.external.ProductService.class)
            .disposalProduct(product);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }




}
