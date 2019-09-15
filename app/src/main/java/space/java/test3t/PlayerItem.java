package space.java.test3t;

public class PlayerItem {

    private int mPlayerID;
    private String mPlayerName;
    private int mWin;
    private int mTotalPlays;

    public PlayerItem(int id, String name, int win, int total){
        mPlayerID = id;
        mPlayerName = name;
        mWin = win;
        mTotalPlays = total;
    }

    public int getID(){return mPlayerID;}

    public String getPlayerName(){return mPlayerName;}

    public int getWins(){return mWin;}

    public int getTotalPlays(){return mTotalPlays;}
}
