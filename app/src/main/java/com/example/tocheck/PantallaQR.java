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

    //FUNCION CLIC
    private void clickButton() {
        buttonGenerarQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               generarQRCode();
            }
        });
    }

    //FUNCION QUE GENERA QR
    private void generarQRCode() {
        //SI EL CAMPO DE TEXTO ESTA VACIO, MANDA UN MENSAJE DE ERROR
        if(editText.getText().length()==0) {
            Toast.makeText(this, "Por favor, introduzca una clave para generar el QR", Toast.LENGTH_LONG).show();
        }else{
        //SI EL CAMPO DE TEXTO TIENE CONTENIDO, GENERA EL CODIGO QR Y BAJA EL TECLADO PARA PODER VERLO
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

    //FUNCION DE OCULTAR EL TECLADO (PARA LA FUNCION QUE GENERA EL QR)
    public void ocultarTecladoMovil() {
        View view=this.getCurrentFocus();
        //SI EL TECLADO ESTA ACTIVO, LO OCULTA
        if(view!=null){
            InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    //INICIA LOS COMPONENTES
    private void iniciarComponentes() {
        editText=(EditText) findViewById(R.id.editText3);
        buttonGenerarQR=(Button) findViewById(R.id.buttonGenerarQR);
        imagenQR=(ImageView) findViewById(R.id.imagenQR);
    }
}
