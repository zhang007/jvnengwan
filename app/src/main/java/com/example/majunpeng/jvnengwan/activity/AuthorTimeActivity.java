package com.example.majunpeng.jvnengwan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.adapter.ListViewAdapter_QSVideo;
import com.example.majunpeng.jvnengwan.bean.QSBaiKeBean;
import com.example.majunpeng.jvnengwan.model.LoadDataModel;
import com.example.majunpeng.jvnengwan.model.impl.LoadDataModelImpl;
import com.example.majunpeng.jvnengwan.model.listener.OnLoadDataListener;
import com.example.majunpeng.jvnengwan.url.LoadUrl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AuthorTimeActivity extends AppCompatActivity implements
        OnLoadDataListener {

    private ListView listView_video_Vitamio;
    private LoadDataModel loadDataModel;
    private List<QSBaiKeBean.ItemsBean> data;
    private ListViewAdapter_QSVideo adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_time);
        initView();
        loadDataModel.getData(LoadUrl.URL_ETLITE_VIDEO, this);
        adapter = new ListViewAdapter_QSVideo(data, this);

        listView_video_Vitamio.setAdapter(adapter);
    }

    private void initView() {

        loadDataModel = new LoadDataModelImpl();
        listView_video_Vitamio = (ListView) findViewById(R.id
                .listView_video_Vitamio);
        data = new ArrayList<>();
    }

    @Override
    public void getDataForGson(boolean isSuccess, String response) {
        if (isSuccess) {
            Gson gson = new Gson();
            List<QSBaiKeBean.ItemsBean> itemsBeen = gson.fromJson(response,
                    QSBaiKeBean.class).getItems();

            this.data.addAll(itemsBeen);
            adapter.addData(itemsBeen);


        } else {
            Toast.makeText(this, "failure", Toast.LENGTH_LONG).show();
        }


    }
}
