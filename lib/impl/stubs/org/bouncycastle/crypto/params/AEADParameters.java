/**
 * 
 * Classes for parameter objects for ciphers and generators.
 */
package org.bouncycastle.crypto.params;


public class AEADParameters implements org.bouncycastle.crypto.CipherParameters {

	/**
	 *  Base constructor.
	 * 
	 *  @param key key to be used by underlying cipher
	 *  @param macSize macSize in bits
	 *  @param nonce nonce to be used
	 *  @param associatedText associated text, if any
	 */
	public AEADParameters(KeyParameter key, int macSize, byte[] nonce, byte[] associatedText) {
	}

	public KeyParameter getKey() {
	}

	public int getMacSize() {
	}

	public byte[] getAssociatedText() {
	}

	public byte[] getNonce() {
	}
}
