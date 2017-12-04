package study.com.definedialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AlertDialog.OnShowListener,
        AlertDialog.OnDismissListener {

    private TextView tvResult;
    private AlertDialog testDialog;
    private String[] things = {"吃药", "喝水", "运动", "接孩子", "起床", "自定义"};
    private String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"};
    private boolean[] booleanIndexs = {false, false, false, false, false, false, false};
    private String clickA = "";
    private int singleIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    /**
     * 用于测试对话框的显示方式,测试方法如下：
     * testDialog.setContentView(inflate);
     *
     * @param view
     */
    public void test1(View view) {
        clickA = "1";

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.dialog_lhp);
        View inflate = LayoutInflater.from(this).inflate(R.layout.add_remind_record, null);
        final LinearLayout llRecord = (LinearLayout) inflate.findViewById(R.id.ll_record);
        TextView tvSeconds = (TextView) inflate.findViewById(R.id.tv_seconds);


        testDialog = builder.create();


        llRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testDialog.dismiss();
            }
        });
        testDialog.setCanceledOnTouchOutside(false);
        testDialog.setOnShowListener(this);
        testDialog.setOnDismissListener(this);
        testDialog.show();
        testDialog.setContentView(R.layout.add_remind_record);
        testDialog.setCancelable(false);

        Window window = testDialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setDimAmount(0);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        lp.width = (int) (widthPixels * 0.5);
        lp.height = lp.width;
        window.setAttributes(lp);
    }

    /**
     * 用于测试对话框的显示方式,测试方法如下：
     * builder.setView(inflate);
     *
     * @param view
     */
    public void test2(View view) {
        clickA = "2";


        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Light_Dialog);
        View inflate = LayoutInflater.from(this).inflate(R.layout.add_remind_record, null);
        final LinearLayout llRecord = (LinearLayout) inflate.findViewById(R.id.ll_record);
        TextView tvSeconds = (TextView) inflate.findViewById(R.id.tv_seconds);
        TextView tvCancel = (TextView) inflate.findViewById(R.id.tv_cancel);


        builder.setView(inflate);
        testDialog = builder.create();

        llRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testDialog.dismiss();
            }
        });
        testDialog.setCanceledOnTouchOutside(false);
        testDialog.show();
        testDialog.setOnShowListener(this);
        testDialog.setOnDismissListener(this);
        testDialog.setCancelable(false);

        Window window = testDialog.getWindow();


        int id = Resources.getSystem().getIdentifier("parentPanel", "id", "android");
        LinearLayout llview = (LinearLayout) window.findViewById(id);
//        llview.setBackgroundColor(Color.WHITE);
//        llview.setPadding(0, 0, 0, 0);             //非必要
//        ViewGroup.LayoutParams params1 = llview.getLayoutParams();
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
//        params.setMargins(0, 0, 0, 0);
        llview.setLayoutParams(params);
        llview.setBackgroundColor(Color.TRANSPARENT);
        ViewGroup.LayoutParams a3 = llview.getLayoutParams();

        int id2 = Resources.getSystem().getIdentifier("customPanel", "id", "android");
        FrameLayout llview2 = (FrameLayout) window.findViewById(id2);
        llview2.setPadding(0, 0, 0, 0);   //必要
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        llview2.setBackgroundColor(Color.TRANSPARENT);
        llview2.setLayoutParams(params2);
        ViewGroup.LayoutParams a2 = llview2.getLayoutParams();

        FrameLayout customFrame = (FrameLayout) window.findViewById(android.R.id.custom);
//        customFrame.setPadding(0, 0, 0, 0);
        FrameLayout.LayoutParams params3 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        customFrame.setLayoutParams(params3);
        customFrame.setBackgroundColor(Color.TRANSPARENT);
        ViewGroup.LayoutParams a1 = customFrame.getLayoutParams();


        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setDimAmount(0);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        lp.width = (int) (widthPixels * 0.5);
        lp.height = lp.width;
        window.setAttributes(lp);
    }

    /**
     * 用于测试对话框的显示方式,测试方法如下：
     * builder.setView(R.layout.add_remind_record);
     *
     * @param view
     */
    public void test3(View view) {
        clickA = "3";


        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Light_Dialog);
        AlertDialog.Builder addViewBulider = builder.setView(R.layout.add_remind_record);
        testDialog = addViewBulider.create();

        testDialog.setOnShowListener(this);
        testDialog.setOnDismissListener(this);
        testDialog.show();


//        Window window = testDialog.getWindow();
//        window.setBackgroundDrawableResource(android.R.color.holo_red_dark);
//        WindowManager.LayoutParams lp = window.getAttributes();
//        window.setDimAmount(0);
//        int widthPixels = getResources().getDisplayMetrics().widthPixels;
//        lp.width = (int) (widthPixels * 0.5);
//        lp.height = lp.width;
//        window.setAttributes(lp);

        Window window = testDialog.getWindow();


        int id = Resources.getSystem().getIdentifier("parentPanel", "id", "android");
        LinearLayout llview = (LinearLayout) window.findViewById(id);
//        llview.setBackgroundColor(Color.WHITE);
        llview.setPadding(0, 0, 0, 0);             //非必要
//        ViewGroup.LayoutParams params1 = llview.getLayoutParams();
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
//        params.setMargins(0, 0, 0, 0);
        llview.setLayoutParams(params);
        llview.setBackgroundColor(Color.TRANSPARENT);
        ViewGroup.LayoutParams a3 = llview.getLayoutParams();

        int id2 = Resources.getSystem().getIdentifier("customPanel", "id", "android");
        FrameLayout llview2 = (FrameLayout) window.findViewById(id2);
        llview2.setPadding(0, 0, 0, 0);   //必要
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        llview2.setBackgroundColor(Color.TRANSPARENT);
        llview2.setLayoutParams(params2);
        ViewGroup.LayoutParams a2 = llview2.getLayoutParams();

        FrameLayout customFrame = (FrameLayout) window.findViewById(android.R.id.custom);
//        customFrame.setPadding(0, 0, 0, 0);
        FrameLayout.LayoutParams params3 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        customFrame.setLayoutParams(params3);
        customFrame.setBackgroundColor(Color.TRANSPARENT);
        ViewGroup.LayoutParams a1 = customFrame.getLayoutParams();


        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setDimAmount(0);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        lp.width = (int) (widthPixels * 0.5);
        lp.height = lp.width;
        window.setAttributes(lp);
    }

    /**
     * 用于测试对话框的显示方式,测试方法如下：
     * window.setContentView(inflate);
     *
     * @param view
     */
    public void test4(View view) {
        clickA = "4";


        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Light_Dialog);
        View inflate = LayoutInflater.from(this).inflate(R.layout.add_remind_record, null);
        final LinearLayout llRecord = (LinearLayout) inflate.findViewById(R.id.ll_record);
        TextView tvSeconds = (TextView) inflate.findViewById(R.id.tv_seconds);

//        builder.setView(inflate);
        testDialog = builder.create();

        llRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testDialog.dismiss();
            }
        });
        testDialog.setCanceledOnTouchOutside(false);
        testDialog.setOnShowListener(this);
        testDialog.setOnDismissListener(this);
        testDialog.show();
        testDialog.setCancelable(false);

        Window window = testDialog.getWindow();
        window.setContentView(inflate);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setDimAmount(0);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        lp.width = (int) (widthPixels * 0.5);
        lp.height = lp.width;
        window.setAttributes(lp);
    }

    public void test5(View view) {
        AlertDialog thingDialog = new AlertDialog.
                Builder(this, R.style.dialog_lhp).
                setSingleChoiceItems(things, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvResult.setText(things[which]);
                        singleIndex = which;
                    }
                }).
                setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (singleIndex == things.length - 1) {
                            showWeeks(weeks, booleanIndexs);
                        }
                    }
                }).
                setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        singleIndex = -1;

                    }
                }).
                create();
        definePadding(thingDialog.getListView());
        setDialogAttribute(thingDialog);
    }

    public void test6(View view) {
        showWeeks(weeks, booleanIndexs);
    }

    private void showWeeks(final String[] weeks, final boolean[] indexs) {
        AlertDialog thingDialog = new AlertDialog.
                Builder(this, R.style.dialog_lhp).
                setMultiChoiceItems(weeks, indexs, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        indexs[which] = isChecked;
                    }
                }).
                setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str = "";
                        for (int i = 0; i < indexs.length; i++) {
                            if (indexs[i]) {
                                str += weeks[i] + ",";
                            }
                        }
                        str = str.substring(0, str.length() - 1);
                        tvResult.setText(str);
                    }
                }).
                setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).
                create();

        setDialogAttribute(thingDialog);
    }

    private void definePadding(Object object) {
        if (object instanceof ViewParent) {
            ViewParent viewParent = (ViewParent) object;
            if (viewParent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) viewParent;
                group.setPadding(0, 0, 0, 0);
                ViewParent parent = group.getParent();
                if (parent != null) {
                    definePadding(parent);
                }
            }
        }

        Log.e("parent::", object.toString());
    }

    /**
     * 设置对话框的弹出配置
     *
     * @param dialog
     */
    private void setDialogAttribute(AlertDialog dialog) {
        dialog.show();
        Window window = dialog.getWindow();
        window.setDimAmount(0);

        int id = Resources.getSystem().getIdentifier("parentPanel", "id", "android");
        LinearLayout llview = (LinearLayout) window.findViewById(id);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        llview.setLayoutParams(params);

        int id2 = Resources.getSystem().getIdentifier("contentPanel", "id", "android");
        LinearLayout llview2 = (LinearLayout) window.findViewById(id2);
//        llview2.setPadding(0, 0, 0, 0);   //非必要
        llview2.setBackgroundColor(Color.WHITE);

        int id3 = Resources.getSystem().getIdentifier("buttonPanel", "id", "android");
        LinearLayout llview3 = (LinearLayout) window.findViewById(id3);
        llview3.setPadding(0, 0, 0, 0);
        llview3.setBackgroundColor(Color.WHITE);   //不设置颜色 二者给一即可

//        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置弹出的动画效果
        window.setWindowAnimations(R.style.mystyle);
        window.setGravity(Gravity.BOTTOM);
    }


    @Override
    public void onDismiss(DialogInterface anInterface) {
        Toast.makeText(this, "关闭" + clickA, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShow(DialogInterface anInterface) {
        Toast.makeText(this, "打开" + clickA, Toast.LENGTH_SHORT).show();
    }
}
