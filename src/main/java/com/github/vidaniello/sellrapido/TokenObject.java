package com.github.vidaniello.sellrapido;

import java.io.Serializable;

/**
 * Rappresenta un token OAuth2 restituito dall'API di Sellrapido.
 * <p>
 * Contiene il valore del token, la data/ora di scadenza in formato ISO 8601
 * e il tipo di tipicamente {@code "bearer"}.
 * </p>
 *
 * <pre>{@code
 * {
 *   "token": "stringa, valore del token",
 *   "expiresat": "timestampISO8601 (YYYY-MM-ddThh:mm:ssZ), data e ora di scadenza",
 *   "type": "bearer, tipo di token"
 * }
 * }</pre>
 *
 * @see AuthResponse
 */
public class TokenObject extends ReflectionUtilities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Valore del token (es. token di accesso o di refresh).
	 */
	private String token;

	/**
	 * Data e ora di scadenza del token in formato ISO 8601 ({@code YYYY-MM-ddThh:mm:ssZ}).
	 */
	private String expires_at;

	/**
	 * Tipo di token, tipicamente {@code "bearer"}.
	 */
	private String type;

	public TokenObject() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getExpires_at() {
		return expires_at;
	}

	public void setExpiresat(String expiresat) {
		this.expires_at = expiresat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}