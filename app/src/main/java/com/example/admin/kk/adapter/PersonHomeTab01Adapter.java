package com.example.admin.kk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.kk.R;

import java.util.HashMap;
import java.util.List;

/**
 * @see 热门列表的listView适配器
 * @author ly-lihongliang
 */
public class PersonHomeTab01Adapter extends BaseAdapter{

	private LayoutInflater mInflater;// 动态布局映射
	private List<HashMap<String, Object>> mData;

	public PersonHomeTab01Adapter(Context context, List<HashMap<String, Object>> mData) {
		this.mInflater = LayoutInflater.from(context);
		this.mData = mData;
	}
	
	@Override
	public int getCount() {
		// TODO 在此适配器中所代表的数据集中的条目数
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO 获取数据集中与指定索引对应的数据项
		return 0;
	}

	@Override
	public long getItemId(int position) {
		// TODO 取在列表中与指定索引对应的行id
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder vHolder = null; 
	    //如果convertView对象为空则创建新对象，不为空则复用    
	    if (convertView == null) {  
	        convertView = mInflater.inflate(R.layout.list_person_home_tab01_item, null);  //根据布局文件实例化view\
	        // 创建 ViewHodler 对象
	        vHolder = new ViewHolder();
	        vHolder.person_home_tab01_item_img= (ImageView) convertView.findViewById(R.id.person_home_tab01_item_img);//找某个控件
	        vHolder.person_home_tab01_item_tv= (TextView) convertView.findViewById(R.id.person_home_tab01_item_tv);//找某个控件
			// 将ViewHodler保存到Tag中(Tag可以接收Object类型对象，所以任何东西都可以保存在其中)
	        convertView.setTag(vHolder);
	    } else {
	        //当convertView不为空时，通过getTag()得到View
	        vHolder = (ViewHolder) convertView.getTag();
	    }
	    // 给对象赋值，修改显示的值
		vHolder.person_home_tab01_item_img.setBackgroundResource((Integer) mData.get(position).get("person_home_tab01_item_img"));
	    vHolder.person_home_tab01_item_tv.setText(mData.get(position).get("person_home_tab01_item_tv").toString());//给该控件设置数据(数据从集合类中来)

	    return convertView;
	}

	static class ViewHolder {
		ImageView person_home_tab01_item_img;
		TextView person_home_tab01_item_tv;
	}
	
}
