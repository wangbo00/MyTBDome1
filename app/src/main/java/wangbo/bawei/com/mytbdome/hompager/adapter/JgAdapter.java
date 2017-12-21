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
import wangbo.bawei.com.mytbdome.hompager.bean.JgBean;

/**
 * author:Created by Wangbo on 2017/12/13.
 */

public class JgAdapter extends RecyclerView.Adapter<JgAdapter.ViewHolder>{


    Context context;
    List<JgBean.DataBean> list;

    public JgAdapter(Context context, List<JgBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public JgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.jgitem,null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(JgAdapter.ViewHolder holder, int position) {
        //ViewHolder holder1 = holder;
        holder.title.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.name);
        }
    }
}
