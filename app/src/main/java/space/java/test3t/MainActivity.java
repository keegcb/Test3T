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


public class MainActivity extends AppCompatActivity {

    DatabaseHelper gameDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameDb = new DatabaseHelper(this);

        Toolbar toolbar = findViewById(R.id.toolbar_new_game);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        switch (item.getItemId()) {
            case R.id.action_add_game:
                Intent intentGame = new Intent(this, AddGameActivity.class);
                startActivity(intentGame);
                return true;
            case R.id.action_add_player:
                Intent intentPlayer = new Intent(this, AddPlayerActivity.class);
                startActivity(intentPlayer);
                return true;
            case R.id.action_add_group:
                Intent intentGroup = new Intent(this, AddGroupActivity.class);
                startActivity(intentGroup);
                return true;
            case R.id.action_game_library:
                Intent intentLibrary = new Intent(this, GameLibraryActivity.class);
                startActivity(intentLibrary);
                return true;
            case R.id.action_settings:
                System.out.println("No settings page set up yet");
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
