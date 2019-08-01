package space.java.test3t;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper gameDb;

    private static Button button_add_game;
    private static Button button_add_player;
    private static Button button_add_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameDb = new DatabaseHelper(this);

        Toolbar toolbar = findViewById(R.id.toolbar_new_game);
        setSupportActionBar(toolbar);

        //addGameButtonListener();
        //addPlayerButtonListener();
        //addGroupButtonListener();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*
    public void addGameButtonListener(){
        button_add_game = (Button)findViewById(R.id.action_add_game);
        button_add_game.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(".AddGameActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addPlayerButtonListener(){
        button_add_player = (Button)findViewById(R.id.action_add_player);
        button_add_player.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(".AddPlayerActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void addGroupButtonListener(){
        button_add_group = (Button)findViewById(R.id.action_add_group);
        button_add_group.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(".AddGroupActivity");
                        startActivity(intent);
                    }
                }
        );
    }
    */

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
}
