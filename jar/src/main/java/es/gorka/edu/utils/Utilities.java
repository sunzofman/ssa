package es.gorka.edu.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.request.cycle.RequestCycle;

public class Utilities {

	public static String getServerUrl() {
		HttpServletRequest req = (HttpServletRequest) (RequestCycle.get().getRequest()).getContainerRequest();
		String serverName = req.getServerName();
		int portNumber = req.getServerPort();
		return "http://" + (serverName + ":" + portNumber);

	}

}
