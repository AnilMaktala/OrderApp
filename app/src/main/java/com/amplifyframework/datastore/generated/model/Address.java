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

/** This is an auto generated class representing the Address type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Addresses")
@Index(name = "byAddress", fields = {"customerID","id"})
public final class Address implements Model {
  public static final QueryField ID = field("Address", "id");
  public static final QueryField ADDRESS = field("Address", "address");
  public static final QueryField CITY = field("Address", "city");
  public static final QueryField STATE = field("Address", "state");
  public static final QueryField CUSTOMER_ID = field("Address", "customerID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String address;
  private final @ModelField(targetType="String", isRequired = true) String city;
  private final @ModelField(targetType="String", isRequired = true) String state;
  private final @ModelField(targetType="ID", isRequired = true) String customerID;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getAddress() {
      return address;
  }
  
  public String getCity() {
      return city;
  }
  
  public String getState() {
      return state;
  }
  
  public String getCustomerId() {
      return customerID;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Address(String id, String address, String city, String state, String customerID) {
    this.id = id;
    this.address = address;
    this.city = city;
    this.state = state;
    this.customerID = customerID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Address address = (Address) obj;
      return ObjectsCompat.equals(getId(), address.getId()) &&
              ObjectsCompat.equals(getAddress(), address.getAddress()) &&
              ObjectsCompat.equals(getCity(), address.getCity()) &&
              ObjectsCompat.equals(getState(), address.getState()) &&
              ObjectsCompat.equals(getCustomerId(), address.getCustomerId()) &&
              ObjectsCompat.equals(getCreatedAt(), address.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), address.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getAddress())
      .append(getCity())
      .append(getState())
      .append(getCustomerId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Address {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("address=" + String.valueOf(getAddress()) + ", ")
      .append("city=" + String.valueOf(getCity()) + ", ")
      .append("state=" + String.valueOf(getState()) + ", ")
      .append("customerID=" + String.valueOf(getCustomerId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static AddressStep builder() {
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
  public static Address justId(String id) {
    return new Address(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      address,
      city,
      state,
      customerID);
  }
  public interface AddressStep {
    CityStep address(String address);
  }
  

  public interface CityStep {
    StateStep city(String city);
  }
  

  public interface StateStep {
    CustomerIdStep state(String state);
  }
  

  public interface CustomerIdStep {
    BuildStep customerId(String customerId);
  }
  

  public interface BuildStep {
    Address build();
    BuildStep id(String id);
  }
  

  public static class Builder implements AddressStep, CityStep, StateStep, CustomerIdStep, BuildStep {
    private String id;
    private String address;
    private String city;
    private String state;
    private String customerID;
    @Override
     public Address build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Address(
          id,
          address,
          city,
          state,
          customerID);
    }
    
    @Override
     public CityStep address(String address) {
        Objects.requireNonNull(address);
        this.address = address;
        return this;
    }
    
    @Override
     public StateStep city(String city) {
        Objects.requireNonNull(city);
        this.city = city;
        return this;
    }
    
    @Override
     public CustomerIdStep state(String state) {
        Objects.requireNonNull(state);
        this.state = state;
        return this;
    }
    
    @Override
     public BuildStep customerId(String customerId) {
        Objects.requireNonNull(customerId);
        this.customerID = customerId;
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
    private CopyOfBuilder(String id, String address, String city, String state, String customerId) {
      super.id(id);
      super.address(address)
        .city(city)
        .state(state)
        .customerId(customerId);
    }
    
    @Override
     public CopyOfBuilder address(String address) {
      return (CopyOfBuilder) super.address(address);
    }
    
    @Override
     public CopyOfBuilder city(String city) {
      return (CopyOfBuilder) super.city(city);
    }
    
    @Override
     public CopyOfBuilder state(String state) {
      return (CopyOfBuilder) super.state(state);
    }
    
    @Override
     public CopyOfBuilder customerId(String customerId) {
      return (CopyOfBuilder) super.customerId(customerId);
    }
  }
  
}
