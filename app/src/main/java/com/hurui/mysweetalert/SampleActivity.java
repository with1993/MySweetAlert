package com.hurui.mysweetalert;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class SampleActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);
        findViewById(R.id.basic_test).setOnClickListener(this);
        findViewById(R.id.under_text_test).setOnClickListener(this);
        findViewById(R.id.error_text_test).setOnClickListener(this);
        findViewById(R.id.success_text_test).setOnClickListener(this);
        findViewById(R.id.warning_confirm_test).setOnClickListener(this);
        findViewById(R.id.warning_cancel_test).setOnClickListener(this);
        findViewById(R.id.custom_img_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basic_test:
                // default title "这是一条消息！"
                new SweetAlertDialog(this)
                        .show();
                break;
            case R.id.under_text_test:
                new SweetAlertDialog(this)
                        .setContentText("完美！")
                        .show();
                break;
            case R.id.error_text_test:
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("哎哟...")
                        .setContentText("发生了一些错误！")
                        .show();
                break;
            case R.id.success_text_test:
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("成功！")
                        .setContentText("你点击了这个按钮！")
                        .show();
                break;
            case R.id.warning_confirm_test:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("是否确定删除这张图片？")
                        .setContentText("图片删除后不可恢复！")
                        .setConfirmText("是的，删掉它！")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            // reuse previous dialog instance
                            sDialog.setTitleText("已删除！")
                                    .setContentText("图片已经删除！")
                                    .setConfirmText("确定")
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                        }
                        })
                        .show();
                break;
            case R.id.warning_cancel_test:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("是否确定删除这张图片？")
                        .setContentText("图片删除后不可恢复！")
                        .setCancelText("取消！")
                        .setConfirmText("是的，删掉它！")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                // reuse previous dialog instance, keep widget user state, reset them if you need
                                sDialog.setTitleText("已取消")
                                        .setContentText("您的图片没有删除 :)")
                                        .setConfirmText("确定")
                                        .showCancelButton(false)
                                        .setCancelClickListener(null)
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                                // or you can new a SweetAlertDialog to show
                               /* sDialog.dismiss();
                                new SweetAlertDialog(SampleActivity.this, SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Cancelled!")
                                        .setContentText("Your imaginary file is safe :)")
                                        .setConfirmText("OK")
                                        .show();*/
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.setTitleText("已删除！")
                                        .setContentText("图片已删除！")
                                        .setConfirmText("确定")
                                        .showCancelButton(false)
                                        .setCancelClickListener(null)
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            }
                        })
                        .show();
                break;
            case R.id.custom_img_test:
                new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("见到本王还不下跪?")
                        .setContentText("你们对力量一无所知")
                        .setCustomImage(R.drawable.custom_img)
                        .setConfirmText("去下跪")
                        .show();
                break;
        }
    }
}
