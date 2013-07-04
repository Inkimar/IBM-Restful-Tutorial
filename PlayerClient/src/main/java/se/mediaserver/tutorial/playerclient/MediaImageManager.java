/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.playerclient;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.ArrayList;
import java.util.List;
import se.mediaserver.tutorial.domain.Image;
import se.mediaserver.tutorial.domain.Media;
import se.mediaserver.tutorial.util.RestfulImage;

/**
 *
 * @author ingimar
 */
public class MediaImageManager {

    public static void main(String args[]) throws UniformInterfaceException {
        System.out.println("Running MediaImageManager");
        //createImage();
        get();
    }

    private static void createImage() throws UniformInterfaceException {
        RestfulImage restful = new RestfulImage();

        Media media = new Image();

        media.setFilename("scorpio.jpg");
        media.setOwner("actus");
        media.setVisibility("private");
        System.out.println("Media:Image " + media);
        restful.create_XML(media);
    }
    
     private static void get() {

        RestfulImage restful = new RestfulImage();
        ClientResponse response = restful.findAll_XML(ClientResponse.class);

        GenericType<List<Image>> genericType = new GenericType<List<Image>>() {
        };

        // Returns an ArrayList of Players from the web service
        List<Image> images = new ArrayList<Image>();
        images = (response.getEntity(genericType));
        System.out.println("Retreiving and Displaying Players Details");
        for (Image image : images) {
            System.out.println("Filename: " + image.getFilename() );
            System.out.println(" Owner is: " + image.getOwner() );
      
        }
    }
}
