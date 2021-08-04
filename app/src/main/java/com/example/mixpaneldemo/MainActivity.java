package com.example.mixpaneldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MixpanelAPI mMixpanel;

    private MyCartMedicineDB cartMedicineDB;

    List<MyCartMedicine> myCartMedicines = new ArrayList<>();

    TextView dataShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMixpanel = MixpanelAPI.getInstance(this, "5a955118f54c13439ff3191876d0d659");

        dataShow = findViewById(R.id.dataShow);

        cartMedicineDB = MyCartMedicineDB.getInstance(this);

        showDAta();

        try {
            sendToMixpanel();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void addDataToRoomDatabase() {
        MyCartMedicine cartMedicine = new MyCartMedicine(0,"aaaa",10,"peace",10.00);
        cartMedicineDB.cartMedicineDao().insert(cartMedicine);
        MyCartMedicine cartMedicine2 = new MyCartMedicine(1,"bbbb",20,"peace",10.00);
        cartMedicineDB.cartMedicineDao().insert(cartMedicine2);

        showDAta();
    }

    private void showDAta() {
        myCartMedicines.clear();
        myCartMedicines.addAll(cartMedicineDB.cartMedicineDao().getAll());
        dataShow.setText(myCartMedicines.toString()+"");
        Toast.makeText(this, "Now Show"+myCartMedicines.toString(), Toast.LENGTH_SHORT).show();
    }


    private void sendToMixpanel() throws JSONException {
        JSONObject props = new JSONObject();
        props.put("source", "Pat's affiliate site");
        props.put("Opted out of email", true);
        mMixpanel.track("Sign Up", props);
    }

    public void update(View view) {
        MyCartMedicine cartMedicine2 = new MyCartMedicine(0,"zzzzz",100,"pack",500.00);
        cartMedicineDB.cartMedicineDao().update(cartMedicine2);
        showDAta();
    }

    public void add(View view) {

        addDataToRoomDatabase();
    }

    public void delete(View view) {
        if (myCartMedicines.size()>0)
            cartMedicineDB.cartMedicineDao().delete(myCartMedicines.get(0));
            showDAta();


    }
}