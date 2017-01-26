package ivan.kopeykin.opticalcharacteristicscalc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cable);

        final EditText lEditer = (EditText) findViewById(R.id.editTextL);
        final EditText s0Editer = (EditText) findViewById(R.id.editTextS0);
        final EditText l0Editer = (EditText) findViewById(R.id.editTextL0);
        final EditText markEditer = (EditText) findViewById(R.id.editTextMark);

        findViewById(R.id.buttonSubmitCable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("mark", markEditer.getText().toString());

                String s0String = s0Editer.getText().toString();
                String l0String = l0Editer.getText().toString();
                String lString = lEditer.getText().toString();

                if (s0String.isEmpty() || l0String.isEmpty() || lString.isEmpty()) {
                    setResult(RESULT_CANCELED);
                    finish();
                }

                double l = 0.0,s0 = 0.0,l0 = 0.0;

                try {
                    l = Double.parseDouble(lString);
                    l0 = Double.parseDouble(l0String);
                    s0 = Double.parseDouble(s0String);
                } catch (Exception ex) {
                    Log.w("CABLE", ex);
                    setResult(RESULT_CANCELED);
                    finish();
                }

                intent.putExtra("l",l);
                intent.putExtra("l0",l0);
                intent.putExtra("s0",s0);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
