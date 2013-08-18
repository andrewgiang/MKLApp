package com.majorkiekkoleague.android.things;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew on 8/17/13.
 */
public class MklGame {


    public long id;
    public String date;
    public int home_id;
    public int away_id;
    public int season_id;
    public String home_name;

    @Override
    public String toString() {
        return "MklGame{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", home_id=" + home_id +
                ", away_id=" + away_id +
                ", season_id=" + season_id +
                ", home_name='" + home_name + '\'' +
                ", away_name='" + away_name + '\'' +
                ", game_type=" + game_type +
                ", is_finished=" + is_finished +
                ", is_ot=" + is_ot +
                ", away_score=" + away_score +
                ", home_score=" + home_score +
                '}';
    }

    public String away_name;
    @SerializedName("type")
    public int game_type;
    @SerializedName("finished")
    private boolean is_finished;
    @SerializedName("ot")
    public boolean is_ot;
    public int away_score;
    public int home_score;

}
