package com.majorkiekkoleague.android.mkl.things;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew on 8/17/13.
 */
public class PlayerSeasonStats implements Parcelable {

    public String abrev;
    public String player_name;
    @SerializedName("pos")
    public String position;
    public String team_name;
    public int team_id;
    public int player_id;
    public int season_id;
    @SerializedName("played")
    public int games_played;
    public int goals;
    public int assists;
    public int gwg;
    public int pts;


    public PlayerSeasonStats(Parcel in) {
        abrev = in.readString();
        player_name = in.readString();
        position = in.readString();
        team_name = in.readString();
        team_id = in.readInt();
        player_id = in.readInt();
        season_id = in.readInt();
        games_played = in.readInt();
        goals = in.readInt();
        assists = in.readInt();
        gwg = in.readInt();
        pts = in.readInt();


    }

    @Override
    public String toString() {
        return "PlayerSeasonStats{" +
                "abrev='" + abrev + '\'' +
                ", team_id=" + team_id +
                ", player_id=" + player_id +
                ", season_id=" + season_id +
                ", player_name='" + player_name + '\'' +
                ", position='" + position + '\'' +
                ", games_played=" + games_played +
                ", goals=" + goals +
                ", assists=" + assists +
                ", gwg=" + gwg +
                ", pts=" + pts +
                ", team_name='" + team_name + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(abrev);
        dest.writeString(player_name);
        dest.writeString(position);
        dest.writeString(team_name);
        dest.writeInt(team_id);
        dest.writeInt(player_id);
        dest.writeInt(season_id);
        dest.writeInt(games_played);
        dest.writeInt(goals);
        dest.writeInt(assists);
        dest.writeInt(gwg);
        dest.writeInt(pts);
    }


    public static final Parcelable.Creator<PlayerSeasonStats> CREATOR
            = new Parcelable.Creator<PlayerSeasonStats>() {
        public PlayerSeasonStats createFromParcel(Parcel in) {
            return new PlayerSeasonStats(in);
        }

        public PlayerSeasonStats[] newArray(int size) {
            return new PlayerSeasonStats[size];
        }
    };
}
