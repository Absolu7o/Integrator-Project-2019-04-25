package model;
// Generated 19/05/2019 14:54:07 by Hibernate Tools 4.3.1


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Item generated by hbm2java
 */
@Entity
@Table(name="item"
    ,schema="dksystem"
)
public class Item  implements java.io.Serializable {


     private int code;
     private Itemcategory itemcategory;
     private String barcode;
     private String description;
     private String measureunit;
     private Date datetimeins;
     private Set<Itemlog> itemlogs = new HashSet<Itemlog>(0);
     private Set<Itemcompany> itemcompanies = new HashSet<Itemcompany>(0);

    public Item() {
    }

	
    public Item(int code, Itemcategory itemcategory) {
        this.code = code;
        this.itemcategory = itemcategory;
    }
    public Item(int code, Itemcategory itemcategory, String barcode, String description, String measureunit, Date datetimeins, Set<Itemlog> itemlogs, Set<Itemcompany> itemcompanies) {
       this.code = code;
       this.itemcategory = itemcategory;
       this.barcode = barcode;
       this.description = description;
       this.measureunit = measureunit;
       this.datetimeins = datetimeins;
       this.itemlogs = itemlogs;
       this.itemcompanies = itemcompanies;
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
    @JoinColumn(name="code_itemcategory", nullable=false)
    public Itemcategory getItemcategory() {
        return this.itemcategory;
    }
    
    public void setItemcategory(Itemcategory itemcategory) {
        this.itemcategory = itemcategory;
    }

    
    @Column(name="barcode", length=9)
    public String getBarcode() {
        return this.barcode;
    }
    
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    
    @Column(name="description", length=40)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="measureunit", length=20)
    public String getMeasureunit() {
        return this.measureunit;
    }
    
    public void setMeasureunit(String measureunit) {
        this.measureunit = measureunit;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datetimeins", length=29)
    public Date getDatetimeins() {
        return this.datetimeins;
    }
    
    public void setDatetimeins(Date datetimeins) {
        this.datetimeins = datetimeins;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="item")
    public Set<Itemlog> getItemlogs() {
        return this.itemlogs;
    }
    
    public void setItemlogs(Set<Itemlog> itemlogs) {
        this.itemlogs = itemlogs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="item")
    public Set<Itemcompany> getItemcompanies() {
        return this.itemcompanies;
    }
    
    public void setItemcompanies(Set<Itemcompany> itemcompanies) {
        this.itemcompanies = itemcompanies;
    }




}


