package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class PantallaQR extends AppCompatActivity {

    EditText editText;
    Button buttonGenerarQR;
    ImageView imagenQR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_qr);

        iniciarComponentes();
        clickButton();
    }

    private void clickButton() {
        buttonGenerarQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               generarQRCode();
            }
        });
    }

    private void generarQRCode() {
        if(editText.getText().length()==0) {
            Toast.makeText(this, "Por favor, introduzca una clave para generar el QR", Toast.LENGTH_LONG).show();
        }else{
        String texto= editText.getText().toString();
        MultiFormatWriter multiFormatWriter =new MultiFormatWriter();

        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(texto, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder= new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imagenQR.setImageBitmap(bitmap);
        }catch (WriterException e){
            e.printStackTrace();
        }}
        ocultarTecladoMovil();
    }

    public void ocultarTecladoMovil() {

        View view=this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    private void iniciarComponentes() {
        editText=(EditText) findViewById(R.id.editTextPalabra);
        buttonGenerarQR=(Button) findViewById(R.id.buttonGenerarQR);
        imagenQR=(ImageView) findViewById(R.id.imagenQR);


    }
}
