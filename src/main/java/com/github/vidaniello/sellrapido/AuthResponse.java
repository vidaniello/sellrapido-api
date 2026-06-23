package com.github.vidaniello.sellrapido;

import java.io.Serializable;

/**
 * Rappresenta la risposta di autenticazione restituita dall'API di Sellrapido.
 * <p>
 * Contiene due {@link TokenObject}: uno per l'access token e uno per il refresh token.
 * </p>
 *
 * <pre>{@code
 * {
 *   "access_token": {
 *     "token": "stringa, token di accesso. Usato in header Authorization per autenticare le richieste API. Durata 15 min.",
 *     "expires_at": "timestamp_ISO8601 (YYYY-MM-ddThh:mm:ssZ), data e ora di scadenza di questo token",
 *     "type": "bearer, tipo di token. Di norma bearer"
 *   },
 *   "refresh_token": {
 *     "token": "stringa, token di refresh usato per aggiornare l'access_token e ruotare lo stesso refresh. Durata 30gg",
 *     "expires_at": "timestamp_ISO8601 (YYYY-MM-ddThh:mm:ssZ), data e ora di scadenza di questo token",
 *     "type": "bearer, tipo di token. Di norma bearer"
 *   }
 * }
 * }</pre>
 *
 * @see TokenObject
 */
public class AuthResponse extends ReflectionUtilities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Token di accesso utilizzato nell'header {@code Authorization} per autenticare le richieste API.
	 * <p>Durata: 15 minuti.</p>
	 */
	private TokenObject access_token;
	
	/**
	 * Token di refresh utilizzato per ottenere un nuovo {@code access_token} e ruotare il refresh token stesso.
	 * <p>Durata: 30 giorni.</p>
	 */
	private TokenObject refresh_token;
	
	public AuthResponse() {
	}

	public TokenObject getAccess_token() {
		return access_token;
	}

	public void setAccess_token(TokenObject access_token) {
		this.access_token = access_token;
	}

	public TokenObject getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(TokenObject refresh_token) {
		this.refresh_token = refresh_token;
	}

}