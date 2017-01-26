package ivan.kopeykin.opticalcharacteristicscalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CommunicationLineActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_line);

        final EditText deltaFEditer = (EditText)findViewById(R.id.editTextdeltaF);
        final EditText fEditer = (EditText)findViewById(R.id.editTextF);
        final EditText lEditer = (EditText)findViewById(R.id.editTextLength);

        Button submit = (Button)findViewById(R.id.buttonSubmitCommunicationLine);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String deltaFString = deltaFEditer.getText().toString();
                String fString = fEditer.getText().toString();
                String lString = lEditer.getText().toString();

                if (deltaFString.isEmpty() || fString.isEmpty() || lString.isEmpty()) {
                    setResult(RESULT_CANCELED);
                    finish();
                }

                double deltaF = 0.0, f = 0.0, l = 0.0;

                try {
                    deltaF = Double.parseDouble(deltaFString);
                    f = Double.parseDouble(fString);
                    l = Double.parseDouble(lString);
                }catch (Exception ex){
                    Log.w("COMLINE", ex);
                    setResult(RESULT_CANCELED);
                    finish();
                }

                intent.putExtra("deltaF", deltaF);
                intent.putExtra("f", f);
                intent.putExtra("l", l);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
