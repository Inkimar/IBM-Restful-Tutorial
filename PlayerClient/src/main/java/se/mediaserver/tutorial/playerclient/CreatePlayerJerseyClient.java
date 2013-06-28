package se.mediaserver.tutorial.playerclient;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import java.text.MessageFormat;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import com.playerentity.Player;
import se.mediaserver.tutorial.util.URI;

/**
 * Jersey REST client generated for REST resource:PlayerFacadeREST
 * [com.playerentity.player]<br>
 * USAGE:
 * <pre>
 *        CreatePlayerJerseyClient client = new CreatePlayerJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author ingimar
 */
public class CreatePlayerJerseyClient {

    public static void main(String args[]) throws UniformInterfaceException {

        CreatePlayerJerseyClient client1 = new CreatePlayerJerseyClient();
        ClientResponse response = client1.findAll_XML(ClientResponse.class);

        GenericType<List<Player>> genericType = new GenericType<List<Player>>() {
        };

        // Returns an ArrayList of Players from the web service
        List<Player> data = new ArrayList<>();
//        data = (response.getEntity(genericType));

        Player player = new Player();
         player.setId(39); // 
        player.setFirstname("Gissur");
        player.setLastname("Erlingsson");
        player.setJerseynumber(66);
        player.setLastspokenwords("tack takk");
        client1.create_XML(player);
    }

    private WebResource webResource;

    private Client client;

    public CreatePlayerJerseyClient() {
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
       webResource = client.resource(URI.BASE_URI).path("com.playerentity.player");
       // webResource = client.resource(BASE_URI).path("playerentities.player");
    }

    public void remove(String id) throws UniformInterfaceException {
        webResource.path(MessageFormat.format("{0}", new Object[]{id})).delete();
    }

    public String countREST() throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("count");
        return resource.accept(MediaType.TEXT_PLAIN).get(String.class);
    }

    public <T> T findAll_XML(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findAll_JSON(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void edit_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(MediaType.APPLICATION_XML).put(requestEntity);
    }

    public void edit_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(MediaType.APPLICATION_JSON).put(requestEntity);
    }

    public void create_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(MediaType.APPLICATION_XML).post(requestEntity);
    }

    public void create_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(MediaType.APPLICATION_JSON).post(requestEntity);
    }

    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findRange_JSON(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T find_XML(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T find_JSON(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.destroy();
    }
}