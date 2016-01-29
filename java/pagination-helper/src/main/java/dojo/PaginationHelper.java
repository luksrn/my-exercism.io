package dojo;

import static java.lang.Math.ceil;

public class PaginationHelper  {
 
	private int totalItens;
	private int totalPorPagina;

	public PaginationHelper(int totalItens, int totalPorPagina) {
		this.totalItens = totalItens;
		this.totalPorPagina = totalPorPagina;
	}

	public int itemCount() {
		return totalItens;
	}
	
	public int pageCount() {
		return (int)ceil(  itemCount() / (double)totalPorPagina );
	}
	
	public int pageItemCount(int paginaVisitada) {
		if ( paginaVisitada < 0 || paginaVisitada >= pageCount() ){
			return -1;
		}
		
		int totalItensAvacados = (paginaVisitada + 1) * totalPorPagina;
		
		if ( totalItensAvacados < itemCount() ){
			return totalPorPagina;
		} else {
			return itemCount() - (totalItensAvacados - totalPorPagina);
		}
	}
	
	public int pageIndex(int elemento) {
		if ( elemento < 0 || elemento >= itemCount() ){
			return -1;
		} 
		return (int) (elemento / totalPorPagina);
	}
}
