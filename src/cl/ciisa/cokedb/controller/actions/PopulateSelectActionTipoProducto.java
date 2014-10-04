package cl.ciisa.cokedb.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import cl.ciisa.cokedb.model.TipoProductoBeans;
import cl.ciisa.cokedb.services.impl.TipoProductoService;
import cl.ciisa.cokedb.services.interfaces.ITipoProductoService;

public class PopulateSelectActionTipoProducto extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionMessages messages = new ActionMessages();
		
		try {
						
			ITipoProductoService tipoProductosService = new TipoProductoService();
			ArrayList<TipoProductoBeans> tipoProductosList = tipoProductosService.getAll();
			
			request.setAttribute("tipoProductosList", tipoProductosList);
				
		} catch (Exception e) {
			messages.add("errors", new ActionMessage("errors.detail",e.getMessage()));
			this.saveErrors(request, messages);
			return mapping.findForward("failure");
		}
		
		return mapping.findForward("success");
	}
	
	
}
