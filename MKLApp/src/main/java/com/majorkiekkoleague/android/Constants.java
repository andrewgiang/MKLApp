package com.majorkiekkoleague.android;

/**
 * Created by Andrew on 8/17/13.
 */
public class Constants {

    public static enum DrawerMenuItems {
        STATS,
        STANDINGS,
        SCHEDULE,
        TEAMS,
        PLAYERS,
        AWARDS;

    }

    public static final class MKL {
        /**
         * API Constants
         */
        public static final String
                SCHEME_HTTP = "http",
                DOMAIN_HTTP = "www.majorkiekkoleague.com/index.php",
                PLAYERS = "/api/players",//NO_Arguments
                PLAYER = "/api/player/",//PLAYER_ID
                STATS_NAME = "/api/stats/name/",//PLAYER NAME REQUIRED, TYPE OF GAME, TOTAL OR NOT
                GAME = "/api/game/id/",//GAME_ID REQUIRED
                SEASON = "/api/season/id/";
        /**
         * Type of Game
         * Either Regular Season Game or Playoff Game
         */
        public static int REG_TYPE = 0, POST_TYPE = 1;

        public static String getScheme() {
            return SCHEME_HTTP;
        }

        public static String getDomain() {
            return DOMAIN_HTTP;
        }

        public static String getUrl(final String path) {
            return getScheme() + "://" + getDomain() + path;
        }


    }
}

