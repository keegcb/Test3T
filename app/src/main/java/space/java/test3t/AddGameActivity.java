package space.java.test3t;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AddGameActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);
        Toolbar toolbar = findViewById(R.id.toolbar_new_game);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Game to Collection");


        Spinner spinnerMinSeat = findViewById(R.id.spinner_minSeat);
        ArrayAdapter<CharSequence> adapterMinS = ArrayAdapter.createFromResource(this, R.array.spinner_min_seats, android.R.layout.simple_spinner_item);
        adapterMinS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinSeat.setAdapter(adapterMinS);
        spinnerMinSeat.setOnItemSelectedListener(this);

        Spinner spinnerMaxSeat = findViewById(R.id.spinner_maxSeat);
        ArrayAdapter<CharSequence> adapterMaxS = ArrayAdapter.createFromResource(this, R.array.spinner_max_seats, android.R.layout.simple_spinner_item);
        adapterMaxS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaxSeat.setAdapter(adapterMaxS);
        spinnerMaxSeat.setOnItemSelectedListener(this);

        Spinner spinnerMinTime = findViewById(R.id.spinner_minTime);
        ArrayAdapter<CharSequence> adapterMinT = ArrayAdapter.createFromResource(this, R.array.spinner_play_time, android.R.layout.simple_spinner_item);
        adapterMinT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinTime.setAdapter(adapterMinT);
        spinnerMinTime.setOnItemSelectedListener(this);

        Spinner spinnerMaxTime = findViewById(R.id.spinner_maxTime);
        ArrayAdapter<CharSequence> adapterMaxT = ArrayAdapter.createFromResource(this, R.array.spinner_play_time, android.R.layout.simple_spinner_item);
        adapterMaxT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaxTime.setAdapter(adapterMaxT);
        spinnerMaxTime.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
