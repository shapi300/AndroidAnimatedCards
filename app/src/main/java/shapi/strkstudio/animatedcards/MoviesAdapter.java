package shapi.strkstudio.animatedcards;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MoviesAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater = null;


    MoviesAdapter(Context con, String[] list) {

        this.context = con;
        DataModel.movies = list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return DataModel.movies.length;
    }

    @Override
    public Object getItem(int i) {
        return DataModel.movies.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertview == null) {

            convertview =inflater.inflate(R.layout.card_item_template,null);
            holder = new ViewHolder();

            holder._cover = convertview.findViewById(R.id.img_cover_d);
            holder._background = convertview.findViewById(R.id.img_background);
            holder._movies = convertview.findViewById(R.id.txt_movie_details);
            holder._plot = convertview.findViewById(R.id.txt_plot_d);
            holder._releaseDate = convertview.findViewById(R.id.txt_release_d);
            holder._vw_blayer =  convertview.findViewById(R.id.vw_blacklayer);

            convertview.setTag(holder);

        } else {
            holder = (ViewHolder) convertview.getTag();
        }


        holder._movies.setText(DataModel.movies[i]);
        holder._plot.setText(DataModel.plot[i]);
        holder._releaseDate.setText("o "+DataModel.releaseDate[i]);
        //holder._cover.setImageResource(cover[i]);
        Picasso.with(context).load(DataModel.cover[i]).into(holder._cover);
        // holder._background.setImageResource(background[i]);
        Picasso.with(context).load(DataModel.background[i]).into(holder._background);


        ObjectAnimator fade = ObjectAnimator.ofFloat(holder._vw_blayer, View.ALPHA, 1f,.3f);
        fade.setDuration(1500);
        fade.setInterpolator(new LinearInterpolator());
        fade.start();


        return convertview;
    }

    public class ViewHolder {

        ImageView _cover;
        ImageView _background;
        TextView _movies;
        TextView _plot;
        TextView _releaseDate;
        View _vw_blayer;


    }
}
