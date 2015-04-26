package mattias.andersson.darksouls2builds;

// Fragment for listing build types (Currently Pve & pvp).
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
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentTypeList extends Fragment {
    public static int currentType;
    // Create an arraylist of types (pve or pvp)
    public static ArrayList<Type> types = new ArrayList<Type>();

    //This method comes first so lets create the books here
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Clear the array and the populate it with desired types.
        types.clear();
        Drawable img = getResources().getDrawable(R.drawable.pve);
        types.add(new Type("PVE builds", img));
        img = getResources().getDrawable(R.drawable.pvp);
        types.add(new Type("PVP builds", img));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_type_list, container, false);
        Log.i("TypeList", "Number of types added: " + types.size() + " " + types.get(0).getType() + " & " + types.get(1).getType());
        TypeListAdapter la = new TypeListAdapter(getActivity(), types);
        GridView gw = (GridView) v.findViewById(R.id.typesGridView);
        gw.setAdapter(la);
        gw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentType = position;

                // Log and toast on list interaction
                Log.i("TypeList", "Clicked on position: " + position + "/ " + types.get(position).getType());
                //display in short period of time
                Toast.makeText(getActivity(), types.get(position).getType(),
                        Toast.LENGTH_SHORT).show();

                // Fragment transaction on list interaction
                if (currentType == 0) {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    FragmentPve ftype = new FragmentPve();
                    // byt layout till Fragment FragmentType
                    ft.replace(R.id.homeLayout, ftype);
                    ft.commit();

                }
                if (currentType == 1) {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    FragmentPve ftype = new FragmentPve();
                    // byt layout till Fragment FragmentType
                    ft.replace(R.id.homeLayout, ftype);
                    ft.commit();

                }
            }
        });
        return v;
    }

    public String getType() {
        return types.get(currentType).getType();
    }

    public Drawable getImage() {
        return types.get(currentType).getImage();
    }
}
