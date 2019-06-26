package br.com.caelum.livraria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.dao.UsuarioDAO;
import br.com.caelum.livraria.modelo.Usuario;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public RedirectView logarUsuario() {
		System.out.println("Logando usuario: "+ this.usuario.getEmail());
		FacesContext context = FacesContext.getCurrentInstance();
		Boolean usuarioExiste = new UsuarioDAO().usuarioExiste(this.usuario);
		if(usuarioExiste) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return new RedirectView("livro");			
		}
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuario não Encontrado"));
		return new RedirectView("login");
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		
		return "login?faces-redirect=true";
		
	}
}
