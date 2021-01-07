/**
 *
 */
package it.tsc.controller.endpoint;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author "astraservice" custom Configurator implementation which maps (authenticated) user name to
 *         a token (sent via HTTP header)
 */

public class TokenStore extends ServerEndpointConfig.Configurator {
  Map<String, String> userTokens;

  public TokenStore() {
    userTokens = new ConcurrentHashMap<>();
  }

  @Override
  public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request,
      HandshakeResponse response) {
    String token = request.getHeaders().get("sec-websocket-key").get(0);
    String name = request.getUserPrincipal().getName();
    userTokens.put(name, token);
  }

  public Map<String, String> getUserTokens() {
    return Collections.unmodifiableMap(userTokens);
  }

  @Override
  public boolean checkOrigin(String originHeaderValue) {
    return super.checkOrigin(originHeaderValue);
  }

  @Override
  public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
    return super.getEndpointInstance(endpointClass);
  }
}
