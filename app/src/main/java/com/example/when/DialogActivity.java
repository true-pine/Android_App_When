package com.example.when;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class DialogActivity extends Activity {

    private int index;
    private int skill_lv;
    private int cooltime;
    private int max_cooltime;
    private int spell_cooltime;
    private final int COSMIC_PERCENT = 5;
    private final int SHOES_PERCENT = 10;

    private RadioGroup radioGroup;
    private EditText editText;
    private CheckBox checkBox_cosmic;
    private CheckBox checkBox_shoes;
    private Button button_setting;
    private SeekBar sb_ultimate;
    private SeekBar sb_dragon;
    private TextView tv_ultimate;
    private TextView tv_dragon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Intent intent = getIntent();
        index = intent.getIntExtra("INDEX", -1);

        this.initializeVariable();
        this.setListeners();
        this.setDisplay();
    }

    protected void setListeners() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rg_btn1) {
                    skill_lv = 1;
                }
                else if(checkedId == R.id.rg_btn2) {
                    skill_lv = 2;
                }
                else if(checkedId == R.id.rg_btn3) {
                    skill_lv = 3;
                }
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    hideKeyboard(editText);
                    return true;
                }
                return false;
            }
        });

        button_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();

                cooltime = Integer.parseInt(editText.getText().toString());

                if(checkBox_cosmic.isChecked()) {
                    max_cooltime += COSMIC_PERCENT;
                    cooltime += COSMIC_PERCENT;
                    spell_cooltime += COSMIC_PERCENT;
                }

                if(checkBox_shoes.isChecked()) {
                    cooltime += SHOES_PERCENT;
                    spell_cooltime += SHOES_PERCENT;
                }

                if(cooltime > max_cooltime)
                    cooltime = max_cooltime;

                int ultimate = sb_ultimate.getProgress() * 4 + 5;
                int dragon = sb_dragon.getProgress() * 10;

                MyApplication.cooltime[index] = cooltime;
                MyApplication.cosmic_sight[index] = checkBox_cosmic.isChecked();
                MyApplication.shoes[index] = checkBox_shoes.isChecked();
                MyApplication.ultimate_hunter[index] = sb_ultimate.getProgress();
                MyApplication.wind_dragon[index] = sb_dragon.getProgress();
                MyApplication.skill_lv[index] = skill_lv;

                double num1 = 1.0 - ((double)(ultimate + dragon) / 100);
                double num2 = 1.0 - (double)cooltime / 100;
                double num3 = 1.0 - (double)spell_cooltime / 100;

                resultIntent.putExtra("SKILL_LV", skill_lv);
                resultIntent.putExtra("COOLTIME", (num1 * num2));
                resultIntent.putExtra("SPELL_COOLTIME", num3);

                DialogActivity.this.setResult(DialogActivity.this.RESULT_OK, resultIntent);
                DialogActivity.this.finish();
            }
        });

        sb_ultimate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_ultimate.setText("X   " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        sb_dragon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_dragon.setText("X   " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    protected void initializeVariable() {
        skill_lv = MyApplication.skill_lv[index];
        cooltime = MyApplication.cooltime[index];
        max_cooltime = 40;
        spell_cooltime = 0;

        radioGroup = (RadioGroup)findViewById(R.id.rg_skill);
        editText = (EditText)findViewById(R.id.editText);
        checkBox_cosmic = (CheckBox)findViewById(R.id.cb_cosmic);
        checkBox_shoes = (CheckBox)findViewById(R.id.cb_shoes);
        button_setting = (Button)findViewById(R.id.btn_setting);
        sb_ultimate = (SeekBar)findViewById(R.id.sb_ultimate);
        sb_dragon = (SeekBar)findViewById(R.id.sb_dragon);
        tv_ultimate = (TextView)findViewById(R.id.tv_ultimate);
        tv_dragon = (TextView)findViewById(R.id.tv_dragon);

        radioGroup.check(getResources().getIdentifier("rg_btn" + skill_lv, "id", getPackageName()));
        editText.setText(String.valueOf(cooltime));
        checkBox_cosmic.setChecked(MyApplication.cosmic_sight[index]);
        checkBox_shoes.setChecked(MyApplication.shoes[index]);
        sb_ultimate.setProgress(MyApplication.ultimate_hunter[index]);
        sb_dragon.setProgress(MyApplication.wind_dragon[index]);
        tv_ultimate.setText("X   " + sb_ultimate.getProgress());
        tv_dragon.setText("X   " + sb_dragon.getProgress());

    }

    protected void setDisplay() {
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        int width = (int)(dm.widthPixels * 0.9);
        getWindow().getAttributes().width = width;

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;

        Drawable[] drawable = {getResources().getDrawable(R.drawable.cosmic_insight),
                getResources().getDrawable(R.drawable.dragon),
                getResources().getDrawable(R.drawable.shoes),
                getResources().getDrawable(R.drawable.ultimate_hunter)};
        int ic_width = Math.round(50 * density);
        int ic_height = Math.round(50 * density);
        for(int i = 0; i < drawable.length; i++) {
            drawable[i].setBounds(0, 0, ic_width, ic_height);
        }
        checkBox_cosmic.setCompoundDrawables(drawable[0], null, null, null);
        checkBox_shoes.setCompoundDrawables(null, null, drawable[2], null);
        tv_ultimate.setCompoundDrawables(drawable[3], null, null, null);
        tv_dragon.setCompoundDrawables(drawable[1], null, null, null);

        this.setFinishOnTouchOutside(false);
    }

    protected void hideKeyboard(EditText et) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
        et.clearFocus();

        MyApplication.cooltime[index] = Integer.parseInt(et.getText().toString());
    }

    /**
     * 안드로이드 백버튼 막기
     */
    @Override
    public void onBackPressed() {
        return;
    }
}
