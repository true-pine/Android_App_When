package com.example.when;

public class ItemModel {
    private int icon;
    private int ability;
    private String eng_name;
    private String kor_name;
    private int time_1;
    private int time_2;
    private int time_3;

    public ItemModel(int icon, int ability, String eng_name, String kor_name, int time_1, int time_2, int time_3) {
        this.icon = icon;
        this.ability = ability;
        this.eng_name = eng_name;
        this.kor_name = kor_name;
        this.time_1 = time_1;
        this.time_2 = time_2;
        this.time_3 = time_3;
    }

    public int getIcon() {
        return icon;
    }

    public int getAbility() {
        return ability;
    }

    public String getEng_name() {
        return eng_name;
    }

    public String getKor_name() {
        return kor_name;
    }

    public int getTime_1() {
        return time_1;
    }

    public int getTime_2() {
        return time_2;
    }

    public int getTime_3() {
        return time_3;
    }
}
