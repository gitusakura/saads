package com.kimganteng.myapplication;

import static com.kimganteng.myapplication.SettingsAlien.AppIDViewAds;
import static com.kimganteng.myapplication.SettingsAlien.BackupIntertitial;
import static com.kimganteng.myapplication.SettingsAlien.BackupReward;
import static com.kimganteng.myapplication.SettingsAlien.Backup_Initialize;
import static com.kimganteng.myapplication.SettingsAlien.MainIntertitial;
import static com.kimganteng.myapplication.SettingsAlien.MainRewards;
import static com.kimganteng.myapplication.SettingsAlien.Select_Backup_Ads;
import static com.kimganteng.myapplication.SettingsAlien.Select_Main_Ads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aliendroid.alienads.AlienGDPR;
import com.aliendroid.alienads.AliendroidInitialize;
import com.aliendroid.alienads.AliendroidIntertitial;
import com.aliendroid.alienads.AliendroidReward;
import com.aliendroid.alienads.interfaces.interstitial.show.OnShowInterstitialAdmob;
import com.aliendroid.alienads.interfaces.interstitial.load.OnLoadInterstitialAdmob;
import com.aliendroid.sdkads.config.AESHelper;
import com.aliendroid.sdkads.config.AppPromote;
import com.aliendroid.sdkads.interfaces.OnOpenViewAdListener;
import com.aliendroid.sdkads.type.view.AlienViewAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppPromote.initializeAppPromote(this);

        if (SettingsAlien.Select_Open_Ads.equals("2")) {
            AlienViewAds.OpenApp(MainActivity.this,AppIDViewAds);
        }
        AliendroidInitialize.SelectAdsApplovinMax(this,Select_Backup_Ads,Backup_Initialize);
        AlienGDPR.loadGdpr(this,Select_Main_Ads,true);
        AliendroidIntertitial.LoadIntertitialAdmob(this,Select_Backup_Ads,MainIntertitial,BackupIntertitial,
                "","","","","");
        AliendroidIntertitial.onLoadInterstitialAdmob = new OnLoadInterstitialAdmob() {
            @Override
            public void onInterstitialAdLoaded() {

            }

            @Override
            public void onInterstitialAdFailedToLoad(String error) {

            }
        };

        AliendroidReward.LoadRewardAdmob(this,Select_Backup_Ads,MainRewards,BackupReward);

    }

    public void BANNER(View view){
        Intent open = new Intent(MainActivity.this,BannerActivity.class);
        startActivity(open);

    }

    public void VIEWADS(View view){
        Intent open = new Intent(MainActivity.this,ViewAdsActivity.class);
        startActivity(open);

    }

    public void NATIVES(View view){
        Intent open = new Intent(MainActivity.this,NativeActivity.class);
        startActivity(open);

    }


    public void MEDIATION(View view){
        Intent open = new Intent(MainActivity.this,MediationAdsActivity.class);
        startActivity(open);

    }

    public void INTERSTITIAL(View view){
        Intent open = new Intent(MainActivity.this,MediationAdsActivity.class);
        startActivity(open);

        AliendroidIntertitial.ShowIntertitialAdmob(MainActivity.this,Select_Backup_Ads,MainIntertitial,BackupIntertitial,0,"",
        "","","","");
    }

    public void REWARD(View view){
        AliendroidReward.ShowRewardAdmob(MainActivity.this,Select_Backup_Ads,MainRewards,BackupReward);
    }

    public void onBackPressed(){
        finishAffinity();
        System.exit(0);
    }
}