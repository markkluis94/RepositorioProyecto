package paquete.example.the_factory_hka_definitivo.conexion;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import paquete.example.the_factory_hka_definitivo.modelo.Usuario;
import paquete.example.the_factory_hka_definitivo.modelo.Categoria;
import paquete.example.the_factory_hka_definitivo.modelo.Producto;
import paquete.example.the_factory_hka_definitivo.modelo.Proveedor;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	
	private static final String DATABASE_NAME = "bdTheFactoryHKA.sqlite";	
	private static final int DATABASE_VERSION = 1;
	private Dao<Usuario, Integer> UsuarioDao = null;
    private Dao<Categoria, Integer> CategoriaDao = null;
    private Dao<Proveedor, Integer> ProveedorDao = null;
    private Dao<Producto, Integer> ProductoDao = null;
	
	public DatabaseHelper(Context contexto) {
		super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
		// TODO Auto-generated method stub
		try {
			TableUtils.createTable(connectionSource, Usuario.class);
			TableUtils.createTable(connectionSource, Categoria.class);
			TableUtils.createTable(connectionSource, Proveedor.class);
			TableUtils.createTable(connectionSource, Producto.class);
			
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "No se puede crear la base de datos", e);
			// TODO: handle exception
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
        e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int viejaVersion, int nuevaVersion) {
		// TODO Auto-generated method stub
		 try {
	            List<String> todoSql = new ArrayList<String>(); 
	            switch(viejaVersion) 
	            {
	              case 1: 
	                  //allSql.add("alter table AdData add column `new_col` VARCHAR");
	                  //allSql.add("alter table AdData add column `new_col2` VARCHAR");
	            }
	            for (String sql : todoSql) {
	                db.execSQL(sql);
	            }
	        } catch (SQLException e) {
	            Log.e(DatabaseHelper.class.getName(), "excepción durante la Actualizacion", e);
	            throw new RuntimeException(e);
	        }
	        
	    }

	    public Dao<Usuario, Integer> getUsuarioDao() {
	        if (null == UsuarioDao) {
	            try {
	                UsuarioDao = getDao(Usuario.class);
	            }catch (java.sql.SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return UsuarioDao;
	    }

	    public Dao<Categoria, Integer> getCategoriaDao() {
	        if (null == CategoriaDao) {
	            try {
	                CategoriaDao = getDao(Categoria.class);
	            }catch (java.sql.SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return CategoriaDao;
	    }

	    public Dao<Proveedor, Integer> getProveedorDao() {
	        if (null == ProveedorDao) {
	            try {
	                ProveedorDao = getDao(Proveedor.class);
	            }catch (java.sql.SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return ProveedorDao;
	    }
	    
	    public Dao<Producto, Integer> getProductoDao() {
	        if (null == ProductoDao) {
	            try {
	                ProductoDao = getDao(Producto.class);
	            }catch (java.sql.SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return ProductoDao;
	    }
	

}
