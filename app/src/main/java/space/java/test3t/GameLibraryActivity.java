package space.java.test3t;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class GameLibraryActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private GameItemAdapter gAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    DatabaseHelper gameDB;

    Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_library);
        Toolbar toolbar = findViewById(R.id.toolbar_game_library);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Collection Library");
        gameDB = new DatabaseHelper(this);

        btnRefresh = findViewById(R.id.action_game_library);

        ArrayList<GameItem> gameList = new ArrayList<>();


        mRecyclerView = findViewById(R.id.recyclerview_game_library);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GameItemAdapter(this, getAllGames());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private Cursor getAllGames(){
        return gameDB.getGameData();
    }

    public void showDataMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
