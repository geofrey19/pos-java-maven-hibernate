package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.Endereco;
import model.Perfil;
import model.Usuario;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {
		/* HibernateUtil.getEntityManager(); */
		DaoGeneric daoGeneric = new DaoGeneric<Usuario>();
		Perfil perfil =  (Perfil) daoGeneric.pesquisar(23L, Perfil.class);
		Usuario usuario = new Usuario();

		usuario.setNome("George Hilton Frey");
		usuario.setEmail("geofrey@gmail.com");
		usuario.setCpf("82273421591");
		usuario.setPerfil(perfil);
		daoGeneric.salvar(usuario);

	}
	
	@Test
	public void testeBuscar() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario usuario = new Usuario();
		usuario.setId(15L);
		usuario = daoGeneric.pesquisar(usuario);
		System.out.println(usuario);
	}

	@Test
	public void testeBuscar2() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario usuario = daoGeneric.pesquisar(10L, Usuario.class);
		System.out.println(usuario);
	}

	@Test
	public void testeUpdateUsuario() {
		DaoGeneric daoGeneric = new DaoGeneric<Usuario>();
		Perfil perfil = (Perfil) daoGeneric.pesquisar(24L, Perfil.class );
		Usuario usuario = (Usuario) daoGeneric.pesquisar(25L, Usuario.class);
		usuario.setPerfil(perfil);
		usuario.setNome("Hilton");
		daoGeneric.updateMerge(usuario);
		System.out.println(usuario);
	}

	@Test
	public void testeDelete() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario usuario = daoGeneric.pesquisar(26L, Usuario.class);
		daoGeneric.deletarPoId(usuario);
		System.out.println(usuario);
	}
	
	@Test
	public void testeConsultar() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		List<Usuario> list = daoGeneric.listar(Usuario.class);

		for (Usuario usuario : list) {
			System.out.println(usuario);
			System.out.println("---------------------------------------");
		}

	}

	@Test
	public void testeQueryListParameter() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		List<Usuario> list = daoGeneric.getEntityManager()
				.createQuery("from Usuario where nome =:nome and email =:email")
				.setParameter("nome", ""
						+ "George Hilton de Andrade Frey").setParameter("email", "geofrey@gmail.com").getResultList();

		for (Usuario usuario : list) {
			System.out.println(usuario);
		}
	}
	
	@Test
	public void testeGravaEndereco() {
		DaoGeneric daoGeneric = new DaoGeneric();
		
		Usuario usuario = (Usuario) daoGeneric.pesquisar(15L, Usuario.class);
		
		Endereco endereco = new Endereco();
		endereco.setTipo("Rua");
		endereco.setNumero(965);
		endereco.setLogradouro("Rua Arhtur de Azevedo");
		endereco.setComplemento("Cond. Joia da Praia");
		daoGeneric.salvar(endereco);
	}
	
	@Test
	public void testeGravaPerfil() {
		DaoGeneric<Perfil> daoGeneric = new DaoGeneric<Perfil>();
		
		Perfil perfil = new Perfil();
		perfil.setTipo("Convidado");
		daoGeneric.salvar(perfil);
	}
	
	@Test
	public void testeConsultaEnderecos() {
		DaoGeneric daoGeneric = new DaoGeneric();
		
		Usuario usuario = (Usuario) daoGeneric.pesquisar(15L, Usuario.class);
		
		for (Endereco endereco : usuario.getEnderecos()) {
			System.out.println(endereco.getTipo());
			System.out.println(endereco.getLogradouro());
			
			System.out.println("-------------------------------");
		}
	}
}
