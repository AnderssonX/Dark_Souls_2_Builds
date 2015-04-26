package mattias.andersson.darksouls2builds;

// This is the build class. It holds all the details for each build that we add to the array in
// FragmentPve and FragmentPvp.

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Mattias on 2015-04-23.
 */
public class Build implements Serializable {
    String name;
    int vig;
    int end;
    int vit;
    int att;
    int str;
    int dex;
    int ada;
    int intel;
    int faith;
    String desc;
    Drawable screenshot;

    public Build(String name, String desc, int vig, int end, int vit, int att, int str, int dex, int ada, int intel, int faith, Drawable screenshot) {
        this.name = name;
        this.desc = desc;
        this.vig = vig;
        this.end = end;
        this.vit = vit;
        this.att = att;
        this.str = str;
        this.dex = dex;
        this.ada = ada;
        this.intel = intel;
        this.faith = faith;
        this.screenshot = screenshot;
    }

    public void setName(String name) {
        this.name = name;
    }

    // A method to fetch build name and all stats in a formatted string.
    public String getBuildSummary() {
        return "Build name: " + name + "\n" + "Vigor: " + vig + "\n" + "Endurance: " + end + "\n" + "Vitality: " + vit + "\n" + "Attunment: " + att + "\n" + "Strength: " + str + "\n" + "Dexterity: " + dex + "\n" + "Adaptation: " + ada + "\n" + "Intellect: " + intel + "\n" + "Faith: " + faith;

    }

    // Only returns a string of different attribute names
    public String getStats() {
        return "Vigor:\nEndurance:\nVitality:\nAttunment:\nStrength:\nDexterity:\nAdaptation:\nIntellect:\nFaith:";
    }

    // Grabs and returns the values of the different attributes in a string.
    public String getStatValues() {
        return vig + "\n" + end + "\n" + vit + "\n" + att + "\n" + str + "\n" + dex + "\n" + ada + "\n" + intel + "\n" + faith;
    }

    // Returns the build description in a string
    public String getDesc() {
        return desc;
    }

    // Returns the build name in a string.
    public String getName() {
        return name;
    }
}