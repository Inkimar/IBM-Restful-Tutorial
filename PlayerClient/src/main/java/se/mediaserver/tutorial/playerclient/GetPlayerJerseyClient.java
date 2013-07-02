/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.playerclient;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;
import java.util.List;
import com.playerentity.Player;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import se.mediaserver.tutorial.util.URI;

/**
 * Jersey REST client generated for REST resource:PlayerFacadeREST
 * [com.playerentity.player]<br>
 * USAGE:
 * <pre>
 *        GetPlayerJerseyClient client = new GetPlayerJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author ingimar
 */
public class GetPlayerJerseyClient {

    public static void main(String args[]) throws UniformInterfaceException {


        GetPlayerJerseyClient client1 = new GetPlayerJerseyClient();
        // client1.remove("3");
        //  client1.update();

        ClientResponse response = client1.findAll_XML(ClientResponse.class);


        GenericType<List<Player>> genericType = new GenericType<List<Player>>() {
        };

        // Returns an ArrayList of Players from the web service
        List<Player> data = new ArrayList<Player>();
        data = (response.getEntity(genericType));
        System.out.println("Retreiving and Displaying Players Details");
        for (Player players : data) {
            System.out.println("FirstName: " + players.getFirstname());
            System.out.println(" Jerseyno: " + players.getJerseynumber());
            System.out.println("LastName: " + players.getLastname());
            System.out.println("Last Spoken Words:" + players.getLastspokenwords());
        }

    }

    private void update() {
        CreatePlayerJerseyClient client1 = new CreatePlayerJerseyClient();
        ClientResponse response1 = client1.find_XML(ClientResponse.class, "3");
        GenericType<Player> genericType = new GenericType<Player>() {
        };
        Player player = response1.getEntity(genericType);
        System.out.println("FirstName: " + player.getFirstname());
        System.out.println(" Jerseyno: " + player.getJerseynumber());
        System.out.println("LastName: " + player.getLastname());
        System.out.println("Last Spoken Words: " + player.getLastspokenwords());

        player.setJerseynumber(101);
        player.setLastspokenwords(" I will be retiring soon -updated");
        client1.edit_XML(player);


    }
    private WebResource webResource;

    public GetPlayerJerseyClient() {
        webResource = URI.getWebResource();
    }

    public void remove(String id) throws UniformInterfaceException {
        webResource.path(java.text.MessageFormat.format("{0}", new Object[]{id})).delete();
    }

    public String countREST() throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("count");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public <T> T findAll_XML(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findAll_JSON(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void edit_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }

    public void edit_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(requestEntity);
    }

    public void create_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(requestEntity);
    }

    public void create_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(requestEntity);
    }

    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findRange_JSON(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T find_XML(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T find_JSON(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

//    public void close() {
//        client.destroy();
//    }
}
