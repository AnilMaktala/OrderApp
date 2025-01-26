package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the AccountRepresentative type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "AccountRepresentatives")
@Index(name = "bySalesPeriodByOrderTotal", fields = {"salesPeriod","orderTotal"})
public final class AccountRepresentative implements Model {
  public static final QueryField ID = field("AccountRepresentative", "id");
  public static final QueryField ORDER_TOTAL = field("AccountRepresentative", "orderTotal");
  public static final QueryField SALES_PERIOD = field("AccountRepresentative", "salesPeriod");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Customer") @HasMany(associatedWith = "accountRepresentativeID", type = Customer.class) List<Customer> customers = null;
  private final @ModelField(targetType="Order") @HasMany(associatedWith = "accountRepresentativeID", type = Order.class) List<Order> orders = null;
  private final @ModelField(targetType="Int") Integer orderTotal;
  private final @ModelField(targetType="String") String salesPeriod;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public List<Customer> getCustomers() {
      return customers;
  }
  
  public List<Order> getOrders() {
      return orders;
  }
  
  public Integer getOrderTotal() {
      return orderTotal;
  }
  
  public String getSalesPeriod() {
      return salesPeriod;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private AccountRepresentative(String id, Integer orderTotal, String salesPeriod) {
    this.id = id;
    this.orderTotal = orderTotal;
    this.salesPeriod = salesPeriod;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      AccountRepresentative accountRepresentative = (AccountRepresentative) obj;
      return ObjectsCompat.equals(getId(), accountRepresentative.getId()) &&
              ObjectsCompat.equals(getOrderTotal(), accountRepresentative.getOrderTotal()) &&
              ObjectsCompat.equals(getSalesPeriod(), accountRepresentative.getSalesPeriod()) &&
              ObjectsCompat.equals(getCreatedAt(), accountRepresentative.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), accountRepresentative.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getOrderTotal())
      .append(getSalesPeriod())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("AccountRepresentative {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("orderTotal=" + String.valueOf(getOrderTotal()) + ", ")
      .append("salesPeriod=" + String.valueOf(getSalesPeriod()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static AccountRepresentative justId(String id) {
    return new AccountRepresentative(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      orderTotal,
      salesPeriod);
  }
  public interface BuildStep {
    AccountRepresentative build();
    BuildStep id(String id);
    BuildStep orderTotal(Integer orderTotal);
    BuildStep salesPeriod(String salesPeriod);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private Integer orderTotal;
    private String salesPeriod;
    @Override
     public AccountRepresentative build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new AccountRepresentative(
          id,
          orderTotal,
          salesPeriod);
    }
    
    @Override
     public BuildStep orderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
        return this;
    }
    
    @Override
     public BuildStep salesPeriod(String salesPeriod) {
        this.salesPeriod = salesPeriod;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Integer orderTotal, String salesPeriod) {
      super.id(id);
      super.orderTotal(orderTotal)
        .salesPeriod(salesPeriod);
    }
    
    @Override
     public CopyOfBuilder orderTotal(Integer orderTotal) {
      return (CopyOfBuilder) super.orderTotal(orderTotal);
    }
    
    @Override
     public CopyOfBuilder salesPeriod(String salesPeriod) {
      return (CopyOfBuilder) super.salesPeriod(salesPeriod);
    }
  }
  
}
