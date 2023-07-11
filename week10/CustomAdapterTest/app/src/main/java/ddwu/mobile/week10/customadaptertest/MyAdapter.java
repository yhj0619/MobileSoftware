package ddwu.mobile.week10.customadaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MyData> myDatalist;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDatalist) {
        this.context = context;
        this.layout = layout;
        this.myDatalist = myDatalist;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDatalist.size();
    }

    @Override
    public Object getItem(int position) {
        return myDatalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myDatalist.get(position).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        final int position = pos;
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, viewGroup, false);

            holder = new ViewHolder();
            holder.tvNo = (TextView) convertView.findViewById(R.id.tvNo);
            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            holder.btnCheck = (Button) convertView.findViewById(R.id.btnCheck);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvNo.setText(Integer.valueOf((int) myDatalist.get(position).get_id()).toString());
        holder.tvName.setText(myDatalist.get(position).getName());
        holder.tvPhone.setText(myDatalist.get(position).getPhone());
        holder.btnCheck.setFocusable(false);
        holder.btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myDatalist.get(pos).getPhone() + "선택", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
//        tvPhone.setText(myDatalist.get(position).getPhone());
//        btnCheck.setOnClickListener(new Button.OnClickListener() {

    //        TextView tvNo = convertView.findViewById(R.id.tvNo);
//        TextView tvName = convertView.findViewById(R.id.tvName);
//        TextView tvPhone = convertView.findViewById(R.id.tvPhone);
//        Button btnCheck = convertView.findViewById(R.id.btnCheck);
//        btnCheck.setFocusable(false);
//
//        tvNo.setText(String.valueOf(myDatalist.get(position).get_id()));
//        tvName.setText(myDatalist.get(position).getName());
//        tvPhone.setText(myDatalist.get(position).getPhone());
//        btnCheck.setOnClickListener(new Button.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,myDatalist.get(pos).getPhone() + "선택", Toast.LENGTH_SHORT).show();
//            }
//        });
//        return convertView;
}

    static class ViewHolder{
        TextView tvNo;
        TextView tvName;
        TextView tvPhone;
        Button btnCheck;
    }
}
