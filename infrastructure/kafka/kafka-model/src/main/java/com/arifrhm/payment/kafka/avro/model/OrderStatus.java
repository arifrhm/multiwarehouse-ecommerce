/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.arifrhm.payment.kafka.avro.model;
@org.apache.avro.specific.AvroGenerated
public enum OrderStatus implements org.apache.avro.generic.GenericEnumSymbol<OrderStatus> {
  PENDING, PAID, APPROVED, CANCELLING, CANCELLED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"OrderStatus\",\"namespace\":\"com.arifrhm.payment.kafka.avro.model\",\"symbols\":[\"PENDING\",\"PAID\",\"APPROVED\",\"CANCELLING\",\"CANCELLED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
