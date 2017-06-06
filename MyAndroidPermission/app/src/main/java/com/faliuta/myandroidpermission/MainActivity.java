package com.faliuta.myandroidpermission;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.faliuta.myeasypermission.EasyPermission;
import com.faliuta.myeasypermission.PermissionCallback;
import com.faliuta.myeasypermission.PermissionItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });
    }

    private void checkPermission() {
        List<PermissionItem> permissionItems = new ArrayList<>();
        permissionItems.add(new PermissionItem(Manifest.permission.CAMERA, "Camera"));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_FINE_LOCATION, "Location"));
        permissionItems.add(new PermissionItem(Manifest.permission.WRITE_EXTERNAL_STORAGE, "Write storage"));
        EasyPermission.create(this)
                .permissions(permissionItems)
                .checkMultiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {
                        Toast.makeText(MainActivity.this,
                                "onClose",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this,
                                "onFinish",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDeny(String permission, int position) {
                        Toast.makeText(MainActivity.this,
                                "on Deny " + permission,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onGuarantee(String permission, int position) {
                        Toast.makeText(MainActivity.this,
                                "on Guarantee " + permission,
                                Toast.LENGTH_SHORT).show();
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
}
