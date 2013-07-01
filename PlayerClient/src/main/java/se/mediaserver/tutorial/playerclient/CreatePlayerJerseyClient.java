package se.mediaserver.tutorial.playerclient;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.text.MessageFormat;
import javax.ws.rs.core.MediaType;

import com.playerentity.Player;
import se.mediaserver.tutorial.util.URI;

/**
 * @author ingimar
 */
public class CreatePlayerJerseyClient {

    public static void main(String args[]) throws UniformInterfaceException {

        CreatePlayerJerseyClient client1 = new CreatePlayerJerseyClient();

        Player player = new Player();
        player.setFirstname("Marie");
        player.setLastname("Andersson");
        player.setJerseynumber(66);
        player.setLastspokenwords("THANKS");
        client1.create_XML(player);
    }

    private WebResource webResource;

    public CreatePlayerJerseyClient() {
        webResource = URI.getWebResource();
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

//    public void close() {
//        client.destroy();
//    }
}