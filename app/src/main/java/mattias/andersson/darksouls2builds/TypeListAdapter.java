package mattias.andersson.darksouls2builds;

// Adapter that lists the build types and listens for clicks.

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TypeListAdapter extends ArrayAdapter<Type> {
    ArrayList<Type> typesList;
    Context c;

    public TypeListAdapter(Context context, ArrayList<Type> typesList) {
        super(context, 0, typesList);
        this.typesList = typesList;
        this.c = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("MyListAdapter", "Called for position: " + position);
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item_types, null);
        Type t = typesList.get(position);
        TextView tw_title = (TextView) convertView.findViewById(R.id.type_title);
        ImageView iv_image = (ImageView) convertView.findViewById(R.id.typeList_image);
        tw_title.setText(t.getType());
                iv_image.setImageDrawable(t.getImage());
        return convertView;
    }
}
