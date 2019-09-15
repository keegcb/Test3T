package space.java.test3t;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/*
Class that handles the moving data from GameItem into the CardView and then handles
putting the Card View items into the RecyclerView
 */

public class GameItemAdapter extends RecyclerView.Adapter<GameItemAdapter.GameViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public GameItemAdapter(Context context, Cursor cursor){
        mContext = context;
        mCursor = cursor;
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder{

        public TextView mTitle;
        public TextView mPublisher;
        public TextView mSeatMin;
        public TextView mSeatMax;
        public TextView mTimeMin;
        public TextView mTimeMax;
        public TextView mDiff;
        public TextView mLearn;
        public RatingBar mRating;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.textView_title_card);
            mPublisher = itemView.findViewById(R.id.textView_publisher_card);
            mSeatMin = itemView.findViewById(R.id.textView_seatMin_card);
            mSeatMax = itemView.findViewById(R.id.textView_seatMax_card);
            mTimeMin = itemView.findViewById(R.id.textView_timeMin_card);
            mTimeMax = itemView.findViewById(R.id.textView_timeMax_card);
            mDiff = itemView.findViewById(R.id.textView_diff1_card);
            mLearn = itemView.findViewById(R.id.textView_learn1_card);
            mRating = itemView.findViewById(R.id.ratingBar_gameRating_card);
        }
    }

    //ArrayList that holds GameItem class (data sets) for distribution into views
    /*public GameItemAdapter(ArrayList<GameItem> gameList){
        mGameList = gameList;
    }*/

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.game_item, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position)){
            return;
        }
        String game = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_GAME_NAME));
        String seatmin = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_SEAT_MIN));
        String seatmax = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_SEAT_MAX));
        String timemin = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_LENG_MIN));
        String timemax = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_LENG_MAX));
        String difficulty = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_DIFF));
        String learn = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_LEARN_DIFF));
        String publisher = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_PUBLISHER));
        float rating = mCursor.getFloat(mCursor.getColumnIndex(DatabaseHelper.COL_RATE));

        holder.mTitle.setText(game);
        holder.mPublisher.setText(publisher);
        holder.mSeatMin.setText(seatmin);
        holder.mSeatMax.setText(seatmax);
        holder.mTimeMin.setText(timemin);
        holder.mTimeMax.setText(timemax);
        holder.mDiff.setText(difficulty);
        holder.mLearn.setText(learn);
        holder.mRating.setRating(rating);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if(mCursor != null){
            mCursor.close();
        }

        mCursor = newCursor;
        if(newCursor != null){
            notifyDataSetChanged();
        }
    }
}
