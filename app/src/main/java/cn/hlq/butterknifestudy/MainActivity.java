package cn.hlq.butterknifestudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;
import butterknife.OnTouch;
import cn.hlq.butterknifestudy.activity.ListShowActivity;

/**
 * create by heliquan at 2017年4月11日
 */
public class MainActivity extends Activity {

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.tv_editor_action)
    EditText tvEditorAction;
    @BindView(R.id.editTextFocus)
    EditText editTextFocus;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListView();
    }

    private void initListView() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        adapter.add("测试item点击事件");
        adapter.add("测试item长按事件");
        listView.setAdapter(adapter);
    }

    @OnClick(R.id.text)
    void textClick() {
        Toast.makeText(MainActivity.this, "TextView的单击事件触发。。。(无参-默认)", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.text)
    void textClick(TextView textView) {
        Toast.makeText(MainActivity.this, "TextView的单击事件触发。。。(TextView)", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.text)
    void textClick(View view) {
        Toast.makeText(MainActivity.this, "TextView的单击事件触发。。。(View)", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.button)
    boolean buttonLongClick(Button button) {
        Toast.makeText(MainActivity.this, "Button的长按事件触发。。。(无参-默认)", Toast.LENGTH_SHORT).show();
        return false;
    }

//    @OnLongClick(R.id.button)
//    boolean buttonLongClick(Button button){
//        Toast.makeText(MainActivity.this, "Button的长按事件触发。。。(TextView)", Toast.LENGTH_SHORT).show();
//        return false;
//    }

//    @OnLongClick(R.id.button)
//    boolean buttonLongClick(View view){
//        Toast.makeText(MainActivity.this, "Button的长按事件触发。。。(View)", Toast.LENGTH_SHORT).show();
//        return false;
//    }

    @OnCheckedChanged(R.id.checkBox)
    void radioButtonCheckChange(boolean isl) {
        Toast.makeText(MainActivity.this, "CheckBox。。。(无参)" + isl, Toast.LENGTH_SHORT).show();
    }

    @OnCheckedChanged(R.id.checkBox)
    void radioButtonCheckChange(CheckBox checkBox, boolean isl) {
        Toast.makeText(MainActivity.this, "CheckBox。。。(CheckBox)" + isl, Toast.LENGTH_SHORT).show();
    }

//    @OnEditorAction(R.id.tv_editor_action)
//    boolean EditTextAction() {
//        Toast.makeText(MainActivity.this, " 点击---通往天堂 无参", Toast.LENGTH_SHORT).show();
//        return false;
//    }

//    @OnEditorAction(R.id.tv_editor_action)
//    boolean EditTextAction(int code) {
//        Toast.makeText(MainActivity.this, " 点击---通往天堂 code:"+code, Toast.LENGTH_SHORT).show();
//        return false;
//    }

//    @OnEditorAction(R.id.tv_editor_action)
//    boolean EditTextAction(KeyEvent keyEvent) {
//        Toast.makeText(MainActivity.this, "点击---通往天堂 KeyEvent:"+keyEvent, Toast.LENGTH_SHORT).show();
//        return false;
//    }

//    @OnEditorAction(R.id.tv_editor_action)
//    boolean EditTextAction(int code, KeyEvent keyEvent) {
//        Toast.makeText(MainActivity.this, "点击---通往天堂 code:"+code+" KeyEvent:"+keyEvent, Toast.LENGTH_SHORT).show();
//        return false;
//    }

    @OnEditorAction(R.id.tv_editor_action)
    boolean EditTextAction(TextView textView, int code, KeyEvent keyEvent) {
        Toast.makeText(MainActivity.this, textView.getText().toString() + " 点击---通往天堂 code:" + code + " KeyEvent:" + keyEvent, Toast.LENGTH_SHORT).show();
        return false;
    }

//    @OnTextChanged(R.id.editText)
//    void editTextChange() {
//        Toast.makeText(MainActivity.this, " editTextChange ...", Toast.LENGTH_SHORT).show();
//    }

    @OnTextChanged(value = R.id.editText, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void editTextChangeAfter(Editable editable) {
        Toast.makeText(MainActivity.this, "改变后内容为：" + editable.toString(), Toast.LENGTH_SHORT).show();
        System.out.println("改变后---内容为：" + editable.toString());
    }

    @OnTextChanged(value = R.id.editText, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void editTextChangeBefore(CharSequence s, int start, int before, int count) {
        Toast.makeText(MainActivity.this, "编辑内容为:" + s + "，开始前个数:" + start, Toast.LENGTH_SHORT).show();
        System.out.println("改变前---内容为:" + s + "，开始前个数:" + start + "，:" + before + "，" + count);
    }

    @OnTextChanged(value = R.id.editText, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void editTextChange(CharSequence s, int start, int before, int count) {
        Toast.makeText(MainActivity.this, "编辑内容为:" + s + "，开始前个数:" + start, Toast.LENGTH_SHORT).show();
        System.out.println("未编辑---内容为:" + s + "，开始前个数:" + start + "，" + before + "，" + count);
    }

    @OnFocusChange(R.id.editTextFocus)
    void editTextFocus(boolean isl) {
        if (isl) {
            Toast.makeText(MainActivity.this, "获取焦点" + isl, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "失去焦点" + isl, Toast.LENGTH_SHORT).show();
        }
    }

    @OnTouch(R.id.imageView)
    boolean imageView(MotionEvent event) {
        System.out.println(event);
        return false;
    }

    @OnItemClick(R.id.listView)
    void listItemClick(int position) {
        Toast.makeText(this, "OnItemClick---点击了第" + position + "个", Toast.LENGTH_SHORT).show();
    }

    @OnItemLongClick(R.id.listView)
    boolean listItemLongClick(int position) {
        Toast.makeText(this, "OnItemLongClick---点击了第" + position + "个", Toast.LENGTH_SHORT).show();
        return true;
    }

    @OnClick(R.id.btn_login)
    void gotoListViewActivity() {
        startActivity(new Intent(MainActivity.this, ListShowActivity.class));
    }

}
