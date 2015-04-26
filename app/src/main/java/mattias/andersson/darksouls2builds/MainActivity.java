package mattias.andersson.darksouls2builds;

// Main Activity loads the FragmentTypeList on creation
// Also handles what happens when backbutton is pressed.

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
public static int currentFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.homeLayout, new FragmentTypeList());
        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Validation to decide where the backbutton sohuld take us.
    // Each fragment sets currentFragment to different values
    // That way, we will always be able to check where we're at
    // Before deciding where to go on backbutton!

    @Override
     public void onBackPressed() {
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (currentFragment == 0) {
            ft.replace(R.id.homeLayout, new FragmentTypeList());
            ft.commit();
        }
        if (currentFragment == 1) {
            ft.replace(R.id.homeLayout, new FragmentPve());
            ft.commit();
        }
        if (currentFragment == 2) {
            ft.replace(R.id.homeLayout, new FragmentPvp());
            ft.commit();
        }
    }
}
