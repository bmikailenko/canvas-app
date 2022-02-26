package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.annotations.HasMany;

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

/** This is an auto generated class representing the Canvas type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Canvas")
public final class Canvas implements Model {
  public static final QueryField ID = field("Canvas", "id");
  public static final QueryField DATE = field("Canvas", "date");
  public static final QueryField USER = field("Canvas", "canvasUserId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime date;
  private final @ModelField(targetType="User") @BelongsTo(targetName = "canvasUserId", type = User.class) User user;
  private final @ModelField(targetType="datapoint") @HasMany(associatedWith = "canvas", type = datapoint.class) List<datapoint> datapoint = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public Temporal.DateTime getDate() {
      return date;
  }
  
  public User getUser() {
      return user;
  }
  
  public List<datapoint> getDatapoint() {
      return datapoint;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Canvas(String id, Temporal.DateTime date, User user) {
    this.id = id;
    this.date = date;
    this.user = user;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Canvas canvas = (Canvas) obj;
      return ObjectsCompat.equals(getId(), canvas.getId()) &&
              ObjectsCompat.equals(getDate(), canvas.getDate()) &&
              ObjectsCompat.equals(getUser(), canvas.getUser()) &&
              ObjectsCompat.equals(getCreatedAt(), canvas.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), canvas.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDate())
      .append(getUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Canvas {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
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
  public static Canvas justId(String id) {
    return new Canvas(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      date,
      user);
  }
  public interface BuildStep {
    Canvas build();
    BuildStep id(String id);
    BuildStep date(Temporal.DateTime date);
    BuildStep user(User user);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private Temporal.DateTime date;
    private User user;
    @Override
     public Canvas build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Canvas(
          id,
          date,
          user);
    }
    
    @Override
     public BuildStep date(Temporal.DateTime date) {
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep user(User user) {
        this.user = user;
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
    private CopyOfBuilder(String id, Temporal.DateTime date, User user) {
      super.id(id);
      super.date(date)
        .user(user);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.DateTime date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder user(User user) {
      return (CopyOfBuilder) super.user(user);
    }
  }
  
}
