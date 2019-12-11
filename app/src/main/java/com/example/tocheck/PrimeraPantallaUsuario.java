package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;

public class PrimeraPantallaUsuario extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView miScannerView;
    private static final int SOLICITUD_PERMISO_CAMARA=1;
    private Intent intentCamara;
    private static final int RESULT_CODE_OPEN=1;
    private String[] permisos={CAMERA};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla_usuario);

    }

    public void botonEscanear(View view) {

         //IMPLEMENTAR CORRECTAMENTE PERMISOS DE CAMARA

        if(ActivityCompat.checkSelfPermission(this,CAMERA)== PackageManager.PERMISSION_GRANTED){

            Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            miScannerView= new ZXingScannerView(this);
            setContentView(miScannerView);
            miScannerView.setResultHandler(this);
            miScannerView.startCamera();

        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, CAMERA)){
                ActivityCompat.requestPermissions(this,permisos,SOLICITUD_PERMISO_CAMARA);
            }else{
                Toast.makeText(this,"Permiso denegado, por favor active los permisos de cámara",Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,permisos,SOLICITUD_PERMISO_CAMARA);
            }
        }
    }

    @Override
    public void handleResult(Result result) {
        Log.v("HandleResult",result.getText());
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Resultado del escaneo");
        builder.setMessage(result.getText());
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

        miScannerView.resumeCameraPreview(this);
    }

    public void IrPantallaCalendario(View view) {
       // Intent PAgenda =new Intent(this,PantallaCalendario.class);
        //this.startActivity(PAgenda);
        long calendarId = 1234; // here goes your calendar Id

        final Intent calIntent = new Intent(Intent.ACTION_EDIT)
                .setType("vnd.android.cursor.item/event")
                .putExtra(CalendarContract.Events.CALENDAR_ID, calendarId);

        startActivityForResult(calIntent, RESULT_CODE_OPEN);
    }

    public void webHora(View view) {
        Uri uri = Uri.parse("https://reloj-alarma.es/hora/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void infoUsuarios(View view) {
        Intent intent= new Intent(this,InfoUsuarios.class);
        this.startActivity(intent);
    }
}
