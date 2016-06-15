package by.htp.liblary.jsp_tags;

import by.htp.liblary.entity.User;
import by.htp.liblary.jsp_bean.JSPUserBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by meco on 15.06.2016.
 */
public class JSPPagTag extends TagSupport {
    private JSPUserBean jspUserBean;

    public JSPUserBean getJspUserBean() {
        return jspUserBean;
    }

    public void setJspUserBean(JSPUserBean jspUserBean) {
        this.jspUserBean = jspUserBean;
    }

    public int doStartTag() throws JspException {

        int position=jspUserBean.getPosition();
        int page=0;
        int pageCommand=0;
        int allUsers = new Integer(jspUserBean.getCountAllUsers());
        int interval=jspUserBean.getInterval();
        int numOfPages;
        if(allUsers%interval==0){
            numOfPages=allUsers/interval;

        }else {
            numOfPages=allUsers/interval;
            numOfPages++;
        }


        try {
            JspWriter out = pageContext.getOut();
            out.write("<ul class = \"pagination\">\n");
            out.write("<li><a href = \"Controller?command=back_position\">&laquo;</a></li>");
            for(int i=0;i<3;i++){
                if(numOfPages>=page+1){
                    System.out.println(numOfPages+" "+pageCommand);
                 page=i+1+(position*3);
                pageCommand=i+(position*3);
                out.write("\t\t\t<li><a href = \"Controller?command=show_users&numpage="+pageCommand+"\">"+page+"</a></li>\n");}
            }
            out.write("<li><a href = \"Controller?command=add_position\">&raquo;</a></li>");
            out.write("\t\t</ul>");






        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;

    }
}
