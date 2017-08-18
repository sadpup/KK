package com.example.admin.kk.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
public class MessageTab01Adapter extends BaseAdapter{

	private LayoutInflater mInflater;// 动态布局映射
	private List<HashMap<String, Object>> mData;

	public MessageTab01Adapter(Context context, List<HashMap<String, Object>> mData) {
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
	        convertView = mInflater.inflate(R.layout.list_message_tab01_item, null);  //根据布局文件实例化view\
	        // 创建 ViewHodler 对象    
	        vHolder = new ViewHolder();  
	        vHolder.message_tab01_item_img= (ImageView) convertView.findViewById(R.id.message_tab01_item_img);//找某个控件
	        vHolder.message_tab01_item_tv01= (TextView) convertView.findViewById(R.id.message_tab01_item_tv01);//找某个控件
	        vHolder.message_tab01_item_tv02= (TextView) convertView.findViewById(R.id.message_tab01_item_tv02);
			vHolder.message_tab01_item_follow_tv= (TextView) convertView.findViewById(R.id.message_tab01_item_follow_tv);
			vHolder.message_tab01_item_tv03= (TextView) convertView.findViewById(R.id.message_tab01_item_tv03);
			// 将ViewHodler保存到Tag中(Tag可以接收Object类型对象，所以任何东西都可以保存在其中)
	        convertView.setTag(vHolder);  
	    } else {  
	        //当convertView不为空时，通过getTag()得到View    
	        vHolder = (ViewHolder) convertView.getTag();   
	    }  
	    // 给对象赋值，修改显示的值
		vHolder.message_tab01_item_img.setBackgroundResource((Integer) mData.get(position).get("message_tab01_item_img"));
	    vHolder.message_tab01_item_tv01.setText(mData.get(position).get("message_tab01_item_tv01").toString());//给该控件设置数据(数据从集合类中来)
	    vHolder.message_tab01_item_tv02.setText(mData.get(position).get("message_tab01_item_tv02").toString());//给该控件设置数据(数据从集合类中来)
	    vHolder.message_tab01_item_follow_tv.setText(mData.get(position).get("message_tab01_item_follow_tv").toString());
		vHolder.message_tab01_item_tv03.setText(mData.get(position).get("message_tab01_item_tv03").toString());
		vHolder.message_tab01_item_img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mOnItemMessageTab01Listener.onItemClick(v,position);
			}
		});
		vHolder.message_tab01_item_tv01.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mOnItemMessageTab01Listener.onItemClick(v,position);
			}
		});
		vHolder.message_tab01_item_tv02.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mOnItemMessageTab01Listener.onItemClick(v,position);
			}
		});
		vHolder.message_tab01_item_follow_tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mOnItemMessageTab01Listener.onItemClick(v,position);
			}
		});
		vHolder.message_tab01_item_tv03.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mOnItemMessageTab01Listener.onItemClick(v,position);
			}
		});
	    return convertView;  
	}

	/**
	 *关注的监听接口
	 */
	public interface OnItemMessageTab01Listener {
		void onItemClick(View v, int i);
	}

	private OnItemMessageTab01Listener mOnItemMessageTab01Listener;

	public void setOnItemMessageTab01Listener(OnItemMessageTab01Listener mOnItemMessageTab01Listener) {
		this.mOnItemMessageTab01Listener = mOnItemMessageTab01Listener;
	}

	static class ViewHolder {
		ImageView message_tab01_item_img;
		TextView message_tab01_item_tv01;
		TextView message_tab01_item_tv02;
		TextView message_tab01_item_follow_tv;
		TextView message_tab01_item_tv03;
	}
	
}
