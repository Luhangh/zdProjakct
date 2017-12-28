package com.ludvk.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ludvk.activity.R;
import com.ludvk.activity.custominfoActivity;
import com.ludvk.activity.dialog.TextViewAlertDialog;
import com.ludvk.bean.custombean;
import com.ludvk.database.DBHelper;
import com.ludvk.database.DatabaseUtils;
import com.ludvk.utils.Constant;
import com.ludvk.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class InOrderfragment extends Fragment implements OnClickListener {
    private DatabaseUtils databaseutils;
    private TextViewAlertDialog MainDialog;
    private TextView Text_select;
    private EditText mFoodEdt;
    private EditText mArticlesEdt;
    private EditText mTrafficEdt;
    private EditText mTravelEdt;
    private EditText mClothesEdt;
    private EditText mDoctorEdt;
    private EditText mRenQingEdt;
    private EditText mBabyEdt;
    private EditText mLiveEdt;
    private EditText mOtherEdt;
    private EditText mRemarkEdt;
    private Button mSaveBtn;
    private List<custombean> list;
    private custombean bean;

    private View friendView;
    private DBHelper mDbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreateView(inflater, container, savedInstanceState);
        friendView = inflater.inflate(R.layout.activity_fragment_zero, container, false);
        findViewsById();
        mDbHelper = new DBHelper(getActivity());
        mDbHelper.open();
        list = new ArrayList<>();
        return friendView;
    }

    private void findViewsById() {
        Text_select = (TextView) friendView.findViewById(R.id.Text_select);
        mFoodEdt = (EditText) friendView.findViewById(R.id.family_bill_food_edt);
        mArticlesEdt = (EditText) friendView.findViewById(R.id.family_bill_articles_edt);
        mTrafficEdt = (EditText) friendView.findViewById(R.id.family_bill_traffic_edt);
        mTravelEdt = (EditText) friendView.findViewById(R.id.family_bill_travel_edt);
        mClothesEdt = (EditText) friendView.findViewById(R.id.family_bill_clothes_edt);
        mDoctorEdt = (EditText) friendView.findViewById(R.id.family_bill_doctor_edt);
        mRenQingEdt = (EditText) friendView.findViewById(R.id.family_bill_laiwang_edt);
        mBabyEdt = (EditText) friendView.findViewById(R.id.family_bill_baby_edt);
        mOtherEdt = (EditText) friendView.findViewById(R.id.family_bill_other_edt);
        mRemarkEdt = (EditText) friendView.findViewById(R.id.family_bill_remark_edt);
        mSaveBtn = (Button) friendView.findViewById(R.id.family_bill_save);
        mSaveBtn.setOnClickListener(this);
        Text_select.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.family_bill_save) {
            inorder();
        } else if (v.getId() == R.id.Text_select) {
            selectdialog();

        }
    }

    private void selectdialog() {

        final String put = "0";

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.textview_dialog, null);
        builder.setInverseBackgroundForced(true);
        builder.setView(view);
        final Dialog dialog = builder.create();
        final TextView dialogTitle = (TextView) view.findViewById(R.id.dialogTitle);
        final TextView dialogLeftBtn = (TextView) view.findViewById(R.id.dialogLeftBtn);
        final TextView dialogRightBtn = (TextView) view.findViewById(R.id.dialogRightBtn);
        final EditText dialoginput = (EditText) view.findViewById(R.id.dialoginput);
        dialoginput.setVisibility(View.VISIBLE);
        final TextView dialogMessage = (TextView) view.findViewById(R.id.dialogMessage);
        dialogTitle.setText("请输入查询名字");
        dialogLeftBtn.setText("取消");
        dialogRightBtn.setText("确定");
        dialogMessage.setVisibility(View.GONE);
        dialogMessage.setText("");
        dialoginput.setText(" ");
        if ("".equals(StringUtils.object2String(dialoginput.getText()))) {
            dialogLeftBtn.setClickable(false);
        }
        dialogLeftBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getlistcustom(dialoginput.getText().toString());

                if (list != null) {
                    Intent inte = new Intent(getActivity(), custominfoActivity.class);
                    inte.putParcelableArrayListExtra("custom",
                            (ArrayList<? extends Parcelable>) list);
                    startActivity(inte);
                }
                dialog.cancel();
            }
        });

        dialogRightBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();

    }

    public void getlistcustom(String input) {
        Cursor cursor = mDbHelper.exeSql(Constant.SQLORDERNAME,
                new String[]{StringUtils.object2String(input)});
        while (cursor.moveToNext()) {

            bean = new custombean();
            bean.setTimes(cursor.getString(cursor.getColumnIndex("time")) + "");
            bean.setAdress(cursor.getString(cursor.getColumnIndex("adress")) + "");
            bean.setName(cursor.getString(cursor.getColumnIndex("name")) + "");
            bean.setCity(cursor.getString(cursor.getColumnIndex("city")) + "");
            bean.setFroms(cursor.getString(cursor.getColumnIndex("froms")) + "");
            bean.setQq(cursor.getString(cursor.getColumnIndex("qq")) + "");
            bean.setPhone(cursor.getString(cursor.getColumnIndex("phone")) + "");
            bean.setOther(cursor.getString(cursor.getColumnIndex("other")) + "");
            bean.setInfo(cursor.getString(cursor.getColumnIndex("info")) + "");
            bean.setWrokname(cursor.getString(cursor.getColumnIndex("workname")) + "");
            bean.setSex(cursor.getString(cursor.getColumnIndex("sex")) + "");
            list.add(bean);
        }

        cursor.close();

    }

    private void inorder() {
        //databaseutils =new DatabaseUtils(getActivity(),DatabaseHelper.INPUT_ORDER, null, null);
        ContentValues values = new ContentValues();
        if (canSave()) {
            values.put("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            values.put("name", mFoodEdt.getText().toString());
            values.put("sex", mArticlesEdt.getText().toString());
            values.put("phone", mTrafficEdt.getText().toString());
            values.put("qq", mTravelEdt.getText().toString());
            values.put("workname", mClothesEdt.getText().toString());
            values.put("city", mDoctorEdt.getText().toString());
            values.put("adress", mRenQingEdt.getText().toString());
            values.put("froms", mBabyEdt.getText().toString());
            values.put("other", mOtherEdt.getText().toString());
            values.put("info", mRemarkEdt.getText().toString());
            long insert = mDbHelper.insert("inorder", values);
            if (insert > 0) {
                Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean canSave() {
        if (TextUtils.isEmpty(mFoodEdt.getText())) {
            return false;
        }
        if (TextUtils.isEmpty(mArticlesEdt.getText())) {
            return false;
        }
        if (TextUtils.isEmpty(mTrafficEdt.getText())) {
            return false;
        }
        if (TextUtils.isEmpty(mTravelEdt.getText())) {
            return false;
        }
        if (TextUtils.isEmpty(mClothesEdt.getText())) {
            return false;
        }
        if (TextUtils.isEmpty(mDoctorEdt.getText())) {
            return false;
        }
        if (TextUtils.isEmpty(mRenQingEdt.getText())) {
            return false;
        }
        if (TextUtils.isEmpty(mBabyEdt.getText())) {
            return false;
        }


        return true;
    }


}
