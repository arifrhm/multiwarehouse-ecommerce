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
public class StockCreatedAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4471247688612732007L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"StockCreatedAvroModel\",\"namespace\":\"com.arifrhm.warehouse.kafka.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"stockId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"warehouseId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"productId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"warehouseName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"productName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"warehouseLatitude\",\"type\":\"double\"},{\"name\":\"warehouseLongitude\",\"type\":\"double\"},{\"name\":\"stock\",\"type\":\"int\"},{\"name\":\"totalProductStock\",\"type\":\"int\"},{\"name\":\"eventTimestamp\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<StockCreatedAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<StockCreatedAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<StockCreatedAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<StockCreatedAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<StockCreatedAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this StockCreatedAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a StockCreatedAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a StockCreatedAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static StockCreatedAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.util.UUID id;
  private java.util.UUID sagaId;
  private java.util.UUID stockId;
  private java.util.UUID warehouseId;
  private java.util.UUID productId;
  private java.lang.String warehouseName;
  private java.lang.String productName;
  private double warehouseLatitude;
  private double warehouseLongitude;
  private int stock;
  private int totalProductStock;
  private java.time.Instant eventTimestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public StockCreatedAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param stockId The new value for stockId
   * @param warehouseId The new value for warehouseId
   * @param productId The new value for productId
   * @param warehouseName The new value for warehouseName
   * @param productName The new value for productName
   * @param warehouseLatitude The new value for warehouseLatitude
   * @param warehouseLongitude The new value for warehouseLongitude
   * @param stock The new value for stock
   * @param totalProductStock The new value for totalProductStock
   * @param eventTimestamp The new value for eventTimestamp
   */
  public StockCreatedAvroModel(java.util.UUID id, java.util.UUID sagaId, java.util.UUID stockId, java.util.UUID warehouseId, java.util.UUID productId, java.lang.String warehouseName, java.lang.String productName, java.lang.Double warehouseLatitude, java.lang.Double warehouseLongitude, java.lang.Integer stock, java.lang.Integer totalProductStock, java.time.Instant eventTimestamp) {
    this.id = id;
    this.sagaId = sagaId;
    this.stockId = stockId;
    this.warehouseId = warehouseId;
    this.productId = productId;
    this.warehouseName = warehouseName;
    this.productName = productName;
    this.warehouseLatitude = warehouseLatitude;
    this.warehouseLongitude = warehouseLongitude;
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
    case 5: return warehouseName;
    case 6: return productName;
    case 7: return warehouseLatitude;
    case 8: return warehouseLongitude;
    case 9: return stock;
    case 10: return totalProductStock;
    case 11: return eventTimestamp;
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
    case 2: stockId = (java.util.UUID)value$; break;
    case 3: warehouseId = (java.util.UUID)value$; break;
    case 4: productId = (java.util.UUID)value$; break;
    case 5: warehouseName = value$ != null ? value$.toString() : null; break;
    case 6: productName = value$ != null ? value$.toString() : null; break;
    case 7: warehouseLatitude = (java.lang.Double)value$; break;
    case 8: warehouseLongitude = (java.lang.Double)value$; break;
    case 9: stock = (java.lang.Integer)value$; break;
    case 10: totalProductStock = (java.lang.Integer)value$; break;
    case 11: eventTimestamp = (java.time.Instant)value$; break;
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
   * Gets the value of the 'warehouseName' field.
   * @return The value of the 'warehouseName' field.
   */
  public java.lang.String getWarehouseName() {
    return warehouseName;
  }


  /**
   * Sets the value of the 'warehouseName' field.
   * @param value the value to set.
   */
  public void setWarehouseName(java.lang.String value) {
    this.warehouseName = value;
  }

  /**
   * Gets the value of the 'productName' field.
   * @return The value of the 'productName' field.
   */
  public java.lang.String getProductName() {
    return productName;
  }


  /**
   * Sets the value of the 'productName' field.
   * @param value the value to set.
   */
  public void setProductName(java.lang.String value) {
    this.productName = value;
  }

  /**
   * Gets the value of the 'warehouseLatitude' field.
   * @return The value of the 'warehouseLatitude' field.
   */
  public double getWarehouseLatitude() {
    return warehouseLatitude;
  }


  /**
   * Sets the value of the 'warehouseLatitude' field.
   * @param value the value to set.
   */
  public void setWarehouseLatitude(double value) {
    this.warehouseLatitude = value;
  }

  /**
   * Gets the value of the 'warehouseLongitude' field.
   * @return The value of the 'warehouseLongitude' field.
   */
  public double getWarehouseLongitude() {
    return warehouseLongitude;
  }


  /**
   * Sets the value of the 'warehouseLongitude' field.
   * @param value the value to set.
   */
  public void setWarehouseLongitude(double value) {
    this.warehouseLongitude = value;
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
   * Creates a new StockCreatedAvroModel RecordBuilder.
   * @return A new StockCreatedAvroModel RecordBuilder
   */
  public static com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder newBuilder() {
    return new com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder();
  }

  /**
   * Creates a new StockCreatedAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new StockCreatedAvroModel RecordBuilder
   */
  public static com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder newBuilder(com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder other) {
    if (other == null) {
      return new com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder();
    } else {
      return new com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new StockCreatedAvroModel RecordBuilder by copying an existing StockCreatedAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new StockCreatedAvroModel RecordBuilder
   */
  public static com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder newBuilder(com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel other) {
    if (other == null) {
      return new com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder();
    } else {
      return new com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for StockCreatedAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<StockCreatedAvroModel>
    implements org.apache.avro.data.RecordBuilder<StockCreatedAvroModel> {

    private java.util.UUID id;
    private java.util.UUID sagaId;
    private java.util.UUID stockId;
    private java.util.UUID warehouseId;
    private java.util.UUID productId;
    private java.lang.String warehouseName;
    private java.lang.String productName;
    private double warehouseLatitude;
    private double warehouseLongitude;
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
    private Builder(com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder other) {
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
      if (isValidValue(fields()[5], other.warehouseName)) {
        this.warehouseName = data().deepCopy(fields()[5].schema(), other.warehouseName);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.productName)) {
        this.productName = data().deepCopy(fields()[6].schema(), other.productName);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.warehouseLatitude)) {
        this.warehouseLatitude = data().deepCopy(fields()[7].schema(), other.warehouseLatitude);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.warehouseLongitude)) {
        this.warehouseLongitude = data().deepCopy(fields()[8].schema(), other.warehouseLongitude);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.stock)) {
        this.stock = data().deepCopy(fields()[9].schema(), other.stock);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
      if (isValidValue(fields()[10], other.totalProductStock)) {
        this.totalProductStock = data().deepCopy(fields()[10].schema(), other.totalProductStock);
        fieldSetFlags()[10] = other.fieldSetFlags()[10];
      }
      if (isValidValue(fields()[11], other.eventTimestamp)) {
        this.eventTimestamp = data().deepCopy(fields()[11].schema(), other.eventTimestamp);
        fieldSetFlags()[11] = other.fieldSetFlags()[11];
      }
    }

    /**
     * Creates a Builder by copying an existing StockCreatedAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel other) {
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
      if (isValidValue(fields()[5], other.warehouseName)) {
        this.warehouseName = data().deepCopy(fields()[5].schema(), other.warehouseName);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.productName)) {
        this.productName = data().deepCopy(fields()[6].schema(), other.productName);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.warehouseLatitude)) {
        this.warehouseLatitude = data().deepCopy(fields()[7].schema(), other.warehouseLatitude);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.warehouseLongitude)) {
        this.warehouseLongitude = data().deepCopy(fields()[8].schema(), other.warehouseLongitude);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.stock)) {
        this.stock = data().deepCopy(fields()[9].schema(), other.stock);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.totalProductStock)) {
        this.totalProductStock = data().deepCopy(fields()[10].schema(), other.totalProductStock);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.eventTimestamp)) {
        this.eventTimestamp = data().deepCopy(fields()[11].schema(), other.eventTimestamp);
        fieldSetFlags()[11] = true;
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setId(java.util.UUID value) {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearId() {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setSagaId(java.util.UUID value) {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearSagaId() {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setStockId(java.util.UUID value) {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearStockId() {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setWarehouseId(java.util.UUID value) {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearWarehouseId() {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setProductId(java.util.UUID value) {
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearProductId() {
      productId = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'warehouseName' field.
      * @return The value.
      */
    public java.lang.String getWarehouseName() {
      return warehouseName;
    }


    /**
      * Sets the value of the 'warehouseName' field.
      * @param value The value of 'warehouseName'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setWarehouseName(java.lang.String value) {
      validate(fields()[5], value);
      this.warehouseName = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'warehouseName' field has been set.
      * @return True if the 'warehouseName' field has been set, false otherwise.
      */
    public boolean hasWarehouseName() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'warehouseName' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearWarehouseName() {
      warehouseName = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'productName' field.
      * @return The value.
      */
    public java.lang.String getProductName() {
      return productName;
    }


    /**
      * Sets the value of the 'productName' field.
      * @param value The value of 'productName'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setProductName(java.lang.String value) {
      validate(fields()[6], value);
      this.productName = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'productName' field has been set.
      * @return True if the 'productName' field has been set, false otherwise.
      */
    public boolean hasProductName() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'productName' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearProductName() {
      productName = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'warehouseLatitude' field.
      * @return The value.
      */
    public double getWarehouseLatitude() {
      return warehouseLatitude;
    }


    /**
      * Sets the value of the 'warehouseLatitude' field.
      * @param value The value of 'warehouseLatitude'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setWarehouseLatitude(double value) {
      validate(fields()[7], value);
      this.warehouseLatitude = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'warehouseLatitude' field has been set.
      * @return True if the 'warehouseLatitude' field has been set, false otherwise.
      */
    public boolean hasWarehouseLatitude() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'warehouseLatitude' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearWarehouseLatitude() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'warehouseLongitude' field.
      * @return The value.
      */
    public double getWarehouseLongitude() {
      return warehouseLongitude;
    }


    /**
      * Sets the value of the 'warehouseLongitude' field.
      * @param value The value of 'warehouseLongitude'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setWarehouseLongitude(double value) {
      validate(fields()[8], value);
      this.warehouseLongitude = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'warehouseLongitude' field has been set.
      * @return True if the 'warehouseLongitude' field has been set, false otherwise.
      */
    public boolean hasWarehouseLongitude() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'warehouseLongitude' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearWarehouseLongitude() {
      fieldSetFlags()[8] = false;
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setStock(int value) {
      validate(fields()[9], value);
      this.stock = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'stock' field has been set.
      * @return True if the 'stock' field has been set, false otherwise.
      */
    public boolean hasStock() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'stock' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearStock() {
      fieldSetFlags()[9] = false;
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setTotalProductStock(int value) {
      validate(fields()[10], value);
      this.totalProductStock = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'totalProductStock' field has been set.
      * @return True if the 'totalProductStock' field has been set, false otherwise.
      */
    public boolean hasTotalProductStock() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'totalProductStock' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearTotalProductStock() {
      fieldSetFlags()[10] = false;
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
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder setEventTimestamp(java.time.Instant value) {
      validate(fields()[11], value);
      this.eventTimestamp = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'eventTimestamp' field has been set.
      * @return True if the 'eventTimestamp' field has been set, false otherwise.
      */
    public boolean hasEventTimestamp() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'eventTimestamp' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel.Builder clearEventTimestamp() {
      fieldSetFlags()[11] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public StockCreatedAvroModel build() {
      try {
        StockCreatedAvroModel record = new StockCreatedAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.util.UUID) defaultValue(fields()[0]);
        record.sagaId = fieldSetFlags()[1] ? this.sagaId : (java.util.UUID) defaultValue(fields()[1]);
        record.stockId = fieldSetFlags()[2] ? this.stockId : (java.util.UUID) defaultValue(fields()[2]);
        record.warehouseId = fieldSetFlags()[3] ? this.warehouseId : (java.util.UUID) defaultValue(fields()[3]);
        record.productId = fieldSetFlags()[4] ? this.productId : (java.util.UUID) defaultValue(fields()[4]);
        record.warehouseName = fieldSetFlags()[5] ? this.warehouseName : (java.lang.String) defaultValue(fields()[5]);
        record.productName = fieldSetFlags()[6] ? this.productName : (java.lang.String) defaultValue(fields()[6]);
        record.warehouseLatitude = fieldSetFlags()[7] ? this.warehouseLatitude : (java.lang.Double) defaultValue(fields()[7]);
        record.warehouseLongitude = fieldSetFlags()[8] ? this.warehouseLongitude : (java.lang.Double) defaultValue(fields()[8]);
        record.stock = fieldSetFlags()[9] ? this.stock : (java.lang.Integer) defaultValue(fields()[9]);
        record.totalProductStock = fieldSetFlags()[10] ? this.totalProductStock : (java.lang.Integer) defaultValue(fields()[10]);
        record.eventTimestamp = fieldSetFlags()[11] ? this.eventTimestamp : (java.time.Instant) defaultValue(fields()[11]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<StockCreatedAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<StockCreatedAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<StockCreatedAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<StockCreatedAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










