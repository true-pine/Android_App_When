package com.example.when;

import android.app.Application;

public class MyApplication extends Application {
    public static int[] skill_lv;
    public static int[] ultimate_hunter;
    public static int[] wind_dragon;
    public static int[] cooltime;
    public static boolean[] cosmic_sight;
    public static boolean[] shoes;

    @Override
    public void onCreate() {
        super.onCreate();

        skill_lv = new int[5];
        ultimate_hunter = new int[5];
        wind_dragon = new int[5];
        cooltime = new int[5];
        cosmic_sight = new boolean[5];
        shoes = new boolean[5];
        for(int i = 0; i < 5; i++) {
            skill_lv[i] = 1;
            ultimate_hunter[i] = 0;
            wind_dragon[i] = 0;
            cooltime[i] = 0;
            cosmic_sight[i] = false;
            shoes[i] = false;
        }
    }
}
