/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.arifrhm.warehouse.kafka.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class StockUpdatedAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7711491160524787725L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"StockUpdatedAvroModel\",\"namespace\":\"com.arifrhm.warehouse.kafka.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"stockId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"warehouseId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"productId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"stock\",\"type\":\"int\"},{\"name\":\"totalProductStock\",\"type\":\"int\"},{\"name\":\"eventTimestamp\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<StockUpdatedAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<StockUpdatedAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<StockUpdatedAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<StockUpdatedAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<StockUpdatedAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this StockUpdatedAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a StockUpdatedAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a StockUpdatedAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static StockUpdatedAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.util.UUID id;
  private java.util.UUID sagaId;
  private java.util.UUID stockId;
  private java.util.UUID warehouseId;
  private java.util.UUID productId;
  private int stock;
  private int totalProductStock;
  private java.time.Instant eventTimestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public StockUpdatedAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param stockId The new value for stockId
   * @param warehouseId The new value for warehouseId
   * @param productId The new value for productId
   * @param stock The new value for stock
   * @param totalProductStock The new value for totalProductStock
   * @param eventTimestamp The new value for eventTimestamp
   */
  public StockUpdatedAvroModel(java.util.UUID id, java.util.UUID sagaId, java.util.UUID stockId, java.util.UUID warehouseId, java.util.UUID productId, java.lang.Integer stock, java.lang.Integer totalProductStock, java.time.Instant eventTimestamp) {
    this.id = id;
    this.sagaId = sagaId;
    this.stockId = stockId;
    this.warehouseId = warehouseId;
    this.productId = productId;
    this.stock = stock;
    this.totalProductStock = totalProductStock;
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
    case 2: return stockId;
    case 3: return warehouseId;
    case 4: return productId;
    case 5: return stock;
    case 6: return totalProductStock;
    case 7: return eventTimestamp;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
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
    case 2: stockId = (java.util.UUID)value$; break;
    case 3: warehouseId = (java.util.UUID)value$; break;
    case 4: productId = (java.util.UUID)value$; break;
    case 5: stock = (java.lang.Integer)value$; break;
    case 6: totalProductStock = (java.lang.Integer)value$; break;
    case 7: eventTimestamp = (java.time.Instant)value$; break;
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
   * Gets the value of the 'stockId' field.
   * @return The value of the 'stockId' field.
   */
  public java.util.UUID getStockId() {
    return stockId;
  }


  /**
   * Sets the value of the 'stockId' field.
   * @param value the value to set.
   */
  public void setStockId(java.util.UUID value) {
    this.stockId = value;
  }

  /**
   * Gets the value of the 'warehouseId' field.
   * @return The value of the 'warehouseId' field.
   */
  public java.util.UUID getWarehouseId() {
    return warehouseId;
  }


  /**
   * Sets the value of the 'warehouseId' field.
   * @param value the value to set.
   */
  public void setWarehouseId(java.util.UUID value) {
    this.warehouseId = value;
  }

  /**
   * Gets the value of the 'productId' field.
   * @return The value of the 'productId' field.
   */
  public java.util.UUID getProductId() {
    return productId;
  }


  /**
   * Sets the value of the 'productId' field.
   * @param value the value to set.
   */
  public void setProductId(java.util.UUID value) {
    this.productId = value;
  }

  /**
   * Gets the value of the 'stock' field.
   * @return The value of the 'stock' field.
   */
  public int getStock() {
    return stock;
  }


  /**
   * Sets the value of the 'stock' field.
   * @param value the value to set.
   */
  public void setStock(int value) {
    this.stock = value;
  }

  /**
   * Gets the value of the 'totalProductStock' field.
   * @return The value of the 'totalProductStock' field.
   */
  public int getTotalProductStock() {
    return totalProductStock;
  }


  /**
   * Sets the value of the 'totalProductStock' field.
   * @param value the value to set.
   */
  public void setTotalProductStock(int value) {
    this.totalProductStock = value;
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
   * Creates a new StockUpdatedAvroModel RecordBuilder.
   * @return A new StockUpdatedAvroModel RecordBuilder
   */
  public static com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder newBuilder() {
    return new com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder();
  }

  /**
   * Creates a new StockUpdatedAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new StockUpdatedAvroModel RecordBuilder
   */
  public static com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder newBuilder(com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder other) {
    if (other == null) {
      return new com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder();
    } else {
      return new com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new StockUpdatedAvroModel RecordBuilder by copying an existing StockUpdatedAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new StockUpdatedAvroModel RecordBuilder
   */
  public static com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder newBuilder(com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel other) {
    if (other == null) {
      return new com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder();
    } else {
      return new com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for StockUpdatedAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<StockUpdatedAvroModel>
    implements org.apache.avro.data.RecordBuilder<StockUpdatedAvroModel> {

    private java.util.UUID id;
    private java.util.UUID sagaId;
    private java.util.UUID stockId;
    private java.util.UUID warehouseId;
    private java.util.UUID productId;
    private int stock;
    private int totalProductStock;
    private java.time.Instant eventTimestamp;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.stockId)) {
        this.stockId = data().deepCopy(fields()[2].schema(), other.stockId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.warehouseId)) {
        this.warehouseId = data().deepCopy(fields()[3].schema(), other.warehouseId);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.productId)) {
        this.productId = data().deepCopy(fields()[4].schema(), other.productId);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.stock)) {
        this.stock = data().deepCopy(fields()[5].schema(), other.stock);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.totalProductStock)) {
        this.totalProductStock = data().deepCopy(fields()[6].schema(), other.totalProductStock);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.eventTimestamp)) {
        this.eventTimestamp = data().deepCopy(fields()[7].schema(), other.eventTimestamp);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
    }

    /**
     * Creates a Builder by copying an existing StockUpdatedAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.stockId)) {
        this.stockId = data().deepCopy(fields()[2].schema(), other.stockId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.warehouseId)) {
        this.warehouseId = data().deepCopy(fields()[3].schema(), other.warehouseId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.productId)) {
        this.productId = data().deepCopy(fields()[4].schema(), other.productId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.stock)) {
        this.stock = data().deepCopy(fields()[5].schema(), other.stock);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.totalProductStock)) {
        this.totalProductStock = data().deepCopy(fields()[6].schema(), other.totalProductStock);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.eventTimestamp)) {
        this.eventTimestamp = data().deepCopy(fields()[7].schema(), other.eventTimestamp);
        fieldSetFlags()[7] = true;
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
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder setId(java.util.UUID value) {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder clearId() {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder setSagaId(java.util.UUID value) {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder clearSagaId() {
      sagaId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'stockId' field.
      * @return The value.
      */
    public java.util.UUID getStockId() {
      return stockId;
    }


    /**
      * Sets the value of the 'stockId' field.
      * @param value The value of 'stockId'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder setStockId(java.util.UUID value) {
      validate(fields()[2], value);
      this.stockId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'stockId' field has been set.
      * @return True if the 'stockId' field has been set, false otherwise.
      */
    public boolean hasStockId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'stockId' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder clearStockId() {
      stockId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'warehouseId' field.
      * @return The value.
      */
    public java.util.UUID getWarehouseId() {
      return warehouseId;
    }


    /**
      * Sets the value of the 'warehouseId' field.
      * @param value The value of 'warehouseId'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder setWarehouseId(java.util.UUID value) {
      validate(fields()[3], value);
      this.warehouseId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'warehouseId' field has been set.
      * @return True if the 'warehouseId' field has been set, false otherwise.
      */
    public boolean hasWarehouseId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'warehouseId' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder clearWarehouseId() {
      warehouseId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'productId' field.
      * @return The value.
      */
    public java.util.UUID getProductId() {
      return productId;
    }


    /**
      * Sets the value of the 'productId' field.
      * @param value The value of 'productId'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder setProductId(java.util.UUID value) {
      validate(fields()[4], value);
      this.productId = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'productId' field has been set.
      * @return True if the 'productId' field has been set, false otherwise.
      */
    public boolean hasProductId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'productId' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder clearProductId() {
      productId = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'stock' field.
      * @return The value.
      */
    public int getStock() {
      return stock;
    }


    /**
      * Sets the value of the 'stock' field.
      * @param value The value of 'stock'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder setStock(int value) {
      validate(fields()[5], value);
      this.stock = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'stock' field has been set.
      * @return True if the 'stock' field has been set, false otherwise.
      */
    public boolean hasStock() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'stock' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder clearStock() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'totalProductStock' field.
      * @return The value.
      */
    public int getTotalProductStock() {
      return totalProductStock;
    }


    /**
      * Sets the value of the 'totalProductStock' field.
      * @param value The value of 'totalProductStock'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder setTotalProductStock(int value) {
      validate(fields()[6], value);
      this.totalProductStock = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'totalProductStock' field has been set.
      * @return True if the 'totalProductStock' field has been set, false otherwise.
      */
    public boolean hasTotalProductStock() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'totalProductStock' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder clearTotalProductStock() {
      fieldSetFlags()[6] = false;
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
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder setEventTimestamp(java.time.Instant value) {
      validate(fields()[7], value);
      this.eventTimestamp = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'eventTimestamp' field has been set.
      * @return True if the 'eventTimestamp' field has been set, false otherwise.
      */
    public boolean hasEventTimestamp() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'eventTimestamp' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel.Builder clearEventTimestamp() {
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public StockUpdatedAvroModel build() {
      try {
        StockUpdatedAvroModel record = new StockUpdatedAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.util.UUID) defaultValue(fields()[0]);
        record.sagaId = fieldSetFlags()[1] ? this.sagaId : (java.util.UUID) defaultValue(fields()[1]);
        record.stockId = fieldSetFlags()[2] ? this.stockId : (java.util.UUID) defaultValue(fields()[2]);
        record.warehouseId = fieldSetFlags()[3] ? this.warehouseId : (java.util.UUID) defaultValue(fields()[3]);
        record.productId = fieldSetFlags()[4] ? this.productId : (java.util.UUID) defaultValue(fields()[4]);
        record.stock = fieldSetFlags()[5] ? this.stock : (java.lang.Integer) defaultValue(fields()[5]);
        record.totalProductStock = fieldSetFlags()[6] ? this.totalProductStock : (java.lang.Integer) defaultValue(fields()[6]);
        record.eventTimestamp = fieldSetFlags()[7] ? this.eventTimestamp : (java.time.Instant) defaultValue(fields()[7]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<StockUpdatedAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<StockUpdatedAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<StockUpdatedAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<StockUpdatedAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










