/**
 * 
 * A library for parsing and writing ASN.1 objects. Support is provided for DER and BER encoding.
 */
package org.bouncycastle.asn1;


public interface ASN1SetParser extends ASN1Encodable, InMemoryRepresentable {

	public ASN1Encodable readObject();
}
