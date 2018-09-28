package com.marioaliaga.demo.rest;

import com.marioaliaga.demo.dominio.Persona;
import com.marioaliaga.demo.services.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

@RestController
public class XMLController {

    @Autowired
    private XMLService xmlService;

    @RequestMapping(value="/lista", produces= MediaType.APPLICATION_XML_VALUE)
    public List<String> findLista() {

        return xmlService.findAll();
    }

    @RequestMapping(value="/personas", produces= MediaType.APPLICATION_XML_VALUE)
    public List<Persona> findListaPersonas() {

        return xmlService.findAllPersonas();
    }

    @RequestMapping(value = "/xml",produces= MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    Document getDocument() throws Exception {
        final DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
        final DocumentBuilder db= dbf.newDocumentBuilder();

        final Document doc= db.newDocument();
        doc.setXmlStandalone(true);
       /* final Element foo= doc.createElement("foo");
        final Element bar= doc.createElement("bar");
        bar.setTextContent("This is bar text content");
        foo.appendChild(bar);
        doc.appendChild(foo);*/

        Element mainRootElement = doc.createElementNS("https://crunchify.com/CrunchifyCreateXMLDOM", "Companies");
        doc.appendChild(mainRootElement);

        // append child elements to root element
        mainRootElement.appendChild(getCompany(doc, "1", "Paypal", "Payment", "1000"));
        mainRootElement.appendChild(getCompany(doc, "2", "eBay", "Shopping", "2000"));
        mainRootElement.appendChild(getCompany(doc, "3", "Google", "Search", "3000"));

        return doc;
    }

    private static Node getCompany(Document doc, String id, String name, String age, String role) {
        Element company = doc.createElement("Company");
        company.setAttribute("id", id);
        company.appendChild(getCompanyElements(doc, company, "Name", name));
        company.appendChild(getCompanyElements(doc, company, "Type", age));
        company.appendChild(getCompanyElements(doc, company, "Employees", role));
        return company;
    }

    // utility method to create text node
    private static Node getCompanyElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
