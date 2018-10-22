package bitcamp.java110.cms.web.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;
import bitcamp.java110.cms.web.PageController;

@Component("/manager/detail")
public class ManagerDetailController implements PageController { 
    
    @Autowired
    ManagerService managerService;
    
    @Override
    public String Service(
            HttpServletRequest request, 
            HttpServletResponse response) {
        
        int no = Integer.parseInt(request.getParameter("no"));
        Manager m = managerService.get(no);
        request.setAttribute("manager", m);
        return "/manager/detail.jsp";
        
    }
    
}
    
    













    
    
    
    
    
    
    