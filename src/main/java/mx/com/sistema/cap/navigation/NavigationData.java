package mx.com.sistema.cap.navigation;

public class NavigationData {

	private String actionMethodName;
	
	private String actionName;
	
	private String viewId;
	
	

	public NavigationData() {

	}

	public NavigationData(String actionMethodName, String actionName, String viewId) {
		this.actionMethodName = actionMethodName;
		this.actionName = actionName;
		this.viewId = viewId;
	}

	public String getActionMethodName() {
		return actionMethodName;
	}

	public void setActionMethodName(String actionMethodName) {
		this.actionMethodName = actionMethodName;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}
	
	
}
