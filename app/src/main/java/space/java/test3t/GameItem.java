package space.java.test3t;

/*
Class that holds the generic data that is put into the Card View in the RecyclerView
 */
public class GameItem {
    private int mImageResource;
    private String mTitle;
    private String mPublisher;

    public GameItem(int imageResource, String title, String publisher){
        mImageResource = imageResource;
        mTitle = title;
        mPublisher = publisher;
    }

    public int getImageResource(){
        return mImageResource;
    }

    public String getText1(){
        return mTitle;
    }

    public String getText2(){
        return mPublisher;
    }
}
