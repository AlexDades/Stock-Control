package com.example.android.stockcontrol;

import android.app.Activity;
import android.view.MenuInflater;

public class FloatingMenu extends Activity {

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tab, (android.view.Menu) menu);

        // return true so that the menu pop up is opened
        return true;
    }
}
