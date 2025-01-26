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

/** This is an auto generated class representing the Blog type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Blogs")
public final class Blog implements Model {
  public static final QueryField ID = field("Blog", "id");
  public static final QueryField NAME = field("Blog", "name");
  public static final QueryField AWS_TIME_VALUE = field("Blog", "awsTimeValue");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="AWSTime") Temporal.Time awsTimeValue;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
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
  
  private Blog(String id, String name, Temporal.Time awsTimeValue) {
    this.id = id;
    this.name = name;
    this.awsTimeValue = awsTimeValue;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Blog blog = (Blog) obj;
      return ObjectsCompat.equals(getId(), blog.getId()) &&
              ObjectsCompat.equals(getName(), blog.getName()) &&
              ObjectsCompat.equals(getAwsTimeValue(), blog.getAwsTimeValue()) &&
              ObjectsCompat.equals(getCreatedAt(), blog.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), blog.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getAwsTimeValue())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Blog {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("awsTimeValue=" + String.valueOf(getAwsTimeValue()) + ", ")
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
  public static Blog justId(String id) {
    return new Blog(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      awsTimeValue);
  }
  public interface NameStep {
    BuildStep name(String name);
  }
  

  public interface BuildStep {
    Blog build();
    BuildStep id(String id);
    BuildStep awsTimeValue(Temporal.Time awsTimeValue);
  }
  

  public static class Builder implements NameStep, BuildStep {
    private String id;
    private String name;
    private Temporal.Time awsTimeValue;
    @Override
     public Blog build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Blog(
          id,
          name,
          awsTimeValue);
    }
    
    @Override
     public BuildStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
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
    private CopyOfBuilder(String id, String name, Temporal.Time awsTimeValue) {
      super.id(id);
      super.name(name)
        .awsTimeValue(awsTimeValue);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder awsTimeValue(Temporal.Time awsTimeValue) {
      return (CopyOfBuilder) super.awsTimeValue(awsTimeValue);
    }
  }
  
}
