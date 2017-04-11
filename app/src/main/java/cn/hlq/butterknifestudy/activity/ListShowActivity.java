package cn.hlq.butterknifestudy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hlq.butterknifestudy.R;
import cn.hlq.butterknifestudy.adapter.ListViewAdapter;
import cn.hlq.butterknifestudy.model.Student;

public class ListShowActivity extends Activity {

    @BindView(R.id.lv_show)
    ListView lvShow;
    @BindView(R.id.lv_title)
    TextView lvTitle;

    @BindString(R.string.app_test)
    String titleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_show);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        lvTitle.setText(titleContent);
        ListViewAdapter adapter = new ListViewAdapter(ListShowActivity.this, initData());
        lvShow.setAdapter(adapter);
    }

    private List<Student> initData() {
        List<Student> sList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sList.add(new Student("贺大宝" + i, "贺大大--->" + 1));
        }
        return sList;
    }
@bin




















}
