package stepik.java_functional_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class XmlUtils {

    public static void main(String[] args) {
        List<XmlFile> xmlFiles = List.of(
                new XmlFile("1", "UTF-8", List.of(new Tag("function"), new Tag("load"))),
                new XmlFile("2", "UTF-8", List.of(new Tag("table"), new Tag("main"))),
                new XmlFile("3", "ASCII", List.of(new Tag("row"), new Tag("column"))),
                new XmlFile("4", "ASCII", List.of(new Tag("sheet"), new Tag("row"))),
                new XmlFile("5", "ASCII", List.of(new Tag("sheet"), new Tag("column")))
        );

        System.out.println(countAllByTagName(xmlFiles, "sheet"));
    }

    public static Map<String, Long> countAllByTagName(List<XmlFile> files, String tagName) {
        // write your code here
        Map<String, Long> map = new HashMap<>();
        for (XmlFile file : files) {
            String key = file.getEncoding();
            if(!map.containsKey(key)) map.put(key, 0L);
            for (Tag tag : file.getTags()) {
                if(tag.getName().equals(tagName)) {
                    long value = 0;
                    if(map.containsKey(key)) {
                        value = map.get(key);
                    }
                    map.put(key, value + file.getTags().size());
                    break;
                }
            }
        }
        return map;
    }
}

class Tag {
    private final String name;

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class XmlFile {
    private final String id;
    private final String encoding;
    private final List<Tag> tags;

    public XmlFile(String id, String encoding, List<Tag> tags) {
        this.id = id;
        this.encoding = encoding;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getEncoding() {
        return encoding;
    }
}
