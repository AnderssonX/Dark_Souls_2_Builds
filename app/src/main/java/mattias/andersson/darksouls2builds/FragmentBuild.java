package mattias.andersson.darksouls2builds;

// This fragment shows details for chosen build in the build array.

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by Mattias on 2015-04-24.
 */
public class FragmentBuild extends Fragment {

    public FragmentBuild() {
        // Empty public constructor (required)
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Let's do a quick validation before we decide where the backbutton should take us.
        // If we're viewing a PVE-build the backbutton should take us back to FragmentPVE
        // If we're viewing a PVP-build, it should take us to FragmentPVP
        // ( if currentType is 0 we're viewing pve, if 1, pvp!)

        if(FragmentTypeList.currentType == 0) {
            MainActivity.currentFragment = 1; // (1 takes us to FragmentPVE)
        }
        if(FragmentTypeList.currentType == 1){
            MainActivity.currentFragment = 2; // ( 2 takes us to FragmentPVP)

        }

        View v;
        v = inflater.inflate(R.layout.fragment_build, container, false);
        FragmentPve pve = new FragmentPve();

        TextView buildName = (TextView) v.findViewById(R.id.tw_buildName);
        buildName.setText(pve.getName());
        buildName.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));

        TextView buildDesc = (TextView) v.findViewById(R.id.tw_buildDesc);
        buildDesc.setText(pve.getDesc());
        buildDesc.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));

        TextView tw_stats = (TextView) v.findViewById(R.id.tw_stats);
        tw_stats.setText(pve.getStats());
        tw_stats.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));

        TextView tw_values = (TextView) v.findViewById(R.id.tw_values);
        tw_values.setText(pve.getStatValues());
        tw_values.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));
        return v;
    }


}
