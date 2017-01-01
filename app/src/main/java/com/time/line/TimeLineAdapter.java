package com.time.line;
import android.widget.*;
import android.view.*;
import android.content.Context;
import java.util.*;
import android.graphics.*;

public class TimeLineAdapter extends BaseAdapter
{
	private Context context;
    private List<Map<String,Object>> list;
	private LayoutInflater inflater;
	public TimeLineAdapter(Context context,List<Map<String,Object>> list){
		super();
		this.context=context;
		this.list=list;
	}
	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return list.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO: Implement this method
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO: Implement this method
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder;
		if(convertView==null){
			inflater=LayoutInflater.from(context);
			convertView=inflater.inflate(R.layout.list_item,null);
			viewHolder=new ViewHolder();
			viewHolder.day=(TextView)convertView.findViewById(R.id.day);
			viewHolder.time=(TextView)convertView.findViewById(R.id.time);
			viewHolder.content=(TextView)convertView.findViewById(R.id.content);
		
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder)convertView.getTag();
			
		}
		String day=list.get(position).get("day").toString();
		String time=list.get(position).get("time").toString();
		String content=list.get(position).get("content").toString();
		if(day!=null){
			viewHolder.day.setBackgroundColor(Color.WHITE);
		}
		if(time==null){
			time="#";
		}
		if(content==null){
			content="#";
		}
		viewHolder.day.setText(day);
		viewHolder.day.setBackgroundResource(R.drawable.image_4);
        
		viewHolder.day.setText(day);
		viewHolder.time.setText(time);
		viewHolder.content.setText(content);
		
		// TODO: Implement this method
		return convertView;
	}
   static class ViewHolder{
	   private TextView day;
	   private TextView time;
	   private TextView content;
   }
}
