package ma.enset.tprestapi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ma.enset.tprestapi.model.Article;
import ma.enset.tprestapi.model.ListArticleAdapter;
import ma.enset.tprestapi.model.ListArticleResonse;
import ma.enset.tprestapi.service.RestServiceAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // StrictMode.ThreadPolicy strictMode=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(strictMode);

        ListView listViewUsers=findViewById(R.id.listViewUsers);
        EditText editTextSearch=findViewById(R.id.editTextSearch);
        Button buttonSearch=findViewById(R.id.buttonSearch);
        EditText editTextDate=findViewById(R.id.editTextDate);

        List<Article> data=new ArrayList<>();
        //ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);
        ListArticleAdapter adapter=new ListArticleAdapter(this,R.layout.list_user_item,data);
        listViewUsers.setAdapter(adapter);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RestServiceAPI serviceAPI=retrofit.create(RestServiceAPI.class);

        listViewUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),data.get(i).getLogin(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), NewsDetailsActivity.class);
                intent.putExtra("user",data.get(i));
                startActivity(intent);

            }
        });
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                data.clear();
                String key=editTextSearch.getText().toString();
                String  d= editTextDate.getText().toString();
                System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+d);
                LocalDate date1=LocalDate.of(2020,12,12);
                java.sql.Date date2=Date.valueOf(d);

                Call<ListArticleResonse> callUsers=serviceAPI.listUsersByKey(key,date2,"3cf8c4eb320946bf9d88200dd85311b3");
                System.out.println("============================"+callUsers.request()+"================");
                callUsers.enqueue(new Callback<ListArticleResonse>() {
                    @Override
                    public void onResponse(Call<ListArticleResonse> call, Response<ListArticleResonse> response) {
                        ListArticleResonse listUsers=response.body();

                        for (Article article :listUsers.getUsers()) {
                            data.add(article);
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<ListArticleResonse> call, Throwable t) {
                        Log.e("error","Erreur de réseau");
                    }
                });
            }
        });

    }
}