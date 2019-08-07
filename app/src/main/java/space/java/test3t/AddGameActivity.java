package space.java.test3t;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class AddGameActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    LinearLayout linearLayout;
    private static RatingBar diffRate;
    private static RatingBar learnRate;
    private static Spinner typeSpinner;
    private static Button btnAddType;

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

        listenRatingBar();
        listenTypeSpinner();
        listenTypeBtn();



    }

    public void listenRatingBar(){
        diffRate = findViewById(R.id.ratingBar_difficulty);
        learnRate = findViewById(R.id.ratingBar_learningCurve);

        diffRate.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        String text = String.valueOf(rating);
                        Toast.makeText(ratingBar.getContext(), text, Toast.LENGTH_SHORT).show();
                    }
                }
        );


        learnRate.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        String text = String.valueOf(rating);
                        Toast.makeText(ratingBar.getContext(), text, Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }

    public void listenTypeBtn(){
        linearLayout = findViewById(R.id.linearLayout_type);

        final ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.spinner_game_type, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Button btnAddType = findViewById(R.id.btn_gameType);
        btnAddType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewSpinner(linearLayout, adapterType);
            }
        });
    }

    public void listenTypeSpinner(){
        typeSpinner = findViewById(R.id.spinner_type);
        ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.spinner_game_type, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapterType);
        typeSpinner.setOnItemSelectedListener(this);

    }

    public void addNewSpinner(LinearLayout layout, final ArrayAdapter<CharSequence> adapter){
        linearLayout = layout;

        final Spinner nextSpinner = new Spinner(this);
        nextSpinner.setAdapter(adapter);
        nextSpinner.setOnItemSelectedListener(this);
        setSpinnerAttributes(nextSpinner);
        linearLayout.addView(nextSpinner);

    }

    private void setSpinnerAttributes(Spinner nextSpinner){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,convertDpToPixel(8), 0, 0);

        nextSpinner.setLayoutParams(params);

    }

    private int convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
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
