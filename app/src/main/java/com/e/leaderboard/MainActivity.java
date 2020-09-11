package com.e.leaderboard;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
Button submit;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //tab
    TabLayout tabLayout=findViewById(R.id.tablayoutid);
    TabItem tabLearning=findViewById(R.id.learningtab);
    TabItem tabskills=findViewById(R.id.skilltab);
    final ViewPager myviewPager=findViewById(R.id.viewpagers);
    PageAdapter pageAdapter=new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
    myviewPager.setAdapter(pageAdapter);
    //one last step is to change the tab
    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            myviewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });


    submit=findViewById(R.id.buttonsubmit);
    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =new Intent(MainActivity.this,ProjectSubmission.class);
            startActivity(intent);
        }
    });

}


    }