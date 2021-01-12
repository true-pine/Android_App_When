package com.example.when;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SellectActivity extends AppCompatActivity {

    MyAdapter myAdapter = null;
    ArrayList<ItemModel> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellect);

        ActionBar ab = getSupportActionBar();
        ab.hide();

        initializeDate();
        Collections.sort(mList, new Comparator<ItemModel>() {
            @Override
            public int compare(ItemModel o1, ItemModel o2) {
                return o1.getKor_name().compareTo(o2.getKor_name());
            }
        });

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.ItemListView);
        myAdapter = new MyAdapter(this, mList);
        mRecyclerView.setAdapter(myAdapter);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));

        EditText editText = (EditText)findViewById(R.id.et_search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void initializeDate() {
        mList = new ArrayList<>();

        mList.add(new ItemModel(R.drawable.aatrox, R.drawable.aatrox_r, "Aatrox", "아트록스", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.ahri, R.drawable.ahri_r, "Ahri", "아리", 130, 105, 80));
        mList.add(new ItemModel(R.drawable.akali, R.drawable.akali_r, "Akali", "아칼리", 120, 90, 60));
        mList.add(new ItemModel(R.drawable.alistar, R.drawable.alistar_r, "Alistar", "알리스타", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.amumu, R.drawable.amumu_r, "Amumu", "아무무", 150, 125, 100));
        mList.add(new ItemModel(R.drawable.anivia, R.drawable.anivia_r, "Anivia", "애니비아", 6, 6, 6));
        mList.add(new ItemModel(R.drawable.annie, R.drawable.annie_r, "Annie", "애니", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.aphelios, R.drawable.aphelios_r, "Aphelios", "아펠리오스", 120, 110, 100));
        mList.add(new ItemModel(R.drawable.ashe, R.drawable.ashe_r, "Ashe", "애쉬", 100, 90, 80));
        mList.add(new ItemModel(R.drawable.aurelionsol, R.drawable.aurelionsol_r, "Aurelionsol", "아우렐리온 솔", 110, 90, 70));
        mList.add(new ItemModel(R.drawable.azir, R.drawable.azir_r, "Azir", "아지르", 120, 105, 90));
        mList.add(new ItemModel(R.drawable.bard, R.drawable.bard_r, "Bard", "바드", 110, 95, 80));
        mList.add(new ItemModel(R.drawable.blitzcrank, R.drawable.blitzcrank_r, "Blitzcrank", "블리츠크랭크", 60, 40, 20));
        mList.add(new ItemModel(R.drawable.brand, R.drawable.brand_r, "Brand", "브랜드", 105, 90, 75));
        mList.add(new ItemModel(R.drawable.braum, R.drawable.braum_r, "Braum", "브라움", 140, 120, 100));
        mList.add(new ItemModel(R.drawable.caitlyn, R.drawable.caitlyn_r, "Caitlyn", "케이틀린", 90, 75, 60));
        mList.add(new ItemModel(R.drawable.camille, R.drawable.camille_r, "Camille", "카밀", 140, 115, 90));
        mList.add(new ItemModel(R.drawable.cassiopeia, R.drawable.cassiopeia_r, "Cassiopeia", "카시오페아", 120, 110, 100));
        mList.add(new ItemModel(R.drawable.chogath, R.drawable.chogath_r, "Chogath", "초가스", 80, 80, 80));
        mList.add(new ItemModel(R.drawable.corki, R.drawable.corki_r, "Corki", "코르키", 2, 2, 2));
        mList.add(new ItemModel(R.drawable.darius, R.drawable.darius_r, "Darius", "다리우스", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.diana, R.drawable.diana_r, "Diana", "다이애나", 100, 90, 80));
        mList.add(new ItemModel(R.drawable.draven, R.drawable.draven_r, "Draven", "드레이븐", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.drmundo, R.drawable.drmundo_r, "DrMundo", "문도박사", 110, 100, 90));
        mList.add(new ItemModel(R.drawable.ekko, R.drawable.ekko_r, "Ekko", "에코", 110, 80, 50));
        mList.add(new ItemModel(R.drawable.elise, R.drawable.elise_r, "Elise", "엘리스", 0, 0, 0));
        mList.add(new ItemModel(R.drawable.evelynn, R.drawable.evelynn_r, "Evelynn", "이블린", 140, 110, 80));
        mList.add(new ItemModel(R.drawable.ezreal, R.drawable.ezreal_r, "Ezreal", "이즈리얼", 120, 120, 120));
        mList.add(new ItemModel(R.drawable.fiddlesticks, R.drawable.fiddlesticks_r, "Fiddlesticks", "피들스틱", 140, 110, 80));
        mList.add(new ItemModel(R.drawable.fiora, R.drawable.fiora_r, "Fiora", "피오라", 110, 90, 70));
        mList.add(new ItemModel(R.drawable.fizz, R.drawable.fizz_r, "Fizz", "피즈", 100, 85, 70));
        mList.add(new ItemModel(R.drawable.galio, R.drawable.galio_r, "Galio", "갈리오", 200, 180, 160));
        mList.add(new ItemModel(R.drawable.gangplank, R.drawable.gangplank_r, "Gangplank", "갱플랭크", 180, 160, 140));
        mList.add(new ItemModel(R.drawable.garen, R.drawable.garen_r, "Garen", "가렌", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.gnar, R.drawable.gnar_r, "Gnar", "나르", 90, 60, 30));
        mList.add(new ItemModel(R.drawable.gragas, R.drawable.gragas_r, "Gragas", "그라가스", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.graves, R.drawable.graves_r, "Graves", "그레이브즈", 120, 90, 60));
        mList.add(new ItemModel(R.drawable.hecarim, R.drawable.hecarim_r, "Hecarim", "헤카림", 140, 120, 100));
        mList.add(new ItemModel(R.drawable.heimerdinger, R.drawable.heimerdinger_r, "Heimerdinger", "하이머딩거", 100, 85, 70));
        mList.add(new ItemModel(R.drawable.illaoi, R.drawable.illaoi_r, "illaoi", "일라오이", 120, 95, 70));
        mList.add(new ItemModel(R.drawable.irelia, R.drawable.irelia_r, "Irelia", "이렐리아", 140, 120, 100));
        mList.add(new ItemModel(R.drawable.ivern, R.drawable.ivern_r, "Ivern", "아이번", 160, 140, 120));
        mList.add(new ItemModel(R.drawable.janna, R.drawable.janna_r, "Janna", "잔나", 150, 135, 120));
        mList.add(new ItemModel(R.drawable.jarvan4, R.drawable.jarvan4_r, "JarvanVI", "자르반4세", 120, 105, 90));
        mList.add(new ItemModel(R.drawable.jax, R.drawable.jax_r, "Jax", "잭스", 80, 80, 80));
        mList.add(new ItemModel(R.drawable.jayce, R.drawable.jayce_r, "Jayce", "제이스", 0, 0, 0));
        mList.add(new ItemModel(R.drawable.jhin, R.drawable.jhin_r, "Jhin", "진", 120, 105, 90));
        mList.add(new ItemModel(R.drawable.jinx, R.drawable.jinx_r, "Jinx", "징크스", 90, 75, 60));
        mList.add(new ItemModel(R.drawable.kaisa, R.drawable.kaisa_r, "Kaisa", "카이사", 110, 90, 70));
        mList.add(new ItemModel(R.drawable.kalista, R.drawable.kalista_r, "Kalista", "칼리스타", 150, 120, 90));
        mList.add(new ItemModel(R.drawable.karma, R.drawable.karma_r, "Karma", "카르마", 45, 42, 39));
        mList.add(new ItemModel(R.drawable.karthus, R.drawable.karthus_r, "Karthus", "카서스", 200, 180, 160));
        mList.add(new ItemModel(R.drawable.kassadin, R.drawable.kassadin_r, "Kassadin", "카사딘", 5, 3, 2));
        mList.add(new ItemModel(R.drawable.katarina, R.drawable.katarina_r, "Katarina", "카타리나", 90, 60, 45));
        mList.add(new ItemModel(R.drawable.kayle, R.drawable.kayle_r, "Kayle", "케일", 160, 120, 80));
        mList.add(new ItemModel(R.drawable.kayn, R.drawable.kayn_r, "Kayn", "케인", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.kennen, R.drawable.kennen_r, "Kennen", "케넨", 120, 120, 120));
        mList.add(new ItemModel(R.drawable.khazix, R.drawable.khazix_r, "Khazix", "카직스", 100, 85, 70));
        mList.add(new ItemModel(R.drawable.kindred, R.drawable.kindred_r, "Kindred", "킨드레드", 180, 150, 120));
        mList.add(new ItemModel(R.drawable.kled, R.drawable.kled_r, "Kled", "클레드", 160, 140, 120));
        mList.add(new ItemModel(R.drawable.kogmaw, R.drawable.kogmaw_r, "Kogmaw", "코그모", 2, 1, 1));
        mList.add(new ItemModel(R.drawable.leblanc, R.drawable.leblanc_r, "Leblanc", "르블랑", 60, 45, 30));
        mList.add(new ItemModel(R.drawable.leesin, R.drawable.leesin_r, "LeeSin", "리신", 110, 85, 60));
        mList.add(new ItemModel(R.drawable.leona, R.drawable.leona_r, "Leona", "레오나", 90, 75, 60));
        mList.add(new ItemModel(R.drawable.lissandra, R.drawable.lissandra_r, "Lissandra", "리산드라", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.lucian, R.drawable.lucian_r, "Lucian", "루시안", 110, 100, 90));
        mList.add(new ItemModel(R.drawable.lulu, R.drawable.lulu_r, "Lulu", "룰루", 110, 95, 80));
        mList.add(new ItemModel(R.drawable.lux, R.drawable.lux_r, "Lux", "럭스", 80, 60, 40));
        mList.add(new ItemModel(R.drawable.malphite, R.drawable.malphite_r, "Malphite", "말파이트", 130, 105, 80));
        mList.add(new ItemModel(R.drawable.malzahar, R.drawable.malzahar_r, "Malzahar", "말자하", 140, 110, 80));
        mList.add(new ItemModel(R.drawable.maokai, R.drawable.maokai_r, "Maokai", "마오카이", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.masteryi, R.drawable.masteryi_r, "MasterYi", "마스터이", 85, 85, 85));
        mList.add(new ItemModel(R.drawable.missfortune, R.drawable.missfortune_r, "MissFortune", "미스포츈", 120, 110, 100));
        mList.add(new ItemModel(R.drawable.monkeyking, R.drawable.monkeyking_r, "MonkeyKing", "오공", 120, 105, 90));
        mList.add(new ItemModel(R.drawable.mordekaiser, R.drawable.mordekaiser_r, "Mordekaiser", "모데카이저", 140, 120, 100));
        mList.add(new ItemModel(R.drawable.morgana, R.drawable.morgana_r, "Morgana", "모르가나", 120, 110, 100));
        mList.add(new ItemModel(R.drawable.nami, R.drawable.nami_r, "Nami", "나미", 120, 110, 100));
        mList.add(new ItemModel(R.drawable.nasus, R.drawable.nasus_r, "Nasus", "나서스", 120, 120, 120));
        mList.add(new ItemModel(R.drawable.nautilus, R.drawable.nautilus_r, "Nautilus", "노틸러스", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.neeko, R.drawable.neeko_r, "Neeko", "니코", 90, 90, 90));
        mList.add(new ItemModel(R.drawable.nidalee, R.drawable.nidalee_r, "Nidalee", "니달리", 0, 0, 0));
        mList.add(new ItemModel(R.drawable.nocturne, R.drawable.nocturne_r, "Nocturne", "녹턴", 150, 125, 100));
        mList.add(new ItemModel(R.drawable.nunu_willump, R.drawable.nunu_r, "Nunu&Willump", "누누와윌럼프", 110, 100, 90));
        mList.add(new ItemModel(R.drawable.olaf, R.drawable.olaf_r, "Olaf", "올라프", 100, 90, 80));
        mList.add(new ItemModel(R.drawable.orianna, R.drawable.oriana_r, "Orianna", "오리아나", 110, 95, 80));
        mList.add(new ItemModel(R.drawable.ornn, R.drawable.ornn_r, "Ornn", "오른", 140, 120, 100));
        mList.add(new ItemModel(R.drawable.pantheon, R.drawable.pantheon_r, "Pantheon", "판테온", 150, 135, 120));
        mList.add(new ItemModel(R.drawable.poppy, R.drawable.poppy_r, "Poppy", "뽀삐", 140, 120, 100));
        mList.add(new ItemModel(R.drawable.pyke, R.drawable.pyke_r, "Pyke", "파이크", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.qiyana, R.drawable.qiyana_r, "Qiyana", "키아나", 120, 120, 120));
        mList.add(new ItemModel(R.drawable.quinn, R.drawable.quinn_r, "Quinn", "퀸", 3, 3, 3));
        mList.add(new ItemModel(R.drawable.rakan, R.drawable.rakan_r, "Rakan", "라칸", 130, 110, 90));
        mList.add(new ItemModel(R.drawable.rammus, R.drawable.rammus_r, "Rammus", "람머스", 100, 80, 60));
        mList.add(new ItemModel(R.drawable.reksai, R.drawable.reksai_r, "Reksai", "렉사이", 100, 90, 80));
        mList.add(new ItemModel(R.drawable.renekton, R.drawable.renekton_r, "Renekton", "레넥톤", 120, 120, 120));
        mList.add(new ItemModel(R.drawable.rengar, R.drawable.rengar_r, "Rengar", "렝가", 110, 90, 70));
        mList.add(new ItemModel(R.drawable.riven, R.drawable.riven_r, "Riven", "리븐", 120, 90, 60));
        mList.add(new ItemModel(R.drawable.rumble, R.drawable.rumble_r, "Rumble", "럼블", 100, 85, 70));
        mList.add(new ItemModel(R.drawable.ryze, R.drawable.ryze_r, "Ryze", "라이즈", 210, 180, 150));
        mList.add(new ItemModel(R.drawable.sejuani, R.drawable.sejuani_r, "Sejuani", "세주아니", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.senna, R.drawable.senna_r, "Senna", "세나", 160, 140, 120));
        mList.add(new ItemModel(R.drawable.shaco, R.drawable.shaco_r, "Shaco", "샤코", 100, 90, 80));
        mList.add(new ItemModel(R.drawable.shen, R.drawable.shen_r, "Shen", "쉔", 200, 180, 160));
        mList.add(new ItemModel(R.drawable.shyvana, R.drawable.shyvana_r, "Shyvana", "쉬바나", 0, 0, 0));
        mList.add(new ItemModel(R.drawable.singed, R.drawable.singed_r, "Singed", "신지드", 120, 110, 100));
        mList.add(new ItemModel(R.drawable.sion, R.drawable.sion_r, "Sion", "사이온", 140, 100, 60));
        mList.add(new ItemModel(R.drawable.sivir, R.drawable.sivir_r, "Sivir", "시비르", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.skarner, R.drawable.skarner_r, "Skarner", "스카너", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.sona, R.drawable.sona_r, "Sona", "소나", 140, 120, 100));
        mList.add(new ItemModel(R.drawable.soraka, R.drawable.soraka_r, "Soraka", "소라카", 160, 145, 130));
        mList.add(new ItemModel(R.drawable.swain, R.drawable.swain_r, "Swain", "스웨인", 120, 120, 120));
        mList.add(new ItemModel(R.drawable.sylas, R.drawable.sylas_r, "Sylas", "사일러스", 100, 80, 60));
        mList.add(new ItemModel(R.drawable.syndra, R.drawable.syndra_r, "Syndra", "신드라", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.tahmkench, R.drawable.tahmkench_r, "Tahmkench", "탐켄치", 140, 130, 120));
        mList.add(new ItemModel(R.drawable.taliyah, R.drawable.taliyah_r, "Taliyah", "탈리야", 180, 150, 120));
        mList.add(new ItemModel(R.drawable.talon, R.drawable.talon_r, "Talon", "탈론", 100, 80, 60));
        mList.add(new ItemModel(R.drawable.taric, R.drawable.taric_r, "Taric", "타릭", 180, 150, 120));
        mList.add(new ItemModel(R.drawable.teemo, R.drawable.teemo_r, "Teemo", "티모", 1, 1, 1));
        mList.add(new ItemModel(R.drawable.thresh, R.drawable.thresh_r, "Thresh", "쓰레쉬", 140, 120, 100));
        mList.add(new ItemModel(R.drawable.tristana, R.drawable.tristana_r, "Tristana", "트리스타나", 120, 110, 100));
        mList.add(new ItemModel(R.drawable.trundle, R.drawable.trundle_r, "Trundle", "트런들", 100, 80, 60));
        mList.add(new ItemModel(R.drawable.tryndamere, R.drawable.tryndamere_r, "Tryndamere", "트린다미어", 110, 100, 90));
        mList.add(new ItemModel(R.drawable.twistedfate, R.drawable.twistedfate_r, "Twistedfate", "트위스티드페이트", 180, 150, 120));
        mList.add(new ItemModel(R.drawable.twitch, R.drawable.twitch_r, "Twitch", "트위치",90, 90, 90));
        mList.add(new ItemModel(R.drawable.udyr, R.drawable.udyr_r, "Udyr", "우디르", 0, 0, 0));
        mList.add(new ItemModel(R.drawable.urgot, R.drawable.urgot_r, "Urgot", "우르곳", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.varus, R.drawable.varus_r, "Varus", "바루스", 110, 90, 70));
        mList.add(new ItemModel(R.drawable.vayne, R.drawable.vayne_r, "Vayne", "베인", 100, 85, 70));
        mList.add(new ItemModel(R.drawable.veigar, R.drawable.veigar_r, "Veigar", "베이가", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.velkoz, R.drawable.velkoz_r, "Velkoz", "벨코즈", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.vi, R.drawable.vi_r, "Vi", "바이", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.viktor, R.drawable.viktor_r, "Viktor", "빅토르", 120, 100, 80));
        mList.add(new ItemModel(R.drawable.vladimir, R.drawable.vladimir_r, "Vladimir", "블라디미르", 150, 135, 120));
        mList.add(new ItemModel(R.drawable.volibear, R.drawable.volibear_r, "Volibear", "볼리베어", 100, 90, 80));
        mList.add(new ItemModel(R.drawable.warwick, R.drawable.warwick_r, "Warwick", "워윅", 110, 90, 70));
        mList.add(new ItemModel(R.drawable.xayah, R.drawable.xayah_r, "Xayah", "자야", 160, 145, 130));
        mList.add(new ItemModel(R.drawable.xerath, R.drawable.xerath_r, "Xerath", "제라스", 130, 115, 100));
        mList.add(new ItemModel(R.drawable.xin_zhao, R.drawable.xinzhao_r, "XinZhao", "신짜오", 120, 110, 100));
        mList.add(new ItemModel(R.drawable.yasuo, R.drawable.yasuo_r, "Yasuo", "야스오", 80, 55, 30));
        mList.add(new ItemModel(R.drawable.yorick, R.drawable.yorick_r, "Yorick", "요릭", 160, 130, 100));
        mList.add(new ItemModel(R.drawable.yuumi, R.drawable.yuumi_r, "Yummi", "유미", 130, 110, 90));
        mList.add(new ItemModel(R.drawable.zac, R.drawable.zac_r, "Zac", "자크", 130, 115, 100));
        mList.add(new ItemModel(R.drawable.zed, R.drawable.zed_r, "Zed", "제드", 120, 90, 60));
        mList.add(new ItemModel(R.drawable.ziggs, R.drawable.ziggs_r, "Ziggs", "직스", 120, 95, 70));
        mList.add(new ItemModel(R.drawable.zilean, R.drawable.zilean_r, "Zilean", "질리언", 120, 90, 60));
        mList.add(new ItemModel(R.drawable.zoe, R.drawable.zoe_r, "Zoe", "조이", 11, 8, 5));
        mList.add(new ItemModel(R.drawable.zyra, R.drawable.zyra_r, "Zyra", "자이라", 110, 100, 90));
    }
}
