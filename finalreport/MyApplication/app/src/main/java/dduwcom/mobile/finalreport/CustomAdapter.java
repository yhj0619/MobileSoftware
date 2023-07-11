package dduwcom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Movie> movielist;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, int layout, ArrayList<Movie> myDatalist) {
        this.context = context;
        this.layout = layout;
        this.movielist = myDatalist;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return movielist.size();
    }

    @Override
    public Object getItem(int position) {
        return movielist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movielist.get(position).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        final int position = pos;
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, viewGroup, false);

            holder = new ViewHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            holder.tvDirector = (TextView) convertView.findViewById(R.id.tvDirector);
            holder.tvActor = (TextView) convertView.findViewById(R.id.tvActor);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
            holder.tvTitle.setText(movielist.get(position).getTitle());
        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.tvTitle.setText(movielist.get(position).getTitle());
        }
        holder.tvDirector.setText(movielist.get(position).getDirector());
        holder.tvActor.setText(movielist.get(position).getActor());

        if("해리 포터와 마법사의 돌".equals(movielist.get(position).getTitle()))
            holder.imageView.setImageResource(R.mipmap.harrypotter);
        else if("범죄도시2".equals(movielist.get(position).getTitle()))
            holder.imageView.setImageResource(R.mipmap.crimecity);
        else if("어벤져스:엔드게임".equals(movielist.get(position).getTitle()))
            holder.imageView.setImageResource(R.mipmap.avengers);
        else if("트와일라잇".equals(movielist.get(position).getTitle()))
            holder.imageView.setImageResource(R.mipmap.twilight);
        else if("하울의 움직이는 성".equals(movielist.get(position).getTitle()))
            holder.imageView.setImageResource(R.mipmap.howl);
        else if("기생충".equals(movielist.get(position).getTitle()))
            holder.imageView.setImageResource(R.mipmap.parasite);
        else
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        return convertView;

    }

    static class ViewHolder{
        TextView tvTitle;
        TextView tvDirector;
        TextView tvActor;
        ImageView imageView;
    }
}
