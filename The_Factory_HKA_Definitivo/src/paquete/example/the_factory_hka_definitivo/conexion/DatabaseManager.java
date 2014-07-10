package paquete.example.the_factory_hka_definitivo.conexion;

import java.sql.SQLException;
import java.util.List;

//import com.j256.ormlite.support.DatabaseConnection;
//
//import android.R.integer;
import android.content.Context;
import android.util.Log;
import paquete.example.the_factory_hka_definitivo.modelo.Usuario;
import paquete.example.the_factory_hka_definitivo.modelo.Categoria;
import paquete.example.the_factory_hka_definitivo.modelo.Producto;
import paquete.example.the_factory_hka_definitivo.modelo.Proveedor;

public class DatabaseManager {
	
	static private DatabaseManager instancia;
		
	static public void init(Context ctx) {
        if (null==instancia) {
            instancia = new DatabaseManager(ctx);
        }
    }
	
	static public DatabaseManager getInstancia() {
        return instancia;
    }
	private DatabaseHelper ayudante;
    private DatabaseManager(Context ctx) {
       ayudante = new DatabaseHelper(ctx);
    }
    
    private DatabaseHelper getAyudante() {
        return ayudante;
    }
    
    public List<Usuario> getTodosUsuarios() {
        List<Usuario> usuarios = null;
        try {
            usuarios = getAyudante().getUsuarioDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public List<Categoria> getTodosCategoria() {
        List<Categoria> categorias = null;
        try {
            categorias = getAyudante().getCategoriaDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }
    
    public List<Proveedor> getTodosProveedores() {
        List<Proveedor> proveedores = null;
        try {
            proveedores = getAyudante().getProveedorDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }
    
    public List<Producto> getTodosProductos() {
        List<Producto> productos = null;
        try {
            productos = getAyudante().getProductoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
    
    public Proveedor buscarProveedorId(int id){
    	Proveedor proveedor = null;
    	try {
			proveedor = getAyudante().getProveedorDao().queryForId(id);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "No se puede buscar el proveedor", e);
			// TODO: handle exception
			throw new RuntimeException(e);
		}
    	 return proveedor;
    }
    
    public Producto buscarProductoId(int id){
    	Producto producto = null;
    	try {
			producto = getAyudante().getProductoDao().queryForId(id);
		} catch (SQLException e) {
			Log.e(DatabaseManager.class.getName(), "No se puede buscar el producto", e);
			// TODO: handle exception
			throw new RuntimeException(e);
		}
    	 return producto;
    }
    
    public Categoria buscarCategoriaId(int id){
    	Categoria categoria = null;
    	
    	try {
			categoria = getAyudante().getCategoriaDao().queryForId(id);
		} catch (SQLException e) {
			Log.e(DatabaseManager.class.getName(), "No se puede buscar la Categoria", e);
			// TODO: handle exception
			throw new RuntimeException(e);
		}
    	 return categoria;
    }
    
    public Usuario buscarUsuarioId(int id){
    	Usuario usuario = null;
    	
    	try {
			usuario = getAyudante().getUsuarioDao().queryForId(id);
		} catch (SQLException e) {
			Log.e(DatabaseManager.class.getName(), "No se puede buscar la Categoria", e);
			// TODO: handle exception
			throw new RuntimeException(e);
		}
    	 return usuario;
    }
    
    public Usuario crearUsuario(Usuario usu){
    	Usuario usuario = usu;
    	
    	try {
			getAyudante().getUsuarioDao().create(usuario);
		} catch (SQLException e) {
			Log.e(DatabaseManager.class.getName(), "No se puede buscar la Categoria", e);
			// TODO: handle exception
			throw new RuntimeException(e);
		}
    	 return usuario;
    }
    public void refreshUsuario(Usuario usu){    	
    	try {
			getAyudante().getUsuarioDao().refresh(usu);
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
    public Usuario buscarUsuario(String NombreUsuario ,int id){
    	Usuario usuario = null;
    	List<Usuario> listaUsuarios = instancia.getTodosUsuarios(); 
    	Usuario aux = null;
			for(int i = 0; i < listaUsuarios.size(); i++){
				aux = listaUsuarios.get(i);
				if(aux.getNombreUsuario()== NombreUsuario && aux.getPassword() == id){
					usuario = aux;
				}
			}
    	 return usuario;
    }
    
}
