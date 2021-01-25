package com.example.thenewipad.page;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.example.thenewipad.R;
import com.example.thenewipad.formatFolder.BusRoute;
import com.example.thenewipad.function.JsonDataFormat;
import com.example.thenewipad.page.busPageAdaper.BusPageInfo;
import com.example.thenewipad.page.mainAdaper.CellularPage;
import com.example.thenewipad.page.mainAdaper.HomePage;
import com.example.thenewipad.page.mainAdaper.MapPage;
import com.example.thenewipad.page.mainAdaper.PersonPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    FloatingSearchView search;
    private final List<Suggestion> mSuggestions =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ver beta 1.0", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        search = (FloatingSearchView) findViewById(R.id.mainSearchBar);
        search.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {
                if (!oldQuery.equals("") && newQuery.equals("")) {
                    search.clearSuggestions();
                } else {
                    search.showProgress();
                    getRouteData(newQuery);
                    search.swapSuggestions(getSuggestion(newQuery));
                    search.hideProgress();
                }
            }
        });

        search.setOnMenuItemClickListener(new FloatingSearchView.OnMenuItemClickListener() {
            @Override
            public void onActionMenuItemSelected(MenuItem item) {
                Toast.makeText(MainActivity.this,"關於...",
                                        Toast.LENGTH_SHORT).show();
            }
        });

        search.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , BusPageInfo.class);
                intent.putExtra("title", searchSuggestion.getBody());
                startActivity(intent);
                search.clearFocus();
            }

            @Override
            public void onSearchAction(String currentQuery) {

            }
        });

        BottomNavigationView bottoNav = findViewById(R.id.bottomNavBar);
        bottoNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                new HomePage()).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomePage();
                            break;
                        case R.id.nav_person:
                            selectedFragment = new PersonPage();
                            break;
                        case R.id.nav_cellular:
                            selectedFragment = new CellularPage();
                            break;
                        case R.id.nav_setting:
                            selectedFragment = new MapPage();
                            break;
                    }
                    assert selectedFragment != null;
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    private List<Suggestion> getSuggestion(String query){
        List<Suggestion> suggestions=new ArrayList<>();
        for(Suggestion suggestion:mSuggestions){
            if(suggestion.getBody().toLowerCase().contains(query.toLowerCase())){
                suggestions.add(suggestion);
            }
        }
        return suggestions;
    }

    @SuppressLint("ParcelCreator")
    public static class Suggestion implements SearchSuggestion {
        private final String mRouteTitle;
        private final boolean mIsHistory = false;
        public Suggestion(String suggestion) {
            mRouteTitle = suggestion.toLowerCase();
        }
        @Override
        public String getBody() {
            return mRouteTitle;
        }
        @Override
        public int describeContents() {
            return 0;
        }
        @Override
        public void writeToParcel(Parcel parcel, int i) { }
    }

    private void getRouteData(String inputStr){
        mSuggestions.clear();
        ArrayList<String> title = new ArrayList<>();
        JsonDataFormat<BusRoute> getJson = new JsonDataFormat<>(BusRoute.class);
        getJson.request("https://ptx.transportdata.tw/MOTC/v2/Bus/Route/City/Taichung/"+ inputStr + "?&$format=JSON");
        List<String> dataParsing = getJson.dataParsing();
        for (int i = 0; i< dataParsing.size() ; i+=2) {
            title.add(dataParsing.get(i) + "\n" + dataParsing.get(i+1));
        }
        for(String row : title)
            mSuggestions.add(new Suggestion(row));
    }


}
