package com.example.tharani.contextmenu;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*onCreate is the first method in the life cycle of an activity
 savedInstance passes data to super class,data is pull to store state of application
 * setContentView is used to set layout for the activity
 *R is a resource and it is auto generate file
  * activity_main assign an integer value*/
    // declaring variables
    Button btn;//Button is a android widget or view
    //creating bridge between button and java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= findViewById(R.id.btn);
        //registering button for context menu
        registerForContextMenu(btn);
    }
    /*here i created onCreateContextMenu method*
    A context menu is a floating menu that appears when we  performs a long-click on an element.
    It provides actions that affect the selected content or context frame./
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //here we are adding menu
        //here using getters and setters
        menu.setHeaderTitle("Context menu");//setting the title
        /*by using add method adding add,edit,delete actions*/
        menu.add(0,v.getId(),0,"Add");
        menu.add(0,v.getId(),0,"Edit");
        menu.add(0,v.getId(),0,"Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //here we are applying condition for performing different actions
        if (item.getTitle() == "Add") {//gets title
            Toast.makeText(this, "Add", Toast.LENGTH_LONG).show();//it will show the toast of add
            // LENGTH_LONG is the duration for which a toast is displayed on screen and duration which is 3,5 seconds
        } else if (item.getTitle() == "Edit") {
            Toast.makeText(this, "Edit", Toast.LENGTH_LONG).show();//it will show the toast of edit
        } else if (item.getTitle() == "Delete") {
            Toast.makeText(this, "Delete", Toast.LENGTH_LONG).show();//it will show the toast of delete
        } else {
            return false;
        }
        return true;
       //here boolean returns false if action was completed or else returns true
    }
}


