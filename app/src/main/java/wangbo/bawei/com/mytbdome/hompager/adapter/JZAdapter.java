package wangbo.bawei.com.mytbdome.hompager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wangbo.bawei.com.mytbdome.R;
import wangbo.bawei.com.mytbdome.hompager.bean.JZBean;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class JZAdapter extends RecyclerView.Adapter<JZAdapter.ViewHolder>{

    Context context;
    List<JZBean.DataBean> list;

    public JZAdapter(Context context, List<JZBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate =View.inflate(context,R.layout.jz_item,null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.data.setText(list.get(position).getPrice()+"");
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(holder.img);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title;
        private  TextView data;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.name);
            data = itemView.findViewById(R.id.data);
        }
    }

}
