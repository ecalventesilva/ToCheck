package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla_usuario);

    }

    public void botonEscanear(View view) {

         //IMPLEMENTAR CORRECTAMENTE PERMISOS DE LLAMADA

        if(ActivityCompat.checkSelfPermission(this,CAMERA)== PackageManager.PERMISSION_GRANTED){

            Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            miScannerView= new ZXingScannerView(this);
            setContentView(miScannerView);
            miScannerView.setResultHandler(this);
            miScannerView.startCamera();

        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, CAMERA)){
                String[] permisos={CAMERA};
                ActivityCompat.requestPermissions(this,permisos,SOLICITUD_PERMISO_CAMARA);
            }else{
                Toast.makeText(this,"Permiso denegado, por favor active los permisos de cámara",Toast.LENGTH_LONG).show();
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
}
