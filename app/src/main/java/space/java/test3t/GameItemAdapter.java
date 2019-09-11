package space.java.test3t;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
Class that handles the moving data from GameItem into the CardView and then handles
putting the Card View items into the RecyclerView
 */

public class GameItemAdapter extends RecyclerView.Adapter<GameItemAdapter.GameViewHolder> {
    private ArrayList<GameItem> mGameList;

    public static class GameViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTitle;
        public TextView mPublisher;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView_card);
            mTitle = itemView.findViewById(R.id.textView_title_card);
            mPublisher = itemView.findViewById(R.id.textView_publisher_card);
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

        holder.mImageView.setImageResource(currentGameItem.getImageResource());
        holder.mTitle.setText(currentGameItem.getText1());
        holder.mPublisher.setText(currentGameItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mGameList.size();
    }
}
