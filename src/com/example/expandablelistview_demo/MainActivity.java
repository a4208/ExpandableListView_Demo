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
		listGroup.add(new GroupP("����", R.drawable.b1));
		listGroup.add(new GroupP("����", R.drawable.b2));
		listGroup.add(new GroupP("����", R.drawable.b3));

		listChild = new ArrayList<List<String>>();
		List<String> stringGuoJia = new ArrayList<String>();
		stringGuoJia.add("���");
		stringGuoJia.add("���");
		stringGuoJia.add("κ��");
		stringGuoJia.add("Ⱥ��");
		listChild.add(stringGuoJia);

		List<String> stringPeoPle = new ArrayList<String>();
		stringPeoPle.add("��ɮ");
		stringPeoPle.add("����");
		stringPeoPle.add("��Ȩ");
		stringPeoPle.add("������");
		listChild.add(stringPeoPle);

		List<String> stringWuQi = new ArrayList<String>();
		stringWuQi.add("��ֽ�");
		stringWuQi.add("����˫�ɽ�");
		stringWuQi.add("�������µ�");
		stringWuQi.add("�ص�");
		stringWuQi.add("���컭�");
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
