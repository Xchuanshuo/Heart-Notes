package com.time.line;

import android.app.*;
import android.os.*;

import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import java.util.*;
import com.google.gson.Gson;
import android.content.*;
import com.google.gson.reflect.*;
import android.view.View.*;
import android.view.*;
import java.text.*;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.*;

public class MainActivity extends AppCompatActivity 
{
	
	private CoordinatorLayout cdl;
	private ListView listview;
	private TimeLineAdapter adapter;
	private List<Map<String,Object>> list;
	private Button btn1;
	private TextView tv;
	private EditText edt;
    //键值对
	private Map<String,Object> map;
	private String cacheName="cache";
	private Gson gson=new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		//存入数据
		SharedPreferences sp=getSharedPreferences("config",Context.MODE_PRIVATE);
		final SharedPreferences.Editor ed=sp.edit();
		cdl=(CoordinatorLayout)findViewById(R.id.mainandroid_support_design_widget_CoordinatorLayout);
		tv=(TextView)findViewById(R.id.tv);
		tv.setOnClickListener(new OnClickListener(){
    			@Override
				public void onClick(View v)
				{
					Dialog();
					// TODO: Implement this method
				}
			
		});
		String cache=sp.getString(cacheName,"");
		list=gson.fromJson(cache,new TypeToken<ArrayList<Map<String,Object>>>(){
			
		}.getType());
		if(list==null){
			list=new ArrayList<Map<String,Object>>();
		}
		edt=(EditText)findViewById(R.id.dialog_edt);
		listview=(ListView)this.findViewById(R.id.listview);
		listview.setDividerHeight(0);
		
		adapter=new TimeLineAdapter(this,list);
		listview.setAdapter(adapter);
		
//		btn1=(Button)findViewById(R.id.dialog_btn);
//		btn1.setOnClickListener(new OnClickListener(){
//
//				@Override
//				public void onClick(View v)
//				{
//			map=new HashMap<String,Object>();
//			SimpleDateFormat sdf1=new SimpleDateFormat("MM月dd日");
//			SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
//			map.put("day",sdf1.format(new Date()));
//			map.put("time",sdf2.format(new Date()));
//			
//			map.put("content",edt.getText().toString());
//			list.add(map);
//			//倒序
//			Collections.reverse(list);
//			//通知刷新
//			adapter.notifyDataSetChanged();
//			//提交
//			ed.putString(cacheName,gson.toJson(list));
//			ed.commit();
//					// TODO: Implement this method
//				}
//		});
    }
	private void Dialog(){
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setIcon(R.drawable.lovely_emotion);
		LayoutInflater inflater=LayoutInflater.from(this);
		final View dialog=inflater.inflate(R.layout.dialog_item,null);
		builder.setTitle("留下心灵的记忆");
		builder.setView(dialog);
		btn1=(Button)dialog.findViewById(R.id.dialog_btn);
		btn1.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v){
		SharedPreferences sp=getSharedPreferences("config",Context.MODE_PRIVATE);

		final SharedPreferences.Editor ed=sp.edit();
		edt=(EditText)dialog.findViewById(R.id.dialog_edt);
		    map=new HashMap<String,Object>();
			SimpleDateFormat sdf1=new SimpleDateFormat("MM月dd日");
			SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
			map.put("day",sdf1.format(new Date()));
			map.put("time",sdf2.format(new Date()));
			
			map.put("content",edt.getText().toString());
			list.add(map);
			//倒序
			Collections.reverse(list);
			//通知刷新
			adapter.notifyDataSetChanged();
			//提交
			ed.putString(cacheName,gson.toJson(list));
			ed.commit();
			Toast.makeText(MainActivity.this,"记录成功",Toast.LENGTH_SHORT).show();
					// TODO: Implement this method
				}
		});	
		
		
		   builder.create().show();
					
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{ 
		if(keyCode==event.KEYCODE_BACK){
	     Snackbar.make(cdl,"您确定要退出吗",Snackbar.LENGTH_SHORT)
			        .setAction("确定", new OnClickListener(){

				@Override
		public void onClick(View p1)
		{
			android.os.Process.killProcess(android.os.Process.myPid());  
		// TODO: Implement this method
	}

				
			}).show();
	
		}
		// TODO: Implement this method
		return true;
    }
}
