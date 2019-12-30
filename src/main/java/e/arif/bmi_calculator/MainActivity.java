package e.arif.bmi_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    private String getItemSelected(int id) {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    public void computeBMIButtonClicked(View view) {
        String textWeight = getInputOfTextField(R.id.inputWeight);
        String textHeight = getInputOfTextField(R.id.inputHeight);
        String selectedWeight = getItemSelected(R.id.weightSpinner);
        String selectedHeight = getItemSelected(R.id.heightSpinner);

        double weight = Double.parseDouble(textWeight);
        double height = Double.parseDouble(textHeight);

        if (selectedWeight.equals("Kilograms")) {
            weight = weight / 1;
        } else if (selectedWeight.equals("Pounds")) {
            weight = weight / 2.2;
        }
        if (selectedHeight.equals("Centimeters")) {
            height = height / 100;
        } else if (selectedHeight.equals("Inches")) {
            height = height / 39.37;
        }

        BMIModel model = new BMIModel(weight, height);
        setContentsOfTextView(R.id.display, model.toString());
    }
}