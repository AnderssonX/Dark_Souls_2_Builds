package mattias.andersson.darksouls2builds;

// The class "type" holds an image and a name for the different
// types of builds (currently pve & pvp).

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Mattias on 2015-04-23.
 */
public class Type implements Serializable {

    String type;
    Drawable image;

    public Type(String type, Drawable image) {
        this.type = type;
        this.image = image;

    }

    public String getType() {
        return this.type;
    }

    public Drawable getImage() {
        return image;
    }
}