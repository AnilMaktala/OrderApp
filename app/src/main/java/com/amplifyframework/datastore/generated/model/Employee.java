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

/** This is an auto generated class representing the Employee type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Employees")
@Index(name = "byName", fields = {"name","id"})
@Index(name = "byWarehouse", fields = {"warehouseID","id"})
@Index(name = "byTitle", fields = {"jobTitle","id"})
@Index(name = "newHire", fields = {"newHire","id"})
public final class Employee implements Model {
  public static final QueryField ID = field("Employee", "id");
  public static final QueryField NAME = field("Employee", "name");
  public static final QueryField START_DATE = field("Employee", "startDate");
  public static final QueryField PHONE_NUMBER = field("Employee", "phoneNumber");
  public static final QueryField WAREHOUSE_ID = field("Employee", "warehouseID");
  public static final QueryField JOB_TITLE = field("Employee", "jobTitle");
  public static final QueryField NEW_HIRE = field("Employee", "newHire");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String", isRequired = true) String startDate;
  private final @ModelField(targetType="String", isRequired = true) String phoneNumber;
  private final @ModelField(targetType="ID", isRequired = true) String warehouseID;
  private final @ModelField(targetType="String", isRequired = true) String jobTitle;
  private final @ModelField(targetType="String", isRequired = true) String newHire;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getStartDate() {
      return startDate;
  }
  
  public String getPhoneNumber() {
      return phoneNumber;
  }
  
  public String getWarehouseId() {
      return warehouseID;
  }
  
  public String getJobTitle() {
      return jobTitle;
  }
  
  public String getNewHire() {
      return newHire;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Employee(String id, String name, String startDate, String phoneNumber, String warehouseID, String jobTitle, String newHire) {
    this.id = id;
    this.name = name;
    this.startDate = startDate;
    this.phoneNumber = phoneNumber;
    this.warehouseID = warehouseID;
    this.jobTitle = jobTitle;
    this.newHire = newHire;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Employee employee = (Employee) obj;
      return ObjectsCompat.equals(getId(), employee.getId()) &&
              ObjectsCompat.equals(getName(), employee.getName()) &&
              ObjectsCompat.equals(getStartDate(), employee.getStartDate()) &&
              ObjectsCompat.equals(getPhoneNumber(), employee.getPhoneNumber()) &&
              ObjectsCompat.equals(getWarehouseId(), employee.getWarehouseId()) &&
              ObjectsCompat.equals(getJobTitle(), employee.getJobTitle()) &&
              ObjectsCompat.equals(getNewHire(), employee.getNewHire()) &&
              ObjectsCompat.equals(getCreatedAt(), employee.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), employee.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getStartDate())
      .append(getPhoneNumber())
      .append(getWarehouseId())
      .append(getJobTitle())
      .append(getNewHire())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Employee {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("startDate=" + String.valueOf(getStartDate()) + ", ")
      .append("phoneNumber=" + String.valueOf(getPhoneNumber()) + ", ")
      .append("warehouseID=" + String.valueOf(getWarehouseId()) + ", ")
      .append("jobTitle=" + String.valueOf(getJobTitle()) + ", ")
      .append("newHire=" + String.valueOf(getNewHire()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
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
  public static Employee justId(String id) {
    return new Employee(
      id,
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
      name,
      startDate,
      phoneNumber,
      warehouseID,
      jobTitle,
      newHire);
  }
  public interface NameStep {
    StartDateStep name(String name);
  }
  

  public interface StartDateStep {
    PhoneNumberStep startDate(String startDate);
  }
  

  public interface PhoneNumberStep {
    WarehouseIdStep phoneNumber(String phoneNumber);
  }
  

  public interface WarehouseIdStep {
    JobTitleStep warehouseId(String warehouseId);
  }
  

  public interface JobTitleStep {
    NewHireStep jobTitle(String jobTitle);
  }
  

  public interface NewHireStep {
    BuildStep newHire(String newHire);
  }
  

  public interface BuildStep {
    Employee build();
    BuildStep id(String id);
  }
  

  public static class Builder implements NameStep, StartDateStep, PhoneNumberStep, WarehouseIdStep, JobTitleStep, NewHireStep, BuildStep {
    private String id;
    private String name;
    private String startDate;
    private String phoneNumber;
    private String warehouseID;
    private String jobTitle;
    private String newHire;
    @Override
     public Employee build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Employee(
          id,
          name,
          startDate,
          phoneNumber,
          warehouseID,
          jobTitle,
          newHire);
    }
    
    @Override
     public StartDateStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public PhoneNumberStep startDate(String startDate) {
        Objects.requireNonNull(startDate);
        this.startDate = startDate;
        return this;
    }
    
    @Override
     public WarehouseIdStep phoneNumber(String phoneNumber) {
        Objects.requireNonNull(phoneNumber);
        this.phoneNumber = phoneNumber;
        return this;
    }
    
    @Override
     public JobTitleStep warehouseId(String warehouseId) {
        Objects.requireNonNull(warehouseId);
        this.warehouseID = warehouseId;
        return this;
    }
    
    @Override
     public NewHireStep jobTitle(String jobTitle) {
        Objects.requireNonNull(jobTitle);
        this.jobTitle = jobTitle;
        return this;
    }
    
    @Override
     public BuildStep newHire(String newHire) {
        Objects.requireNonNull(newHire);
        this.newHire = newHire;
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
    private CopyOfBuilder(String id, String name, String startDate, String phoneNumber, String warehouseId, String jobTitle, String newHire) {
      super.id(id);
      super.name(name)
        .startDate(startDate)
        .phoneNumber(phoneNumber)
        .warehouseId(warehouseId)
        .jobTitle(jobTitle)
        .newHire(newHire);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder startDate(String startDate) {
      return (CopyOfBuilder) super.startDate(startDate);
    }
    
    @Override
     public CopyOfBuilder phoneNumber(String phoneNumber) {
      return (CopyOfBuilder) super.phoneNumber(phoneNumber);
    }
    
    @Override
     public CopyOfBuilder warehouseId(String warehouseId) {
      return (CopyOfBuilder) super.warehouseId(warehouseId);
    }
    
    @Override
     public CopyOfBuilder jobTitle(String jobTitle) {
      return (CopyOfBuilder) super.jobTitle(jobTitle);
    }
    
    @Override
     public CopyOfBuilder newHire(String newHire) {
      return (CopyOfBuilder) super.newHire(newHire);
    }
  }
  
}
