package model;
// Generated 15/05/2019 21:27:16 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Requestpay generated by hbm2java
 */
@Entity
@Table(name="requestpay"
    ,schema="gcsystem"
)
public class Requestpay  implements java.io.Serializable {


     private int code;
     private Request request;
     private Userlogin userlogin;
     private BigDecimal price;
     private String typepay;

    public Requestpay() {
    }

	
    public Requestpay(int code) {
        this.code = code;
    }
    public Requestpay(int code, Request request, Userlogin userlogin, BigDecimal price, String typepay) {
       this.code = code;
       this.request = request;
       this.userlogin = userlogin;
       this.price = price;
       this.typepay = typepay;
    }
   
     @Id 

    
    @Column(name="code", unique=true, nullable=false)
    public int getCode() {
        return this.code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="code_request")
    public Request getRequest() {
        return this.request;
    }
    
    public void setRequest(Request request) {
        this.request = request;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="code_userlogin")
    public Userlogin getUserlogin() {
        return this.userlogin;
    }
    
    public void setUserlogin(Userlogin userlogin) {
        this.userlogin = userlogin;
    }

    
    @Column(name="price", precision=12)
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    
    @Column(name="typepay", length=3)
    public String getTypepay() {
        return this.typepay;
    }
    
    public void setTypepay(String typepay) {
        this.typepay = typepay;
    }




}


