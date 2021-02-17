package jp.ac.u_ryukyu.ie.e195746;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView turnLabel;     //テキスト
    private ImageView lattice;      //格子の画像

    private int key = 1;

    private String[] board[] = new String[3][3];


    @Override
    public void onBackPressed() {}  //戻るボタンの無効化

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        turnLabel = findViewById(R.id.turnLabel);
        lattice = findViewById(R.id.lattice);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        final FrameLayout frame = findViewById(R.id.frame);

        ScaleAnimation sa = new ScaleAnimation(
         0.2f, 1.0f, 0.2f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(2000); // 3000msかけてアニメーションする
        lattice.startAnimation(sa); // アニメーション適用
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {

            // タップした指が離れた時に処理が起こる
            case MotionEvent.ACTION_UP:

                // フレームレイアウト
                final FrameLayout fl = findViewById(R.id.frame);
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
                //key = key * (-1);

                switch (tap_position(pointX,pointY)){
                    case 1:
                        if(board[0][0] == null){
                            setImageView(fl,resources,lattice.getX(),lattice.getY(),lattice.getWidth()/3,lattice.getHeight()/3);
                            board[0][0] = String.valueOf(resources);
                            key = key * (-1);
                            if(isjudge(String.valueOf(resources))){
                                turnLabel.setText("勝利！！");
                                System.out.println("勝利！");
                            }
                        }
                        break;

                    case 2:
                        if(board[0][1] == null) {
                            setImageView(fl,resources,lattice.getX()+lattice.getWidth()/3, lattice.getY(),lattice.getWidth()/3,lattice.getHeight()/3);
                            board[0][1] = String.valueOf(resources);
                            key = key * (-1);
                            if(isjudge(String.valueOf(resources))){
                                turnLabel.setText("勝利！！");
                                System.out.println("勝利！");
                            }
                        }
                        break;

                    case 3:
                        if(board[0][2] == null) {
                            setImageView(fl,resources,lattice.getX()+lattice.getWidth()/3*2, lattice.getY(),lattice.getWidth()/3,lattice.getHeight()/3);
                            board[0][2] = String.valueOf(resources);
                            key = key * (-1);
                            if(isjudge(String.valueOf(resources))){
                                turnLabel.setText("勝利！！");
                                System.out.println("勝利！");
                            }
                        }
                        break;

                    case 4:
                        if(board[1][0] == null) {
                            setImageView(fl,resources,lattice.getX(),lattice.getY()+lattice.getHeight()/3,lattice.getWidth()/3,lattice.getHeight()/3);
                            board[1][0] = String.valueOf(resources);
                            key = key * (-1);
                            if(isjudge(String.valueOf(resources))){
                                turnLabel.setText("勝利！！");
                                System.out.println("勝利！");
                            }
                        }
                        break;

                    case 5:
                        if(board[1][1] == null) {
                            setImageView(fl,resources,lattice.getX()+lattice.getWidth()/3,lattice.getY()+lattice.getHeight()/3,lattice.getWidth()/3,lattice.getHeight()/3);
                            board[1][1] = String.valueOf(resources);
                            key = key * (-1);
                            if(isjudge(String.valueOf(resources))){
                                turnLabel.setText("勝利！！");
                                System.out.println("勝利！");
                            }
                        }
                        break;

                    case 6:
                        if(board[1][2] == null) {
                            setImageView(fl,resources,lattice.getX()+lattice.getWidth()/3*2,lattice.getY()+lattice.getHeight()/3,lattice.getWidth()/3,lattice.getHeight()/3);
                            board[1][2] = String.valueOf(resources);
                            key = key * (-1);
                            if(isjudge(String.valueOf(resources))){
                                turnLabel.setText("勝利！！");
                                System.out.println("勝利！");
                            }
                        }
                        break;

                    case 7:
                        if(board[2][0] == null) {
                            setImageView(fl,resources,lattice.getX(),lattice.getY()+lattice.getHeight()/3*2,lattice.getWidth()/3,lattice.getHeight()/3);
                            board[2][0] = String.valueOf(resources);
                            key = key * (-1);
                            if(isjudge(String.valueOf(resources))){
                                turnLabel.setText("勝利！！");
                                System.out.println("勝利！");
                            }
                        }
                        break;

                    case 8:
                        if(board[2][1] == null) {
                            setImageView(fl,resources,lattice.getX()+lattice.getWidth()/3,lattice.getY()+lattice.getHeight()/3*2,lattice.getWidth()/3,lattice.getHeight()/3);
                            board[2][1] = String.valueOf(resources);
                            key = key * (-1);
                            if(isjudge(String.valueOf(resources))){
                                turnLabel.setText("勝利！！");
                                System.out.println("勝利！");
                            }
                        }
                        break;

                    case 9:
                        if(board[2][2] == null) {
                            setImageView(fl,resources,lattice.getX()+lattice.getWidth()/3*2,lattice.getY()+lattice.getHeight()/3*2,lattice.getWidth()/3,lattice.getHeight()/3);
                            board[2][2] = String.valueOf(resources);
                            key = key * (-1);
                            if(isjudge(String.valueOf(resources))){
                                turnLabel.setText("勝利！！");
                                System.out.println("勝利！");
                            }
                        }
                        break;
                }

                break;
        }

        return false;
    }

    public int tap_position(float x, float y){
        // タップの位置を入手
        // 1 2 3
        // 4 5 6
        // 7 8 9
        if( (lattice.getY()) < y && y < (lattice.getY()+lattice.getHeight()/3) ){
            if( (lattice.getX()) < x && x < (lattice.getX()+lattice.getWidth()/3) ){
                return 1;
            }
            if( (lattice.getX()+lattice.getWidth()/3) < x && x < (lattice.getX()+lattice.getWidth()/3*2) ){
                return 2;
            }
            if( (lattice.getX()+lattice.getWidth()/3*2) < x && x < (lattice.getX()+lattice.getWidth()) ) {
                return 3;
            }
        }
        if( (lattice.getY()+lattice.getHeight()/3) < y && y < (lattice.getY()+lattice.getHeight()/3*2) ){
            if( (lattice.getX()) < x && x < (lattice.getX()+lattice.getWidth()/3) ){
                return 4;
            }
            if( (lattice.getX()+lattice.getWidth()/3) < x && x < (lattice.getX()+lattice.getWidth()/3*2) ){
                return 5;
            }
            if( (lattice.getX()+lattice.getWidth()/3*2) < x && x < (lattice.getX()+lattice.getWidth()) ){
                return 6;
            }
        }
        if( (lattice.getY()+lattice.getHeight()/3*2) < y && y < (lattice.getY()+lattice.getHeight()) ){
            if( (lattice.getX()) < x && x < (lattice.getX()+lattice.getWidth()/3) ){
                return 7;
            }
            if( (lattice.getX()+lattice.getWidth()/3) < x && x < (lattice.getX()+lattice.getWidth()/3*2) ){
                return 8;
            }
            if( (lattice.getX()+lattice.getWidth()/3*2) < x && x < (lattice.getX()+lattice.getWidth()) ){
                return 9;
            }
        }


        return 0;
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

    boolean isjudge(String shape) {
        if (isMatch(0,0, shape) && isMatch(0, 1, shape) && isMatch(0, 2, shape)) {
            return true; }

        if (isMatch(1,0, shape) && isMatch(1,1, shape) && isMatch(1,2, shape)) {
            return true; }

        if (isMatch(2,0, shape) && isMatch(2,1, shape) && isMatch(2,2, shape)) {
            return true; }

        if (isMatch(0,0, shape) && isMatch(1,0, shape) && isMatch(2,0, shape)) {
            return true; }

        if (isMatch(0,1, shape) && isMatch(1,1, shape) && isMatch(2,1, shape)) {
            return true; }

        if (isMatch(0,2, shape) && isMatch(1,2, shape) && isMatch(2,2, shape)) {
            return true; }

        if (isMatch(0,0, shape) && isMatch(1,1, shape) && isMatch(2,2, shape)) {
            return true; }

        if (isMatch(0,2, shape) && isMatch(1,1, shape) && isMatch(2,0, shape)) {
            return true; }

        else {
            return false;
        }
    }
    boolean isMatch(int x, int y, String shape){
        if(board[x][y] != null) {
            if (board[x][y].equals(shape)) {
                System.out.println("マッチ成功");
                return true;
            }
        }
        return false;
    }

}