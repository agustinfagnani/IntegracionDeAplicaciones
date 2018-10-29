package bean;

import java.util.ArrayList;
import java.util.List;

import bean.srv.FacturaSRV;
import negocio.Factura;




public class ListFactura 
{
	private List<Factura> facts;
	
	public ListFactura()
	{
		facts= new ArrayList<Factura>();
		facts = FacturaSRV.leerFacturas();
		}

	public List<Factura> getFacturas() {
		return facts;
	}
	
	public void setFacturas(List<Factura> facturas) {
		this.facts = facturas;
	}
	
	public void addFactura(Factura fact){
		facts.add(fact);
		FacturaSRV.grabarFactura(fact);
	}
	
	public boolean removeFactura(Factura fact) {
		return facts.remove(fact);
	}
	
	public Factura getFacturaPorId(int id){
//		for(Factura u : facts){
//			if(u.getDni()== id)
//				return u;
//		}
		return null;
	}
	
	
	
	
	public int size(){
		return facts.size();
	}

	public void actualizarBD() 
	{
		FacturaSRV.grabaFacturas(facts);
		
	}
}
