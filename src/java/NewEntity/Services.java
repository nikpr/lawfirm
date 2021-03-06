package NewEntity;
// Generated 24.12.2016 0:32:12 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Services generated by hbm2java
 */
@Entity
@Table(name="services"
    ,catalog="law_firm_db"
)
@XmlRootElement
public class Services extends BaseEntity implements java.io.Serializable {


     private int id;
     private String serviceName;
     private String description;
     private BigDecimal price;
     private Set<Businesses> businesseses = new HashSet<Businesses>(0);

    public Services() {
    }

	
    public Services(int id, String serviceName, BigDecimal price) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
    }
    public Services(int id, String serviceName, String description, BigDecimal price, Set<Businesses> businesseses) {
       this.id = id;
       this.serviceName = serviceName;
       this.description = description;
       this.price = price;
       this.businesseses = businesseses;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="ServiceName", nullable=false, length=50)
    public String getServiceName() {
        return this.serviceName;
    }
    
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    
    @Column(name="Description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="Price", nullable=false)
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="services")
@XmlTransient
    public Set<Businesses> getBusinesseses() {
        return this.businesseses;
    }
    
    public void setBusinesseses(Set<Businesses> businesseses) {
        this.businesseses = businesseses;
    }




}


