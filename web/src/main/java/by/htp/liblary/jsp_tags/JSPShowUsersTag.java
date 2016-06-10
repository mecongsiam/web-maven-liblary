package by.htp.liblary.jsp_tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import by.htp.liblary.entity.Abonement;
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
				Abonement abonement = jspUserBean.getElement(i);
				out.write("<tr><td>");
				//out.write(Integer.toString(abonement.getIdAbonement()));
				out.write("</td><td>");
				//out.write(abonement.getLogin());
				out.write("</td><td>");
				out.write(abonement.getName());
				out.write("</td><td>");
				out.write(abonement.getSurname());
				out.write("</td><td>");
				out.write(abonement.getEmail());
				out.write("</td><td>");
				out.write(abonement.getAddress());
				out.write("</td><td>");
				out.write(abonement.getPhone());
				out.write("</td></tr>");

			}
			out.write("</table>");
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;

	}

}
