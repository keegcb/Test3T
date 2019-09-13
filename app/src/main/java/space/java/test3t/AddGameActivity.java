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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class AddGameActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseHelper gameDB;

    LinearLayout linearLayout;
    private static RatingBar diffRate;
    private static RatingBar learnRate;
    private static RatingBar gameRating;
    private static Spinner typeSpinner;
    private static Spinner catSpinner;
    private static Spinner mechSpinner;
    Button btnAddGameData;
    EditText editGame, editPublisher;
    Spinner spinnerMinSeat, spinnerMaxSeat, spinnerMinTime, spinnerMaxTime;
    String textDiffRate;
    String textLearnRate;
    String textGameRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);
        Toolbar toolbar = findViewById(R.id.toolbar_new_game);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Game to Collection");
        gameDB = new DatabaseHelper(this);

        editGame = findViewById(R.id.editText_gameTitle);
        editPublisher = findViewById(R.id.editText_publisher);
        btnAddGameData = findViewById(R.id.button_addGame);

        spinnerMinSeat = findViewById(R.id.spinner_minSeat);
        ArrayAdapter<CharSequence> adapterMinS = ArrayAdapter.createFromResource(this, R.array.spinner_min_seats, android.R.layout.simple_spinner_item);
        adapterMinS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinSeat.setAdapter(adapterMinS);
        spinnerMinSeat.setOnItemSelectedListener(this);

        spinnerMaxSeat = findViewById(R.id.spinner_maxSeat);
        ArrayAdapter<CharSequence> adapterMaxS = ArrayAdapter.createFromResource(this, R.array.spinner_max_seats, android.R.layout.simple_spinner_item);
        adapterMaxS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaxSeat.setAdapter(adapterMaxS);
        spinnerMaxSeat.setOnItemSelectedListener(this);

        spinnerMinTime = findViewById(R.id.spinner_minTime);
        ArrayAdapter<CharSequence> adapterMinT = ArrayAdapter.createFromResource(this, R.array.spinner_play_time, android.R.layout.simple_spinner_item);
        adapterMinT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinTime.setAdapter(adapterMinT);
        spinnerMinTime.setOnItemSelectedListener(this);

        spinnerMaxTime = findViewById(R.id.spinner_maxTime);
        ArrayAdapter<CharSequence> adapterMaxT = ArrayAdapter.createFromResource(this, R.array.spinner_play_time, android.R.layout.simple_spinner_item);
        adapterMaxT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaxTime.setAdapter(adapterMaxT);
        spinnerMaxTime.setOnItemSelectedListener(this);

        listenRatingBar();
        listenTypeSpinner();
        listenTypeBtn();
        listenCategorySpinner();
        listenCatBtn();
        listenMechSpinner();
        listenMechBtn();

        AddGameData();
    }

    public void listenRatingBar(){
        diffRate = findViewById(R.id.ratingBar_difficulty);
        learnRate = findViewById(R.id.ratingBar_learningCurve);
        gameRating = findViewById(R.id.ratingBar_gameRating);

        diffRate.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        textDiffRate = String.valueOf(rating);
                    }
                }
        );


        learnRate.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        textLearnRate = String.valueOf(rating);
                    }
                }
        );

        gameRating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        textGameRate = String.valueOf(rating);
                    }
                }
        );

    }

    public void listenTypeBtn(){
        final LinearLayout typeLayout = findViewById(R.id.linearLayout_type);

        final ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.spinner_game_type, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Button btnAddType = findViewById(R.id.btn_gameType);
        btnAddType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewSpinner(typeLayout, adapterType);
            }
        });
    }

    public void listenCatBtn(){
        final LinearLayout catLayout = findViewById(R.id.linearLayout_category);

        final ArrayAdapter<CharSequence> adapterCat = ArrayAdapter.createFromResource(this, R.array.spinner_game_category, android.R.layout.simple_spinner_item);
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Button btnAddCat = findViewById(R.id.btn_gameCategory);
        btnAddCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewSpinner(catLayout, adapterCat);
            }
        });
    }

    public void listenMechBtn(){
        final LinearLayout mechLayout = findViewById(R.id.linearLayout_mechanism);

        final ArrayAdapter<CharSequence> adapterMech = ArrayAdapter.createFromResource(this, R.array.spinner_game_mechanism, android.R.layout.simple_spinner_item);
        adapterMech.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Button btnAddMech = findViewById(R.id.btn_gameMechanism);
        btnAddMech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewSpinner(mechLayout, adapterMech);
            }
        });
    }

    public void listenCategorySpinner(){
        catSpinner = findViewById(R.id.spinner_category);
        ArrayAdapter<CharSequence> adapterCat = ArrayAdapter.createFromResource(this, R.array.spinner_game_category, android.R.layout.simple_spinner_item);
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        catSpinner.setAdapter(adapterCat);
        catSpinner.setOnItemSelectedListener(this);
    }

    public void listenTypeSpinner(){
        typeSpinner = findViewById(R.id.spinner_type);
        ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.spinner_game_type, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapterType);
        typeSpinner.setOnItemSelectedListener(this);

    }

    public void listenMechSpinner(){
        mechSpinner = findViewById(R.id.spinner_mechanism);
        ArrayAdapter<CharSequence> adapterMech = ArrayAdapter.createFromResource(this, R.array.spinner_game_mechanism, android.R.layout.simple_spinner_item);
        adapterMech.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mechSpinner.setAdapter(adapterMech);
        mechSpinner.setOnItemSelectedListener(this);
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
        params.setMargins(0,convertDpToPixel(8), 0, convertDpToPixel(8));

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

    public void AddGameData(){
        btnAddGameData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        boolean isInserted = gameDB.insertGameData(editGame.getText().toString(), spinnerMinSeat.getSelectedItem().toString(), spinnerMaxSeat.getSelectedItem().toString(),
                                spinnerMinTime.getSelectedItem().toString(), spinnerMaxTime.getSelectedItem().toString(),
                                String.valueOf(diffRate.getRating()), String.valueOf(learnRate.getRating()), editPublisher.getText().toString(), String.valueOf(gameRating.getRating()));
                        if(isInserted == true)
                            Toast.makeText(AddGameActivity.this, "Game Added to Collection", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddGameActivity.this, "Game NOT Added", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
