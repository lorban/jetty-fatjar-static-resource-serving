package org.sample;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        String webDir = Main.class.getClassLoader().getResource("static").toExternalForm();
        System.out.println("Serving from webDir " + webDir);
        WebAppContext waContext = new WebAppContext(webDir, "/");

        waContext.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$");

        server.setHandler(waContext);

        server.setStopAtShutdown(true);

        server.start();
    }
}
