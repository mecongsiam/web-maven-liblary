package by.htp.liblary.jsp_tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


import by.htp.liblary.entity.User;
import by.htp.liblary.jsp_bean.JSPUserBean;


public class JSPShowUsersTag extends TagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6980012309609439962L;
    /**
     *
     */

    private JSPUserBean jspUserBean;

    public JSPUserBean getJspUserBean() {
        return jspUserBean;
    }

    public void setJspUserBean(JSPUserBean jspUserBean) {
        this.jspUserBean = jspUserBean;
    }

    public int doStartTag() throws JspException {
        int size = new Integer(jspUserBean.getSize());

        try {
            JspWriter out = pageContext.getOut();
            out.write("Users Information");
            out.write("<table border=\"1\">");

            for (int i = 0; i < size; i++) {
                User user = jspUserBean.getElement(i);
                out.write("<tr><td>");
                out.write(Integer.toString(user.getId()));
                out.write("</td><td>");
                out.write(user.getLogin());
                out.write("</td><td>");
                out.write(user.getAbonement().getName());
                out.write("</td><td>");
                out.write(user.getAbonement().getSurname());
                out.write("</td><td>");
                out.write(user.getAbonement().getEmail());
                out.write("</td><td>");
                out.write(user.getAbonement().getAddress());
                out.write("</td><td>");
                out.write(user.getAbonement().getPhone());
                out.write("</td></tr>");

            }
            out.write("</table>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;

    }

}
