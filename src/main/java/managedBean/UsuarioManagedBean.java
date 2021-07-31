package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.DaoGeneric;
import model.Usuario;

@ViewScoped
@ManagedBean(name = "usuarioManagedBean")
public class UsuarioManagedBean {

	private Usuario usuario = new Usuario();
	private DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
