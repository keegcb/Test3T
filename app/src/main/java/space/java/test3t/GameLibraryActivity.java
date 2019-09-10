package space.java.test3t;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
        gameList.add(new GameItem(R.drawable.ic_casino_black_24dp, "Game 1", "Attribute 1"));
        gameList.add(new GameItem(R.drawable.ic_extension_black_24dp, "Game 2", "Attribute 2"));
        gameList.add(new GameItem(R.drawable.ic_casino_black_24dp, "Game 3", "Attribute 3"));

        RefreshGameData();

    }

    public void RefreshGameData(){
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = gameDB.getGameData();
                 if(res.getCount()==0){
                     showDataMessage("Error", "Nothing found");
                     return;
                 }

                 StringBuffer buffer = new StringBuffer();
                 while (res.moveToNext()){
                     buffer.append(res.getString(0));
                 }

                 //show data
                showDataMessage("Games", buffer.toString());
            }
        });
    }

    public void showDataMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
