package com.example.user.buttonnavigationbarexceple;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
///import android.support.v7.widget.Toolbar;

import android.support.v7.widget.ActionBarContextView;

import com.example.user.buttonnavigationbarexceple.fragments.BoxsingFragment;
import com.example.user.buttonnavigationbarexceple.fragments.MixfightFragment;
import com.example.user.buttonnavigationbarexceple.fragments.ReslingFragment;

public class MainActivity extends AppCompatActivity {

     private TextView mTextMessage;
    //private Toolbar toolbar;
    private ActionBar actionBar;


   BoxsingFragment fBoxsingFragment;
   MixfightFragment fMixfingFragment;
   ReslingFragment ReslingFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ftrans =getFragmentManager().beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                   ftrans.replace(R.id.container,fBoxsingFragment);
                    break;
                case R.id.navigation_dashboard:
                    ftrans.replace(R.id.container,fMixfingFragment);
                    break;
                case R.id.navigation_notifications:
                   ftrans.replace(R.id.container,ReslingFragment);
                    break;
            }
            ftrans.commit();
            return true;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//       actionBar = findViewById(R.id.action_bar);
//        setSupportActionBar(actionBar);




        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fBoxsingFragment=new BoxsingFragment();
        fMixfingFragment=new MixfightFragment();
        ReslingFragment=new ReslingFragment();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main_menu, menu);
//        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.header);
        if(!item.isChecked()) item.setChecked(true);
        switch(id){
            case R.id.action_settings :
                headerView.setText("Настройки");
                return true;
            case R.id.open_settings:
                headerView.setText("Открыть");
                return true;
            case R.id.save_settings:
                headerView.setText("Сохранить");
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}
