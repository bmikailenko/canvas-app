package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
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

/** This is an auto generated class representing the datapoint type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "datapoints")
public final class datapoint implements Model {
  public static final QueryField ID = field("datapoint", "id");
  public static final QueryField X = field("datapoint", "x");
  public static final QueryField Y = field("datapoint", "y");
  public static final QueryField VALUE = field("datapoint", "value");
  public static final QueryField CANVAS = field("datapoint", "canvasDatapointId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Int") Integer x;
  private final @ModelField(targetType="Int") Integer y;
  private final @ModelField(targetType="Int") Integer value;
  private final @ModelField(targetType="Canvas") @BelongsTo(targetName = "canvasDatapointId", type = Canvas.class) Canvas canvas;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public Integer getX() {
      return x;
  }
  
  public Integer getY() {
      return y;
  }
  
  public Integer getValue() {
      return value;
  }
  
  public Canvas getCanvas() {
      return canvas;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private datapoint(String id, Integer x, Integer y, Integer value, Canvas canvas) {
    this.id = id;
    this.x = x;
    this.y = y;
    this.value = value;
    this.canvas = canvas;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      datapoint datapoint = (datapoint) obj;
      return ObjectsCompat.equals(getId(), datapoint.getId()) &&
              ObjectsCompat.equals(getX(), datapoint.getX()) &&
              ObjectsCompat.equals(getY(), datapoint.getY()) &&
              ObjectsCompat.equals(getValue(), datapoint.getValue()) &&
              ObjectsCompat.equals(getCanvas(), datapoint.getCanvas()) &&
              ObjectsCompat.equals(getCreatedAt(), datapoint.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), datapoint.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getX())
      .append(getY())
      .append(getValue())
      .append(getCanvas())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("datapoint {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("x=" + String.valueOf(getX()) + ", ")
      .append("y=" + String.valueOf(getY()) + ", ")
      .append("value=" + String.valueOf(getValue()) + ", ")
      .append("canvas=" + String.valueOf(getCanvas()) + ", ")
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
  public static datapoint justId(String id) {
    return new datapoint(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      x,
      y,
      value,
      canvas);
  }
  public interface BuildStep {
    datapoint build();
    BuildStep id(String id);
    BuildStep x(Integer x);
    BuildStep y(Integer y);
    BuildStep value(Integer value);
    BuildStep canvas(Canvas canvas);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private Integer x;
    private Integer y;
    private Integer value;
    private Canvas canvas;
    @Override
     public datapoint build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new datapoint(
          id,
          x,
          y,
          value,
          canvas);
    }
    
    @Override
     public BuildStep x(Integer x) {
        this.x = x;
        return this;
    }
    
    @Override
     public BuildStep y(Integer y) {
        this.y = y;
        return this;
    }
    
    @Override
     public BuildStep value(Integer value) {
        this.value = value;
        return this;
    }
    
    @Override
     public BuildStep canvas(Canvas canvas) {
        this.canvas = canvas;
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
    private CopyOfBuilder(String id, Integer x, Integer y, Integer value, Canvas canvas) {
      super.id(id);
      super.x(x)
        .y(y)
        .value(value)
        .canvas(canvas);
    }
    
    @Override
     public CopyOfBuilder x(Integer x) {
      return (CopyOfBuilder) super.x(x);
    }
    
    @Override
     public CopyOfBuilder y(Integer y) {
      return (CopyOfBuilder) super.y(y);
    }
    
    @Override
     public CopyOfBuilder value(Integer value) {
      return (CopyOfBuilder) super.value(value);
    }
    
    @Override
     public CopyOfBuilder canvas(Canvas canvas) {
      return (CopyOfBuilder) super.canvas(canvas);
    }
  }
  
}
