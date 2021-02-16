package jp.ac.u_ryukyu.ie.e195746;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView turnLabel;     //テキスト
    private ImageView lattice;      //格子の画像

    private int key = 1;


    @Override
    public void onBackPressed() {}  //戻るボタンの無効化

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // フレームレイアウト
        final FrameLayout frame = findViewById(R.id.frame);

        turnLabel = findViewById(R.id.turnLabel);

        lattice = findViewById(R.id.lattice);

        // onCreate実行後に処理したいため↓
        ViewTreeObserver observer = frame.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener()
                {
                    @Override
                    public void onGlobalLayout()
                    {
                        // 処理したい内容
                        lattice.setY(frame.getHeight()/2 - lattice.getHeight()/2);
                        lattice.setX(frame.getWidth()/2 - lattice.getWidth()/2);
                    }
                });
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            // タップした指が離れた時に処理が起こる
            case MotionEvent.ACTION_UP:
                // フレームレイアウト
                final FrameLayout frame = findViewById(R.id.frame);
                // X軸の取得
                float pointX = motionEvent.getX();
                // Y軸の取得
                float pointY = motionEvent.getY();

                // 画像のリソース
                int resources;

                // １回ごとに切り替わるように設計
                if(key==1){
                    resources = R.drawable.circle;
                }else {
                    resources = R.drawable.cross;
                }
                key = key * (-1);

                setUnit(frame, resources, pointX, pointY);

                break;
        }

        return false;
    }



    public void setUnit(FrameLayout layout, int drawble, float x, float y){

        ImageView lattice = findViewById(R.id.lattice);

        if (lattice.getX() < x && x < lattice.getX() + lattice.getWidth() / 3) {
            if (lattice.getY() < y && y < lattice.getY() + lattice.getHeight() / 3) {
                setImageView(layout,drawble,lattice.getX(),lattice.getY(),320,320);
            }
            if (lattice.getY()+lattice.getHeight()/3 < y && y < lattice.getY() + lattice.getHeight()/3*2) {
                setImageView(layout,drawble,lattice.getX(),lattice.getY()+lattice.getHeight()/3,320,320);
            }
            if (lattice.getY()+lattice.getHeight()/3*2 < y && y < lattice.getY() + lattice.getHeight()) {
                setImageView(layout,drawble,lattice.getX(),lattice.getY()+lattice.getHeight()/3*2,320,320);
            }

        }
        if (lattice.getX()+lattice.getWidth()/3 < x && x < lattice.getX() + lattice.getWidth()/3*2) {
            if (lattice.getY() < y && y < lattice.getY() + lattice.getHeight() / 3) {
                setImageView(layout,drawble,lattice.getX()+lattice.getWidth()/3,lattice.getY(),320,320);
            }
            if (lattice.getY()+lattice.getHeight()/3 < y && y < lattice.getY() + lattice.getHeight()/3*2) {
                setImageView(layout,drawble,lattice.getX()+lattice.getWidth()/3,lattice.getY()+lattice.getHeight()/3,320,320);
            }
            if (lattice.getY()+lattice.getHeight()/3*2 < y && y < lattice.getY() + lattice.getHeight()) {
                setImageView(layout,drawble,lattice.getX()+lattice.getWidth()/3,lattice.getY()+lattice.getHeight()/3*2,320,320);
            }

        }
        if (lattice.getX()+lattice.getWidth()/3*2 < x && x < lattice.getX() + lattice.getWidth()) {
            if (lattice.getY() < y && y < lattice.getY() + lattice.getHeight() / 3) {
                setImageView(layout,drawble,lattice.getX()+lattice.getWidth()/3*2,lattice.getY(),320,320);
            }
            if (lattice.getY()+lattice.getHeight()/3 < y && y < lattice.getY() + lattice.getHeight()/3*2) {
                setImageView(layout,drawble,lattice.getX()+lattice.getWidth()/3*2,lattice.getY()+lattice.getHeight()/3,320,320);
            }
            if (lattice.getY()+lattice.getHeight()/3*2 < y && y < lattice.getY() + lattice.getHeight()) {
                setImageView(layout,drawble,lattice.getX()+lattice.getWidth()/3*2,lattice.getY()+lattice.getHeight()/3*2,320,320);
            }

        }

    }

    public void setImageView(FrameLayout layout, int resource, float x, float y, int width, int height){
        // ImageViewのインスタンス生成
        ImageView imageView = new ImageView(this);
        // drawableの画像を指定
        imageView.setImageResource(resource);


        // 画像の縦横サイズをimageViewのサイズとして設定
        FrameLayout.LayoutParams layoutParams =
                new FrameLayout.LayoutParams(width, height);
        imageView.setLayoutParams(layoutParams);

        imageView.setX(x);
        imageView.setY(y);

        // layoutにimageViewを追加
        layout.addView(imageView);

    }
}