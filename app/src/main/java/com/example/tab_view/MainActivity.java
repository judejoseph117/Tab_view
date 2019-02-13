package com.example.tab_view;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private Toolbar toolbar;
     private TabLayout tabLayout;
     private ViewPager viewPager;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.tlbr);
        toolbar.setTitle("Nabin's App");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager=(ViewPager)findViewById(R.id.view_pgr);
        setupViewpager(viewPager);
        tabLayout=(TabLayout)findViewById(R.id.tbly);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewpager(ViewPager viewPager)
    {
       ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
//       adapter.addFragment(new Call(),"Call");


       viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

//        public final List<Fragment>fragmentslist=new ArrayList<>();
//        private final List<String> fragtitle=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            switch (i)
            {
                case 0:
                       Call cll=new Call();//Fragmentname obj=new Fragmentname;
                       return cll;         //return obj;
                case 1:
                    Chat ch=new Chat();
                    return ch;

                       default:
                           return null;
            }

        }

        @Override
        public int getCount() {
            return 2;
        }



        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position)
            {
                case 0:
              return "Call";
                case 1:
                    return "Chat";

              default:
                  return null;

            }


        }
    }

}
