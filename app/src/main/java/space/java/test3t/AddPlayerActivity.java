package space.java.test3t;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    EditText editPlayer;
    Button btnAddPlayerData;
    DatabaseHelper gameDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        Toolbar toolbar = findViewById(R.id.toolbar_new_game);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Player List");
        gameDB = new DatabaseHelper(this);

        editPlayer = findViewById(R.id.editText_playerName);
        btnAddPlayerData = findViewById(R.id.button_addPlayer);

        mRecyclerView = findViewById(R.id.recyclerview_addPlayer);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new PlayerItemAdapter(this, getAllPlayers());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        AddPlayerData();

    }

    private Cursor getAllPlayers(){
        return gameDB.getPlayerData();
    }

    public void AddPlayerData() {
        btnAddPlayerData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = gameDB.insertPlayerData(editPlayer.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(AddPlayerActivity.this, "Player Added to Collection", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddPlayerActivity.this, "Player NOT Added", Toast.LENGTH_LONG).show();

                        UpdateList();
                    }
                }
        );
    }

    public void UpdateList(){
        setContentView(R.layout.activity_add_player);
        Toolbar toolbar = findViewById(R.id.toolbar_new_game);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Player List");
        gameDB = new DatabaseHelper(this);

        editPlayer = findViewById(R.id.editText_playerName);
        btnAddPlayerData = findViewById(R.id.button_addPlayer);

        mRecyclerView = findViewById(R.id.recyclerview_addPlayer);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new PlayerItemAdapter(this, getAllPlayers());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
