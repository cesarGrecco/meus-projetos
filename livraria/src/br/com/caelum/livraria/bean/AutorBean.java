package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public RedirectView gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		System.out.println("Id: "+this.autor.getId());
		if(!(this.autor.getId() == null))
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		else
			new DAO<Autor>(Autor.class).adiciona(this.autor);

		this.autor = new Autor();
		
		return new RedirectView("autor");
	}
	
	public void removerAutor(Autor autor) {
		System.out.println("Removendo autor: "+ autor.getNome());
		new DAO<Autor>(Autor.class).remove(autor);
	}
	
	public void atualizarAutor(Autor autor) {
		System.out.println("Atuliazando autor..."+ autor.getNome());
		carregarAutor(autor);
		new DAO<Autor>(Autor.class).atualiza(autor);
	}

	private void carregarAutor(Autor autor) {
		this.autor = autor;
	}
	
	public void carregaPelaId() {
	    Integer id = this.autor.getId();
	    this.autor = new DAO<Autor>(Autor.class).buscaPorId(id);
	    if (this.autor == null) {
	            this.autor = new Autor();
	    }
	}

}
