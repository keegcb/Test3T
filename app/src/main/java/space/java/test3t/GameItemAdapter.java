package space.java.test3t;

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
    private ArrayList<GameItem> mGameList;

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
    public GameItemAdapter(ArrayList<GameItem> gameList){
        mGameList = gameList;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        GameViewHolder gvh = new GameViewHolder(v);
        return gvh;
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        GameItem currentGameItem = mGameList.get(position);

        holder.mTitle.setText(currentGameItem.getTitle());
        holder.mPublisher.setText(currentGameItem.getPublisher());
    }

    @Override
    public int getItemCount() {
        return mGameList.size();
    }
}
