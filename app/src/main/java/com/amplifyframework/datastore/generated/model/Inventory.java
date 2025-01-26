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

/** This is an auto generated class representing the Inventory type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Inventories")
@Index(name = "undefined", fields = {"productID","warehouseID"})
@Index(name = "byWarehouseID", fields = {"warehouseID"})
public final class Inventory implements Model {
  public static final QueryField ID = field("Inventory", "id");
  public static final QueryField PRODUCT_ID = field("Inventory", "productID");
  public static final QueryField WAREHOUSE_ID = field("Inventory", "warehouseID");
  public static final QueryField INVENTORY_AMOUNT = field("Inventory", "inventoryAmount");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String productID;
  private final @ModelField(targetType="ID", isRequired = true) String warehouseID;
  private final @ModelField(targetType="Int", isRequired = true) Integer inventoryAmount;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getProductId() {
      return productID;
  }
  
  public String getWarehouseId() {
      return warehouseID;
  }
  
  public Integer getInventoryAmount() {
      return inventoryAmount;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Inventory(String id, String productID, String warehouseID, Integer inventoryAmount) {
    this.id = id;
    this.productID = productID;
    this.warehouseID = warehouseID;
    this.inventoryAmount = inventoryAmount;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Inventory inventory = (Inventory) obj;
      return ObjectsCompat.equals(getId(), inventory.getId()) &&
              ObjectsCompat.equals(getProductId(), inventory.getProductId()) &&
              ObjectsCompat.equals(getWarehouseId(), inventory.getWarehouseId()) &&
              ObjectsCompat.equals(getInventoryAmount(), inventory.getInventoryAmount()) &&
              ObjectsCompat.equals(getCreatedAt(), inventory.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), inventory.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getProductId())
      .append(getWarehouseId())
      .append(getInventoryAmount())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Inventory {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("productID=" + String.valueOf(getProductId()) + ", ")
      .append("warehouseID=" + String.valueOf(getWarehouseId()) + ", ")
      .append("inventoryAmount=" + String.valueOf(getInventoryAmount()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static ProductIdStep builder() {
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
  public static Inventory justId(String id) {
    return new Inventory(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      productID,
      warehouseID,
      inventoryAmount);
  }
  public interface ProductIdStep {
    WarehouseIdStep productId(String productId);
  }
  

  public interface WarehouseIdStep {
    InventoryAmountStep warehouseId(String warehouseId);
  }
  

  public interface InventoryAmountStep {
    BuildStep inventoryAmount(Integer inventoryAmount);
  }
  

  public interface BuildStep {
    Inventory build();
    BuildStep id(String id);
  }
  

  public static class Builder implements ProductIdStep, WarehouseIdStep, InventoryAmountStep, BuildStep {
    private String id;
    private String productID;
    private String warehouseID;
    private Integer inventoryAmount;
    @Override
     public Inventory build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Inventory(
          id,
          productID,
          warehouseID,
          inventoryAmount);
    }
    
    @Override
     public WarehouseIdStep productId(String productId) {
        Objects.requireNonNull(productId);
        this.productID = productId;
        return this;
    }
    
    @Override
     public InventoryAmountStep warehouseId(String warehouseId) {
        Objects.requireNonNull(warehouseId);
        this.warehouseID = warehouseId;
        return this;
    }
    
    @Override
     public BuildStep inventoryAmount(Integer inventoryAmount) {
        Objects.requireNonNull(inventoryAmount);
        this.inventoryAmount = inventoryAmount;
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
    private CopyOfBuilder(String id, String productId, String warehouseId, Integer inventoryAmount) {
      super.id(id);
      super.productId(productId)
        .warehouseId(warehouseId)
        .inventoryAmount(inventoryAmount);
    }
    
    @Override
     public CopyOfBuilder productId(String productId) {
      return (CopyOfBuilder) super.productId(productId);
    }
    
    @Override
     public CopyOfBuilder warehouseId(String warehouseId) {
      return (CopyOfBuilder) super.warehouseId(warehouseId);
    }
    
    @Override
     public CopyOfBuilder inventoryAmount(Integer inventoryAmount) {
      return (CopyOfBuilder) super.inventoryAmount(inventoryAmount);
    }
  }
  
}
