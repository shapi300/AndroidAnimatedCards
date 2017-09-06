package shapi.strkstudio.animatedcards;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ListView lv = (ListView) findViewById(R.id.ListView);
        MoviesAdapter adapter = new MoviesAdapter(MainActivity.this, DataModel.movies);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //We are passing Bundle to activity, these lines will animate when we laucnh activity
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        Pair.create(view,"selectedMovie")
                ).toBundle();

                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("bg",DataModel.background[i]);
                intent.putExtra("cover",DataModel.cover[i]);
                intent.putExtra("title",DataModel.movies[i]);
                intent.putExtra("plot",DataModel.plot[i]);
                startActivity(intent,bundle);

            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}
