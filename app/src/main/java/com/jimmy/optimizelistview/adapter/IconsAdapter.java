package com.jimmy.optimizelistview.adapter;

import android.content.Context;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jimmy.optimizelistview.R;


/**
 * Created by zhangtianjie on 2017/7/26.
 *
 *          qq交流群 极客A计划：194343904
 */

public class IconsAdapter extends BaseAdapter {


    Context mContext;

    Pair<Integer, String>[] icons;


    public IconsAdapter(Context mContext, Pair<Integer, String>[] icons) {
        this.mContext = mContext;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return icons.length;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //这里的getview  用了性能优化
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView用来做性能优化 做缓存的
        //初始显示的时候,每次显示一个item都调用一次getview方法,但是每次调用的时候covertview为空
        //如果屏幕移动了之后，并且导致有些Item（也可以说是view）跑到屏幕外面,当item 重新滑回来
        //则这些item显示时调用的getview方法中的convertview参数就不是null
        ViewHolder mViewHolder;

        if (convertView == null) {//如果convertview 是第一次展示我们就创建新的ViewHolder对象与之绑定
            mViewHolder = new ViewHolder();

            LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);

            //false 为了保证item的视图中的layout参数不被改变
            convertView = mLayoutInflater.inflate(R.layout.item_icon_choose, parent, false);


            mViewHolder.mTvName = (TextView) convertView.findViewById(R.id.tv_name);
            mViewHolder.mIvIcon = (ImageView) convertView.findViewById(R.id.iv_icon);

            //我们通过convertview的setTag方法和getTag方法来将我们要显示的数据绑定在convertview上
            convertView.setTag(mViewHolder);

        }

        //如果convertview是回收来的那么我们就不必创建新的ViewHolder对象，
        // 只需要把原来的绑定的ViewHolder 取出加上新的数据就行了。

        else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.mIvIcon.setImageResource(icons[position].first);
        mViewHolder.mTvName.setText(icons[position].second);


        return convertView;
    }

   // ViewHolder只是将需要缓存的那些view封装好
    class ViewHolder {
        ImageView mIvIcon;
        TextView mTvName;
    }


}
