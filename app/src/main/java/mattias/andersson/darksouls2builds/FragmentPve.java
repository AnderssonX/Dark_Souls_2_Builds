package mattias.andersson.darksouls2builds;

// Fragment for listing pve builds
// Creates an arraylist of builds and adds objects to it.
// Then calls for the BuildsList Adapter to list them in a layout and listen for clicks.

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mattias on 2015-04-23.
 */
public class FragmentPve extends Fragment {


    // Create an arraylist of builds
    public static ArrayList<Build> builds = new ArrayList<Build>();

    // Declares the in "currentBuild" to hold the position of currently chosen build
    public static int currentBuild;

    public FragmentPve() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Set the currentFragment for the backButton method in MainActivity
        // To control where "homebutton" takes us from here. (0 goes to home screen)
        MainActivity.currentFragment = 0;

        super.onCreate(savedInstanceState);

        // Clear the builds array
        builds.clear();

        // Declare a dummy screenshot for objects, so that we don't have to add a new one to each build for now.
        Drawable screenshot = getResources().getDrawable(R.drawable.screenshotdummy);

        builds.add(new Build("Tainted Pilgrim", "A Cleric/Hex based version of the mystic knight. Built for Tanking heavy enemies like Ruin sentinels and other high poise enemies. WEAPONS: Halberd, and later, Lucerene , Archdrake chime, Archdrake staff ARMOR: Full Royal Swordsman set SHIELDS:Any medium shield, but I prefer the Archdrake or Silverblack shields. SPELLS: Dark Orb, Heal", 30, 15, 12, 17, 24, 12, 11, 9, 40, screenshot));
        builds.add(new Build("Second Build", "description", 12, 15, 16, 23, 42, 12, 42, 12, 12, screenshot));
        builds.add(new Build("Third Build", "description", 12, 15, 16, 23, 42, 12, 42, 12, 12, screenshot));
        builds.add(new Build("Fourth Build", "description", 12, 15, 16, 23, 42, 12, 42, 12, 12, screenshot));
        builds.add(new Build("Fifth Build", "description", 12, 15, 16, 23, 42, 12, 42, 12, 12, screenshot));

        builds.get(0).setArmor("Chloranthy Ring, Stone Ring, Ring of Binding, Ring of Blades");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflates the layout for this fragment
        View v;

        FragmentTypeList ftl = new FragmentTypeList();

        v = inflater.inflate(R.layout.fragment_list_builds, container, false);
        Log.i("FragmentPVE", "Number of builds added: " + builds.size());
        BuildsListAdapter bla = new BuildsListAdapter(getActivity(), builds);
        ListView lv = (ListView) v.findViewById(R.id.buildslistview);
        lv.setAdapter(bla);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentBuild = position;

                // Log stuff
                Log.i("FragmentPVE", "Clicked on position: " + position + "(" + builds.get(position).getName() + ")");
                Toast.makeText(getActivity(), builds.get(position).getName(), Toast.LENGTH_SHORT).show();

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FragmentBuild fb = new FragmentBuild();
                ft.replace(R.id.homeLayout, fb);
                ft.commit();
            }
        });

        Log.i("TypeFragment", "We're listing " + ftl.getType() + " builds");

        return v;
    }
// Declaring some methods so we can grab details from the FragmentBuild-fragment.

    public String getSummary() {
        return builds.get(currentBuild).getBuildSummary();
    }

    public String getName() {
        return builds.get(currentBuild).getName();
    }

    public String getStats() {
        return builds.get(currentBuild).getStats();
    }

    public String getDesc() {
        return builds.get(currentBuild).getDesc();
    }

    public String getStatValues() {
        return builds.get(currentBuild).getStatValues();
    }

    public String getGear() {
        return builds.get(currentBuild).getGear();
    }
}