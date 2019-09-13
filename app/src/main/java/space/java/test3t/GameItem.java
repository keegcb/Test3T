package space.java.test3t;

/*
Class that holds the generic data that is put into the Card View in the RecyclerView
 */
public class GameItem {

    private String mTitle;
    private String mPublisher;
    private String mSeatMin;
    private String mSeatMax;
    private String mTimeMin;
    private String mTimeMax;
    private String mDifficulty;
    private String mLearnDiff;
    private String mRating;

    public GameItem(String title, String seatMin, String seatMax, String timeMin, String timeMax, String difficulty, String learn, String publisher, String rating){
        mTitle = title;
        mPublisher = publisher;
        mSeatMin = seatMin;
        mSeatMax = seatMax;
        mTimeMin = timeMin;
        mTimeMax = timeMax;
        mDifficulty = difficulty;
        mLearnDiff = learn;
        mRating = rating;

    }

    public String getTitle(){
        return mTitle;
    }

    public String getPublisher(){
        return mPublisher;
    }

    public String getSeatMin(){return mSeatMin;}

    public String getSeatMax(){return mSeatMax;}

    public String getTimeMin(){return mTimeMin;}

    public String getmTimeMax(){return mTimeMax;}

    public String getDiff(){return mDifficulty;}

    public String getLearn(){return mLearnDiff;}

    public String getmRating(){return mRating;}


}
