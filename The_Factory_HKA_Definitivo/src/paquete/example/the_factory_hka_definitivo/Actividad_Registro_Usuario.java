package paquete.example.the_factory_hka_definitivo;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import paquete.example.the_factory_hka_definitivo.conexion.DatabaseManager;
import paquete.example.the_factory_hka_definitivo.modelo.Usuario;
import android.view.View.OnClickListener;

public class Actividad_Registro_Usuario extends ActionBarActivity {
private EditText tfNombre;
private EditText tfCodigo;
private EditText tfApellido;
private EditText tfCorreo;
private EditText tfTelefono;
private EditText tfUsuario;
private EditText tfPassword;
private RadioButton rbtMasculino;
private RadioButton rbtFemenino;
private Button btnGuardar;
private Button btnRegresar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actividad__registro__usuario);
		tfCodigo = (EditText) findViewById(R.id.tfCodigo);
		tfNombre = (EditText) findViewById(R.id.tfNombre);	
		tfApellido = (EditText) findViewById(R.id.tfApellido);
		tfCorreo = (EditText) findViewById(R.id.tfCorreo);
		tfTelefono = (EditText) findViewById(R.id.tfTelefono);
		tfUsuario = (EditText) findViewById(R.id.tfUsuario);
		tfPassword = (EditText) findViewById(R.id.tfPassword);
		rbtMasculino = (RadioButton) findViewById(R.id.rbtSexoMasculino);
		rbtFemenino = (RadioButton) findViewById(R.id.rbtSexoFemenino);
		btnGuardar = (Button) findViewById(R.id.btnGuardar);
		btnRegresar = (Button) findViewById(R.id.btnRegresar);
		rbtFemenino.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					rbtMasculino.setChecked(false);
				}
			}
		});
		rbtMasculino.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					rbtFemenino.setChecked(false);
				}

			}
		});
		Regresar();
		guardarUsuario();
	}
	public void Regresar(){
		btnRegresar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(),Actividad_Sesion.class);
				startActivity(i);
			}
		});
	}
	
	public boolean notnull(String cadena){
		return null != cadena && cadena.length()>0;
	}
	
	public String TransformrSexo(){
		String sexo = "";
		if(rbtMasculino.isChecked()){
			sexo = "Masculino";
		}
		else if(rbtFemenino.isChecked()){
			sexo = "Femenino";
		}
		return sexo;
	}
	public void guardarUsuario(){
		btnGuardar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(notnull(tfNombre.getText().toString())== false){
					Toast.makeText(getApplicationContext(), "Campo Nombre Vacio",Toast.LENGTH_LONG).show();
				}
				else if(notnull(tfCodigo.getText().toString())== false){
					Toast.makeText(getApplicationContext(), "Campo Apellido Vacio",Toast.LENGTH_LONG).show();
				}
				else if(notnull(tfApellido.getText().toString())== false){
					Toast.makeText(getApplicationContext(), "Campo Apellido Vacio",Toast.LENGTH_LONG).show();
				}
				else if(notnull(tfCorreo.getText().toString())== false){
					Toast.makeText(getApplicationContext(), "Campo Correo Vacio",Toast.LENGTH_LONG).show();
				}
				else if(notnull(tfTelefono.getText().toString())== false){
					Toast.makeText(getApplicationContext(), "Campo Telefono Vacio",Toast.LENGTH_LONG).show();
				}
				else if(notnull(tfUsuario.getText().toString())== false){
					Toast.makeText(getApplicationContext(), "Campo nombre de Usuario Vacio",Toast.LENGTH_LONG).show();
				}
				else if(notnull(tfPassword.getText().toString())== false){
					Toast.makeText(getApplicationContext(), "Campo Password de Usuario Vacio",Toast.LENGTH_LONG).show();
				}
				else if(rbtMasculino.isChecked()==false || rbtFemenino.isChecked() == false){
					Toast.makeText(getApplicationContext(), "Indique el sexo",Toast.LENGTH_LONG).show();
				}
				else{
					int CodigoUsuario = Integer.parseInt(tfCodigo.getText().toString());
					int PasswordUsuario = Integer.parseInt(tfPassword.getText().toString());
					Usuario usuarioNuevo = new Usuario(CodigoUsuario, tfNombre.getText().toString(), tfApellido.getText().toString(),
							TransformrSexo(), tfCorreo.getText().toString(), tfTelefono.getText().toString(), tfUsuario.getText().toString(),
							PasswordUsuario);
					DatabaseManager.getInstancia().crearUsuario(usuarioNuevo);
					DatabaseManager.getInstancia().refreshUsuario(usuarioNuevo);
					
					tfCodigo.setText(""); tfNombre.setText("");	tfApellido.setText(""); tfCorreo.setText("");
					tfTelefono.setText(""); tfUsuario.setText(""); tfPassword.setText("");
					rbtMasculino.setChecked(false); rbtFemenino.setChecked(false);
					
				}
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actividad__registro__usuario, menu);
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
