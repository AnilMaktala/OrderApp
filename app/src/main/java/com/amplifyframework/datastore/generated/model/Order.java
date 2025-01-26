package com.amplifyframework.datastore.generated.model;

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

/** This is an auto generated class representing the Order type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Orders")
@Index(name = "byCustomerByStatusByDate", fields = {"customerID","status","date"})
@Index(name = "byRepresentativebyDate", fields = {"accountRepresentativeID","date"})
@Index(name = "byProduct", fields = {"productID","id"})
public final class Order implements Model {
  public static final QueryField ID = field("Order", "id");
  public static final QueryField CUSTOMER_ID = field("Order", "customerID");
  public static final QueryField ACCOUNT_REPRESENTATIVE_ID = field("Order", "accountRepresentativeID");
  public static final QueryField PRODUCT_ID = field("Order", "productID");
  public static final QueryField STATUS = field("Order", "status");
  public static final QueryField AMOUNT = field("Order", "amount");
  public static final QueryField DATE = field("Order", "date");
  public static final QueryField AWS_TIME_VALUE = field("Order", "awsTimeValue");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String customerID;
  private final @ModelField(targetType="ID", isRequired = true) String accountRepresentativeID;
  private final @ModelField(targetType="ID", isRequired = true) String productID;
  private final @ModelField(targetType="String", isRequired = true) String status;
  private final @ModelField(targetType="Int", isRequired = true) Integer amount;
  private final @ModelField(targetType="String", isRequired = true) String date;
  private final @ModelField(targetType="AWSTime") Temporal.Time awsTimeValue;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getCustomerId() {
      return customerID;
  }
  
  public String getAccountRepresentativeId() {
      return accountRepresentativeID;
  }
  
  public String getProductId() {
      return productID;
  }
  
  public String getStatus() {
      return status;
  }
  
  public Integer getAmount() {
      return amount;
  }
  
  public String getDate() {
      return date;
  }
  
  public Temporal.Time getAwsTimeValue() {
      return awsTimeValue;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Order(String id, String customerID, String accountRepresentativeID, String productID, String status, Integer amount, String date, Temporal.Time awsTimeValue) {
    this.id = id;
    this.customerID = customerID;
    this.accountRepresentativeID = accountRepresentativeID;
    this.productID = productID;
    this.status = status;
    this.amount = amount;
    this.date = date;
    this.awsTimeValue = awsTimeValue;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Order order = (Order) obj;
      return ObjectsCompat.equals(getId(), order.getId()) &&
              ObjectsCompat.equals(getCustomerId(), order.getCustomerId()) &&
              ObjectsCompat.equals(getAccountRepresentativeId(), order.getAccountRepresentativeId()) &&
              ObjectsCompat.equals(getProductId(), order.getProductId()) &&
              ObjectsCompat.equals(getStatus(), order.getStatus()) &&
              ObjectsCompat.equals(getAmount(), order.getAmount()) &&
              ObjectsCompat.equals(getDate(), order.getDate()) &&
              ObjectsCompat.equals(getAwsTimeValue(), order.getAwsTimeValue()) &&
              ObjectsCompat.equals(getCreatedAt(), order.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), order.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCustomerId())
      .append(getAccountRepresentativeId())
      .append(getProductId())
      .append(getStatus())
      .append(getAmount())
      .append(getDate())
      .append(getAwsTimeValue())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Order {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("customerID=" + String.valueOf(getCustomerId()) + ", ")
      .append("accountRepresentativeID=" + String.valueOf(getAccountRepresentativeId()) + ", ")
      .append("productID=" + String.valueOf(getProductId()) + ", ")
      .append("status=" + String.valueOf(getStatus()) + ", ")
      .append("amount=" + String.valueOf(getAmount()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("awsTimeValue=" + String.valueOf(getAwsTimeValue()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static CustomerIdStep builder() {
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
  public static Order justId(String id) {
    return new Order(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      customerID,
      accountRepresentativeID,
      productID,
      status,
      amount,
      date,
      awsTimeValue);
  }
  public interface CustomerIdStep {
    AccountRepresentativeIdStep customerId(String customerId);
  }
  

  public interface AccountRepresentativeIdStep {
    ProductIdStep accountRepresentativeId(String accountRepresentativeId);
  }
  

  public interface ProductIdStep {
    StatusStep productId(String productId);
  }
  

  public interface StatusStep {
    AmountStep status(String status);
  }
  

  public interface AmountStep {
    DateStep amount(Integer amount);
  }
  

  public interface DateStep {
    BuildStep date(String date);
  }
  

  public interface BuildStep {
    Order build();
    BuildStep id(String id);
    BuildStep awsTimeValue(Temporal.Time awsTimeValue);
  }
  

  public static class Builder implements CustomerIdStep, AccountRepresentativeIdStep, ProductIdStep, StatusStep, AmountStep, DateStep, BuildStep {
    private String id;
    private String customerID;
    private String accountRepresentativeID;
    private String productID;
    private String status;
    private Integer amount;
    private String date;
    private Temporal.Time awsTimeValue;
    @Override
     public Order build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Order(
          id,
          customerID,
          accountRepresentativeID,
          productID,
          status,
          amount,
          date,
          awsTimeValue);
    }
    
    @Override
     public AccountRepresentativeIdStep customerId(String customerId) {
        Objects.requireNonNull(customerId);
        this.customerID = customerId;
        return this;
    }
    
    @Override
     public ProductIdStep accountRepresentativeId(String accountRepresentativeId) {
        Objects.requireNonNull(accountRepresentativeId);
        this.accountRepresentativeID = accountRepresentativeId;
        return this;
    }
    
    @Override
     public StatusStep productId(String productId) {
        Objects.requireNonNull(productId);
        this.productID = productId;
        return this;
    }
    
    @Override
     public AmountStep status(String status) {
        Objects.requireNonNull(status);
        this.status = status;
        return this;
    }
    
    @Override
     public DateStep amount(Integer amount) {
        Objects.requireNonNull(amount);
        this.amount = amount;
        return this;
    }
    
    @Override
     public BuildStep date(String date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep awsTimeValue(Temporal.Time awsTimeValue) {
        this.awsTimeValue = awsTimeValue;
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
    private CopyOfBuilder(String id, String customerId, String accountRepresentativeId, String productId, String status, Integer amount, String date, Temporal.Time awsTimeValue) {
      super.id(id);
      super.customerId(customerId)
        .accountRepresentativeId(accountRepresentativeId)
        .productId(productId)
        .status(status)
        .amount(amount)
        .date(date)
        .awsTimeValue(awsTimeValue);
    }
    
    @Override
     public CopyOfBuilder customerId(String customerId) {
      return (CopyOfBuilder) super.customerId(customerId);
    }
    
    @Override
     public CopyOfBuilder accountRepresentativeId(String accountRepresentativeId) {
      return (CopyOfBuilder) super.accountRepresentativeId(accountRepresentativeId);
    }
    
    @Override
     public CopyOfBuilder productId(String productId) {
      return (CopyOfBuilder) super.productId(productId);
    }
    
    @Override
     public CopyOfBuilder status(String status) {
      return (CopyOfBuilder) super.status(status);
    }
    
    @Override
     public CopyOfBuilder amount(Integer amount) {
      return (CopyOfBuilder) super.amount(amount);
    }
    
    @Override
     public CopyOfBuilder date(String date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder awsTimeValue(Temporal.Time awsTimeValue) {
      return (CopyOfBuilder) super.awsTimeValue(awsTimeValue);
    }
  }
  
}
