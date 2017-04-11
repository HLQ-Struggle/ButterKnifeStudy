package cn.hlq.butterknifestudy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hlq.butterknifestudy.R;
import cn.hlq.butterknifestudy.model.Student;

/**
 * Created by HLQ on 2017/4/11 0011.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Student> stuList = new ArrayList<Student>();

    public ListViewAdapter(Context context, List<Student> stuList) {
        this.context = context;
        this.stuList = stuList;
    }

    @Override
    public int getCount() {
        return stuList != null ? stuList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return stuList != null ? stuList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_show, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Student stu = stuList.get(position);
        viewHolder.itemUsername.setText(stu.getUserName());
        viewHolder.itemUserPwd.setText(stu.getUserPwd());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_username)
        TextView itemUsername;
        @BindView(R.id.item_userPwd)
        TextView itemUserPwd;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
