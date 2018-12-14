package burger.burgerized;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class bk_sides extends Fragment {
    static float totalOrders;
    private static final String TAG = "WC_Fragment";
    ImageButton item1, item2, item3, item4;
    DatabaseHelper mDatabaseHelper;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.bk_sides, container, false);
        item1 = view.findViewById(R.id.item1);
        item2 = view.findViewById(R.id.item2);
        item3 = view.findViewById(R.id.item3);
        item4 = view.findViewById(R.id.item4);
        mDatabaseHelper = new DatabaseHelper(getActivity());


        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String order = "P60 - Fries";
                AddData(order);
                totalOrders += 60;
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String order = "P70 - 4PC Chicken Nuggets";
                AddData(order);
                totalOrders += 70;
            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String order = "P60 - Frosty";
                AddData(order);
                totalOrders += 60;
            }
        });
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String order = "P40 - Soda";
                AddData(order);
                totalOrders += 40;
            }
        });
        return view;
    }
    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);
        Toast.makeText(getActivity(), "Item has been added to bag",Toast.LENGTH_SHORT).show();
    }

}
