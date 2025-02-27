/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.arifrhm.warehouse.kafka.order.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ProductQuantity extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4380569119429656928L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ProductQuantity\",\"namespace\":\"com.arifrhm.warehouse.kafka.order.avro.model\",\"fields\":[{\"name\":\"productId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"stockId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"quantity\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
  }

  private static final BinaryMessageEncoder<ProductQuantity> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ProductQuantity> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ProductQuantity> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ProductQuantity> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ProductQuantity> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ProductQuantity to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ProductQuantity from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ProductQuantity instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ProductQuantity fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.util.UUID productId;
  private java.util.UUID stockId;
  private int quantity;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ProductQuantity() {}

  /**
   * All-args constructor.
   * @param productId The new value for productId
   * @param stockId The new value for stockId
   * @param quantity The new value for quantity
   */
  public ProductQuantity(java.util.UUID productId, java.util.UUID stockId, java.lang.Integer quantity) {
    this.productId = productId;
    this.stockId = stockId;
    this.quantity = quantity;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return productId;
    case 1: return stockId;
    case 2: return quantity;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      null,
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
    case 0: productId = (java.util.UUID)value$; break;
    case 1: stockId = (java.util.UUID)value$; break;
    case 2: quantity = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
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
   * Gets the value of the 'quantity' field.
   * @return The value of the 'quantity' field.
   */
  public int getQuantity() {
    return quantity;
  }


  /**
   * Sets the value of the 'quantity' field.
   * @param value the value to set.
   */
  public void setQuantity(int value) {
    this.quantity = value;
  }

  /**
   * Creates a new ProductQuantity RecordBuilder.
   * @return A new ProductQuantity RecordBuilder
   */
  public static com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder newBuilder() {
    return new com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder();
  }

  /**
   * Creates a new ProductQuantity RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ProductQuantity RecordBuilder
   */
  public static com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder newBuilder(com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder other) {
    if (other == null) {
      return new com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder();
    } else {
      return new com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder(other);
    }
  }

  /**
   * Creates a new ProductQuantity RecordBuilder by copying an existing ProductQuantity instance.
   * @param other The existing instance to copy.
   * @return A new ProductQuantity RecordBuilder
   */
  public static com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder newBuilder(com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity other) {
    if (other == null) {
      return new com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder();
    } else {
      return new com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder(other);
    }
  }

  /**
   * RecordBuilder for ProductQuantity instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ProductQuantity>
    implements org.apache.avro.data.RecordBuilder<ProductQuantity> {

    private java.util.UUID productId;
    private java.util.UUID stockId;
    private int quantity;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.productId)) {
        this.productId = data().deepCopy(fields()[0].schema(), other.productId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.stockId)) {
        this.stockId = data().deepCopy(fields()[1].schema(), other.stockId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.quantity)) {
        this.quantity = data().deepCopy(fields()[2].schema(), other.quantity);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing ProductQuantity instance
     * @param other The existing instance to copy.
     */
    private Builder(com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.productId)) {
        this.productId = data().deepCopy(fields()[0].schema(), other.productId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.stockId)) {
        this.stockId = data().deepCopy(fields()[1].schema(), other.stockId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.quantity)) {
        this.quantity = data().deepCopy(fields()[2].schema(), other.quantity);
        fieldSetFlags()[2] = true;
      }
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
    public com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder setProductId(java.util.UUID value) {
      validate(fields()[0], value);
      this.productId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'productId' field has been set.
      * @return True if the 'productId' field has been set, false otherwise.
      */
    public boolean hasProductId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'productId' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder clearProductId() {
      productId = null;
      fieldSetFlags()[0] = false;
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
    public com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder setStockId(java.util.UUID value) {
      validate(fields()[1], value);
      this.stockId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'stockId' field has been set.
      * @return True if the 'stockId' field has been set, false otherwise.
      */
    public boolean hasStockId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'stockId' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder clearStockId() {
      stockId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'quantity' field.
      * @return The value.
      */
    public int getQuantity() {
      return quantity;
    }


    /**
      * Sets the value of the 'quantity' field.
      * @param value The value of 'quantity'.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder setQuantity(int value) {
      validate(fields()[2], value);
      this.quantity = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'quantity' field has been set.
      * @return True if the 'quantity' field has been set, false otherwise.
      */
    public boolean hasQuantity() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'quantity' field.
      * @return This builder.
      */
    public com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity.Builder clearQuantity() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ProductQuantity build() {
      try {
        ProductQuantity record = new ProductQuantity();
        record.productId = fieldSetFlags()[0] ? this.productId : (java.util.UUID) defaultValue(fields()[0]);
        record.stockId = fieldSetFlags()[1] ? this.stockId : (java.util.UUID) defaultValue(fields()[1]);
        record.quantity = fieldSetFlags()[2] ? this.quantity : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ProductQuantity>
    WRITER$ = (org.apache.avro.io.DatumWriter<ProductQuantity>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ProductQuantity>
    READER$ = (org.apache.avro.io.DatumReader<ProductQuantity>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










