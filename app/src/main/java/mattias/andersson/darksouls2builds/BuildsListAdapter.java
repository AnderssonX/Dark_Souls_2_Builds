package mattias.andersson.darksouls2builds;


// Adapter for listing the pve & pvp builds.

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mattias on 2015-04-24.
 */

// Adapter that lists the builds in the builds array from FragmentPve or FragmentPvp.

public class BuildsListAdapter extends ArrayAdapter<Build> {
    ArrayList<Build> buildsList;
    Context c;

    public BuildsListAdapter(Context context, ArrayList<Build> buildsList) {
        super(context, 0, buildsList);
        this.buildsList = buildsList;
        this.c = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("buildsListAdapter", "Called for position: " + position);
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item_builds, null);
        Build b = buildsList.get(position);
        TextView tw_title = (TextView) convertView.findViewById(R.id.build_title);
        tw_title.setText(b.getName());
        //iv_image.setImageDrawable(t.getImage());
        return convertView;
    }
}


