package org.openjfx.view;

import javafx.scene.image.Image;

class ResourceHandler {

    //Fetches PNG Image called id.png
    static Image getResource(String id){
        String imageUrl = ClassLoader.getSystemResource(id + ".png").toExternalForm();
        return new Image (imageUrl);
    }
}
