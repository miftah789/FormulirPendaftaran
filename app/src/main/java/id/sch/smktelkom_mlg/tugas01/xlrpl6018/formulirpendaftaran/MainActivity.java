package id.sch.smktelkom_mlg.tugas01.xlrpl6018.formulirpendaftaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNama;
    Button bDaftar;
    TextView hasilnama;
    TextView hasiljkl;
    TextView hasilorg;
    TextView hasilkels;
    RadioGroup rgjk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNama = (EditText) findViewById(R.id.editTextnama);
        rgjk = (RadioGroup) findViewById(R.id.rbjk);
        bDaftar = (Button) findViewById(R.id.button);
        hasilnama = (TextView) findViewById(R.id.textViewHasilnm);
        hasiljkl = (TextView) findViewById(R.id.textViewhasiljk);
        hasilorg = (TextView) findViewById(R.id.textViewhasilor);
        hasilkels = (TextView) findViewById(R.id.textViewhasilkls);

        bDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

    }

    private void doProcess() {
        if (isValid()) {
            String nama = edNama.getText().toString();
            hasilnama.setText("Nama : " + nama);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = edNama.getText().toString();

        if (nama.isEmpty()) {
            edNama.setError("Nama Belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            edNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            edNama.setError(null);
        }

        return valid;
    }

    private void doClick() {
        String hasil = null;

        if (rgjk.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgjk.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (hasil == null) {
            hasiljkl.setText("Belum memilih jenis kelamin");
        } else {
            hasiljkl.setText("Jenis kelamin : " + hasil);
        }
    }

}
