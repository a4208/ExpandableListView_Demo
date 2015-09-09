package com.example.expandablelistview_demo.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.expandablelistview_demo.R;
import com.example.expandablelistview_demo.model.GroupP;

public class YouExpandableAdapter extends BaseExpandableListAdapter {
	private List<GroupP> listGroup = null;

	private List<List<String>> listChild = null;

	private Context context;

	public YouExpandableAdapter(Context context, List<GroupP> listGroup,
			List<List<String>> listChild) {
		this.context = context;
		this.listGroup = listGroup;
		this.listChild = listChild;
	}

	/**
	 * 获得组的长度
	 */
	@Override
	public int getGroupCount() {

		return listGroup.size();
	}

	/**
	 * 获得组的对象
	 */
	@Override
	public Object getGroup(int groupPosition) {
		return listGroup.get(groupPosition);
	}

	/**
	 * 获得组的ID
	 */
	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	/**
	 * 获得的子的长度
	 */
	@Override
	public int getChildrenCount(int groupPosition) {
		return listChild.get(groupPosition).size();
	}

	/**
	 * 获得子的对象
	 */
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return listChild.get(groupPosition).get(childPosition);
	}

	/**
	 * 获得子的ID
	 */
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View v,
			ViewGroup parent) {
		HolderView holder = null;
		if (v == null) {
			holder = new HolderView();
			v = View.inflate(context, R.layout.expandable_group_item, null);
			holder.iv_icon = (ImageView) v.findViewById(R.id.iv_icon);
			holder.tv_name = (TextView) v.findViewById(R.id.tv_name);
			holder.iv_isExpandable = (ImageView) v
					.findViewById(R.id.iv_isExpandable);
			v.setTag(holder);
		} else {
			holder = (HolderView) v.getTag();
		}
		holder.iv_icon.setImageResource(listGroup.get(groupPosition)
				.getImageResId());
		holder.tv_name.setText(listGroup.get(groupPosition).getName());
		if (isExpanded) {
//			holder.iv_isExpandable.setVisibility(View.INVISIBLE);
			holder.iv_isExpandable.startAnimation(AnimationUtils.loadAnimation(context, R.anim.xuanzhuan));
			
			
		} else {
//			holder.iv_isExpandable.setVisibility(View.VISIBLE);
		}
		return v;
	}

	class HolderView {
		ImageView iv_icon;
		TextView tv_name;
		ImageView iv_isExpandable;
	}

	// @Override
	// public View getChildView(int groupPosition, int childPosition,
	// boolean isLastChild, View convertView, ViewGroup parent) {
	// TextView tv = null;
	// if (convertView == null) {
	// tv = new TextView(context);
	// LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
	// 100);
	// tv.setLayoutParams(params);
	// } else {
	// tv = (TextView) convertView;
	// }
	// tv.setText(listChild.get(groupPosition).get(childPosition));
	// return tv;
	// }
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		TextView tv_content = null;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.expandable_child_item,
					null);
			tv_content = (TextView) convertView.findViewById(R.id.tv_content);
			convertView.setTag(tv_content);
		} else 
		{
			tv_content = (TextView) convertView.getTag();
		}
		
		String sss=listChild.get(groupPosition).get(childPosition);
		
		tv_content.setText(sss);
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}
}
