package com.satorimaiden.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.NONE)
public class Config {

    @XmlElement(name = "file")
    private List<File> files;


    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public static Config get() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Config.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Config) unmarshaller.unmarshal(Config.class.getClassLoader().getResource("configuration.xml"));
    }
}
