package space.java.test3t;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GameItemAdapter extends RecyclerView.Adapter<GameItemAdapter.GameViewHolder> {

    public static class GameViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView_card);
            mTextView1 = itemView.findViewById(R.id.textView_gameCard);
            mTextView2 = itemView.findViewById(R.id.textView_attributeCard);
        }
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        GameViewHolder gvh = new GameViewHolder(v);
        return gvh;
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder gameViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
