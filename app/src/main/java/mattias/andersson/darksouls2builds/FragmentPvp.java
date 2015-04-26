package mattias.andersson.darksouls2builds;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mattias on 2015-04-24.
 */

// Fragment for listing pvp builds
// Creates an arraylist of builds and adds objects to it.
// Then calls for the BuildsList Adapter to list them in a layout and listen for clicks.
// ** NOT started yet **

public class FragmentPvp extends Fragment {

    // Create an arraylist of builds

    public FragmentPvp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Set the currentFragment for the backButton method in MainActivity
        // To control where "homebutton" takes us from here. (0 goes to home screen)
        MainActivity.currentFragment = 0;

        // Inflate the layout for this fragment
        View v;
        FragmentTypeList ftl = new FragmentTypeList();
        v = inflater.inflate(R.layout.fragment_list_builds, container, false);
        // TextView planetName = (TextView) v.findViewById(R.id.textViewType);
        // planetName.setText(ftl.getType());
        Log.i("TypeFragment", "We're listing builds");
        // ImageView typeImage = (ImageView) v.findViewById(R.id.typeImage);
        // typeImage.setImageDrawable(ftl.getImage());
        return v;
    }


}