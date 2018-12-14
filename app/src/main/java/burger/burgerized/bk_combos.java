package burger.burgerized;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class bk_combos extends Fragment {
    private static final String TAG = "WC_Fragment";
    ImageButton item1, item2, item3, item4;
    static float totalOrders;
DatabaseHelper mDatabaseHelper;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.bk_combos, container, false);
        item1 = view.findViewById(R.id.combo1);
        item2 = view.findViewById(R.id.combo2);
        item3 = view.findViewById(R.id.combo3);
        item4 = view.findViewById(R.id.combo4);
        mDatabaseHelper = new DatabaseHelper(getActivity());
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ComboBuilder selectedCombo = new Combo1();
                ComboAssembler comboAssembler = new ComboAssembler(selectedCombo);
                comboAssembler.makeCombo();
                Combos builtCombo = comboAssembler.getCombo();
                String order = "P165 - "+builtCombo.getSelectedBurger() + " with " + builtCombo.getSides1() + ", " + builtCombo.getSides2() +
                        ", " + builtCombo.getSides3();
                totalOrders += 165;
                AddData(order);
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ComboBuilder selectedCombo = new Combo2();
                ComboAssembler comboAssembler = new ComboAssembler(selectedCombo);
                comboAssembler.makeCombo();
                Combos builtCombo = comboAssembler.getCombo();
                String order = "P265 - " + builtCombo.getSelectedBurger() + " with " + builtCombo.getSides1() + ", " + builtCombo.getSides2() +
                        ", " + builtCombo.getSides3();
                AddData(order);
                totalOrders += 265;
            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ComboBuilder selectedCombo = new Combo3();
                ComboAssembler comboAssembler = new ComboAssembler(selectedCombo);
                comboAssembler.makeCombo();
                Combos builtCombo = comboAssembler.getCombo();
                String order = "P199 - " + builtCombo.getSelectedBurger() + " with " + builtCombo.getSides1() + ", " + builtCombo.getSides2() +
                        ", " + builtCombo.getSides3();
                AddData(order);
                totalOrders += 199;
            }
        });
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ComboBuilder selectedCombo = new Combo4();
                ComboAssembler comboAssembler = new ComboAssembler(selectedCombo);
                comboAssembler.makeCombo();
                Combos builtCombo = comboAssembler.getCombo();
                String order = "P149 - " + builtCombo.getSelectedBurger() + " with " + builtCombo.getSides1() + ", " + builtCombo.getSides2() +
                        ", " + builtCombo.getSides3();
                AddData(order);
                totalOrders += 149;
            }
        });
        return view;
    }
    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);
        Toast.makeText(getActivity(), "Item has been added to bag",Toast.LENGTH_SHORT).show();
    }
}
