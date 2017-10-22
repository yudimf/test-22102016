package yudimf.id.prelo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import yudimf.id.prelo.R;
import yudimf.id.prelo.adapters.ItemAdapter;
import yudimf.id.prelo.models.Item;

public class LovelistActivity extends AppCompatActivity {

    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovelist);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_item);

        createItemList();

        ItemAdapter itemAdapter = new ItemAdapter(itemList,this);

        recyclerView.setAdapter(itemAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void createItemList(){
        itemList = new ArrayList<>();
        itemList.add(new Item("Barang 1","https://www.gstatic.com/webp/gallery/1.sm.webp","$ 200"));
        itemList.add(new Item("Barang 2","https://www.gstatic.com/webp/gallery/3.sm.webp","$ 50"));
        itemList.add(new Item("Barang 3","https://www.gstatic.com/webp/gallery/4.sm.webp","$ 20"));
        itemList.add(new Item("Barang 4","https://www.gstatic.com/webp/gallery/5.sm.webp","$ 75"));
        itemList.add(new Item("Barang 5","https://www.gstatic.com/webp/gallery/2.sm.webp","$ 150"));
    }
}
