package com.example.max.uicomponent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by max on 2017/4/4.
 */

public class MyAdapter extends SimpleAdapter {
    private List<Map<String,Object>> mList;
    private Context mContext;
    private static int[] mItemState;
    private Drawable mBackground;
    private boolean isCachedBackground=false;
    public MyAdapter(Context context, List<Map<String,Object>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        mList=data;
        mContext=context;
        mItemState = new int[mList.size()];
        for (int i = 0; i < mItemState.length; i++) {
            mItemState[i] = 0;
        }
    }
    public static int getCheckedItemCount() {
        int count = 0;
        for (int i : mItemState) {
            if (i == 1) count++;
        }
        return count;
    }
    public int[] getItemState() {
        return mItemState;
    }
    public void checkAll() {
        for (int i = 0; i < mItemState.length; i++) {
            mItemState[i] = 1;
        }
    }
    public void unCheckAll() {
        for (int i = 0; i < mItemState.length; i++) {
            mItemState[i] = 0;
        }
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        ViewHolder holder;
//        if (convertView == null) {
//            holder = new ViewHolder();
//            convertView = LayoutInflater.from(mContext).inflate(R.layout.simple_item, parent, false);
//            holder.mTv=(TextView)convertView.findViewById(R.id.num);
//            holder.mIv=(ImageView)convertView.findViewById(R.id.pic);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        //首先缓存原来的background
//        if (!isCachedBackground) {
//            isCachedBackground = true;
//            mBackground = convertView.getBackground();
//        }
//        convertView.setBackgroundColor(mItemState[position]==0?Color.BLUE:Color.GREEN);
//        updateBackground(position,convertView);
//        return convertView;
//
//    }
    private void updateBackground(int position,View convertView) {
        if (getItemState()[position] == 1) {
            convertView.setBackgroundColor(0xFFDFDFDF);
        } else if (getItemState()[position] == 0){
            convertView.setBackgroundDrawable(mBackground);
        }
    }
    @Override
    public Map<String,Object> getItem(int position) {
        return mList.get(position);
    }

}

class ViewHolder
{
    public TextView mTv;
    public ImageView mIv;
}