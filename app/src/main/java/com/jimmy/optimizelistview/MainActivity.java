package com.jimmy.optimizelistview;

import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.jimmy.optimizelistview.adapter.IconsAdapter;


/**
 * Created by zhangtianjie on 2017/7/26.
 *
 *          qq交流群 极客A计划：194343904
 */

public class MainActivity extends AppCompatActivity {

    ListView mLvIcons;

    Pair<Integer,String>[] icons=new Pair[]{
            new Pair<Integer,String>(R.drawable.icon_account,"account"),
            new Pair<Integer,String>(R.drawable.icon_message,"message"),
            new Pair<Integer,String>(R.drawable.icon_phone,"phone"),
            new Pair<Integer,String>(R.drawable.icon_school,"school"),
            new Pair<Integer,String>(R.drawable.icon_setting,"setting"),
            new Pair<Integer,String>(R.drawable.icon_submit,"submit"),
            new Pair<Integer,String>(R.drawable.icon_collect,"collect"),


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLvIcons = (ListView) findViewById(R.id.lv_icons);

        //为listview添加一个适配器adapter
        mLvIcons.setAdapter(new IconsAdapter(MainActivity.this,icons));
    }
}
