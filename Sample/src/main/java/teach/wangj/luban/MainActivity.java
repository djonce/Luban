package teach.wangj.luban;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;

import teach.wangjie.luban.Luban;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        String imagePath = "/sdcard/jonce/girl.jpg";

        Luban.from(this)
                .load(imagePath)
                .putGear(Luban.THIRD_GEAR)
                .setCompressListener(new Luban.OnCompressListener() {
                    @Override
                    public void onSuccess(File file) {

                        Log.d(TAG, "file name :" + file.getName()
                                + " file size:" + file.length()
                                + " file path:" + file.getAbsolutePath());

                        imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                })
                .launch();
    }
}
