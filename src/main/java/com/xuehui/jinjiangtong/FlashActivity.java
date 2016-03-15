package com.xuehui.jinjiangtong;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.TimerTask;

public class FlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        UpdateChecker mUpdateChecker = new UpdateChecker();
        mUpdateChecker.execute();
    }

    private class UpdateChecker extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Object doInBackground(Object[] params) {
            try {
                System.out.println("正在展示闪屏页");
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("sleep happen exception");
                e.printStackTrace();
            }
            System.out.println("正在获取更新");
            //获取更新
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (true) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(FlashActivity.this);
                mBuilder.setTitle("系统更新").setMessage("检测到新版本，是否更新").setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //下载更新
                        startActivity(new Intent(FlashActivity.this, MainActivity.class));
                        finish();
                    }
                }).setPositiveButton("下次再说", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(FlashActivity.this, MainActivity.class));
                        finish();
                    }
                }).setCancelable(false).show();
            }
        }
    }
}
