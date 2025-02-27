/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.arifrhm.user.kafka.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class UserResponseAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5618106537594530188L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserResponseAvroModel\",\"namespace\":\"com.arifrhm.user.kafka.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"userId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"email\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"role\",\"type\":{\"type\":\"enum\",\"name\":\"UserRole\",\"symbols\":[\"CUSTOMER\",\"WAREHOUSE_ADMIN\",\"SUPER_ADMIN\"]}},{\"name\":\"token\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"isActive\",\"type\":\"boolean\"},{\"name\":\"eventTimestamp\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<UserResponseAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<UserResponseAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<UserResponseAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<UserResponseAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<UserResponseAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this UserResponseAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a UserResponseAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a UserResponseAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static UserResponseAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.util.UUID id;
  private java.util.UUID sagaId;
  private java.util.UUID userId;
  private java.lang.String email;
  private java.lang.String name;
  private com.arifrhm.user.kafka.avro.model.UserRole role;
  private java.lang.String token;
  private boolean isActive;
  private java.time.Instant eventTimestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserResponseAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param userId The new value for userId
   * @param email The new value for email
   * @param name The new value for name
   * @param role The new value for role
   * @param token The new value for token
   * @param isActive The new value for isActive
   * @param eventTimestamp The new value for eventTimestamp
   */
  public UserResponseAvroModel(java.util.UUID id, java.util.UUID sagaId, java.util.UUID userId, java.lang.String email, java.lang.String name, com.arifrhm.user.kafka.avro.model.UserRole role, java.lang.String token, java.lang.Boolean isActive, java.time.Instant eventTimestamp) {
    this.id = id;
    this.sagaId = sagaId;
    this.userId = userId;
    this.email = email;
    this.name = name;
    this.role = role;
    this.token = token;
    this.isActive = isActive;
    this.eventTimestamp = eventTimestamp.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return sagaId;
    case 2: return userId;
    case 3: return email;
    case 4: return name;
    case 5: return role;
    case 6: return token;
    case 7: return isActive;
    case 8: return eventTimestamp;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      null,
      null,
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.util.UUID)value$; break;
    case 1: sagaId = (java.util.UUID)value$; break;
    case 2: userId = (java.util.UUID)value$; break;
    case 3: email = value$ != null ? value$.toString() : null; break;
    case 4: name = value$ != null ? value$.toString() : null; break;
    case 5: role = (com.arifrhm.user.kafka.avro.model.UserRole)value$; break;
    case 6: token = value$ != null ? value$.toString() : null; break;
    case 7: isActive = (java.lang.Boolean)value$; break;
    case 8: eventTimestamp = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.util.UUID getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.util.UUID value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'sagaId' field.
   * @return The value of the 'sagaId' field.
   */
  public java.util.UUID getSagaId() {
    return sagaId;
  }


  /**
   * Sets the value of the 'sagaId' field.
   * @param value the value to set.
   */
  public void setSagaId(java.util.UUID value) {
    this.sagaId = value;
  }

  /**
   * Gets the value of the 'userId' field.
   * @return The value of the 'userId' field.
   */
  public java.util.UUID getUserId() {
    return userId;
  }


  /**
   * Sets the value of the 'userId' field.
   * @param value the value to set.
   */
  public void setUserId(java.util.UUID value) {
    this.userId = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public java.lang.String getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(java.lang.String value) {
    this.email = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'role' field.
   * @return The value of the 'role' field.
   */
  public com.arifrhm.user.kafka.avro.model.UserRole getRole() {
    return role;
  }


  /**
   * Sets the value of the 'role' field.
   * @param value the value to set.
   */
  public void setRole(com.arifrhm.user.kafka.avro.model.UserRole value) {
    this.role = value;
  }

  /**
   * Gets the value of the 'token' field.
   * @return The value of the 'token' field.
   */
  public java.lang.String getToken() {
    return token;
  }


  /**
   * Sets the value of the 'token' field.
   * @param value the value to set.
   */
  public void setToken(java.lang.String value) {
    this.token = value;
  }

  /**
   * Gets the value of the 'isActive' field.
   * @return The value of the 'isActive' field.
   */
  public boolean getIsActive() {
    return isActive;
  }


  /**
   * Sets the value of the 'isActive' field.
   * @param value the value to set.
   */
  public void setIsActive(boolean value) {
    this.isActive = value;
  }

  /**
   * Gets the value of the 'eventTimestamp' field.
   * @return The value of the 'eventTimestamp' field.
   */
  public java.time.Instant getEventTimestamp() {
    return eventTimestamp;
  }


  /**
   * Sets the value of the 'eventTimestamp' field.
   * @param value the value to set.
   */
  public void setEventTimestamp(java.time.Instant value) {
    this.eventTimestamp = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new UserResponseAvroModel RecordBuilder.
   * @return A new UserResponseAvroModel RecordBuilder
   */
  public static com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder newBuilder() {
    return new com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder();
  }

  /**
   * Creates a new UserResponseAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserResponseAvroModel RecordBuilder
   */
  public static com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder newBuilder(com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder other) {
    if (other == null) {
      return new com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder();
    } else {
      return new com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new UserResponseAvroModel RecordBuilder by copying an existing UserResponseAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new UserResponseAvroModel RecordBuilder
   */
  public static com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder newBuilder(com.arifrhm.user.kafka.avro.model.UserResponseAvroModel other) {
    if (other == null) {
      return new com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder();
    } else {
      return new com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for UserResponseAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserResponseAvroModel>
    implements org.apache.avro.data.RecordBuilder<UserResponseAvroModel> {

    private java.util.UUID id;
    private java.util.UUID sagaId;
    private java.util.UUID userId;
    private java.lang.String email;
    private java.lang.String name;
    private com.arifrhm.user.kafka.avro.model.UserRole role;
    private java.lang.String token;
    private boolean isActive;
    private java.time.Instant eventTimestamp;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.userId)) {
        this.userId = data().deepCopy(fields()[2].schema(), other.userId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.email)) {
        this.email = data().deepCopy(fields()[3].schema(), other.email);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.name)) {
        this.name = data().deepCopy(fields()[4].schema(), other.name);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.role)) {
        this.role = data().deepCopy(fields()[5].schema(), other.role);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.token)) {
        this.token = data().deepCopy(fields()[6].schema(), other.token);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.isActive)) {
        this.isActive = data().deepCopy(fields()[7].schema(), other.isActive);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.eventTimestamp)) {
        this.eventTimestamp = data().deepCopy(fields()[8].schema(), other.eventTimestamp);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
    }

    /**
     * Creates a Builder by copying an existing UserResponseAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.arifrhm.user.kafka.avro.model.UserResponseAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.userId)) {
        this.userId = data().deepCopy(fields()[2].schema(), other.userId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.email)) {
        this.email = data().deepCopy(fields()[3].schema(), other.email);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.name)) {
        this.name = data().deepCopy(fields()[4].schema(), other.name);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.role)) {
        this.role = data().deepCopy(fields()[5].schema(), other.role);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.token)) {
        this.token = data().deepCopy(fields()[6].schema(), other.token);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.isActive)) {
        this.isActive = data().deepCopy(fields()[7].schema(), other.isActive);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.eventTimestamp)) {
        this.eventTimestamp = data().deepCopy(fields()[8].schema(), other.eventTimestamp);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.util.UUID getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder setId(java.util.UUID value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'sagaId' field.
      * @return The value.
      */
    public java.util.UUID getSagaId() {
      return sagaId;
    }


    /**
      * Sets the value of the 'sagaId' field.
      * @param value The value of 'sagaId'.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder setSagaId(java.util.UUID value) {
      validate(fields()[1], value);
      this.sagaId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'sagaId' field has been set.
      * @return True if the 'sagaId' field has been set, false otherwise.
      */
    public boolean hasSagaId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'sagaId' field.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder clearSagaId() {
      sagaId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'userId' field.
      * @return The value.
      */
    public java.util.UUID getUserId() {
      return userId;
    }


    /**
      * Sets the value of the 'userId' field.
      * @param value The value of 'userId'.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder setUserId(java.util.UUID value) {
      validate(fields()[2], value);
      this.userId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'userId' field has been set.
      * @return True if the 'userId' field has been set, false otherwise.
      */
    public boolean hasUserId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'userId' field.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder clearUserId() {
      userId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public java.lang.String getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder setEmail(java.lang.String value) {
      validate(fields()[3], value);
      this.email = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder clearEmail() {
      email = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder setName(java.lang.String value) {
      validate(fields()[4], value);
      this.name = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder clearName() {
      name = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'role' field.
      * @return The value.
      */
    public com.arifrhm.user.kafka.avro.model.UserRole getRole() {
      return role;
    }


    /**
      * Sets the value of the 'role' field.
      * @param value The value of 'role'.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder setRole(com.arifrhm.user.kafka.avro.model.UserRole value) {
      validate(fields()[5], value);
      this.role = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'role' field has been set.
      * @return True if the 'role' field has been set, false otherwise.
      */
    public boolean hasRole() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'role' field.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder clearRole() {
      role = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'token' field.
      * @return The value.
      */
    public java.lang.String getToken() {
      return token;
    }


    /**
      * Sets the value of the 'token' field.
      * @param value The value of 'token'.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder setToken(java.lang.String value) {
      validate(fields()[6], value);
      this.token = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'token' field has been set.
      * @return True if the 'token' field has been set, false otherwise.
      */
    public boolean hasToken() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'token' field.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder clearToken() {
      token = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'isActive' field.
      * @return The value.
      */
    public boolean getIsActive() {
      return isActive;
    }


    /**
      * Sets the value of the 'isActive' field.
      * @param value The value of 'isActive'.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder setIsActive(boolean value) {
      validate(fields()[7], value);
      this.isActive = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'isActive' field has been set.
      * @return True if the 'isActive' field has been set, false otherwise.
      */
    public boolean hasIsActive() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'isActive' field.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder clearIsActive() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'eventTimestamp' field.
      * @return The value.
      */
    public java.time.Instant getEventTimestamp() {
      return eventTimestamp;
    }


    /**
      * Sets the value of the 'eventTimestamp' field.
      * @param value The value of 'eventTimestamp'.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder setEventTimestamp(java.time.Instant value) {
      validate(fields()[8], value);
      this.eventTimestamp = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'eventTimestamp' field has been set.
      * @return True if the 'eventTimestamp' field has been set, false otherwise.
      */
    public boolean hasEventTimestamp() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'eventTimestamp' field.
      * @return This builder.
      */
    public com.arifrhm.user.kafka.avro.model.UserResponseAvroModel.Builder clearEventTimestamp() {
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserResponseAvroModel build() {
      try {
        UserResponseAvroModel record = new UserResponseAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.util.UUID) defaultValue(fields()[0]);
        record.sagaId = fieldSetFlags()[1] ? this.sagaId : (java.util.UUID) defaultValue(fields()[1]);
        record.userId = fieldSetFlags()[2] ? this.userId : (java.util.UUID) defaultValue(fields()[2]);
        record.email = fieldSetFlags()[3] ? this.email : (java.lang.String) defaultValue(fields()[3]);
        record.name = fieldSetFlags()[4] ? this.name : (java.lang.String) defaultValue(fields()[4]);
        record.role = fieldSetFlags()[5] ? this.role : (com.arifrhm.user.kafka.avro.model.UserRole) defaultValue(fields()[5]);
        record.token = fieldSetFlags()[6] ? this.token : (java.lang.String) defaultValue(fields()[6]);
        record.isActive = fieldSetFlags()[7] ? this.isActive : (java.lang.Boolean) defaultValue(fields()[7]);
        record.eventTimestamp = fieldSetFlags()[8] ? this.eventTimestamp : (java.time.Instant) defaultValue(fields()[8]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<UserResponseAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<UserResponseAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<UserResponseAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<UserResponseAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










