/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.playerclient;

import com.playerentity.Player;
import com.sun.jersey.api.client.UniformInterfaceException;
import se.mediaserver.tutorial.domain.Image;
import se.mediaserver.tutorial.domain.Media;
import se.mediaserver.tutorial.util.RestfulImage;
import se.mediaserver.tutorial.util.RestfulPlayer;

/**
 *
 * @author ingimar
 */
public class CreateMediaImage {

    public static void main(String args[]) throws UniformInterfaceException {
        createImage();
    }

    private static void createImage() throws UniformInterfaceException {
        RestfulImage restful = new RestfulImage();

        Media media = new Image();
       
        media.setFilename("scorpio.jpg");
        media.setOwner("actus");
        media.setVisibility("private");
        System.out.println("Media:Image "+media);
        restful.create_XML(media);

//        Player player = new Player();
//        player.setFirstname("Sabba");
//        player.setLastname("Tabba");
//        player.setJerseynumber(51);
//        player.setLastspokenwords("varsågod");
//        restful.create_XML(player);
    }
}
