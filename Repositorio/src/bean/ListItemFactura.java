package bean;

import java.util.ArrayList;
import java.util.List;

import bean.srv.ItemFacturaSRV;
import negocio.ItemFactura;



public class ListItemFactura 
{
	private List<ItemFactura> itemFacturas;
	
	public ListItemFactura()
	{
		itemFacturas= new ArrayList<ItemFactura>();
		itemFacturas = ItemFacturaSRV.leerItemFacturas();}
	
	public List<ItemFactura> getItemFacturas() {
		return itemFacturas;
	}
	
	public void setItemFactura(List<ItemFactura> ifac) {
		this.itemFacturas = ifac;
	}
	
	public void addItemFactura(ItemFactura itemFact){
		itemFacturas.add(itemFact);
		ItemFacturaSRV.grabarItemFactura(itemFact);
	}
	
	public boolean removeItemFactura(ItemFactura item) {
		return itemFacturas.remove(item);
	}
	
	public ItemFactura getItemFactPorId(int id){
//		for(ItemFactura u : itemFacturas){
//			if(u.getDni()== id)
//				return u;
//		}
		return null;
	}
	
	
	
	
	public int size(){
		return itemFacturas.size();
	}

	public void actualizarBD() 
	{
		ItemFacturaSRV.grabarItemFactura(itemFacturas);
		
	}
}
