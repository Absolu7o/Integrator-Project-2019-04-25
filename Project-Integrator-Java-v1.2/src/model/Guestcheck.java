package model;
// Generated 19/05/2019 14:54:07 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Guestcheck generated by hbm2java
 */
@Entity
@Table(name="guestcheck"
    ,schema="gcsystem"
)
public class Guestcheck  implements java.io.Serializable {


     private int code;
     private Company company;
     private String barcode;
     private Set<Request> requests = new HashSet<Request>(0);

    public Guestcheck() {
    }

	
    public Guestcheck(int code) {
        this.code = code;
    }
    public Guestcheck(int code, Company company, String barcode, Set<Request> requests) {
       this.code = code;
       this.company = company;
       this.barcode = barcode;
       this.requests = requests;
    }
   
     @Id 
    
    
    @Column(name="code", nullable=false) 
    public int getCode() {
        return this.code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="code_company")
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }

    
    @Column(name="barcode", length=7)
    public String getBarcode() {
        return this.barcode;
    }
    
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="guestcheck")
    public Set<Request> getRequests() {
        return this.requests;
    }
    
    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }




}


