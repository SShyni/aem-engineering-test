package com.adobe.assignment.aem.core.number.servlet;

import com.adobe.assignment.aem.core.number.impl.NumberException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import com.google.gson.JsonObject;
import com.adobe.assignment.aem.core.Constants;
import com.adobe.assignment.aem.core.number.util.NumberConversion;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service=Servlet.class,
        property={
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.resourceTypes="+ "adobe-assignment/components/structure/page",
                "sling.servlet.extensions=" + "json"
        })
@ServiceDescription("Roman Numeral Servlet")
public class RomanNumeralServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest request,
                         final SlingHttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String numberValue = request.getParameter(Constants.QUERY);

        try {

            JsonObject result = new JsonObject();
            result.addProperty(Constants.INPUT, numberValue);
            result.addProperty(Constants.OUTPUT, NumberConversion.intToRomanNumeral(numberValue));
            response.getWriter().print(result.toString());

        } catch (NumberException e) {

            JsonObject errorMessage = new JsonObject();
            errorMessage.addProperty(Constants.ERROR_MESSAGE, e.getMessage());
            response.getWriter().print(errorMessage.toString());

        }

    }
}
