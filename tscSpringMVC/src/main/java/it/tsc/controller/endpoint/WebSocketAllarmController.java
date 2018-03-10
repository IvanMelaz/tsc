/**
 *
 */
package it.tsc.controller.endpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import it.tsc.service.CodaEveService;

/**
 * @author astraservice
 *
 */
@Controller
@ServerEndpoint(value = "/user/allarmEndpoint/{userid}", configurator = SpringConfigurator.class)
@Service
public class WebSocketAllarmController {
  private static Logger logger = LoggerFactory.getLogger(WebSocketAllarmController.class);
  private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
  private EndpointConfig endpointConfig;
  @Autowired
  private CodaEveService codaEveService;
  @Autowired
  private ScheduledExecutorService scheduledExecutorService;

  /**
   *
   */
  public WebSocketAllarmController() {

  }

  @OnOpen
  public void onOpenSession(@PathParam("userid") String userid, Session session,
      EndpointConfig endpointConfig) {
    /**
     * Manage session
     */
    HttpSession httpSession = (HttpSession) endpointConfig.getUserProperties().get("HTTP_SESSION");
    this.endpointConfig = endpointConfig;
    // Session ID
    // to user ID

    if (httpSession != null) {
      httpSession.setAttribute("WEBSOCKET_SESSION", session);
      logger.debug("manage session attribute {} session id: {} user: {}", session, session.getId(),
          userid);
    }
    synchronized (clients) {
      logger.debug("add item to clients: {}", session.getId());
      clients.add(session);
      this.endpointConfig.getUserProperties().put(session.getId(), userid); // store mapping of
      // WebSocket
    }

    if (clients.size() != 0) {
      /**
       * activate executor if not exist
       */
      // this.executorService = Executors.newSingleThreadScheduledExecutor();
      scheduledExecutorService.scheduleAtFixedRate(() -> checkAllarmOnDatabase(session), 0, 3,
          TimeUnit.SECONDS);
    }
  }

  @OnError
  public void error(Session session, Throwable t) {
    for (Session s : clients) {
      if (s.getId().equals(session.getId())) {
        clients.remove(session);
        if (this.endpointConfig.getUserProperties() != null
            && this.endpointConfig.getUserProperties().containsKey(session.getId())) {
          this.endpointConfig.getUserProperties().remove(session.getId());
        }
        logger.error("Error on session " + session.getId());
        return;
      }
    }
    logger.debug("no matching session " + session.getId());
  }


  private void checkAllarmOnDatabase(Session session) {
    /**
     * Open database connection and send message
     */
    /**
     * broadcast message
     */
    synchronized (clients) {
      for (Session sess : clients) {
        /**
         * check the mapping
         */
        String userid = (String) this.endpointConfig.getUserProperties().get(sess.getId());
        if (sess.isOpen()) {
          try {
            String message = "";
            if (StringUtils.isNotEmpty(userid)) {
              message = codaEveService.jsonQueueGetAllarms(userid);
              sess.getBasicRemote().sendText(message);
            }
          } catch (IOException ex) {
            logger.error(ex.getMessage());
          }
        }
      }
    }
  }

  @OnClose
  public void onClose(Session session) {
    synchronized (clients) {
      for (Session s : clients) {
        if (s.getId().equals(session.getId())) {
          if (this.endpointConfig.getUserProperties() != null
              && this.endpointConfig.getUserProperties().containsKey(session.getId())) {
            this.endpointConfig.getUserProperties().remove(session.getId());
          }
          clients.remove(session);
          logger.debug("Client disconnected @ {}", session.getId());
        }
      }
    }
  }
}
