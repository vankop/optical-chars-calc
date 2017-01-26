package ivan.kopeykin.opticalcharacteristicscalc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ivan.kopeykin.opticalcharacteristicscalc.domain.Cable;

public class CableList extends Activity {

    private List<Cable> init() {
        List<Cable> dataSet = new ArrayList<>();
        Cable smf28e = new Cable();
        smf28e.setMark("SMF-28e");
        smf28e.setL(1550);
        smf28e.setL0D(1310);
        smf28e.setS0(0.092);

        Cable sm332 = new Cable();
        sm332.setMark("SM332");
        sm332.setL(1550);
        sm332.setL0D(1311);
        sm332.setS0(0.092);

        Cable sm8_125 = new Cable();
        sm8_125.setMark("SM8/125");
        sm8_125.setL(1550);
        sm8_125.setL0D(1310);
        sm8_125.setS0(0.092);

        Cable PureBand = new Cable();
        PureBand.setMark("Pure Band");
        PureBand.setL(1550);
        PureBand.setL0D(1300);
        PureBand.setS0(0.086);

        Cable alcatel = new Cable();
        alcatel.setMark("Alcatel 6900");
        alcatel.setL(1550);
        alcatel.setL0D(1310);
        alcatel.setS0(0.092);

        dataSet.add(smf28e);
        dataSet.add(sm332);
        dataSet.add(sm8_125);
        dataSet.add(PureBand);
        dataSet.add(alcatel);

        return dataSet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cable_list);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycleViewCables);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Cable> dataSet = this.init(); //TODO Load from Db
        RecyclerView.Adapter mAdapter = new CablesAdapter(dataSet, new CableClickCallback() {
            @Override
            public void Callback(Cable cable) {
                Intent intent = new Intent();
                intent.putExtra("mark", cable.getMark());
                intent.putExtra("l", cable.getL());
                intent.putExtra("l0", cable.getL0D());
                intent.putExtra("s0", cable.getS0());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
}
