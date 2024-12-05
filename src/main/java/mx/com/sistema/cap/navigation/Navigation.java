package mx.com.sistema.cap.navigation;

import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Navigation extends NavigationHandler{

	private static final Logger log = LogManager.getLogger(Navigation.class);
	
	public static final String BACK_OUTCOME= "volver";
	
	protected NavigationHandler baseHandler;
	
	public Navigation(NavigationHandler baseHandler) {
		
		super();
		this.baseHandler= baseHandler;
	}
	
	private Object getManageBean(String manageBean) {
		
		FacesContext facesContext= FacesContext.getCurrentInstance();
		return facesContext.getApplication()
				.createValueBinding(manageBean).getValue(facesContext);
	}
	
	@Override
	public void handleNavigation(FacesContext context, String actionMethod, String actionName) {

		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		String viewId= viewRoot.getViewId();
		
		NavigationDataHolder navigationDataHolder= (NavigationDataHolder)getManageBean("#{navigationDataHolder}");
		log.debug("handle Navigation: View Id "+ viewId + ", actionMethod: "+ actionMethod+ " actionName: "+ actionName);
		if(actionName== null && actionMethod==null) {
			log.info("handle Navigation Capturando invocacion ajax");
			return;
		}
		if(actionName== null || "".equals(actionName)) {
			log.info("handle Navigation Action name vacio o nulo");
			return;
		}
		
		if(actionName.indexOf(BACK_OUTCOME)> -1) {
			navigateToPreviousPage(context, viewRoot, navigationDataHolder);
		}else {
			validFieldDetail(viewId, navigationDataHolder, actionMethod, actionName);
			baseHandler.handleNavigation(context, actionMethod, actionName);
		}
		
	}	
	
	
	private void validFieldDetail(String viewId, NavigationDataHolder navigationDataHolder, String actionMethod,
			String actionName) {
		
		if(!viewId.contains("fileDetailSearch.")) {
			
			if(navigationDataHolder.consultRecordedNavigationData()== null
				|| !navigationDataHolder.consultRecordedNavigationData().getViewId().equals(viewId)){
					navigationDataHolder.recordNavigation(actionMethod, actionName, viewId);
				}
		}else {
			log.debug("No se almacena navegacion para fileDetailSearch");
		}
		
	}
		
	
	
	
	private void navigateToPreviousPage(FacesContext facesContext, UIViewRoot viewRoot, 
			NavigationDataHolder navigationDataHolder) {
		
		NavigationData navigationData= null;
		
		while(true) {
			navigationData=navigationDataHolder.getLastRecordNavigation();
			if(!navigationData.getViewId().equals(viewRoot.getViewId())) {
				break;
			}
		}
		
		log.info("handle navigation: Navegando a pagina previa"+ navigationData.getViewId());
		viewRoot.setViewId(navigationData.getViewId());
		
		baseHandler.handleNavigation(facesContext, navigationData.getActionMethodName(), navigationData.getActionName());
	}


}
