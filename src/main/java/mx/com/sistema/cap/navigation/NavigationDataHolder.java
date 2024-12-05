package mx.com.sistema.cap.navigation;

import java.util.EmptyStackException;
import java.util.Stack;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;


@Named
@Scope("session")
public class NavigationDataHolder {
	
	private Stack returnPageList= new Stack<>();
	
	public void recordNavigation(String actionMethod, String name, String viewID) {
		
		returnPageList.push(new NavigationData(actionMethod, actionMethod, viewID));
	}
	
	public NavigationData getLastRecordNavigation() {
		NavigationData lastNavigationData= null;
		try {
			lastNavigationData= (NavigationData)returnPageList.pop();
		}catch(EmptyStackException emptyStackException) {
			
		}
		return lastNavigationData;
	}
	
	public NavigationData consultRecordedNavigationData() {
		
		NavigationData lastNavigationData= null;
		try {
			if(returnPageList.isEmpty()) {
				return null;
			}
			
			lastNavigationData= (NavigationData)returnPageList.lastElement();
		}catch(EmptyStackException emptyStackException) {
			
		}
		return lastNavigationData;
		
	}
	

}
