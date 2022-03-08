package ma.enset.tprestapi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

import ma.enset.tprestapi.model.Article;

public class NewsDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        Intent intent=getIntent();
        Article article =(Article)intent.getSerializableExtra("user");
        TextView textView=findViewById(R.id.textViewtitle);
        TextView textView1=findViewById(R.id.textViewAuthe);
        TextView textView2=findViewById(R.id.textViewpublishedAt);
        TextView textView3=findViewById(R.id.textViewcontent);

        ImageView imageView=findViewById(R.id.imageViewProfile);
        textView1.setText(article.getAuthor());
        textView.setText(article.getTitle());
        textView2.setText(article.getPublishedAt());
        textView3.setText(article.getContent());


        Runnable thread= new Runnable(){
             @Override
             public void run() {
                 try {
                     Log.i("info", article.getUrlToImage());
                 URL url=new URL(article.getUrlToImage());
                 Bitmap bitmap= BitmapFactory.decodeStream(url.openStream());
                 imageView.setImageBitmap(bitmap);

                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         };
        Thread t=new Thread(thread);
        t.start();



    }
}
