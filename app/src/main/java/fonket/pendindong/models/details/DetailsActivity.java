package fonket.pendindong.models.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import fonket.pendindong.R;
import fonket.pendindong.models.models.Pending;

/**
 * Created by felip on 05-03-2017.
 */

public class DetailsActivity extends AppCompatActivity {

    private Pending pending;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long id = getIntent().getLongExtra("id", 0);
        Pending pending = Pending.findById(Pending.class, id);

        getSupportActionBar().setTitle(pending.getName());
        editText = (EditText) findViewById(R.id.descriptionEt);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String description = pending.getDescription();
        if (description != null) {
            editText.setText(description);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        String description = editText.getText().toString();
        pending.setDescription(description);
        pending.save();

    }
}
