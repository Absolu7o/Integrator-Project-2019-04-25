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
 * Itemcategory generated by hbm2java
 */
@Entity
@Table(name="itemcategory"
    ,schema="dksystem"
)
public class Itemcategory  implements java.io.Serializable {


     private int code;
     private String description;
     private Set<Item> items = new HashSet<Item>(0);

    public Itemcategory() {
    }

	
    public Itemcategory(int code) {
        this.code = code;
    }
    public Itemcategory(int code, String description, Set<Item> items) {
       this.code = code;
       this.description = description;
       this.items = items;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="itemcategory")
    public Set<Item> getItems() {
        return this.items;
    }
    
    public void setItems(Set<Item> items) {
        this.items = items;
    }




}


