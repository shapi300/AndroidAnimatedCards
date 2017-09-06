package shapi.strkstudio.animatedcards;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Intent intent = getIntent();
        CardView cardView = (CardView) findViewById(R.id.card_view);
        ImageView movie_cover = (ImageView) findViewById(R.id.cover_details);
        TextView movie = (TextView) findViewById(R.id.txt_movie_details);
        ImageView movie_bg = (ImageView) findViewById(R.id.cover_bg_details);
        TextView plot = (TextView) findViewById(R.id.txt_plot_details);


        //These are lines helping Details_Card To Animate
        //===============================================
        AnimatorSet animationSet = new AnimatorSet();

        //Translating Details_Card in Y Scale
        ObjectAnimator card_y = ObjectAnimator.ofFloat(cardView, View.TRANSLATION_Y, 70);
        card_y.setDuration(2500);
        card_y.setRepeatMode(ValueAnimator.REVERSE);
        card_y.setRepeatCount(ValueAnimator.INFINITE);
        card_y.setInterpolator(new LinearInterpolator());

        //Translating Movie_Cover in Y Scale
        ObjectAnimator cover_y = ObjectAnimator.ofFloat(movie_cover, View.TRANSLATION_Y, 30);
        cover_y.setDuration(3000);
        cover_y.setRepeatMode(ValueAnimator.REVERSE);
        cover_y.setRepeatCount(ValueAnimator.INFINITE);
        cover_y.setInterpolator(new LinearInterpolator());

        animationSet.playTogether(card_y,cover_y);
        animationSet.start();


        Picasso.with(this).load(intent.getIntExtra("bg",1)).into(movie_bg);
        Picasso.with(this).load(intent.getIntExtra("cover",1)).into(movie_cover);
        movie.setText(intent.getStringExtra("title"));
        plot.setText(intent.getStringExtra("plot"));

    }
}