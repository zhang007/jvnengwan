package com.example.majunpeng.jvnengwan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.adapter.MyGrideViewAdapter_MyLive;
import com.example.majunpeng.jvnengwan.bean.MyLiveVideoBean;
import com.example.majunpeng.jvnengwan.model.LoadDataModel;
import com.example.majunpeng.jvnengwan.model.impl.LoadDataModelImpl;
import com.example.majunpeng.jvnengwan.model.listener.OnLoadDataListener;
import com.example.majunpeng.jvnengwan.url.LoadUrl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MyLiveActivity extends AppCompatActivity implements OnLoadDataListener {
    private LoadDataModel loadDataModel;
    private List<Object> data;
    private MyGrideViewAdapter_MyLive adapter;
    private GridView gridView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_live);

        initView();

        adapter = new MyGrideViewAdapter_MyLive(data, this);
        gridView.setAdapter(adapter);
    }

    private void initView() {
        loadDataModel = new LoadDataModelImpl();
        loadDataModel.getData(LoadUrl.URL_MYLIVE_VIDEO, this);

        data = new ArrayList<>();

        gridView = (GridView) findViewById(R.id.gridView_myLiveActivity);

    }

    @Override
    public void getDataForGson(boolean isSuccess, String response) {

        if (isSuccess) {
            // TODO: 2016/7/28

            Gson gson = new Gson();
            MyLiveVideoBean myLiveVideoBean = gson.fromJson(response,
                    MyLiveVideoBean.class);
            List<MyLiveVideoBean.RecLiveBean.DataListBean.MyArrayListBean>
                    myArrayList = myLiveVideoBean.getRec_live().getData_list()
                    .get(0).getMyArrayList();
            data.addAll(myArrayList);

            MyLiveVideoBean.RecLiveBean.DataListBean.MyArrayListBean
                    myArrayListBean = myArrayList.get(0);

            List<MyLiveVideoBean.HotLiveBean.DataListBean.MyArrayListBean>
                    myArrayList1 = myLiveVideoBean.getHot_live().getData_list()
                    .get(0).getMyArrayList();

            data.addAll(myArrayList1);


            List<MyLiveVideoBean.ConLiveBean.DataListBean.MyArrayListBean>
                    myArrayList2 = myLiveVideoBean.getCon_live().getData_list()
                    .get(0).getMyArrayList();
            data.addAll(myArrayList2);

            adapter.addData(data);


        } else {
            Toast.makeText(this, "网络异常", Toast.LENGTH_LONG).show();
        }

    }
}
