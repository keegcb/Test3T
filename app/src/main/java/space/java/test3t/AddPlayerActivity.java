package space.java.test3t;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AddPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        Toolbar toolbar = findViewById(R.id.toolbar_new_game);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add New Player");

    }

}
