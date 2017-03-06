package fonket.pendindong.models.views;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import fonket.pendindong.R;
import fonket.pendindong.models.models.Pending;

import static fonket.pendindong.R.id.fab;

public class MainActivity extends AppCompatActivity implements Pendingback {

    private PendingListFragment pendingListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pendingListFragment = (PendingListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_enter);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                ImageButton saveBtn = (ImageButton) dialog.findViewById(R.id.saveTaskBtn);
                saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText input = (EditText) dialog.findViewById(R.id.taskEt);
                        String name = input.getText().toString();
                        CreAcuerdos creAcuerdos = new CreAcuerdos(MainActivity.this);
                        creAcuerdos.validation(name);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void created(Pending pending) { pendingListFragment.addPending(pending);    }

    @Override
    public void noname() {
        Toast.makeText(this, "Ingresa un recuerdo", Toast.LENGTH_SHORT).show();

    }
}
