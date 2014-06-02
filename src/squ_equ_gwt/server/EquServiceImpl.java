package squ_equ_gwt.server;

import squ_equ_gwt.client.EquService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EquServiceImpl extends RemoteServiceServlet implements EquService {

	@Override
	public String equ(Integer a, Integer b, Integer c) {
		double d = (b * b - (4 * a * c));
		if (d == 0) {
			return "There is One Solution s=" + (-b / 2 * a);
		} else if (d > 0) {
			return "There are Two Solutions s1=" + (-b + Math.sqrt(d) / 2 * a)
					+ "   s2=" + (-b - Math.sqrt(d) / 2 * a);
		}

		else
			return "no solution";
	}

}
