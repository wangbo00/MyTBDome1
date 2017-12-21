package wangbo.bawei.com.mytbdome.hompager.lbglideApp;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * author:Created by YanZhiXiong on 2017/12/6.
 */

public class GlideApp extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
