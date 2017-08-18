package com.example.admin.kk.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.kk.R;
import com.example.admin.kk.interfacee.OnClickItemElementListenter;
import com.example.admin.kk.main.PersonHomeActitivity;

/**
 * @see 热门列表的listView适配器
 * @author ly-lihongliang
 */
public class ReMenBaAdapter extends BaseAdapter{

	private LayoutInflater mInflater;// 动态布局映射
	private List<HashMap<String, Object>> mData;
	
	public ReMenBaAdapter(Context context,List<HashMap<String, Object>> mData) {
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
	        convertView = mInflater.inflate(R.layout.list_remen_item, null);  //根据布局文件实例化view\
	        // 创建 ViewHodler 对象    
	        vHolder = new ViewHolder();  
	        vHolder.remen_logo_img_tv= (TextView) convertView.findViewById(R.id.remen_logo_img_tv);//找某个控件
	        vHolder.remen_title_tv= (TextView) convertView.findViewById(R.id.remen_title_tv);//找某个控件
	        vHolder.renmen_flllow_tv= (TextView) convertView.findViewById(R.id.renmen_flllow_tv);
			vHolder.remen_loc_author_tv= (TextView) convertView.findViewById(R.id.remen_loc_author_tv);
			vHolder.remen_book_type_tv= (TextView) convertView.findViewById(R.id.remen_book_type_tv);
			// 将ViewHodler保存到Tag中(Tag可以接收Object类型对象，所以任何东西都可以保存在其中)
	        convertView.setTag(vHolder);  
	    } else {  
	        //当convertView不为空时，通过getTag()得到View    
	        vHolder = (ViewHolder) convertView.getTag();   
	    }  
	    // 给对象赋值，修改显示的值
//		Drawable nav_up = getResources().getDrawable(R.drawable.button_nav_up);
//		nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        vHolder.remen_logo_img_tv.setCompoundDrawables(null, null, (Drawable) mData.get(position).get("remen_logo_img_tv"), null);
//		vHolder.remen_loc_author_tv.setBackgroundResource((Integer) mData.get(position).get("img"));
	    vHolder.remen_title_tv.setText(mData.get(position).get("remen_title_tv").toString());//给该控件设置数据(数据从集合类中来)
	    vHolder.renmen_flllow_tv.setText(mData.get(position).get("renmen_flllow_tv").toString());//给该控件设置数据(数据从集合类中来)
	    vHolder.remen_loc_author_tv.setText(mData.get(position).get("remen_loc_author_tv").toString());
		vHolder.remen_book_type_tv.setText(mData.get(position).get("remen_book_type_tv").toString());
		vHolder.remen_logo_img_tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mOnClickItemElementListenter.onItemElementClick(v,position);
			}
		});


	    return convertView;  
	}


	private OnClickItemElementListenter mOnClickItemElementListenter ;

	public void setOnClickItemElementListenter(OnClickItemElementListenter onClickItemElementListenter){
		this.mOnClickItemElementListenter = onClickItemElementListenter;
	}

	static class ViewHolder {
		TextView remen_logo_img_tv;
		TextView remen_title_tv;
		TextView renmen_flllow_tv;
		TextView remen_loc_author_tv;
		TextView remen_book_type_tv;
	}
	
}
