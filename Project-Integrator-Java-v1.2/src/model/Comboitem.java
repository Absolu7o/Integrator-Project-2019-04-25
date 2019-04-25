package model;
// Generated 25/04/2019 00:40:20 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Comboitem generated by hbm2java
 */
@Entity
@Table(name="comboitem"
    ,schema="gcsystem"
)
public class Comboitem  implements java.io.Serializable {


     private int code;
     private Item itemByCodeItem;
     private Item itemByCodeComboitem;
     private Integer countitem;

    public Comboitem() {
    }

	
    public Comboitem(int code, Item itemByCodeItem, Item itemByCodeComboitem) {
        this.code = code;
        this.itemByCodeItem = itemByCodeItem;
        this.itemByCodeComboitem = itemByCodeComboitem;
    }
    public Comboitem(int code, Item itemByCodeItem, Item itemByCodeComboitem, Integer countitem) {
       this.code = code;
       this.itemByCodeItem = itemByCodeItem;
       this.itemByCodeComboitem = itemByCodeComboitem;
       this.countitem = countitem;
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
    @JoinColumn(name="code_item", nullable=false)
    public Item getItemByCodeItem() {
        return this.itemByCodeItem;
    }
    
    public void setItemByCodeItem(Item itemByCodeItem) {
        this.itemByCodeItem = itemByCodeItem;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="code_comboitem", nullable=false)
    public Item getItemByCodeComboitem() {
        return this.itemByCodeComboitem;
    }
    
    public void setItemByCodeComboitem(Item itemByCodeComboitem) {
        this.itemByCodeComboitem = itemByCodeComboitem;
    }

    
    @Column(name="countitem")
    public Integer getCountitem() {
        return this.countitem;
    }
    
    public void setCountitem(Integer countitem) {
        this.countitem = countitem;
    }




}

