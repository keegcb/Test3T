package space.java.test3t;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlayerItemAdapter extends RecyclerView.Adapter<PlayerItemAdapter.PlayerViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public PlayerItemAdapter(Context context, Cursor cursor){
        mContext = context;
        mCursor = cursor;
    }

    public static class PlayerViewHolder extends RecyclerView.ViewHolder{

        public TextView mPlayerName;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            mPlayerName = itemView.findViewById(R.id.textView_playerName);
        }
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.player_item, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }
        String playerName = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_PLAYER_NAME));

        holder.mPlayerName.setText(playerName);
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
