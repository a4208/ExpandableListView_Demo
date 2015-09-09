package com.example.expandablelistview_demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.expandablelistview_demo.adapter.YouExpandableAdapter;
import com.example.expandablelistview_demo.model.GroupP;

public class MainActivity extends Activity {

	private ExpandableListView expandableListView1;

	private YouExpandableAdapter adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	protected void onResume() {
		super.onResume();
		initData();
		initView();
	}

	private void initData() {
		listGroup = new ArrayList<GroupP>();
		listGroup.add(new GroupP("国家", R.drawable.b1));
		listGroup.add(new GroupP("人物", R.drawable.b2));
		listGroup.add(new GroupP("武器", R.drawable.b3));

		listChild = new ArrayList<List<String>>();
		List<String> stringGuoJia = new ArrayList<String>();
		stringGuoJia.add("蜀国");
		stringGuoJia.add("吴国");
		stringGuoJia.add("魏国");
		stringGuoJia.add("群雄");
		listChild.add(stringGuoJia);

		List<String> stringPeoPle = new ArrayList<String>();
		stringPeoPle.add("唐僧");
		stringPeoPle.add("刘备");
		stringPeoPle.add("孙权");
		stringPeoPle.add("孙尚香");
		listChild.add(stringPeoPle);

		List<String> stringWuQi = new ArrayList<String>();
		stringWuQi.add("青钢剑");
		stringWuQi.add("雌雄双股剑");
		stringWuQi.add("青龙偃月刀");
		stringWuQi.add("关刀");
		stringWuQi.add("方天画戟");
		listChild.add(stringWuQi);

	}

	private List<GroupP> listGroup = null;

	private List<List<String>> listChild = null;

	private void initView() {
		expandableListView1 = (ExpandableListView) findViewById(R.id.expandableListView1);
		adapter = new YouExpandableAdapter(this, listGroup, listChild);
		expandableListView1.setAdapter(adapter);
	}

}
