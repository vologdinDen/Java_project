public class IMG {

    private String id, name, width, height;

    public IMG(String id, String name, String width, String height){
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String get_name(){
        return this.name;
    }

    public String get_id(){
        return this.id;
    }

    public String get_width(){
        return this.width;
    }
    public String get_height(){
        return this.height;
    }
}
