package com.example.dj0708.demo20160119_playcamera;

/**
 * Created by dj0708 on 16/1/19.
 */

import com.example.dj0708.demo20160119_playcamera.CameraInterface.CamOpenOverCallback;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends Activity implements CamOpenOverCallback {
    CameraSurfaceView surfaceView = null;
    float previewRate = -1f;

    private Button turnLeftBtn;
    private Button turnRightBtn;
    private Button midLeftBtn;
    private Button midRightBtn;
    private Button radianBtn;
    private Button forwardTurnLeftBtn;
    private Button forwardTurnRightBtn;
    private Button forwardMidLeftBtn;
    private Button forwardMidRightBtn;

    private ImageView backLeftImg;
    private ImageView backMidLeftImg;
    private ImageView backMidRightImg;
    private ImageView backRightImg;
    private ImageView radianImg;
    private ImageView forwardLeftImg;
    private ImageView forwardMidLeftImg;
    private ImageView forwardMidRightImg;
    private ImageView forwardRightImg;

    private int leftCount = 1;
    private int midLeftCount = 1;
    private int midRightCount = 1;
    private int rightCount = 1;
    private int radianCount = 1;

    private int forwardLeftCount = 1;
    private int forwardMidLeftCount = 1;
    private int forwardMidRightCount = 1;
    private int forwardRightCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread openThread = new Thread(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                CameraInterface.getInstance().doOpenCamera(CameraActivity.this);
            }
        };
        openThread.start();
        setContentView(R.layout.activity_camera);
        initUI();
        initViewParams();
    }

    private void initUI(){
        surfaceView = (CameraSurfaceView)findViewById(R.id.camera_surfaceview);

//        左转按钮;
        turnLeftBtn = (Button)findViewById(R.id.turn_left_btn);
        addTurnLeftListener();

//        中右按钮;
        midRightBtn = (Button)findViewById(R.id.mid_right_btn);
        addMidRightListener();

//        中左按钮;
        midLeftBtn = (Button)findViewById(R.id.mid_left_btn);
        addMidLeftListener();

//        右转按钮;
        turnRightBtn = (Button)findViewById(R.id.turn_right_btn);
        addTurnRightListener();

//        左边弧度按钮;
        radianBtn = (Button)findViewById(R.id.radian_btn);
        addMidRadianListener();

        backLeftImg = (ImageView)findViewById(R.id.back_left_img);
        backMidLeftImg = (ImageView)findViewById(R.id.back_mid_left_img);
        backMidRightImg = (ImageView)findViewById(R.id.back_mid_right_img);
        backRightImg = (ImageView)findViewById(R.id.back_right_img);

        radianImg = (ImageView)findViewById(R.id.radian_img);

//        进左按钮;
        forwardTurnLeftBtn = (Button)findViewById(R.id.forward_turn_left_btn);
        addForwardTurnLeftListener();

        //        进中右按钮;
        forwardMidRightBtn = (Button)findViewById(R.id.forward_mid_right_btn);
        addForwardMidRightListener();

        //        进中左按钮;
        forwardMidLeftBtn = (Button)findViewById(R.id.forward_mid_left_btn);
        addForwardMidLeftListener();

        //        进右按钮;
        forwardTurnRightBtn = (Button)findViewById(R.id.forward_turn_right_btn);
        addForwardTurnRightListener();

        forwardLeftImg = (ImageView)findViewById(R.id.forward_left_img);
        forwardMidLeftImg = (ImageView)findViewById(R.id.forward_mid_left_img);
        forwardMidRightImg = (ImageView)findViewById(R.id.forward_mid_right_img);
        forwardRightImg = (ImageView)findViewById(R.id.forward_right_img);
    }

    private void initViewParams(){
        LayoutParams params = surfaceView.getLayoutParams();
        Point p = DisplayUtil.getScreenMetrics(this);
        params.width = p.x;
        params.height = p.y;
        previewRate = DisplayUtil.getScreenRate(this); //默认全屏的比例预览
        surfaceView.setLayoutParams(params);
    }

    @Override
    public void cameraHasOpened() {
        // TODO Auto-generated method stub
        SurfaceHolder holder = surfaceView.getSurfaceHolder();
        CameraInterface.getInstance().doStartPreview(holder, previewRate);
    }

    //        左转按钮;
    private void addTurnLeftListener() {
        turnLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (leftCount) {
                    case 1: {
                        backLeftImg.setImageResource(R.drawable.back_left_two);
                        leftCount++;
                        break;
                    }
                    case 2: {
                        backLeftImg.setImageResource(R.drawable.back_left_three);
                        leftCount++;
                        break;
                    }
                    case 3: {
                        backLeftImg.setImageResource(R.drawable.back_left_four);
                        leftCount++;
                        break;
                    }
                    case 4: {
                        backLeftImg.setImageResource(R.drawable.back_left_five);
                        leftCount++;
                        break;
                    }
                    case 5: {
                        backLeftImg.setImageResource(R.drawable.back_left_six);
                        leftCount++;
                        break;
                    }
                    case 6: {
                        backLeftImg.setImageResource(R.drawable.back_left_seven);
                        leftCount++;
                        break;
                    }
                    case 7: {
                        backLeftImg.setImageResource(R.drawable.back_left_eight);
                        leftCount++;
                        break;
                    }
                    case 8: {
                        backLeftImg.setImageResource(R.drawable.back_left_nine);
                        leftCount++;
                        break;
                    }
                    case 9: {
                        backLeftImg.setImageResource(R.drawable.back_left_ten);
                        leftCount++;
                        break;
                    }
                    case 10: {
                        backLeftImg.setImageResource(R.drawable.back_left_one);
                        ;
                        leftCount = 1;
                        break;
                    }
                }
            }
        });
    }

    //        右转按钮;
    private void addTurnRightListener() {
        turnRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (rightCount) {
                    case 1: {
                        backRightImg.setImageResource(R.drawable.back_right_two);
                        rightCount++;
                        break;
                    }
                    case 2: {
                        backRightImg.setImageResource(R.drawable.back_right_three);
                        rightCount++;
                        break;
                    }
                    case 3: {
                        backRightImg.setImageResource(R.drawable.back_right_four);
                        rightCount++;
                        break;
                    }
                    case 4: {
                        backRightImg.setImageResource(R.drawable.back_right_five);
                        rightCount++;
                        break;
                    }
                    case 5: {
                        backRightImg.setImageResource(R.drawable.back_right_six);
                        rightCount++;
                        break;
                    }
                    case 6: {
                        backRightImg.setImageResource(R.drawable.back_right_seven);
                        rightCount++;
                        break;
                    }
                    case 7: {
                        backRightImg.setImageResource(R.drawable.back_right_eight);
                        rightCount++;
                        break;
                    }
                    case 8: {
                        backRightImg.setImageResource(R.drawable.back_right_nine);
                        rightCount++;
                        break;
                    }
                    case 9: {
                        backRightImg.setImageResource(R.drawable.back_right_ten);
                        rightCount++;
                        break;
                    }
                    case 10: {
                        backRightImg.setImageResource(R.drawable.back_right_one);
                        rightCount = 1;
                        break;
                    }
                }
            }
        });
    }

    //        中右按钮;
    private void addMidRightListener() {
        midRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (midRightCount) {
                    case 1: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_two);
                        midRightCount++;
                        break;
                    }
                    case 2: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_three);
                        midRightCount++;
                        break;
                    }
                    case 3: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_four);
                        midRightCount++;
                        break;
                    }
                    case 4: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_five);
                        midRightCount++;
                        break;
                    }
                    case 5: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_six);
                        midRightCount++;
                        break;
                    }
                    case 6: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_seven);
                        midRightCount++;
                        break;
                    }
                    case 7: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_eight);
                        midRightCount++;
                        break;
                    }
                    case 8: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_nine);
                        midRightCount++;
                        break;
                    }
                    case 9: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_ten);
                        midRightCount++;
                        break;
                    }
                    case 10: {
                        backMidRightImg.setImageResource(R.drawable.back_mid_left_one);
                        midRightCount = 1;
                        break;
                    }
                }
            }
        });
    }

    //        中左按钮;
    private void addMidLeftListener() {
        midLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (midLeftCount) {
                    case 1: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_two);
                        midLeftCount++;
                        break;
                    }
                    case 2: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_three);
                        midLeftCount++;
                        break;
                    }
                    case 3: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_four);
                        midLeftCount++;
                        break;
                    }
                    case 4: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_five);
                        midLeftCount++;
                        break;
                    }
                    case 5: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_six);
                        midLeftCount++;
                        break;
                    }
                    case 6: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_seven);
                        midLeftCount++;
                        break;
                    }
                    case 7: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_eight);
                        midLeftCount++;
                        break;
                    }
                    case 8: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_nine);
                        midLeftCount++;
                        break;
                    }
                    case 9: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_ten);
                        midLeftCount++;
                        break;
                    }
                    case 10: {
                        backMidLeftImg.setImageResource(R.drawable.back_mid_left_one);
                        midLeftCount = 1;
                        break;
                    }
                }
            }
        });
    }

    //        左边弧度按钮;
    private void addMidRadianListener() {
        radianBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                41 - radianCount 获取图片名字;
                if ( radianCount < 41 && radianCount > 0) {
                    int id = getResources().getIdentifier("radian_left_" + (41 - radianCount ), "drawable", getApplicationContext().getPackageName());
                    radianImg.setImageDrawable(getResources().getDrawable(id));
                    radianCount++;
                } else  if ( radianCount == 41) {
                    radianImg.setImageResource(R.drawable.radian_mid);
                    radianCount = 1;
                }
//                else if ( radianCount > 41 && radianCount < 81) {
//                    int id = getResources().getIdentifier("radian_right_" + (radianCount - 41), "drawable", getApplicationContext().getPackageName());
//                    radianImg.setImageDrawable(getResources().getDrawable(id));
//                    radianCount++;
//                } else  if ( radianCount == 81 ) {
//
//                }


            }
        });
    }

    //        进左按钮;
    private void addForwardTurnLeftListener() {
        forwardTurnLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (forwardLeftCount) {
                    case 1: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_two);
                        forwardLeftCount++;
                        break;
                    }
                    case 2: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_three);
                        forwardLeftCount++;
                        break;
                    }
                    case 3: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_four);
                        forwardLeftCount++;
                        break;
                    }
                    case 4: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_five);
                        forwardLeftCount++;
                        break;
                    }
                    case 5: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_six);
                        forwardLeftCount++;
                        break;
                    }
                    case 6: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_seven);
                        forwardLeftCount++;
                        break;
                    }
                    case 7: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_eight);
                        forwardLeftCount++;
                        break;
                    }
                    case 8: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_nine);
                        forwardLeftCount++;
                        break;
                    }
                    case 9: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_ten);
                        forwardLeftCount++;
                        break;
                    }
                    case 10: {
                        forwardLeftImg.setImageResource(R.drawable.forward_left_one);
                        forwardLeftCount = 1;
                        break;
                    }
                }
            }
        });
    }

    //        进中右按钮;
    private void addForwardMidRightListener() {
        forwardMidRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (forwardMidRightCount) {
                    case 1: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_two);
                        forwardMidRightCount++;
                        break;
                    }
                    case 2: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_three);
                        forwardMidRightCount++;
                        break;
                    }
                    case 3: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_four);
                        forwardMidRightCount++;
                        break;
                    }
                    case 4: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_five);
                        forwardMidRightCount++;
                        break;
                    }
                    case 5: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_six);
                        forwardMidRightCount++;
                        break;
                    }
                    case 6: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_seven);
                        forwardMidRightCount++;
                        break;
                    }
                    case 7: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_eight);
                        forwardMidRightCount++;
                        break;
                    }
                    case 8: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_nine);
                        forwardMidRightCount++;
                        break;
                    }
                    case 9: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_ten);
                        forwardMidRightCount++;
                        break;
                    }
                    case 10: {
                        forwardMidRightImg.setImageResource(R.drawable.forward_mid_left_one);
                        forwardMidRightCount = 1;
                        break;
                    }
                }
            }
        });
    }

    //        进中左按钮;
    private void addForwardMidLeftListener() {
        forwardMidLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (forwardMidLeftCount) {
                    case 1: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_two);
                        forwardMidLeftCount++;
                        break;
                    }
                    case 2: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_three);
                        forwardMidLeftCount++;
                        break;
                    }
                    case 3: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_four);
                        forwardMidLeftCount++;
                        break;
                    }
                    case 4: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_five);
                        forwardMidLeftCount++;
                        break;
                    }
                    case 5: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_six);
                        forwardMidLeftCount++;
                        break;
                    }
                    case 6: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_seven);
                        forwardMidLeftCount++;
                        break;
                    }
                    case 7: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_eight);
                        forwardMidLeftCount++;
                        break;
                    }
                    case 8: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_nine);
                        forwardMidLeftCount++;
                        break;
                    }
                    case 9: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_ten);
                        forwardMidLeftCount++;
                        break;
                    }
                    case 10: {
                        forwardMidLeftImg.setImageResource(R.drawable.forward_mid_left_one);
                        forwardMidLeftCount = 1;
                        break;
                    }
                }
            }
        });
    }

    //        进右按钮;
    private void addForwardTurnRightListener() {
        forwardTurnRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (forwardRightCount) {
                    case 1: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_two);
                        forwardRightCount++;
                        break;
                    }
                    case 2: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_three);
                        forwardRightCount++;
                        break;
                    }
                    case 3: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_four);
                        forwardRightCount++;
                        break;
                    }
                    case 4: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_five);
                        forwardRightCount++;
                        break;
                    }
                    case 5: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_six);
                        forwardRightCount++;
                        break;
                    }
                    case 6: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_seven);
                        forwardRightCount++;
                        break;
                    }
                    case 7: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_eight);
                        forwardRightCount++;
                        break;
                    }
                    case 8: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_nine);
                        forwardRightCount++;
                        break;
                    }
                    case 9: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_ten);
                        forwardRightCount++;
                        break;
                    }
                    case 10: {
                        forwardRightImg.setImageResource(R.drawable.forward_right_one);
                        forwardRightCount = 1;
                        break;
                    }
                }
            }
        });
    }
}
