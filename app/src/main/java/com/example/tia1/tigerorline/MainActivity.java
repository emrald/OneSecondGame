package com.example.tia1.tigerorline;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btntiger, btnlion;
    ImageView imgmain;
    int counter = 0;

    ProgressBar mprogressBar;
    TextView textView2;
    int[] text_array = {1, 2};
    int j = 0;
    int random;
    private long countDown = 1000;

    private long interval = 1000;
    long difference;

    long startTime;

    int[] array_tiger = {R.drawable.ta, R.drawable.la, R.drawable.tb, R.drawable.lb, R.drawable.tc, R.drawable.lc,
            R.drawable.td, R.drawable.ld, R.drawable.te, R.drawable.le, R.drawable.tf, R.drawable.lf,
            R.drawable.tg, R.drawable.lg, R.drawable.th, R.drawable.lh, R.drawable.ti, R.drawable.li,
            R.drawable.tj,R.drawable.lj};

    //  int[] array_lion = {R.drawable.la,R.drawable.lb,R.drawable.lc};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btntiger = (Button) findViewById(R.id.btntiger);
        btnlion = (Button) findViewById(R.id.btnlion);

        textView2 = (TextView) findViewById(R.id.textView2);

        imgmain = (ImageView) findViewById(R.id.imgmain);

        //   imgmain.setBackgroundResource(array_tiger[getRandomNumber()]);
        /*Timer myTimer;
        myTimer = new Timer();
        myTimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {*/

        //  }
       /* }, 0, 2000);*/

        UpdateTask exe = new UpdateTask(MainActivity.this);
        exe.execute();

        mprogressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
        random = new Random().nextInt(20);
        imgmain.setBackgroundResource(array_tiger[random]);

    }

    private int getRandomNumber() {
        //Note that general syntax is Random().nextInt(n)
        //It results in range 0-4
        //So it should be equal to number of images in images[] array
        return new Random().nextInt(20);
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        if(imgmain != null)
            imgmain.setBackgroundResource(array_tiger[getRandomNumber()]);
    }*/
    public class UpdateTask extends AsyncTask<Void, Void, Void> {
        private Handler handler;
        final MyCounter timer = new MyCounter(countDown, interval);

        public UpdateTask(Activity activity) {
           /* new Handler().postDelayed(new Runnable() {

                                          @Override
                                          public void run() {

                                              //TODO after 9 sec

                                              imgmain.setBackgroundResource(array_tiger[getRandomNumber()]);
                                          }
                                      }, 2000
            );*/
            /*new Thread() {
                public void run() {
                    for(j=0;j<2;j++){
                    try {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                          *//*          random_number = getRandomNumber();
                                    imgmain.setBackgroundResource(array_tiger[random_number]);
*//*
                                ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, 100);
                                anim.setDuration(2000);
                                anim.setInterpolator(new DecelerateInterpolator());
                                anim.start();

                                textView2.setText(text_array[j] + "");

                            }
                        });
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                }
            }.start();*/
            startTime = System.currentTimeMillis();

            difference = System.currentTimeMillis() - startTime;
        }

        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }

        protected void onPostExecute(Void result) {

           /* if (timer.onFinish(); > 2000) {
                Intent intent = new Intent(MainActivity.this, ActivityScore.class);
                intent.putExtra("score", counter + "");
                startActivity(intent);
            } else {*/
                btntiger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new Thread() {
                            public void run() {
                                for(j=0;j<2;j++){
                                    try {
                                        runOnUiThread(new Runnable() {

                                            @Override
                                            public void run() {

                                                ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, 100);
                                                anim.setDuration(1000);
                                                anim.setInterpolator(new DecelerateInterpolator());
                                                anim.start();

                                                try {
                                                    textView2.setText(text_array[j] + "");
                                                }
                                                catch(Exception e)
                                                {
                                                    Log.e("Error...",e.getMessage()+"");
                                                }


                                            }
                                        });
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        Log.e("Error...",e.getMessage()+"");
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }.start();

                        Log.e("random btntiger...", random + "");
                        if (random % 2 == 0) {
                            counter++;
                            random = new Random().nextInt(20);
                            imgmain.setBackgroundResource(array_tiger[random]);
                            timer.start();
                            //  Log.e("Counter...",counter+"");
                        } else {
                            // Toast.makeText(MainActivity.this, "sorry...", Toast.LENGTH_SHORT).show();
                            // return;
                            Intent intent = new Intent(MainActivity.this, ActivityScore.class);
                            intent.putExtra("score", counter + "");
                            startActivity(intent);
                            timer.cancel();
                        }
                    }
                });

                btnlion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new Thread() {
                            public void run() {
                                for(j=0;j<2;j++){
                                    try {
                                        runOnUiThread(new Runnable() {

                                            @Override
                                            public void run() {

                                                ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, 100);
                                                anim.setDuration(1000);
                                                anim.setInterpolator(new DecelerateInterpolator());
                                                anim.start();

                                                try {
                                                    textView2.setText(text_array[j] + "");
                                                }
                                                catch(Exception e)
                                                {
                                                    Log.e("Error...",e.getMessage()+"");
                                                }
                                            }
                                        });
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        Log.e("Error...",e.getMessage()+"");
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }.start();

                        Log.e("random btnlion...", random + "");
                  /* btnlion.setEnabled(false);

                    Timer buttonTimer = new Timer();
                    buttonTimer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    btnlion.setEnabled(true);
                                }
                            });
                        }
                    }, 2000);*/

                        if (random % 2 == 1) {
                            counter++;
                            random = new Random().nextInt(20);
                            imgmain.setBackgroundResource(array_tiger[random]);
                            timer.start();
                        } else {
                            Intent intent = new Intent(MainActivity.this, ActivityScore.class);
                            intent.putExtra("score", counter + "");
                            startActivity(intent);
                            timer.cancel();
                        }
                    }
                });
         //   }
        }

        public class MyCounter extends CountDownTimer {

            public MyCounter(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override
            public void onFinish() {
                System.out.println("Timer Completed.");
                Intent intent = new Intent(MainActivity.this, ActivityScore.class);
                intent.putExtra("score", counter + "");
                startActivity(intent);
                //  tv.setText("Timer Completed.");
            }

            @Override
            public void onTick(long millisUntilFinished) {
                //     tv.setText((millisUntilFinished/1000)+"");
                System.out.println("Timer  : " + (millisUntilFinished / 1000));
            }
        }
    }
}

