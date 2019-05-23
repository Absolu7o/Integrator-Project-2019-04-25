package model;
// Generated 19/05/2019 14:54:07 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Productcategory generated by hbm2java
 */
@Entity
@Table(name="productcategory"
    ,schema="gcsystem"
)
public class Productcategory  implements java.io.Serializable {


     private int code;
     private String description;
     private Set<Product> products = new HashSet<Product>(0);
     private Set<Additional> additionals = new HashSet<Additional>(0);
     private Set<Filterhistory> filterhistories = new HashSet<Filterhistory>(0);

    public Productcategory() {
    }

	
    public Productcategory(int code) {
        this.code = code;
    }
    public Productcategory(int code, String description, Set<Product> products, Set<Additional> additionals, Set<Filterhistory> filterhistories) {
       this.code = code;
       this.description = description;
       this.products = products;
       this.additionals = additionals;
       this.filterhistories = filterhistories;
    }
   
     @Id 

    
    @Column(name="code", nullable=false)
    public int getCode() {
        return this.code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }

    
    @Column(name="description", length=40)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productcategory")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productcategory")
    public Set<Additional> getAdditionals() {
        return this.additionals;
    }
    
    public void setAdditionals(Set<Additional> additionals) {
        this.additionals = additionals;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productcategory")
    public Set<Filterhistory> getFilterhistories() {
        return this.filterhistories;
    }
    
    public void setFilterhistories(Set<Filterhistory> filterhistories) {
        this.filterhistories = filterhistories;
    }




}


