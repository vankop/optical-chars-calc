package ivan.kopeykin.opticalcharacteristicscalc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import ivan.kopeykin.opticalcharacteristicscalc.calc.Calc;
import ivan.kopeykin.opticalcharacteristicscalc.domain.Cable;
import ivan.kopeykin.opticalcharacteristicscalc.domain.CommunicationLine;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final int CABLE_ACTIVITY = 1001;
    private static final int COMMUNICATION_LINE_ACTIVITY = 1002;

    private CommunicationLine communicationLine;
    private Cable cable;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView resultTextView = (TextView)findViewById(R.id.textViewResult);

        findViewById(R.id.buttonCompute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double sigmaN = Calc.sigmaN(cable);
                double dispersionChr = Calc.dispersionChr(communicationLine);
                StringBuilder builder = new StringBuilder();
                NumberFormat formatter = new DecimalFormat("0.#####E0");
                builder.append("Удельная хроматическая дисперсия:\n");
                builder.append(formatter.format(sigmaN));
                builder.append(" пс/км");
                builder.append("\n");
                builder.append("Хроматическая дисперсия волокна:\n");
                builder.append(formatter.format(dispersionChr));
                builder.append(" с/км");
                resultTextView.setText(builder);
            }
        });

        findViewById(R.id.buttonEditCommunicationLine).setOnClickListener(this);
        findViewById(R.id.buttonCreateCable).setOnClickListener(this);
        findViewById(R.id.buttonSelectCables).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("DEBUG", "Activity result with request code:" + requestCode + ";result code:" + resultCode);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CABLE_ACTIVITY:
                    String mark = data.getStringExtra("mark");
                    double l = data.getDoubleExtra("l", 0.0);
                    double l0 = data.getDoubleExtra("l0", 0.0);
                    double s0 = data.getDoubleExtra("s0", 0.0);

                    this.cable = new Cable();
                    this.cable.setL(l);
                    this.cable.setL0D(l0);
                    this.cable.setS0(s0);
                    this.cable.setMark(mark);

                    if (this.communicationLine != null) {
                        this.communicationLine.setCable(this.cable);
                        findViewById(R.id.buttonCompute).setVisibility(View.VISIBLE);
                    }
                    break;
                case COMMUNICATION_LINE_ACTIVITY:
                    double deltaF = data.getDoubleExtra("deltaF", 0.0);
                    double f = data.getDoubleExtra("f", 0.0);
                    double length = data.getDoubleExtra("l", 0.0);

                    this.communicationLine = new CommunicationLine();
                    this.communicationLine.setL(length);
                    this.communicationLine.setDeltaF(deltaF);
                    this.communicationLine.setF(f);

                    if (this.cable != null) {
                        this.communicationLine.setCable(this.cable);
                        findViewById(R.id.buttonCompute).setVisibility(View.VISIBLE);
                    }
                    break;
            }
        } else if (RESULT_CANCELED == resultCode){
            Toast.makeText(this, "Не задано", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.buttonEditCommunicationLine:
                intent = new Intent(this, CommunicationLineActivity.class);
                startActivityForResult(intent, COMMUNICATION_LINE_ACTIVITY);
                break;
            case R.id.buttonCreateCable:
                intent = new Intent(this, CableActivity.class);
                startActivityForResult(intent, CABLE_ACTIVITY);
                break;
            case R.id.buttonSelectCables:
                intent = new Intent(this, CableList.class);
                startActivityForResult(intent, CABLE_ACTIVITY);
                break;
        }
    }
}
