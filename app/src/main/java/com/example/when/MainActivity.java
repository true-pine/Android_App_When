package com.example.when;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private final int SELECT_ACTIVITY = 1111;
    private final int DIALOG_ACTIVITY = 2222;
    private final int HELP_ACTIVITY = 3333;

    private TextView[] spellTextViews;
    private TextView[] skillTextViews;
    private boolean[] isPressSpell;
    private boolean[] isPressSkill;
    private boolean[] isExistSpell;
    private boolean[] isExistSkill;
    private CountDownTimer[] timers_spell;
    private CountDownTimer[] timers_skill;

    private HashMap<String, Integer> time_spell;
    private int[][] time_skill;
    private int index_skill;

    private int[] resultInfo_skill;
    private double[] resultInfo_cooltime;
    private double[] resultInfo_cooltime2;

    private ImageView curIv;
    private AlertDialog alertDialog;

    private boolean isStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeView();
        this.initializeData();

        isStart = false;
    }

    /**
     * 스킬을 지정하는 ImageView 에 지정해준 onClick 함수
     *
     * @param view
     */
    public void onClickImageView(final View view) {
        String string = getResources().getResourceEntryName(view.getId());

        if(!isStart) {
            index_skill = Integer.parseInt(string.substring(string.length() - 1));

            curIv = ((ImageView) view);

            Intent intent = new Intent(getApplicationContext(), SellectActivity.class);
            startActivityForResult(intent, SELECT_ACTIVITY);
        }
        else {
            final int index = Integer.parseInt(string.substring(string.length() - 1));

            if(!isPressSkill[index] && isExistSkill[index]) {
                isPressSkill[index] = true;
                ((ImageView) view).setColorFilter(Color.parseColor("#99000000"), PorterDuff.Mode.SRC_OVER);
                skillTextViews[index].setVisibility(View.VISIBLE);

                timers_skill[index] = new CountDownTimer((long)(time_skill[index][resultInfo_skill[index] - 1] * resultInfo_cooltime[index]) * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        skillTextViews[index].setText(String.valueOf(millisUntilFinished / 1000));
                    }

                    @Override
                    public void onFinish() {
                        isPressSkill[index] = false;
                        ((ImageView)view).setColorFilter(null);
                        skillTextViews[index].setVisibility(View.INVISIBLE);
                    }
                }.start();
            }
        }
    }

    /**
     * 쿨타임을 설정하는 ImageVIew 에 지정해준 onClick 함수
     *
     * @param view
     */
    public void onClickSetting(View view) {
        if(isStart) {
            curIv = (ImageView)view;
            String string = getResources().getResourceEntryName(curIv.getId());
            int index = Integer.parseInt(string.substring(string.length() - 1));

            Intent intent = new Intent(getApplicationContext(), DialogActivity.class);
            intent.putExtra("INDEX", index);
            startActivityForResult(intent, DIALOG_ACTIVITY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent resultIntent) {
        super.onActivityResult(requestCode, resultCode, resultIntent);

        if(requestCode == SELECT_ACTIVITY && resultCode == RESULT_OK) {
            curIv.setImageResource(resultIntent.getIntExtra("srcId", 0));
            time_skill[index_skill][0] = resultIntent.getIntExtra("time_1", 0);
            time_skill[index_skill][1] = resultIntent.getIntExtra("time_2", 0);
            time_skill[index_skill][2] = resultIntent.getIntExtra("time_3", 0);

            String string = getResources().getResourceEntryName(curIv.getId());
            int index = Integer.parseInt(string.substring(string.length() - 1));
            isExistSkill[index] = true;
        }

        if(requestCode == DIALOG_ACTIVITY && resultCode == RESULT_OK) {
            String string = getResources().getResourceEntryName(curIv.getId());
            int index = Integer.parseInt(string.substring(string.length() - 1));

            resultInfo_skill[index] = resultIntent.getIntExtra("SKILL_LV", 0);
            resultInfo_cooltime[index] = resultIntent.getDoubleExtra("COOLTIME", 0);
            resultInfo_cooltime2[index] = resultIntent.getDoubleExtra("SPELL_COOLTIME", 0);
        }

        if(requestCode == HELP_ACTIVITY && resultCode == RESULT_OK) {

        }
    }

    /**
     * 스펠을 지정하는 ImageView 에 지정해준 onClick 함수
     *
     * @param view
     */
    public void onClickSpell(final View view) {
        if(!isStart) {
            curIv = ((ImageView) view);

            View dialogView = getLayoutInflater().inflate(R.layout.custom_dialog, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(dialogView);
            builder.setTitle("Spell");

            alertDialog = builder.create();
            alertDialog.show();
        } else {
            String string = getResources().getResourceEntryName(view.getId());
            final int index = Integer.parseInt(string.substring(string.length() - 1));
            int time = 0;

            if(!isPressSpell[index] && isExistSpell[index]) {
                isPressSpell[index] = true;
                ((ImageView) view).setColorFilter(Color.parseColor("#99000000"), PorterDuff.Mode.SRC_OVER);
                spellTextViews[index].setVisibility(View.VISIBLE);

                time = time_spell.get(view.getTag());

                timers_spell[index] = new CountDownTimer((long)(time * resultInfo_cooltime2[index/2]) * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        spellTextViews[index].setText(String.valueOf(millisUntilFinished / 1000));
                    }

                    @Override
                    public void onFinish() {
                        isPressSpell[index] = false;
                        ((ImageView) view).setColorFilter(null);
                        spellTextViews[index].setVisibility(View.INVISIBLE);
                    }
                }.start();
            }
        }
    }

    /**
     * 스펠을 지정하는 다이얼로그의 ImageView 에 지정해준 onClick 함수
     *
     * @param view
     */
    public void onClickDialogImage(View view) {
        curIv.setImageDrawable(((ImageView)view).getDrawable());
        curIv.setTag(view.getTag());

        String string = getResources().getResourceEntryName(curIv.getId());
        int index = Integer.parseInt(string.substring(string.length() - 1));
        isExistSpell[index] = true;

        alertDialog.dismiss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_timer_start:       //타이머 시작 액션 버튼

                if(!isStart) {
                    item.setIcon(android.R.drawable.ic_media_pause);
                }
                else {
                    for(CountDownTimer timer : timers_spell) {
                        try {
                            timer.onFinish();
                            timer.cancel();
                        } catch (Exception e) {

                        }
                    }
                    for(CountDownTimer timer : timers_skill) {
                        try {
                            timer.onFinish();
                            timer.cancel();
                        } catch (Exception e) {

                        }
                    }
                    item.setIcon(android.R.drawable.ic_media_play);
                }

                isStart = !isStart;

                return true;
            case R.id.action_how_to:            //사용법 액션 버튼

                return true;
            case R.id.action_reset:             //초기화 액션 버튼

                if(!isStart) {
                    this.recreate();
                    getApplication().onCreate();
                } else {
                    Toast.makeText(getApplicationContext(), "타이머가 실행 중입니다.", Toast.LENGTH_SHORT).show();
                }

                return true;
            case R.id.action_search:            //전적 검색 액션 버튼

                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://www.op.gg/");
                intent.setData(uri);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void initializeView() {
        spellTextViews = new TextView[10];
        skillTextViews = new TextView[5];
        isPressSpell = new boolean[10];
        isPressSkill = new boolean[5];
        isExistSpell = new boolean[10];
        isExistSkill = new boolean[5];

        for(int i = 0; i < 10; i++) {
            int spell_tv_id = getResources().getIdentifier("tv_spell_" + i, "id", getPackageName());
            int skill_tv_id = getResources().getIdentifier("tv_skill_" + (i/2), "id", getPackageName());

            spellTextViews[i] = (TextView)findViewById(spell_tv_id);
            skillTextViews[i/2] = (TextView)findViewById(skill_tv_id);

            isPressSpell[i] = false;
            isPressSkill[i/2] = false;
            isExistSpell[i] = false;
            isExistSkill[i/2] = false;
        }
    }

    protected void initializeData() {
        timers_spell = new CountDownTimer[10];
        time_spell = new HashMap<String, Integer>();
        time_spell.put("SMITE", 90);
        time_spell.put("GHOST", 180);
        time_spell.put("HEAL", 240);
        time_spell.put("TELEPORT", 360);
        time_spell.put("CLEANSE", 210);
        time_spell.put("BARRIER", 180);
        time_spell.put("IGNITE", 180);
        time_spell.put("EXHAUST", 210);
        time_spell.put("FLASH", 300);

        timers_skill = new CountDownTimer[5];
        time_skill = new int[5][3];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 3; j++) {
                time_skill[i][j] = 0;
            }
        }
        index_skill = 0;

        resultInfo_skill = new int[5];
        resultInfo_cooltime = new double[5];
        resultInfo_cooltime2 = new double[5];
        for(int i = 0; i < 5; i++) {
            resultInfo_skill[i] = 1;
            resultInfo_cooltime[i] = 1.0;
            resultInfo_cooltime2[i] = 1.0;
        }
    }
}
