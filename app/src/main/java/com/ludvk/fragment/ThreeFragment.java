package com.ludvk.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ludvk.activity.R;
import com.ludvk.activity.TransferAccountsActivity;
import com.ludvk.bean.AccountBean;
import com.ludvk.database.DatabaseHelper;
import com.ludvk.database.DatabaseUtils;

import java.util.List;

public class ThreeFragment extends Fragment implements OnClickListener {

    private Button finish_btn;

    private DatabaseUtils databaseutils;

    private List<AccountBean> list;

    private TextView all_balance, xianjin_balance, chuxuka_balance, xinyongka_balance,
            zhifubao_balance;

    private AccountBean bean;

    private double d1, d2, d3, d4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreateView(inflater, container, savedInstanceState);

        View friendView = inflater.inflate(R.layout.activity_fragment_three, container, false);

        finish_btn = (Button) friendView.findViewById(R.id.finish_btn);

        finish_btn.setOnClickListener(this);

        all_balance = (TextView) friendView.findViewById(R.id.all_balance);

        xianjin_balance = (TextView) friendView.findViewById(R.id.xianjin_balance);

        chuxuka_balance = (TextView) friendView.findViewById(R.id.chuxuka_balance);

        xinyongka_balance = (TextView) friendView.findViewById(R.id.xinyongka_balance);

        zhifubao_balance = (TextView) friendView.findViewById(R.id.zhifubao_balance);

        databaseutils = new DatabaseUtils(getActivity(), DatabaseHelper.ACCOUNT_TYPE, null, null);
        list = databaseutils.getAccount();

        bean = list.get(0);
        xianjin_balance.setText(bean.getBalance());
        d1 = Double.valueOf(bean.getBalance());
        bean = list.get(1);
        chuxuka_balance.setText(bean.getBalance());
        d2 = Double.valueOf(bean.getBalance());
        bean = list.get(2);
        xinyongka_balance.setText(bean.getBalance());
        d3 = Double.valueOf(bean.getBalance());
        bean = list.get(3);
        zhifubao_balance.setText(bean.getBalance());
        d4 = Double.valueOf(bean.getBalance());

        String all = d1 + d2 + d3 + d4 + "";

        all_balance.setText(all);

        return friendView;

    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.finish_btn:
                Intent intent = new Intent(getActivity(), TransferAccountsActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();


    }


}
