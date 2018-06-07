package emp.ui.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import emp.model.UsersBean;
 
@ManagedBean(name="dtSelectionView")
@ViewScoped
public class SelectionView implements Serializable {
     
    private List<UsersBean> selectedUsers;
    
     
 
   
     
    public List<UsersBean> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<UsersBean> selectedUsers) {
		this.selectedUsers = selectedUsers;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		session.setAttribute("SelectedResourceEMP", selectedUsers);
		System.out.println(session.getAttribute("SelectedResourceEMP"));
	}

	public void onRowSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		session.setAttribute("SelectedResourceEMP", selectedUsers);
		System.out.println(session.getAttribute("SelectedResourceEMP"));
    }
 
    public void onRowUnselect(UnselectEvent event) {
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		session.setAttribute("SelectedResourceEMP", selectedUsers);
		System.out.println(session.getAttribute("SelectedResourceEMP"));
    }
    
    
}