package paquete.example.the_factory_hka_definitivo;

import paquete.example.the_factory_hka_definitivo.conexion.DatabaseManager;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import paquete.example.the_factory_hka_definitivo.modelo.Usuario;

public class Actividad_Sesion extends ActionBarActivity {
private EditText tfUsuario;
private EditText tfPassword;
private Button btnSalirAplicacion;
private Button btnEntrarSesion;
private TextView txtRegistro;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actividad__sesion);
		
		tfUsuario = (EditText) findViewById(R.id.tfUsuario);
		tfPassword = (EditText) findViewById(R.id.tfPassword);
		txtRegistro = (TextView) findViewById(R.id.txtRegistro);
		btnSalirAplicacion = (Button) findViewById(R.id.btnSalirAplicacion);
		btnEntrarSesion = (Button) findViewById(R.id.btnEntrarSesion);
		
		salirAplicacion();
		registroUsuario();
		entrarAplicacion();
	}
	public void salirAplicacion(){
		btnSalirAplicacion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Actividad_Sesion.this.finish();
			}
		});
	}
	
	public void registroUsuario(){
		txtRegistro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(),Actividad_Registro_Usuario.class);
				startActivity(i);
			}
		});
	}
	
	public void entrarAplicacion(){
		
		btnEntrarSesion.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Nombre de Usuario o Password Vacio",Toast.LENGTH_LONG).show();
				if(tfUsuario.getText().toString() == null || tfPassword.getText().toString() == null){
					Toast.makeText(getApplicationContext(), "Nombre de Usuario o Password Vacio",Toast.LENGTH_LONG).show();
				}
//				if(encontrarUsuario(tfUsuario.getText().toString(), Integer.valueOf(tfPassword.getText().toString()))){
//					System.out.println("entro");
//					Toast.makeText(getApplicationContext(), "Usuario Invalido",Toast.LENGTH_LONG).show();
//				}
			}
		});
	}
	public boolean encontrarUsuario(String NombreUsuario,int pass){
		Usuario usuario = DatabaseManager.getInstancia().buscarUsuario(NombreUsuario, pass);
		if(null != usuario){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean notnull(String cadena){
		return null != cadena && cadena.length()>0;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actividad__sesion, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
