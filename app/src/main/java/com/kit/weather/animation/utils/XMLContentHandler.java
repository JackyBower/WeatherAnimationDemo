package com.kit.weather.animation.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc：描述模块内容
 * User: ZhouJing
 * Date: 2016/11/3 10:55
 */
public class XMLContentHandler extends DefaultHandler {

    private List<XMLActorData> listXMLData = null;
    private XMLActorData actorData;

    public List<XMLActorData> getXMLActorData() {
        return listXMLData;
    }

    @Override
    public void startDocument() throws SAXException {
        listXMLData = new ArrayList<XMLActorData>();
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (localName.equals("actor")) {
            actorData = new XMLActorData();
            if (attributes != null && attributes.getLength() > 0) {
                actorData.setAngle(Float.parseFloat(attributes.getValue(0)));
                actorData.setLayer(Integer.parseInt(attributes.getValue(1)));
                actorData.setX(Float.parseFloat(attributes.getValue(2)));
                actorData.setY(Float.parseFloat(attributes.getValue(3)));
                actorData.setScale(Float.parseFloat(attributes.getValue(4)));
                actorData.setSpeed(Float.parseFloat(attributes.getValue(5)));
                actorData.setCount(Integer.parseInt(attributes.getValue(7)));
            }
        }
        if (localName.equals("name")) {
            actorData.setActorName(attributes.getValue(0));
        }
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (localName.equals("actor")) {
            listXMLData.add(actorData);
            actorData = null;
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
    }

}

